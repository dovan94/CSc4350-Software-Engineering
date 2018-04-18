package com.ibooku.kickoff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.ibooku.kickoff.model.Cart;
import com.ibooku.kickoff.model.User;
import com.ibooku.kickoff.service.BookRepository;
import com.ibooku.kickoff.service.UserRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/api/cart")
public class CartController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	// Add item to cart
		@PostMapping("/add")
		public ResponseEntity<?> addToCart(@RequestBody Cart item)	{
			Integer user_id = item.getUserId();
			Integer book_id = item.getBookId();

			User user = userRepository.findByUId(user_id);
			if (user != null) {
				user.getCartItems().add(bookRepository.findByBId(book_id));
				userRepository.save(user);
			}

			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	

	
	
	// Get all items in cart
//	@GetMapping
//	public Iterable<Book> getAll () {
//		return cartRepository.findAll();
//	}

}