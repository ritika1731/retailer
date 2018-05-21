package com.cg.banking;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.entity.Bank;
import com.cg.exception.BankException;
import com.cg.repository.BankRepository;
import com.cg.services.BankServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankTests {

	@Mock
	private BankRepository repoMock;

	@InjectMocks
	private BankServiceImpl bankSer;

	@Test
	public void createBank() {
		final Bank bank = new Bank(new BigDecimal(0));
		when(repoMock.save(bank)).thenReturn(bank);
		//System.out.println(bank);
		assertThat(bankSer.createBank(bank), is(notNullValue()));
	}
	
	@Test(expected=BankException.class)
	public void createBanks() {
		final Bank bank = new Bank(new BigDecimal(-1));
		when(bankSer.createBank(bank)).thenThrow(new BankException("negative amount"));
		//System.out.println(bank);
		//assertThat(bankSer.createBank(bank), is(notNullValue()));
	}

}
