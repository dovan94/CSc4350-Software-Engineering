package com.ibooku.kickoff.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// import User and Book?

//@Entity
public class Cart {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Integer cart_id;
	private Integer userId;
  	private Integer bookId;

	public Cart() {
    		this.userId = 0;
    		this.bookId = 0;
	}

	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer user_id) {
		this.userId = user_id;
	}
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer book_id) {
		this.bookId = book_id;
	}
	
	@Override
	public String toString() {
		String result = "uid: " + userId + " bid: " + bookId;
		return result;
	}
}
