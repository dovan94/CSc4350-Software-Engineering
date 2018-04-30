package com.ibooku.kickoff.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "Cart")
public class Cart {


	@EmbeddedId
	private CartId cartId;

	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@MapsId("bookId")
	@JoinColumn(name = "book_id")
	private Book book;

	@Column
	private int quantity;

	// Jeff
	@Column
	private int ordered;

	public CartId getCartId() {
		return cartId;
	}
	public void setCartId(CartId cid) {
		cartId = cid;
	}

	// JsonBackReference prevents infinite recursion when performing a join
	// because User refers to Cart and Cart refers to User at the same time
	// This tells Spring Boot to ignore when Cart refers to User
	@JsonBackReference
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// Jeff -set ordered
	public void order(){
		this.ordered += 1;
	}

	@Override
	public String toString() {
		String result = "uid: " + user + "\nbid: " + book + "\nquantity:" + quantity + "\nordered:" + ordered;
		return result;
	}


//	@Override
//	public String toString() {
//		String result = "uid: " + userId + " bid: " + bookId;
//		return result;
//	}
}
