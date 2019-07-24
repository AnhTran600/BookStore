package com.revature.controller;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.revature.entity.Book;
import com.revature.service.BookService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
	
	@Autowired
	BookService bs;
	
	@GetMapping("/Book")
	public List<Book> getBooks() {
		List<Book> alist = bs.listAllBooks();
		//alist.forEach(System.out::println);
		return alist;
	}
	
	@GetMapping("/BookList")
	public String helloo() {
		return "BookList";
	}
	
	@RequestMapping(value = "/Book/{id}", method = RequestMethod.GET)
	public Book findBook(@PathVariable int id) {
		Book b = bs.getBookById(id);
		return b;
	}
	
	@RequestMapping(value = "/Book/{id}", method = RequestMethod.DELETE)
	public String deleteBook(@PathVariable("id") int id) {
		bs.deleteBookById(id);
		return "Deleted";
	}
	
	@RequestMapping(value = "/Book", method = RequestMethod.POST)
	@PostMapping("/Books")
	public String createBook(@RequestBody Book book) {
		bs.createBook(book);
		return "Create";
	}
	
	@RequestMapping(value = "/Book", method = RequestMethod.PUT)
	public String updateBook(@RequestBody Book book) {
		bs.createBook(book);
		return "Update";
	}
	
}
