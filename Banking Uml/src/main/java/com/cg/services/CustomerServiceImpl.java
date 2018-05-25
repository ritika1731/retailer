package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.Enum.EventName;
import com.cg.Enum.EventType;
import com.cg.entity.AuditLog;
import com.cg.entity.Bank;
import com.cg.entity.Customer;
import com.cg.exception.BankException;
import com.cg.repository.BankRepository;
import com.cg.repository.CustomerRepository;
import com.cg.set.CustomerReq;

@Service
public class CustomerServiceImpl implements CustomerService, Cloneable {
	private final static Logger LOGGER = Logger.getLogger(CustomerService.class.getName());

	@Autowired
	CustomerRepository custRepo;

	/*
	 * @InjectMocks CustomerRepository repoCust;
	 */

	@Autowired
	BankRepository bankRepo;

	@Autowired
	AuditService auditService;

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

		try {
			Object cust = custRepo.findBycustomerId(customer.getCustomerId());
			return cust;
		} catch (BankException e) {
			// TODO Auto-generated catch block
			throw new BankException("Id not found");
		}

	}

	public List<Customer> getCustomerDetails() {
		return custRepo.findAll();
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
			auditService.generateAudit(audit);
			return cust;
		} else {
			throw new BankException("Id not found");

		}
	}

}
