import { Component, OnInit, ViewChild } from '@angular/core';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {

  display = false;
  book = new Book("", "", "", "", "");

  @ViewChild('searchBar') searchComponent;

  constructor(
  	private bookService: BookService
  	) { }

  ngOnInit() {
  }

  sayHello(event) {
  	console.log(event);
  }

  searchForBook(book) {
  	if (book.isbn != "") {
  		this.display = true;
  		this.book.isbn = book.isbn;
  		this.book.title = book.title;
  		this.book.genre = book.genre;
        this.book.author = book.author;
        this.book.price = book.price;
        this.book.description = book.description;
        this.book.image = book.image;
        this.book.stock = 10;
  	}
  }

  onCancel(f) {
  	f.resetForm();
  	this.display = false;
  	this.searchComponent.onReset();
  }

  onSubmit(f) {
  	this.bookService.addBook(this.book)
  		.subscribe(res => {
  			if (res === "Saved") {
  				f.resetForm();
  				console.log("success");
  				this.display = false;
  			} else {
  				console.log(res);
  			}
  		});
  }
}
