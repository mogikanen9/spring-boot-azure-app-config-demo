package com.example.bootdemoazappconfig.controller;

public class BookDTO {

	private String name;
	private String author;
	private String isbn;

	public BookDTO(String name, String author, String isbn) {
		super();
		this.name = name;
		this.author = author;
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

}
