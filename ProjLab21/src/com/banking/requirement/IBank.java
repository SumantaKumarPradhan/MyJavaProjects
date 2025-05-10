package com.banking.requirement;

import com.banking.exception.InSufficientBalanceException;
import com.banking.exception.InvalidInputException;

public interface IBank {
	public double getAmount();
	public void setAmount(double amount);
	public String deposit(double amount) throws InvalidInputException;
	public String withdraw(double amount) throws InSufficientBalanceException,InvalidInputException;
	public String toString();
}