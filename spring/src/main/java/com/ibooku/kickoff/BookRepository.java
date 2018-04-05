package com.ibooku.kickoff;

import org.springframework.data.repository.CrudRepository;
import com.ibooku.kickoff.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
