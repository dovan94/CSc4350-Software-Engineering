package com.ibooku.kickoff.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Book implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="book_id")
	private Integer bId;
	private String title;
  	private String author;
  	private String genre;
  	private String isbn;
  	private double price;
  	private String description;
	private String image;
	private int stock;


	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval=true)
	private Set<Cart> users = new HashSet<>();;
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JsonBackReference
//	@JoinTable(name = "Cart",
//			joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
//			inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
//	private Set<User> users = new HashSet<>();
	

	public Integer getBook_id() {
		return bId;
	}
	public void setBook_id(Integer id) {
		bId = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
  	}
	public void setAuthor(String author) {
		this.author = author;
	}

  	public String getGenre() {
  		return genre;
  	}
  	public void setGenre(String genre) {
  		this.genre = genre;
  	}

  	public String getIsbn() {
  		return isbn;
  	}
  	public void setIsbn(String isbn) {
  		this.isbn = isbn;
  	}

  	public double getPrice() {
  		return price;
  	}
  	public void setPrice(double price) {
  		this.price = price;
  	}

  	public String getDescription() {
  		return description;
  	}
  	public void setDescription(String description) {
  		this.description = description;
  	}

	public String getImage() {
		return image;
  	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@JsonBackReference
	public Set<Cart> getUsers() {
		return users;
	}
	public void setUsers(Set<Cart> users) {
		this.users = users;
	}
	
	@Override
	public String toString() {
		String result = "" + bId;
		return result;
	}
}
