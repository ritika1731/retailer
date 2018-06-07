package com.cg.services;

import java.math.BigDecimal;
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
import com.cg.repository.RefMoneyRepository;

@Service
public class BankDenominationServiceImpl implements BankDenominationService {
	private final static Logger LOGGER = Logger.getLogger(BankDenominationServiceImpl.class.getName());

	@Autowired
	BankDenominationRepository bdRepo;
	@Autowired
	BankRepository bankRepo;

	@Autowired
	RefMoneyRepository rfRepo;
	final BankDenomination bankdenom = new BankDenomination();

	@Override
	public BankDenomination addDemomination(final Bank bank, final BigDecimal amount) {

		final Optional<Bank> banks = bankRepo.findById(bank.getId());
		final Bank bankOpt = banks.get();
		bankdenom.setBank(bankOpt);

		List<BankDenomination> currencyList = bdRepo.findAll();
		
		final Random random = new Random();

		Integer remaining = amount.intValue();
		final Integer length = currencyList.size();

		for (int i = 0; i <= length; i++) {
			
			Integer index = random.nextInt(length);
			BankDenomination refMoney = currencyList.get(index);

			Integer currencyValue = refMoney.getDenomination();

			if (currencyValue.compareTo(remaining) == 0 || currencyValue.compareTo(remaining) == -1) {
			
				Integer present = bankdenom.getNoOfDenomination();
				System.out.println("#########" + present);
				Integer set = (remaining / (currencyValue).intValue());


				bankdenom.setNoOfDenomination(set);
				bankdenom.setDenomination(currencyValue.intValue());
				remaining = remaining % currencyValue;
				bdRepo.save(bankdenom);

				if (remaining.equals(0)) {
					break;
				}
			}
			currencyList.remove(index);

		}
		return null;
	}

}