package com.ibooku.kickoff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibooku.kickoff.User;
import com.ibooku.kickoff.Book;
import com.ibooku.kickoff.Order;
import com.ibooku.kickoff.Wishlist;
import com.ibooku.kickoff.Cart;
import com.ibooku.kickoff.UserRepository;
import com.ibooku.kickoff.BookRepository;
import com.ibooku.kickoff.OrderRepository;
import com.ibooku.kickoff.WishlistRepository;
import com.ibooku.kickoff.CartRepository;

@RestController
public class MainController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/add")
	public @ResponseBody String add (@RequestParam String username) {
		User u = new User();
		u.setUsername(username);


		// Add more attribute setters here

		userRepository.save(u);
		return "Saved";
	}


}
