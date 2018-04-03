package com.ibooku.kickoff;

import org.springframework.data.repository.CrudRepository;
import com.ibooku.kickoff.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
}