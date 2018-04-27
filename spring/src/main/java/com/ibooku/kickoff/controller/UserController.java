package com.ibooku.kickoff.controller;

import java.io.IOException;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibooku.kickoff.model.Cart;
import com.ibooku.kickoff.model.User;
import com.ibooku.kickoff.service.BookRepository;
import com.ibooku.kickoff.service.UserRepository;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:4200")
@RequestMapping(path="/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;


	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	// Create new user
	@PostMapping("/signup")
	public @ResponseBody String createUser(@RequestBody User newUser) {
		newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
		User u = userRepository.save(newUser);
		return (u != null) ? "Saved" : "Error";
	}

	// Get user by username
	@GetMapping("username/{username}")
	public User getByUsername(@PathVariable String username) {
		User u = userRepository.findByUsername(username);
		return u;
	}

	
	// Get user by id
	@GetMapping("/{id}")
	public User getById(@PathVariable Integer id) {
		User u = userRepository.findByUId(id);
		return u;
	}
	

	// Check if username is exists
	@GetMapping("/isExist/{username}")
	public boolean isExist (@PathVariable String username) {
		return userRepository.findByUsername(username) != null;
	}

	// Get all users
	@GetMapping
	public Iterable<User> getAll () {
		return userRepository.findAll();
	}
	

}
