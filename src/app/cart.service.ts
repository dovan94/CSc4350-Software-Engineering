import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from './user';
import { Book } from './book';

@Injectable()
export class CartService {
    private cartUrl: string = "http://localhost:8080/api/cart/"

    constructor(private http: HttpClient) { }

    // Add book to Cart
    addToCart(userId: string, bookId: string): Observable<any> {
        let user = new User("", "", "", "", "");
        user.setId(userId);

        let book = new Book("", "", "", "", "");
        book.setId(bookId);

        const item = {
            user: user,
            book: book,
            quantity: 1
        }
        return this.http.post(this.cartUrl + "add", item);
    }

    // get items from cart
    getCartItems(userId: string): Observable<any> {
        return this.http.get(this.cartUrl + userId);
    }
}
