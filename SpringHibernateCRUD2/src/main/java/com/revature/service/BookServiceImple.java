package com.revature.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.revature.DAO.BookDAO;
import com.revature.entity.Book;

@Service("bookService")

public class BookServiceImple implements BookService {
	
	@Autowired
	BookDAO bd;
	
	//private static BookServiceImple bookDaoJdbc;
	
	private BookServiceImple() {}
	/*
	public static BookServiceImple getBookServiceImple() {
		if (bookDaoJdbc == null) {
			bookDaoJdbc = new BookServiceImple();
		}
		return bookDaoJdbc;
	}
	*/
	@Override
	@Transactional
	public List<Book> listAllBooks() {
		List<Book> lbook = bd.getAllBooks();
		return lbook;
	}

	@Override
	@Transactional
	public Book getBookById(long bookId) {
		Book b = bd.fetchBookById(bookId);
		return b;
	}
	
	@Override
	@Transactional
	public void deleteBookById(long bookId) {
		bd.deleteBookById(bookId);
	}
	
	@Override
	@Transactional
	public void createBook(Book book) {
		bd.addBook(book);
	}
	
	@Override
	@Transactional
	public void updateBook(Book book) {
		bd.updateBook(book);
	}
	
}
