import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Book } from './book';
import { BOOKS } from './mock-books';

import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/operator/switchMap';

@Injectable()
export class BookService {
    private GoogleBookURL: string = "https://www.googleapis.com/books/v1/volumes?q=";

    constructor (private http: HttpClient) { }

    // Get all books from database
    getBooks(): Observable<Book[]> {
        return of(BOOKS);
    }

    // Get a book with the passed in id
    getBook(id: any): Observable<Book> {
        return of(BOOKS.find(book => book.id == id));
    }


    search(terms: Observable<string>) {
        return terms.debounceTime(300)
                    .distinctUntilChanged()
                    .switchMap(term => this.searchEntries(term));
    }
    searchEntries(searchTerm: string) {
        if (searchTerm.trim()) {
            searchTerm = searchTerm.replace(/\s+/g, '+');
            let URL = this.GoogleBookURL + searchTerm;
            return this.http.get(URL);

        }
    }

}
