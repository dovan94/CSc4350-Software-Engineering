import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { Book } from './book';
import { BOOKS } from './mock-books';


@Injectable()
export class BookService {

    constructor() { }

    // Get all books from database
    getBooks(): Observable<Book[]> {
        return of(BOOKS);
    }

    // Get a book with the passed in id
    getBook(id: any): Observable<Book> {
        return of(BOOKS.find(book => book.id == id));
    }


}
