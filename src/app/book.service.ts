import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

import { Book } from './book';


import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/operator/switchMap';

@Injectable()
export class BookService {
    private GoogleBookURL: string = "https://www.googleapis.com/books/v1/volumes?q=";
    private APIKey: string = "&key=AIzaSyBFoKzjV2wbdpI9Vqqmoz0_ZlAua5Nm5BY";

    private bookUrl: string = "http://localhost:8080/api/books/";

    private books: Book[];
    constructor (private http: HttpClient) {
        this.getBooks().subscribe(bookList => this.books = bookList);
    }

    // Get all books from database
    getBooks(): Observable<any> {
        return this.http.get(this.bookUrl + "all");
    }

    // Get book by id
    getBook(id: string): Observable<any> {
        return this.http.get(this.bookUrl + id);
    }

    // Search books from inventory
    searchBooks(term: string): Observable<any> {
        if(!term.trim()) {
            return of([]);
        }
        var regex = new RegExp(term.toLowerCase());
        var length = this.books.length;
        var result: Book[] = [];
        for (var i = 0; i < length; i++) {
            if (regex.test(this.books[i].title.toLowerCase())) {
                result.push(this.books[i]);
            }
        }
        return of(result);
    }


    search(terms: Observable<string>) {
        return terms.debounceTime(300)
                    .distinctUntilChanged()
                    .switchMap(term => this.searchEntries(term));
    }
    searchEntries(searchTerm: string) {
        if (searchTerm.trim()) {
            searchTerm = searchTerm.replace(/\s+/g, '+');
            let URL = this.GoogleBookURL + searchTerm + this.APIKey;
            return this.http.get(URL);
        }
    }

}
