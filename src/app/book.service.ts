import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Book } from './book';

import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/operator/switchMap';

@Injectable()
export class BookService {
    private GoogleBookURL: string = "https://www.googleapis.com/books/v1/volumes?q=";
    private APIKey: string = "&key=AIzaSyBFoKzjV2wbdpI9Vqqmoz0_ZlAua5Nm5BY";

    private bookUrl: string = "http://localhost:8080/api/books/";

    constructor (private http: HttpClient) { }

    // Get all books from database
    getBooks(): Observable<any> {
        // return of(BOOKS);
        return this.http.get(this.bookUrl + "all");
    }

    // Get book by id
    getBook(id: any): Observable<any> {
        return this.http.get(this.bookUrl + id);
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
