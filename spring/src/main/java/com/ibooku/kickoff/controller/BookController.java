package com.ibooku.kickoff.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ibooku.kickoff.model.Book;
import com.ibooku.kickoff.service.BookRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/api/books")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	// Add new book
	@PostMapping
	public @ResponseBody String addBook (@RequestBody Book newBook) {
		Book b = bookRepository.save(newBook);
		return (b != null) ? "Saved" : "Error";
	}
	
	// Get book by id
	@GetMapping("/{id}")
	public Book findById (@PathVariable("id") Integer id) {
		return bookRepository.findByBId(id);
	}
	
	// Get all books
	@GetMapping
	public Iterable<Book> getAll () {
		return bookRepository.findAll();
	}

}