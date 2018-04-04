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
  private String genre1;
  private String genre2;
  private String isbn;
  private int price;
  private String description;


	public Book() {
		this.id = null;
		this.title = "";
    this.author = "";
    this.genre1 = "";
    this.genre2 = "";
    this.isbn = "";
    this.price = 0;
    this.description = "";
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

  public String getGenre2() {
    return genre2;
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
}
