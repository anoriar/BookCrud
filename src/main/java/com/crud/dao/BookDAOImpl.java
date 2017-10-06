package com.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.model.Book;
import org.hibernate.Query;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addBook(Book book) {
        Session session =  sessionFactory.getCurrentSession();
        session.saveOrUpdate(book);
    }

    @SuppressWarnings("unchecked")
    public List<Book> getAllBooks() {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Book");
        return query.list();
    }


    @Override
    public List<Book> searchBooksByTitle(String title) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Book WHERE title = '"+ title + "'");
        return query.list();
    }

    @Override
    public void deleteBook(Integer bookId) {
            Book book = (Book) sessionFactory.getCurrentSession().load(Book.class, bookId);
            if (null != book) {
                    this.sessionFactory.getCurrentSession().delete(book);
            }
    }

    public Book getBook(int bookId) {
            return (Book) sessionFactory.getCurrentSession().get(Book.class, bookId);
    }

    @Override
    public Book updateBook(Book book) {
            sessionFactory.getCurrentSession().update(book);
            return book;
    }


}