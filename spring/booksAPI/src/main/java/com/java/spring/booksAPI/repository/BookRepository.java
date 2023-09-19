package com.java.spring.booksAPI.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.spring.booksAPI.models.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
		// This method searches all books in our DB
		List<Book> findAll();
		//This method searches all books with a description matching "search"
		List<Book> findByDescriptionContaining(String search);
		// this method counts how many titles contain a certain string
	    Long countByTitleContaining(String search);
	    // this method deletes a book that starts with a specific title
	    Long deleteByTitleStartingWith(String search);
}
