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
import com.cg.entity.Bank;
import com.cg.entity.BankDenomination;
import com.cg.entity.RefMoney;
import com.cg.repository.ATMRepository;
import com.cg.repository.AtmDenominationRepository;
import com.cg.repository.BankDenominationRepository;
import com.cg.repository.BankRepository;
import com.cg.repository.RefMoneyRepository;

@Service
public class RefMoneyServiceImpl implements RefMoneyService {
	private final static Logger LOGGER = Logger.getLogger(RefMoneyServiceImpl.class.getName());

	@Autowired
	BankRepository bankRepo;

	@Autowired
	RefMoneyRepository rfRepo;
	@Autowired
	BankDenominationRepository bdRepo;
	@Autowired
	ATMRepository atmRepo;
	@Autowired
	AtmDenominationRepository adRepo;

	@Override
	public void createBankDenomination(Integer bankID) {

		Optional<Bank> bankOpt = bankRepo.findById(bankID);
		Bank bank = bankOpt.get();

		BankDenomination bankDnm = new BankDenomination(bank,0,50);
		BankDenomination bankDnm1 = new BankDenomination(bank,0,100);
		BankDenomination bankDnm2 = new BankDenomination(bank,0,200);
		BankDenomination bankDnm3 = new BankDenomination(bank,0,500);
		BankDenomination bankDnm4 = new BankDenomination(bank,0,2000);
		BankDenomination bankDnm5 = new BankDenomination(bank,0,10);
		bdRepo.save(bankDnm);
		bdRepo.save(bankDnm1);
		bdRepo.save(bankDnm2);
		bdRepo.save(bankDnm3);
		bdRepo.save(bankDnm4);
		bdRepo.save(bankDnm5);
	}

	@Override
	public void addDemomination(Integer denomination) {
		
		RefMoney denm=new RefMoney();
		denm.setDenomination(denomination);
		rfRepo.save(denm);
		
		
	}

	
	@Override
	public void createAtmDenomination(Integer atmId) {
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
