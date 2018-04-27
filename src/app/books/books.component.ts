import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { BookService } from '../book.service';
import { CartService } from '../cart.service';
import { TokenStorage } from '../token.storage';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {
    books: Book[];
    isAdded: boolean = false;

    constructor (
        private bookService: BookService,
        private cartService: CartService,
        private token: TokenStorage
    ) { }

    ngOnInit() {
        this.getBooks();
    }

    getBooks(): void {
        this.bookService.getBooks()
            .subscribe(books => this.books = books);
    }

    addToCart(book_id: string) {
        let user_id = this.token.getUserId();

        this.cartService.addToCart(user_id, book_id.toString())
            .subscribe(() => this.isAdded = true);

    }

}
