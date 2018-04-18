import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class CartService {
    private userUrl: string = "http://localhost:8080/api/users/";

    constructor(private http: HttpClient) { }

    // Add book to Cart
    addToCart(userId: string, bookId: string): Observable<any> {
        const item = {
            userId: userId,
            bookId: bookId
        }
        return this.http.post(this.userUrl + "add", item);
    }

}
