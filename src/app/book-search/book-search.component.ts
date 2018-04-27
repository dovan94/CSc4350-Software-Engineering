import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Subject }    from 'rxjs/Subject';

import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';

import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-book-search',
  templateUrl: './book-search.component.html',
  styleUrls: ['./book-search.component.css']
})
export class BookSearchComponent implements OnInit {

    books$: Observable<Book[]>
    searchTerms = new Subject<string>();

    constructor(private bookService: BookService) { }

    ngOnInit(): void {
        this.books$ = this.searchTerms.pipe(
            // wait 400ms after each keystroke before considering the term
            debounceTime(400),

            // ignore new term if same as previous term
            distinctUntilChanged(),

            // switch to new search observable each time the term changes
            switchMap((term: string) => this.bookService.searchBooks(term)),
        );
    }

    // Push a search term into the observable stream.
    search(keyword: string): void {
        this.searchTerms.next(keyword);
    }

}
