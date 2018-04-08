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

import com.ibooku.kickoff.User;
import com.ibooku.kickoff.UserRepository;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:4200")
@RequestMapping(path="/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	// Create new user
	@PostMapping
	public @ResponseBody String createUser (@RequestBody User newUser) {
		User u = userRepository.save(newUser);
		return (u != null) ? "Saved" : "Error";
	}

	// Get user by username
	@GetMapping("/{username}")
	public User getUser (@PathVariable String username) {
		User u = userRepository.findByUsername(username);
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
