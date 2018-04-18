package com.ibooku.kickoff.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// import User and Book?

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cart_id;
	private Integer user_id;
  private Integer book_id;

	public Cart() {
		this.cart_id = null;
    this.user_id = 0;
    this.book_id = 0;
			// Add addresses
	}

	// get user_id
	public Integer getUser_id() {
		return user_id;
	}


}
