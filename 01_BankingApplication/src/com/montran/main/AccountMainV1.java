package com.montran.main;

import com.montran.pojo.Account;

public class AccountMainV1 {
	public static void main(String[] args) {
		Account account = new Account();
		//System.out.println(account.hashCode());
		account.deposit();
		account.withdraw();

	}

}
