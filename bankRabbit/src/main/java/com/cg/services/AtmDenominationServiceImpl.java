package com.cg.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.ATM;
import com.cg.entity.AtmDenomination;
import com.cg.repository.ATMRepository;
import com.cg.repository.AtmDenominationRepository;

@Service
public class AtmDenominationServiceImpl implements AtmDenominationService {
	private final static Logger LOGGER = Logger.getLogger(AtmDenominationServiceImpl.class.getName());

	@Autowired
	AtmDenominationRepository adRepo;

	@Autowired
	ATMRepository atmRepo;
	AtmDenomination atmDemn;
	@Override
	public AtmDenomination addDemomination(ATM atm, BigDecimal amount) {
		final Optional<ATM> atmId = atmRepo.findByAtmId(atm.getAtmId());
		final ATM atmOpt = atmId.get();
		atmDemn.setAtm(atmOpt);

		List<AtmDenomination> currencyList = adRepo.findAll();
		
		final Random random = new Random();

		Integer remaining = amount.intValue();
		final Integer length = currencyList.size();

		for (int i = 0; i <= length; i++) {
			
			Integer index = random.nextInt(length);
			AtmDenomination refMoney = currencyList.get(index);

			Integer currencyValue = refMoney.getDenomination();

			if (currencyValue.compareTo(remaining) == 0 || currencyValue.compareTo(remaining) == -1) {
			
				Integer present = atmDemn.getNoOfDenomination();
				//System.out.println("#########" + present);
				Integer set = (remaining / (currencyValue).intValue());


				atmDemn.setNoOfDenomination(set);
				atmDemn.setDenomination(currencyValue.intValue());
				remaining = remaining % currencyValue;
				adRepo.save(atmDemn);

				if (remaining.equals(0)) {
					break;
				}
			}
			currencyList.remove(index);

		}
		return null;

	
	}
}
