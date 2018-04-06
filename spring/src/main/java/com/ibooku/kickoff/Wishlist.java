package com.ibooku.kickoff;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// import User and Book?

@Entity
public class Wishlist {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cart_id;
	private Integer user_id;
  	private Integer book_id;

	public Wishlist() {
		this.cart_id = null;
		this.user_id = 0;
		this.book_id = 0;
	}


}
