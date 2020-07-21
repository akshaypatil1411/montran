package com.montran.pojo;

public class Current extends Account {
	private double overdraftBalance;
	private double toOverdraftBalance;
	private double overdraftBalancelimit;

	public Current() {
		// TODO Auto-generated constructor stub
	}

	public Current(int accountNumber, String name, double balance, double overdraftBalance,
			double overdraftBalancelimit) {
		super(accountNumber, name, balance);
		this.overdraftBalance = overdraftBalance;
		this.overdraftBalancelimit = overdraftBalancelimit;
	}

	public double getOverdraftBalance() {
		return overdraftBalance;
	}

	public void setOverdraftBalance(double overdraftBalance) {
		this.overdraftBalance = overdraftBalance;
	}

	@Override
	public boolean withdraw(double amount) {
		// TODO Auto-generated method stub

		if (amount > 0) {

			if (amount <= getBalance()) {
				setBalance(getBalance() - amount);
				return true;
			}
			if (amount > getBalance() && amount <= overdraftBalance + getBalance()) {

				amount = amount - getBalance();
				setBalance(getBalance() - getBalance());
				overdraftBalance = overdraftBalance - amount;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deposit(double amount) {
		// TODO Auto-generated method stub
		if (amount > 0) {
			if (overdraftBalance != overdraftBalancelimit) {
				toOverdraftBalance = overdraftBalancelimit - overdraftBalance;
				if (toOverdraftBalance < amount) {
					overdraftBalance = overdraftBalance + toOverdraftBalance;
					amount = amount - toOverdraftBalance;
					setBalance(amount + getBalance());
					return true;
				}
				if (toOverdraftBalance >= amount) {
					overdraftBalance = overdraftBalance + amount;
					return true;
				}
			} else {
				setBalance(amount + getBalance());
				return true;

			}

		}
		return false;
	}

	@Override
	public String toString() {
		return "Current [overdraftBalance=" + overdraftBalance + ", getAccountNumber()=" + getAccountNumber()
				+ ", getName()=" + getName() + ", getBalance()=" + getBalance() + "]";
	}

}
