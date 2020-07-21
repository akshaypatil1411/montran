package com.montran.pojo;

public class Account {
	private int accountNumber;
	private String name;
	private double balance;

	public Account() {
		System.out.println("Default Constructor of Account");
	}

	public Account(int accountNumber, String name, double balance) {
		//System.out.println("Param constructor of Account");
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean deposit(double amount) {
		// System.out.println("deposit() called");
		if (amount > 0) {
			balance = balance + amount;
			return true;
		}
		return false;
	}

	public boolean withdraw(double amount) {
		// System.out.println("withdraw() method called !!");
		if (amount > 0 && amount <= balance) {
			balance = balance - amount;
			return true;
		}
		return false;
	}

	// @Override
	public String toString() {
		return "Account \naccountNumber=" + accountNumber + "\nname=" + name + "\nbalance=" + balance;
	}

}
