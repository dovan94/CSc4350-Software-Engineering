package com.ibooku.kickoff.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
