package com.montran.main;

import com.montran.pojo.Account;
import com.montran.pojo.Savings;

public class AccountMainV4 {
	public static void main(String[] args) {
		boolean result;
		// Account account = new Account();
		// Account account = new Account(101, "Vivek", 1000);
		// System.out.println(account);
		Savings savings = new Savings(101, "akshay", 1500, false);
		System.out.println(savings);

		// savings.withdraw(200);
		// System.out.println(savings);
		savings.deposit(10);
		// savings.withdraw(1200);
		result = savings.withdraw(1200);
		if (result)
			System.out.println(" Transaction Success !!");
		else
			System.out.println(" Transaction Failed");
		System.out.println(savings);
	}

}
