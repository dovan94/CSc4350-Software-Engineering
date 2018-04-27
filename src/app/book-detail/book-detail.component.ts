import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { BookService } from '../book.service';
import { Book } from '../book';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {
    book: Book;

    constructor (
        private route: ActivatedRoute,
        private location: Location,
        private bookService: BookService
    ) { }

    ngOnInit() {
        this.book = new Book("", "", "", "", "");
        this.getBookDetail();
    }

    getBookDetail(): void {
        const id = this.route.snapshot.paramMap.get('id');
        this.bookService.getBook(id)
            .subscribe(returnedBook => {
                this.book = returnedBook;
                console.log(returnedBook);
            });

    }

}
