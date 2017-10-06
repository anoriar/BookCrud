package com.crud.service;

import java.util.List;

import com.crud.model.Book;

public interface BookService {
	
	void addBook(Book book);

	List<Book> getAllBooks();

	List<Book> searchBooksByTitle(String title);

	void deleteBook(Integer bookId);

	Book getBook(int bookId);

	Book updateBook(Book book);

}
