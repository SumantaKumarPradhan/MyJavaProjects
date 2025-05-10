package com.banking.requirement;

public interface IBankFactory {
	public IBank createBank(String bankType);
}