package com.ibooku.kickoff.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Book {
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

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "Cart",
			joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
	private Set<User> users = new HashSet<>();
	
	public Book() {
		this.bId = null;
		this.title = "";
	    this.author = "";
	    this.genre = "";
	    this.isbn = "";
	    this.price = 0.0;
	    this.description = "";
		this.image = "";
	}

	public Integer getBook_id() {
		return bId;
	}
	
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
  	}

  	public String getGenre() {
  		return genre;
  	}

  	public String getIsbn() {
  		return isbn;
  	}

  	public double getPrice() {
  		return price;
  	}

  	public String getDescription() {
  		return description;
  	}

	public String getImage() {
		return image;
  	}
}
