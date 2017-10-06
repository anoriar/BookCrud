package com.crud.dao;

import java.util.List;
import com.crud.model.Book;

public interface BookDAO {
      
	void addBook(Book book);

	List<Book> searchBooksByTitle(String title);

	List<Book> getAllBooks();

	void deleteBook(Integer bookId);

	Book updateBook(Book book);

	Book getBook(int bookId);

}
