package com.cg.banking;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.entity.Bank;
import com.cg.entity.Customer;
import com.cg.exception.BankException;
import com.cg.repository.BankRepository;
import com.cg.repository.CustomerRepository;
import com.cg.services.CustomerServiceImpl;
import com.cg.set.CustomerReq;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {

	@Mock
	private CustomerRepository custRepo;

	@Mock
	private BankRepository bankRepository;
	@InjectMocks
	private CustomerServiceImpl custSer;

	@Test
	public void createCustomer() {
		final Bank bank = new Bank(new BigDecimal(1000));
		bank.setId(1);
		// Optional<Bank> ob = Optional.empty();
		Optional<Bank> ob = Optional.of(bank);
		System.out.println(ob.isPresent());
		final Customer customer = new Customer("ritika", 1231, bank);
		final CustomerReq cust = new CustomerReq(1, customer);
		when(bankRepository.findById(Mockito.any(Integer.class))).thenReturn(ob);
		when(custRepo.save(customer)).thenReturn(customer);
		// System.out.println(bank);
		// when(custSer.createCustomer(customer)).thenThrow(new BankException("details
		// invalid"));
		assertThat(custSer.createCustomer(cust), is(notNullValue()));
	}

	@Test(expected = BankException.class)
	public void checkCustomer() {
		final Bank bank = new Bank(new BigDecimal(1000));

		final Optional<Bank> ob = Optional.empty();
		final Customer customer = new Customer("ritika", 1231, bank);
		final CustomerReq cust = new CustomerReq(1, customer);

		when(bankRepository.findById(Mockito.any(Integer.class))).thenReturn(ob);

		custSer.createCustomer(cust);
		// assertThat(custSer.createCustomer(customer), is(notNullValue()));
	}

	@Test
	public void viewCustomer() {
		final Bank bank = new Bank(new BigDecimal(0));
		bank.setId(1);
		Optional<Bank> bnk = Optional.of(bank);
		final Customer customer = new Customer("ritika", 1231, bank);
		customer.setCustomerId(2);
		Optional<Customer> cust = Optional.of(customer);

		when(custRepo.findBycustomerId(1)).thenReturn(cust);

		assertThat(custSer.getCustomerDetailsById(customer), is(notNullValue()));

	}

}
