package com.montran.util;

import com.montran.pojo.Book;

public class BookUtil {
	private Book[] books;
	//private Book books1;
	static int count = 0;
	private int nextindex = 0;
	private int maxindex;
	
	
	
	public BookUtil(int number) {
		books = new Book[number];
		maxindex = number;
	}
	
		
	
	public int getNextindex() {
		return nextindex;
	}

	public int getMaxindex() {
		return maxindex;
	}

	public boolean addNewBook(Book book) {
		if(nextindex>= 0 && nextindex<maxindex) {
			books[nextindex] = book;
			nextindex++;
			return true;
		}
		return false;
	}
	
	
	
	
	
	public boolean addAllBooks(Book[] books) {
		for (Book book : books) {
			addNewBook(book);
		}
		return true;
			
		
		
	}
	
	public boolean updateBook(int bookId , String newName , double newPrice) {
		for (Book book : books) {
			if (book.getBookId() == bookId) {
				book.setName(newName);
				book.setPrice(newPrice);
				return true;
			}
			
		}
		return false;
		
	}
	
	public boolean deleteBook(int bookId) {
		for (int i = 0; i < books.length; i++) {
			if(books[i].getBookId() == bookId) {
				books[i] = null;
				return true;
			}
		}
		
			
		
		
		
		return false;
	}
	
	public Book getBookByBookId(int bookId) {
		for (Book book : books) {
			if (book != null) {
				if (book.getBookId() == bookId)
					return book;
			}

		}
		return null;
	}
	
	public Book[] getAllBooks() {
		return books;
		
	}
	

}
