package com.ibooku.kickoff.model;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer uId;
	private String username;
	private String email;
	private String password;
	private String first_name;
	private String last_name;
	
	@ManyToMany
	@JoinTable(name = "Cart",
		joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"))
	private Set<Book> cart_books = new HashSet<>();
	
	//user_id's getter and setter
	public Integer getUser_id() {
		return uId;
	}
	public void setUser_id(Integer id) {
		uId = id;
	}

	// Username's getter and setter
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	// Email's getter and setter
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Password's getter and setter
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// first_name's getter and setter
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	// last_name's getter and setter
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	// cart items' getter and setter
	public Set<Book> getCartItems() {
		return cart_books;
	}
	public void setCartItems(Set<Book> cart_books) {
		this.cart_books = cart_books;
	}
	
}

