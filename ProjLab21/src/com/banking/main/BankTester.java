/*
 Banking System with Factory Design Pattern

Bank Interface:
Methods:
double getAmount(): Retrieves the current balance of the account.
void setAmount(double amount): Updates the current balance of the account.
String deposit(double amount): Deposits money into the account and returns a user-friendly message.
String withdraw(double amount): Withdraws money from the account and returns a user-friendly message.
String toString(): Returns a string representation of the current account balance.

SBI Class:Implements Bank interface.
Attributes:
private double amount: Represents the balance in the SBI account.
Methods:
double getAmount(): Returns the current balance of the SBI account.
void setAmount(double amount): Sets the balance in the SBI account.
String deposit(double amount): Adds money to the SBI account.
String withdraw(double amount): Withdraws money from the SBI account. If the balance is insufficient, it returns an error message.
String toString(): Returns the current balance of the SBI account as a string.

HDFC Class:Implements Bank interface.
Attributes:
private double amount: Represents the balance in the HDFC account.
Methods:
double getAmount(): Returns the current balance of the HDFC account.
void setAmount(double amount): Sets the balance in the HDFC account.
String deposit(double amount): Adds money to the HDFC account.
String withdraw(double amount): Withdraws money from the HDFC account. If the balance is insufficient, it returns an error message.
String toString(): Returns the current balance of the HDFC account as a string.

BankFactory Interface:
Methods:
Bank createBank(String bankType): Returns a specific bank object (SBI or HDFC) based on the provided type.

ConcreteBankFactory Class:
Implements BankFactory interface.
Attributes:
@Autowired SBI sbi: Injects the SBI class.
@Autowired HDFC hdfc: Injects the HDFC class.
Methods:
Bank createBank(String bankType): Creates and returns an instance of SBI or HDFC based on the provided bankType.

Customer Class:
Attributes:
private int customerId: Represents the unique ID of the customer.
private String customerName: Stores the name of the customer.
private Bank bank: Reference to the associated bank account.
@Autowired BankFactory bankFactory: Injects the BankFactory to create the bank.
Methods:
void setCustomerId(int customerId): Sets the customer ID.
void setCustomerName(String customerName): Sets the customer name.
void setBank(String bankType): Sets the customer's bank using BankFactory.
void deposit(double amount): Deposits money into the customer's bank account.
void withdraw(double amount): Withdraws money from the customer's bank account.
void displayDetails(): Displays the customer's details including the bank account balance.
AppConfig Class:
Use @ComponentScan to configure component scanning for Spring to detect beans automatically.

BankTester Class:
Retrieves the Customer beans from the Spring application context.
Methods:
main(-): Demonstrates the functionality of the banking system by creating customer objects, associating them with banks, and performing deposit and withdrawal operations.

 */

package com.banking.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.banking.config.AppConfig;
import com.banking.customer.Customer;
import com.banking.exception.InSufficientBalanceException;
import com.banking.exception.InvalidInputException;

public class BankTester {
	public static void main(String[] args) throws InvalidInputException, InSufficientBalanceException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		Customer customer = ctx.getBean(Customer.class);
		customer.setBank("sbi");
		customer.setCustomerId(101);
		customer.setCustomerName("suman");
		customer.deposit(1000);
		customer.withdraw(500);
		customer.displayDetails();
		
		Customer customer2 = ctx.getBean(Customer.class);
		customer2.setBank("hdfc");
		customer2.setCustomerId(102);
		customer2.setCustomerName("Ramdip");
		customer2.deposit(5000);
		customer2.withdraw(1000);
		customer2.displayDetails();
		
		Customer customer3 = ctx.getBean(Customer.class);
		customer3.setBank("sbi");
		customer3.setCustomerId(103);
		customer3.setCustomerName("ShriKumar");
		customer3.deposit(5000);
		customer3.withdraw(1000);
		customer3.displayDetails();
		
		ctx.close();
	}

}