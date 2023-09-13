package com.javahongkong.bootcamp.exercise;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts; // object reference

	public Bank() {
		// complete the function
		this.accounts = new LinkedHashMap<Long, Account>();
	}

	public Account getAccount(Long accountNumber) {
		// complete the function
		for (Map.Entry<Long, Account> entry : accounts.entrySet()) {
			if (entry.getKey().equals(accountNumber))
				return entry.getValue();
		}
		return null;
	}

	public Long openCommercialAccount(Company company, int pin,
			double startingDeposit) {
		// complete the function
		Long accountNumber = (long) accounts.size();
		CommercialAccount commercialAccount = new CommercialAccount(company, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, commercialAccount);
		return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin,
			double startingDeposit) {
		// complete the function
		Long accountNumber = (long) accounts.size();
		ConsumerAccount consumerAccount = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, consumerAccount);
		return accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		return accounts.get(accountNumber).validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		return accounts.get(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		accounts.get(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		return accounts.get(accountNumber).debitAccount(amount);
	}
}
