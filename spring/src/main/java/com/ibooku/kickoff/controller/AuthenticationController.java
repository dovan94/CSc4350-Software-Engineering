package com.ibooku.kickoff.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.ibooku.kickoff.config.JwtTokenUtil;
import com.ibooku.kickoff.model.LoginUser;
import com.ibooku.kickoff.model.User;
import com.ibooku.kickoff.service.UserRepository;

@RestController
@RequestMapping(path="/token")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/generate-token")
	public ResponseEntity registerToken(@RequestBody LoginUser loginUser) throws AuthenticationException {
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final User user = userRepository.findByUsername(loginUser.getUsername());
		final String token = jwtTokenUtil.generateToken(user);
		return ResponseEntity.ok(token);
	}
	
}

