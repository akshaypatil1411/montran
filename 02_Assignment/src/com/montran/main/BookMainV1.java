package com.montran.main;
import com.montran.pojo.Book;
import java.util.Scanner;
public class BookMainV1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book = new Book();
		Scanner scanner = new Scanner(System.in);
		int N;
		double amount;
		book.input();
		System.out.println(book.purchase());
		//System.out.println("Total price :: " +amount);
		
	}

}
