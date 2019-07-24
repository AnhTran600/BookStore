package com.revature.entity;

import javax.persistence.*;

@Entity
@Table(name="Book")

public class Book {

	@Id
	@Column(name="BOOK_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="BOOK_TITLE",length=50)
	private String title;
	
	@Column(name="BOOK_PRICE",length=50)
	private float price;
	
	@Column(name="BOOK_AUTHOR", length=50)
	private String author;
	
	public Book() {}

	public Book(long id, String title, float price, String author) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.author = author;
	}
	
	public Book(String title, String author, float price) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price + ", author=" + author + "]";
	}
	
}
