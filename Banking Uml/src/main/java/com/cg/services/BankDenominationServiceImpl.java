package com.cg.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Bank;
import com.cg.entity.BankDenomination;
import com.cg.repository.BankDenominationRepository;
import com.cg.repository.BankRepository;

@Service
public class BankDenominationServiceImpl implements BankDenominationService {
	private final static Logger LOGGER = Logger.getLogger(ATMService.class.getName());

	@Autowired
	BankDenominationRepository bdRepo;
	@Autowired
	BankRepository bankRepo;

	@Override
	public BankDenomination addDemomination(final Bank bank, final BigDecimal amount) {

		final Optional<Bank> banks = bankRepo.findById(bank.getId());
		final Bank bankOpt = banks.get();
		final BankDenomination bankdenom = new BankDenomination();
		bankdenom.setBank(bankOpt);
		final List<BigDecimal> currencyList = new ArrayList<BigDecimal>();
		currencyList.add(new BigDecimal(2000));
		currencyList.add(new BigDecimal(500));
		currencyList.add(new BigDecimal(200));
		currencyList.add(new BigDecimal(100));
		currencyList.add(new BigDecimal(50));
		currencyList.add(new BigDecimal(10));
		final Random random = new Random();
		BigDecimal remaining = amount;
		final Integer length = currencyList.size();
		// BankDenomination bankdenom = new BankDenomination();

		for (int i = 0; i <= length; i++) {
			Integer index = random.nextInt(length);

			BigDecimal currencyValue = currencyList.get(index);

			if (currencyValue.compareTo(remaining) == 0 || currencyValue.compareTo(remaining) == -1) {

				Integer set = remaining.divide(currencyValue).intValue();

				bankdenom.setNoOfDenomination(set);
				bankdenom.setDenomination(currencyValue.intValue());
				remaining = remaining.remainder(currencyValue);
				bdRepo.save(bankdenom);

				if (remaining.equals(0)) {
					break;
				}
			}
			currencyList.remove(index);

		}
		return null;
	}

	@Override
	public void createDenomination(Integer bankID) {

		Optional<Bank> bankOpt = bankRepo.findById(bankID);
		Bank bank = bankOpt.get();

		BankDenomination bankDnm = new BankDenomination(bank, 0, 10);
		BankDenomination bankDnm1 = new BankDenomination(bank, 0, 100);
		BankDenomination bankDnm2 = new BankDenomination(bank, 0, 50);
		BankDenomination bankDnm3 = new BankDenomination(bank, 0, 500);
		BankDenomination bankDnm4 = new BankDenomination(bank, 0, 200);
		BankDenomination bankDnm5 = new BankDenomination(bank, 0, 2000);
		bdRepo.save(bankDnm);
		bdRepo.save(bankDnm1);
		bdRepo.save(bankDnm2);
		bdRepo.save(bankDnm3);
		bdRepo.save(bankDnm4);
		bdRepo.save(bankDnm5);
	}
}