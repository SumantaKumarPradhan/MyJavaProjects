package com.banking.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.banking.implementations.HDFC;
import com.banking.implementations.SBI;
import com.banking.requirement.IBank;
import com.banking.requirement.IBankFactory;

@Component
public class ConcreteBankFactory implements IBankFactory{
	@Autowired
	private SBI sbi;
	
	@Autowired
	private HDFC hdfc;
	
	@Override
	public IBank createBank(String bankType) {
		if(bankType.equalsIgnoreCase("sbi")) 
			return sbi;
		else if(bankType.equalsIgnoreCase("hdfc"))
			return hdfc;
		else 
			throw new IllegalArgumentException("banktype is not matched.....");
	}

}