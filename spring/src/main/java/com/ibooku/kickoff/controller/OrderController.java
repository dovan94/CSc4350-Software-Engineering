package com.ibooku.kickoff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ibooku.kickoff.model.Cart;
import com.ibooku.kickoff.model.User;
import com.ibooku.kickoff.model.Book;
import com.ibooku.kickoff.service.OrderRepository;
import com.ibooku.kickoff.service.CartRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/api/orders")

public class OrderController {

  @Autowired
  private OrderRepository orderRepository;
  // @Autowired
	// private CartRepository cartRepository;

  // Add cart item to order
  @PostMapping("/add")
	public @ResponseBody String addToOrder (@RequestBody Order item) {
    Order c = orderRepository.save(item);
		return (c != null) ? "Saved" : "Error";
	}


}
