package com.cg.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.mockito.InjectMocks;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.Enum.EventName;
import com.cg.Enum.EventType;
import com.cg.config.RabbitConfig;
import com.cg.entity.AuditLog;
import com.cg.entity.Bank;
import com.cg.entity.Customer;
import com.cg.exception.BankException;
import com.cg.repository.BankRepository;
import com.cg.repository.CustomerRepository;
import com.cg.set.CustomerReq;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Component
public class CustomerServiceImpl implements CustomerService, Cloneable {
	private final static Logger LOGGER = Logger.getLogger(CustomerService.class.getName());

	@Autowired
	CustomerRepository custRepo;
	@Autowired
	RabbitTemplate rabbitTemplate;

	/*
	 * @InjectMocks CustomerRepository repoCust;
	 */

	@Autowired
	BankRepository bankRepo;

	/*@Autowired
	AuditService auditService;*/

	public Customer createCustomer(CustomerReq custReq) {
		Optional<Bank> ob = bankRepo.findById(custReq.getBankId());

		// System.out.println(obj);
		if (ob.isPresent()) {
			final Customer cust = custReq.getCustomer();
			Bank obj = ob.get();
			cust.setBank(obj);
			return custRepo.save(cust);

		} else {
			throw new BankException("Customer or bank details is invalid");
		}
	}

	public Object getCustomerDetailsById(@RequestBody Customer customer) {

		
			Optional<Customer> cust = custRepo.findBycustomerId(customer.getCustomerId());
			if(cust.isPresent()) {
			
			Customer customers=cust.get();
			return customers;
			}
			else
			{
				throw new BankException("Id not found");
			}

	}

	public List<Customer> getCustomerDetails() {
		return custRepo.findAll();
	}

	public static String fromJavaToJson(AuditLog auditObj)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper jsonMapper = new ObjectMapper();
		return jsonMapper.writeValueAsString(auditObj);
	}
	@Override
	public Customer updateCustomer(Integer custId, Integer pin) throws CloneNotSupportedException {

		Optional<Customer> customer = custRepo.findBycustomerId(custId);
		Customer cust = customer.get();
		
		Customer oldValue = cust.clone();
		
		if (customer.isPresent()) {
			cust.setPin(pin);

			AuditLog audit = new AuditLog(EventName.CUSTOMER.toString(), EventType.UPDATED.toString(), cust.getUserId(),
					oldValue, cust);
			//auditService.createAudit(audit);
			String rabbitCall=null;
			
			try {
				rabbitCall =	CustomerServiceImpl.fromJavaToJson(audit);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rabbitTemplate.convertAndSend(RabbitConfig.MESSAGE_QUEUE,rabbitCall);
		
			return cust;
		} else {
			throw new BankException("Id not found");

		}
	}

}
