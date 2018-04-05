package com.ibooku.kickoff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ibooku.kickoff.User;
import com.ibooku.kickoff.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/api/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	// Create new user
	@PostMapping
	public @ResponseBody String createUser (@RequestParam String name) {
		User u = new User();
		u.setUsername(name);
		userRepository.save(u);
		return "Saved";
	}
	
	// Get user by username
	@GetMapping("/{username}")
	public User getUser (@PathVariable String username) {
		User u = userRepository.findByUsername(username);
		return u;
	}
	
	// Get all users
	@GetMapping
	public Iterable<User> getAll () {
		return userRepository.findAll();
	}

}