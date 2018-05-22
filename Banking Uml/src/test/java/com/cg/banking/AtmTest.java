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

import com.cg.entity.ATM;
import com.cg.entity.Bank;
import com.cg.exception.BankException;
import com.cg.repository.ATMRepository;
import com.cg.repository.BankRepository;
import com.cg.services.ATMServiceImpl;
import com.cg.set.ATMRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtmTest {

	@Mock
	private ATMRepository atmRepo;

	@Mock
	private BankRepository bankRepo;

	@InjectMocks
	private ATMServiceImpl atmSer;

	@Test
	public void createAtm() {
		Bank bank = new Bank(new BigDecimal(1200));
		bank.setId(1);
		Optional<Bank> bnk = Optional.of(bank);

		ATM atm = new ATM(new BigDecimal(5000), bank);

		ATMRequest req = new ATMRequest(atm, 1);
		when(bankRepo.findById(Mockito.any(Integer.class))).thenReturn(bnk);
		when(atmRepo.save(atm)).thenReturn(atm);
		assertThat(atmSer.createATM(req), is(notNullValue()));
 
	}

	@Test(expected = BankException.class)
	public void checkAtm() {

		Bank bank = new Bank(new BigDecimal(1200));
		// bank.setId(1);
		//Optional<Bank> bnks = Optional.of(bank);
		Optional<Bank> bnk = Optional.empty();
		ATM atm = new ATM(new BigDecimal(5000), bank);

		ATMRequest req = new ATMRequest(atm, 1);
		when(bankRepo.findById(Mockito.any(Integer.class))).thenReturn(bnk);
		when(atmRepo.save(atm)).thenReturn(atm);
		atmSer.createATM(req);

	}
}
