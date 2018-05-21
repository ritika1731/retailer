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
		when(bankRepository.findById(Mockito.any(Integer.class))).thenReturn(ob);
		when(custRepo.save(customer)).thenReturn(customer);
		// System.out.println(bank);
		// when(custSer.createCustomer(customer)).thenThrow(new BankException("details
		// invalid"));
		assertThat(custSer.createCustomer(customer), is(notNullValue()));
	}

	@Test(expected = BankException.class)
	public void createCustomers() {
		final Bank bank = new Bank(new BigDecimal(1000));

		final Optional<Bank> ob = Optional.empty();
		final Customer customer = new Customer("ritika", 1231, bank);
		when(bankRepository.findById(Mockito.any(Integer.class))).thenReturn(ob);

		when(custSer.createCustomer(customer)).thenThrow(new BankException("details invalid"));
		// assertThat(custSer.createCustomer(customer), is(notNullValue()));
	}

}
