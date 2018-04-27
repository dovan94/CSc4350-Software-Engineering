package com.ibooku.kickoff.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


// This class is used to show composite primary keys (of Cart)
@Embeddable
public class CartId implements Serializable {

	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "book_id")
	private Integer bookId;
	
	public CartId() {}
	
	public CartId(Integer uid, Integer bid) {
		userId = uid;
		bookId = bid;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer id) {
		userId = id;
	}
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer id) {
		bookId = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		CartId cId = (CartId) obj;
		if (userId != cId.userId) return false;
		return bookId == cId.bookId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(userId, bookId);
	}
	
}
