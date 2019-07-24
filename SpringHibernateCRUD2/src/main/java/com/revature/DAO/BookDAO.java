package com.revature.DAO;

import java.util.List;

import com.revature.entity.Book;

public interface BookDAO {
	
	public List<Book> getAllBooks();
	public Book fetchBookById(long bookId);
	public void deleteBookById(long bookId);
	public void addBook(Book book);
	public void updateBook(Book book);
	
}
