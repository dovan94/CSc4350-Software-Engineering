package com.ibooku.kickoff.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.ibooku.kickoff.service.CartRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/api/carts")
public class CartController {

	@Autowired
	private CartRepository cartRepository;

	// Add book to cart
	@PostMapping("/add")
	public @ResponseBody String addToCart (@RequestBody Cart item) {
		Cart c = cartRepository.save(item);
		return (c != null) ? "Saved" : "Error";
	}

	// Delete book from cart
	@DeleteMapping("/delete")
	public @ResponseBody String deleteFromCart( @RequestBody Cart item) {
		String user_id = item.getUser_id();
		cartRepository.deleteFromCart(user_id);
		return;
	}


	// Get all items in cart
//	@GetMapping
//	public Iterable<Book> getAll () {
//		return cartRepository.findAll();
//	}

}
