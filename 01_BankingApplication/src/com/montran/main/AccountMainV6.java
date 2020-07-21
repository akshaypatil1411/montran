package com.montran.main;

import com.montran.pojo.Current;

public class AccountMainV6 {
	public static void main(String[] args) {
		Current current = new Current(102, "akshay current", 10000, 50000, 50000);
		System.out.println(current);
		// balance = 7000 ovd=50000
		System.out.println("Withdraw 10000");
		current.withdraw(10000);
		System.out.println(current);

		// bal = 0 ovd=42000
		System.out.println(" deposit 1000");
		current.deposit(1000);
		System.out.println(current);

		// bal=0 ovd=47000
		System.out.println(" withdraw 11000");
		current.withdraw(11000);
		System.out.println(current);

		// balance = 7000 overdraftbalance = 50000
		System.out.println("Deposit :: 20000");
		current.deposit(20000);
		System.out.println(current);
	}
}
