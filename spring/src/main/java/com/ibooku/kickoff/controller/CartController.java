package com.ibooku.kickoff.controller;

import java.util.Set;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ibooku.kickoff.model.Book;
import com.ibooku.kickoff.model.Cart;
import com.ibooku.kickoff.model.CartId;
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
	@Transactional
	@PostMapping("/add")
	public ResponseEntity<?> addToCart(@RequestBody Cart newItem) {

		Integer user_id = newItem.getUser().getUser_id();
		Integer book_id = newItem.getBook().getBook_id();
		
		User user = userRepository.findByUId(user_id);
		Book book = bookRepository.findByBId(book_id);
	
	    CartId cid = new CartId(user_id, book_id);
		newItem.setCartId(cid);
		
		//add new item to cart
		book.getUsers().add(newItem);
		user.getCartItems().add(newItem);
		
		//populate to Cart table
		userRepository.save(user);
		bookRepository.save(book);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
	//Get all items in cart which belong to user id
	@GetMapping("/{id}")
	public Set<Cart> getAll(@PathVariable Integer id) {
		User user = userRepository.findByUId(id);
		return user.getCartItems();
	}


}
