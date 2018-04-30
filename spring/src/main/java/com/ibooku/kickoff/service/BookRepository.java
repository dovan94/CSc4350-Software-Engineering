package com.ibooku.kickoff.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ibooku.kickoff.model.Book;

@CrossOrigin(origins="http://localhost:4200")
public interface BookRepository extends CrudRepository<Book, Integer> {
	Book findByBId(Integer id);
	Book findByTitle(String title);
}
