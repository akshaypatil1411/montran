package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Book;
import com.montran.util.BookUtil;

public class BookMainV1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int bookChoice;
		String continueChoice;
		int bookId, number;
		String name;
		String newName;
		double newPrice;
		double price;
		boolean result;
		BookUtil bookUtil = new BookUtil(100);
		Book books[] = null;
		Book book;
		do {
			books = bookUtil.getAllBooks();
			for (Book bookTemp : books) {
				if (bookTemp != null) {
					System.out.println(bookTemp.getBookId() + "\t" + bookTemp.getName() + "\t" + bookTemp.getPrice());
				}
			}
			System.out.println("Menu");
			System.out.println("1. Add Single Book");
			System.out.println("2. Add Multiple Books");
			System.out.println("3. Update Existing Book");
			System.out.println("4. Delete Existing Book");
			System.out.println("5. Print Single Book Details");
			System.out.println("6. Exit");
			System.out.println("Enter your choice");
			bookChoice = scanner.nextInt();

			switch (bookChoice) {
			case 1:
				System.out.println(" Enter book ID");
				bookId = scanner.nextInt();

				System.out.println(" Enter book name");
				name = scanner.next();

				System.out.println(" Enter book price");
				price = scanner.nextDouble();

				book = new Book(bookId, name, price);

				result = bookUtil.addNewBook(book);
				if (result)
					System.out.println(" Book is added successfully");
				else
					System.out.println("Failed to add book");
				break;

			case 2:

				System.out.println("Enter number of books you want to add");
				number = scanner.nextInt(); // Book book2 = new Book(10);

				if (number < (bookUtil.getMaxindex() - bookUtil.getNextindex())) {
					books = new Book[number];
					for (int i = 0; i < number; i++) {
						System.out.println(" Enter book ID");
						bookId = scanner.nextInt();

						System.out.println(" Enter book name");
						name = scanner.next();

						System.out.println(" Enter book price");
						price = scanner.nextDouble();

						book = new Book(bookId, name, price);
						books[i] = book;

					}
					bookUtil.addAllBooks(books);
					System.out.println("Books added");
				} else
					System.out.println("Failed");
				break;

			case 3:
				System.out.println("Enter book ID");
				bookId = scanner.nextInt();

				book = bookUtil.getBookByBookId(bookId);
				if (book != null) {

					System.out.println("Enter new name");
					newName = scanner.next();

					System.out.println("Enter new price");
					newPrice = scanner.nextDouble();

					result = bookUtil.updateBook(bookId, newName, newPrice);
					System.out.println("Result of update - " + result);
					if (result)
						System.out.println(" Updated Successfully");
					else
						System.out.println(" Failed");
				} else
					System.out.println(" Book not found ");
				break;

			case 4:
				System.out.println("Enter book ID");
				bookId = scanner.nextInt();
				book = bookUtil.getBookByBookId(bookId);
				if (book != null) {
					result = bookUtil.deleteBook(bookId);
					if (result)
						System.out.println("Deleted successfully");
					else
						System.out.println(" Failed to delete");
				} else
					System.out.println("Book not found");

				break;

			case 5:
				System.out.println("Enter book ID");
				bookId = scanner.nextInt();
				book = bookUtil.getBookByBookId(bookId);
				if (book != null) {
					System.out.println(book);
				} else
					System.out.println(" No book found");
				break;

			case 6:
				System.out.println(" Thank you");
				System.exit(0);

				break;

			default:
				System.out.println("Invalid choice");
				break;
			}
			System.out.println("Do you want to continue ?");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));

		scanner.close();

	}

}
