package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Account;
import com.montran.pojo.Current;
import com.montran.pojo.Savings;

public class AccountMainV5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int accountNumber;
		String name;
		double balance, amount;
		int transactionChoice;
		double overdraftBalance;
		int accountChoice;
		boolean result, isSalary = false;
		String continueChoice;

		System.out.println(" Hello Welcome to XYZ bank !!");
		do {
			System.out.println("Menu");
			System.out.println("1) Savings");
			System.out.println("2) Current");
			System.out.println(" Enter Choice");
			accountChoice = scanner.nextInt();

			switch (accountChoice) {
			case 1:
				System.out.println(" Do you want to open salary account (true - false)");
				isSalary = scanner.nextBoolean();

				System.out.println(" Enter Account Number");
				accountNumber = scanner.nextInt();

				System.out.println("Enter Name");
				name = scanner.next();

				System.out.println("Enter Balance");
				balance = scanner.nextDouble();

				Savings savings = new Savings(accountNumber, name, balance, isSalary);
				System.out.println("Your savings account is opened successfully \n" + savings);

				do {
					System.out.println(" Menu");
					System.out.println(" 1. Withdraw");
					System.out.println(" 2. Deposit");
					System.out.println(" 3. Balance");
					System.out.println(" Enter choice");
					transactionChoice = scanner.nextInt();

					switch (transactionChoice) {
					case 1:
						System.out.println(" Enter amount to withdraw");
						amount = scanner.nextDouble();
						result = savings.withdraw(amount);
						if (result)
							System.out.println(" Transaction Success !!");
						else
							System.out.println(" Transaction Failed");
						break;

					case 2:
						System.out.println(" Enter amount to deposit");
						amount = scanner.nextDouble();
						result = savings.deposit(amount);
						if (result)
							System.out.println(" Transaction Success !!");
						else
							System.out.println(" Transaction Failed");
						break;

					default:
						System.out.println(" Account Balance :: " + savings.getBalance());
						break;

					}
					System.out.println("Do you want to continue ?");
					continueChoice = scanner.next();
				} while (continueChoice.equals("yes"));

				break;

			case 2:
				System.out.println(" Enter overdraft balance");
				overdraftBalance = scanner.nextDouble();

				System.out.println(" Enter Account Number");
				accountNumber = scanner.nextInt();

				System.out.println("Enter Name");
				name = scanner.next();

				System.out.println("Enter Balance");
				balance = scanner.nextDouble();

				Current current = new Current(accountNumber, name, balance, overdraftBalance, overdraftBalance);
				System.out.println("Your current account is opened successfully \n" + current);

				do {
					System.out.println(" Menu");
					System.out.println(" 1. Withdraw");
					System.out.println(" 2. Deposit");
					System.out.println(" 3. Balance");
					System.out.println(" Enter choice");
					transactionChoice = scanner.nextInt();

					switch (transactionChoice) {
					case 1:
						System.out.println(" Enter amount to withdraw");
						amount = scanner.nextDouble();
						result = current.withdraw(amount);
						if (result)
							System.out.println(" Transaction Success !!");
						else
							System.out.println(" Transaction Failed");
						break;

					case 2:
						System.out.println(" Enter amount to deposit");
						amount = scanner.nextDouble();
						result = current.deposit(amount);
						if (result)
							System.out.println(" Transaction Success !!");
						else
							System.out.println(" Transaction Failed");
						break;

					default:
						System.out.println(" Account Balance :: " + current.getBalance());
						System.out.println(" Overdraft Balance ::" + current.getOverdraftBalance());
						break;

					}
					System.out.println("Do you want to continue ?");
					continueChoice = scanner.next();
				} while (continueChoice.equals("yes"));

				break;
			default:
				break;
			}
			System.out.println("Do you want to continue ?");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));

		scanner.close();

	}

}
