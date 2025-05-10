package com.banking.implementations;

import org.springframework.stereotype.Component;

import com.banking.exception.InSufficientBalanceException;
import com.banking.exception.InvalidInputException;
import com.banking.requirement.IBank;

@Component
public class HDFC implements IBank{
	private double amount;
	
	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public void setAmount(double amount) {
		this.amount=amount;
	}

	@Override
	public String deposit(double amount) throws InvalidInputException{
		if(amount>0 && amount<=50000) {
			this.amount+=amount;
			return "Afetr deposited "+amount+" in HDFC current balance : "+this.amount ;
		} else 
			throw new InvalidInputException("error........");
	}

	@Override
	public String withdraw(double amount) throws InSufficientBalanceException,InvalidInputException{
		if(amount<=0) {
			throw new InvalidInputException("error........");
		} else if(amount>this.amount)
			throw new InSufficientBalanceException("error.......");
		else {
			this.amount-=amount;
			return "Afetr withdrawl "+amount+" in HDFC current balance : "+this.amount;
		}
	}

	@Override
	public String toString() {
		return "HDFC currentBalance : " + amount+"\n";
	}

}