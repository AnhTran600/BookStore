package com.revature.DAO;

import java.util.ArrayList;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.revature.entity.Book;

@Repository("bd")

public class BookDAOImple implements BookDAO {

	@Autowired
	SessionFactory sessionFact;
	
	@SuppressWarnings("unchecked")
	public java.util.List<Book> getAllBooks() {
		ArrayList<Book> blist = new ArrayList<>();
		Query query = sessionFact.getCurrentSession().createQuery("from Book");
		//query.setMaxResults(10);
		blist = (ArrayList<Book>) query.getResultList();
		return blist;
	}
	
	@Override
	public Book fetchBookById(long bookId) {
		Session session = sessionFact.getCurrentSession();
		Book b = session.get(Book.class, bookId);
		System.out.println("Fetched!");
		return b;
	}
	
	@Override
	public void deleteBookById(long bookId) {
		Session session = sessionFact.getCurrentSession();
		Book b = session.get(Book.class, bookId);
		session.delete(b);
		System.out.println("Deleted!");
	}
	
	@Override
	public void addBook(Book book) {
		sessionFact.getCurrentSession().save(book);
		System.out.println("Saved!");
	}

	@Override
	public void updateBook(Book book) {
		sessionFact.getCurrentSession().update(book);
		System.out.println("Update!");
	}
}
