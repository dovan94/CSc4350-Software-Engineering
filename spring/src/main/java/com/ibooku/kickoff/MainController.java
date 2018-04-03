package com.ibooku.kickoff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibooku.kickoff.User;
import com.ibooku.kickoff.UserRepository;

@RestController
public class MainController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/add")
	public @ResponseBody String add (@RequestParam String name) {
		User u = new User();
		u.setName(name);
		userRepository.save(u);
		return "Saved";
	}


}