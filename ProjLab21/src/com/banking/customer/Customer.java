package com.banking.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.banking.exception.InSufficientBalanceException;
import com.banking.exception.InvalidInputException;
import com.banking.requirement.IBank;
import com.banking.requirement.IBankFactory;

@Component
public class Customer {
	private int customerId;
	private String customerName;
	private IBank bank;
	
	@Autowired
	private IBankFactory bankfactory;
	
	public IBank getBank() {
		return bank;
	}

	public IBankFactory getBankfactory() {
		return bankfactory;
	}

	public void setBankfactory(IBankFactory bankfactory) {
		this.bankfactory = bankfactory;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId=customerId;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName=customerName;
	}
	
	public void setBank(String bankType) {
		this.bank=bankfactory.createBank(bankType);
	}
	
	public void deposit(double amount) throws InvalidInputException{
		if(amount>0 && amount<=50000) {
			bank.deposit(amount);
			System.out.println("After deposite "+amount+" totalPrice : "+bank.getAmount());
		} else 
			throw new InvalidInputException("please enter the amount(1 to 50000)");
	}
	
	public void withdraw(double amount) throws InvalidInputException,InSufficientBalanceException{
		if(amount<=0) 
			throw new InvalidInputException("please enter currect price...");
		else if(bank.getAmount()<amount) 
			throw new InSufficientBalanceException("Insufficient fund....");
		else {
			bank.withdraw(amount);
			System.out.println("After withdraw "+amount+" totalPrice : "+bank.getAmount());
		}
			
	}
	
	public void displayDetails() {
		System.out.println("Customer Id :"+getCustomerId()+"\nCustomer Name :"+getCustomerName()+"\nBank Details : "+bank.toString());
	}
}