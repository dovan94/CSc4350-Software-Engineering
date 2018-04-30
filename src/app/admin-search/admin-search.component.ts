import { Component, OnInit, EventEmitter, Input, Output} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Subject }    from 'rxjs/Subject';
import { of }         from 'rxjs/observable/of';

// import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';

import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/operator/switchMap';


import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-admin-search',
  templateUrl: './admin-search.component.html',
  styleUrls: ['./admin-search.component.css']
})
export class AdminSearchComponent implements OnInit {

    // private GoogleBookURL: string = "https://www.googleapis.com/books/v1/volumes?q=";

    books: any[] = [];
    dropDown = false;
    searchWidth = true;
    searchTerm$ = new Subject<string>();
    isClick = false;
    // @Input() count: number;
    count = 0;
    isbn: string = "";
    result: any;
    book = new Book("", "", "", "", "");

    @Output()
    searchedBook: EventEmitter<any> = new EventEmitter<any>();
    // reset: EventEmitter<any> = new EventEmitter<any>();

    constructor (
        private bookService: BookService
        // private http: HttpClient
    ) {}

    ngOnInit() {

    }

    onfocus(){
        this.dropDown = !this.dropDown;
        if(this.dropDown)
          this.searchWidth = false;
        else
          this.searchWidth = true;
    }
    onblur(){
        this.searchWidth = true;
        this.dropDown = !this.dropDown;
        this.onfocus();
    }

    onReset() {
        this.isbn = "";
    }

    onSearch() {
        if (this.isbn === "" || this.isbn.length != 13) {
            alert("Please enter valid book's ISBN");
        } else {
            this.bookService.search(this.isbn).subscribe((bookInfo: any) => {
                let items = bookInfo.items;
                for (let item of items) {
                    let volumeInfo = item.volumeInfo;
                    for (let isbnInfo of volumeInfo.industryIdentifiers) {
                        if (isbnInfo.type === "ISBN_13" && isbnInfo.identifier === this.isbn) {
                            this.book.title = volumeInfo.title;
                            this.book.author = volumeInfo.authors[0];
                            this.book.isbn = this.isbn;
                            this.book.genre = volumeInfo.categories[0];
                            this.book.image = volumeInfo.imageLinks.thumbnail;
                            this.book.description = volumeInfo.description;
                            this.searchedBook.emit(this.book);
                        }
                    }
                }
            });
        }
    }
}
