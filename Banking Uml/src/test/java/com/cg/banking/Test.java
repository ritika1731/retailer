package com.cg.banking;

import java.math.BigDecimal;
import java.util.Optional;

import com.cg.entity.Bank;

public class Test {

	public static void main(String[] args) {
		final Bank bank = new Bank(new BigDecimal(1000));
		Optional<Bank> stringToUse = Optional.of( bank );
		
		if( stringToUse.isPresent() )
		{
			System.out.println( stringToUse.get() );
		}	
	}

}
