package com.ibooku.kickoff.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// import User and Book?

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//private Integer cart_id;
	private Integer user_id;
  private Integer book_id;

	public Order() {
		//this.cart_id = null;
		this.user_id = 0;
		this.book_id = 0;
	}

	//user_id's getter and setter
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer id) {
		user_id = id;
	}

	//book_id's getter and setter
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer id) {
		book_id = id;
	}

}
