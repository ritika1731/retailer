package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.Bank;
import com.cg.entity.Customer;
import com.cg.exception.BankException;
import com.cg.repository.BankRepository;
import com.cg.repository.CustomerRepository;
import com.cg.set.CustomerReq;

@Service
public class CustomerServiceImpl implements CustomerService {
	private final static Logger LOGGER = Logger.getLogger(CustomerService.class.getName());

	@Autowired
	CustomerRepository custRepo;
	
	/*@InjectMocks
	CustomerRepository repoCust;*/
	
	@Autowired
	BankRepository bankRepo;

	public Customer createCustomer( CustomerReq custReq) {
		Optional<Bank> ob = bankRepo.findById(custReq.getBankId());
		
		//System.out.println(obj);
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
			Object cust = custRepo.findById(customer.getCustomerId());
			return cust;
		} catch (BankException e) {
			// TODO Auto-generated catch block
			throw new BankException("Id not found");
		}

	}

	public List<Customer> getCustomerDetails() {
		return custRepo.findAll();
	}
}
