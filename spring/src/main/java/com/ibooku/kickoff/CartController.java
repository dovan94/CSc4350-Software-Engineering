package com.ibooku.kickoff;

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

import com.ibooku.kickoff.Cart;
import com.ibooku.kickoff.Book;
import com.ibooku.kickoff.CartRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/api/carts")
public class CartController {
	
	@Autowired
	private CartRepository cartRepository;
	
	// Add book to cart
//	@PostMapping
//	public @ResponseBody String addToCart (@RequestBody Cart item) {
//		Cart c = cartRepository.save(item);
//		return (u != null) ? "Saved" : "Error";
//	}
	
	
	
	// Get all items in cart
//	@GetMapping
//	public Iterable<Book> getAll () {
//		return cartRepository.findAll();
//	}

}