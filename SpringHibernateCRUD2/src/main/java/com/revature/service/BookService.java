package com.revature.service;

import java.util.List;

import com.revature.entity.Book;

public interface BookService {

	public List<Book> listAllBooks();
	public Book getBookById(long bookId);
	public void deleteBookById(long bookId);
	public void createBook(Book book);
	public void updateBook(Book book);
	
}
