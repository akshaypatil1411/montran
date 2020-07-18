package com.montran.pojo;
import java.util.Scanner;
public class Book {
	private int bookNumber;
	private String bookTitle;
	private double price;
	
	private double totalCost(int N) {
		return price*N;
	}
	Scanner scanner = new Scanner(System.in);
	public void input() {
		System.out.println("Enter book number");
		bookNumber = scanner.nextInt();
		
		System.out.println("Enter book title");
		bookTitle = scanner.next();
		
		System.out.println("Enter book price");
		price = scanner.nextDouble();
		
		//System.out.println(bookTitle);
	}
	
	public double purchase() {
		double amount;
		int N;
		System.out.println("Enter total number of copies to be purchased");
		N = scanner.nextInt();		
		amount = totalCost(N);
		return amount;
	}

	
}
