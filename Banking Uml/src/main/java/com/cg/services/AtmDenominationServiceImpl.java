package com.cg.services;

import java.math.BigDecimal;

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
	public AtmDenomination addDemomination(ATM atm, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
