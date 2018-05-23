package com.cg.services;

import java.util.Optional;

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

	@Override
	public void createDenomination(Integer atmId) {
		// TODO Auto-generated method stub
		Optional<ATM> atmOpt = atmRepo.findById(atmId);
		ATM atm = atmOpt.get();
		AtmDenomination atmDm = new AtmDenomination(atm, 0, 100);
		AtmDenomination atmDm1 = new AtmDenomination(atm, 0, 200);
		AtmDenomination atmDm2 = new AtmDenomination(atm, 0, 500);
		AtmDenomination atmDm3 = new AtmDenomination(atm, 0, 2000);
		adRepo.save(atmDm);
		adRepo.save(atmDm1);
		adRepo.save(atmDm2);
		adRepo.save(atmDm3);

	}

}
