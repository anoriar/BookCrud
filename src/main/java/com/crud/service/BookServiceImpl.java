package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.model.Book;
import com.crud.dao.BookDAO;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;

	@Override
	@Transactional
	public void addBook(Book book) {
		bookDAO.addBook(book);
	}

	@Override
	@Transactional
	public List<Book> getAllBooks() {
		return bookDAO.getAllBooks();
	}

	@Override
	public List<Book> searchBooksByTitle(String title) {
		return bookDAO.searchBooksByTitle(title);
	}

	@Override
	@Transactional
	public void deleteBook(Integer bookId) {
            bookDAO.deleteBook(bookId);
	}

	public Book getBook(int bookId) {
            return bookDAO.getBook(bookId);
	}

	public Book updateBook(Book book) {
            return bookDAO.updateBook(book);
	}

	public void setBookDAO(BookDAO bookDAO) {

		this.bookDAO = bookDAO;
	}


}
