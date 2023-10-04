package com.java.spring.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.bookClub.models.Book;
import com.java.spring.bookClub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> findAll(){
		return bookRepo.findAll();
	}
	
	public Book save(Book book) {
		return bookRepo.save(book);
	}
	
	public Book findById(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isEmpty()) {
			return null;
		}
		else return optionalBook.get();
	}
	
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}

}
