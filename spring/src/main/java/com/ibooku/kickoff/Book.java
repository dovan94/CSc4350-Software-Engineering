package com.ibooku.kickoff;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer book_id;
	private String title;
  	private String author;
  	private String genre;
  	private String isbn;
  	private double price;
  	private String description;
	private String image;


	public Book() {
		this.id = null;
		this.title = "";
	    this.author = "";
	    this.genre1 = "";
	    this.isbn = "";
	    this.price = 0.0;
	    this.description = "";
		this.image = "";
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
    	return author;
  	}

  	public String getGenre1() {
    	return genre1;
  	}

  	public String getIsbn() {
    	return isbn;
  	}

  	public int getPrice() {
    	return price;
  	}

  	public String getDescription() {
    	return description;
  	}

	public String getImage() {
    	return image;
  	}
}
