package com.ibooku.kickoff.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ibooku.kickoff.model.User;

@CrossOrigin(origins = "http://localhost:4200")
public interface UserRepository extends CrudRepository<User, Integer> {
	User findByUsername(String username);
	User findByUId(Integer id);
}