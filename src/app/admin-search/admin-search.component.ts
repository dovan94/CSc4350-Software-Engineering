import { Component, OnInit } from '@angular/core';
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

    constructor (
        private bookService: BookService
        // private http: HttpClient
    ) {}

    ngOnInit() {
    }

    search(term: string) {
        if (term) {
            if (term.trim()) {
                this.searchTerm$.next(term);
                this.bookService.search(this.searchTerm$)
                       .subscribe((results: any) => {
                           this.books = results.items;
                       });
            }
        }
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

}
