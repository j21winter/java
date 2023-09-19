package com.java.spring.booksAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.spring.booksAPI.models.Book;
import com.java.spring.booksAPI.repository.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // updates a book
    public Book updateBook(Long id, String title,String desc,String lang,Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        book.setId(id);
    	return bookRepository.save(book);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    // deletes a book by the id
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}
