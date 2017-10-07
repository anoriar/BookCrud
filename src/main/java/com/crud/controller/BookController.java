package com.crud.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.crud.model.Search;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.crud.model.Book;
import com.crud.util.Pagination;
import com.crud.service.BookService;

@Controller
public class BookController {

	private static final Logger logger = Logger
			.getLogger(BookController.class);

	public BookController() {
		System.out.println("BookController()");
	}
        
        private final static int itemLimit = 10;

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView start(ModelAndView model, HttpServletRequest request) throws IOException {
        request.getSession().setAttribute("bookList", bookService.getAllBooks());
        request.getSession().setAttribute("search", new Search());
        model.setViewName("redirect:/books");
        return model;
    }

	@RequestMapping(value = "/books",  method = RequestMethod.GET)
	public ModelAndView showBooks(ModelAndView model, HttpServletRequest request) throws IOException {
        int pageId = 1;
        if(request.getParameter("id") != null){
            pageId = Integer.parseInt(request.getParameter("id"));
        }
        int startPos = (pageId - 1) * itemLimit;
        int endPos = startPos + itemLimit;
        List<Book> allBooks = (ArrayList<Book>)request.getSession().getAttribute("bookList");
        if(endPos > allBooks.size()){
            endPos = allBooks.size();
        }
        List<Book> bookList =  allBooks.subList(startPos, endPos);
        model.addObject("pageList",  Pagination.calcPages(pageId, allBooks.size()));
        model.addObject("bookList", bookList);
        model.addObject("search",  request.getSession().getAttribute("search"));
        model.setViewName("index");
        return model;
	}

    @RequestMapping(value = "/searchBook", method = RequestMethod.POST)
    public ModelAndView searchBook(@ModelAttribute Search search, ModelAndView model,  HttpServletRequest request) {
        int startPos = 0;
        List<Book> bookList = new ArrayList<Book>();
        if(search.getSearchStr().equals("")){
            bookList = bookService.getAllBooks();
        } else{
            bookList = bookService.searchBooksByTitle(search.getSearchStr());
        }
        request.getSession().setAttribute("bookList", bookList);
        model.setViewName("redirect:/books");
        return model;
    }
     

	@RequestMapping(value = "/newBook", method = RequestMethod.GET)
	public ModelAndView addBook(ModelAndView model) {
		Book book = new Book();
		model.addObject("book", book);
		model.setViewName("create_book_form");
		return model;
	}

	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("book") @Valid Book book, BindingResult result, HttpServletRequest request) {
	    if(result.hasErrors()){
            return "create_book_form";
        } else {
            if (book.getId() == 0) {
                bookService.addBook(book);
            } else {
                bookService.updateBook(book);
            }
            request.getSession().setAttribute("bookList", bookService.getAllBooks());
            return "redirect:/books";
        }
	}

	@RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
	public ModelAndView deleteBook(HttpServletRequest request) {
		int bookId = Integer.parseInt(request.getParameter("id"));

		bookService.deleteBook(bookId);
        request.getSession().setAttribute("bookList", bookService.getAllBooks());
		return new ModelAndView("redirect:/books");
	}


	@RequestMapping(value = "/editBook", method = RequestMethod.GET)
	public ModelAndView editBook(HttpServletRequest request) {
		int bookId = Integer.parseInt(request.getParameter("id"));
		Book book = bookService.getBook(bookId);
		book.setReadAlready(false);
		ModelAndView model = new ModelAndView("update_book_form");
		model.addObject("book", book);
		return model;
	}

	@RequestMapping(value = "/readBook", method = RequestMethod.GET)
	public ModelAndView readBook(HttpServletRequest request) {
		int bookId = Integer.parseInt(request.getParameter("id"));
		Book book = bookService.getBook(bookId);
		book.setReadAlready(true);
		bookService.updateBook(book);
        request.getSession().setAttribute("bookList", bookService.getAllBooks());
		return new ModelAndView("redirect:/books");
	}

}