package com.banking.exception;

@SuppressWarnings("serial")
public class InSufficientBalanceException extends Exception{
	public InSufficientBalanceException(String msg) {
		super(msg);
	}
}