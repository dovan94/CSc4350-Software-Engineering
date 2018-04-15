import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { User } from './user';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {
    private userUrl = "http://localhost:8080/api/users/";

    constructor(private http: HttpClient) { }

    getUser(name: string): Observable<any> {
        return this.http.get(this.userUrl + name);
    }

    isExist(username: string): Observable<any> {
        return this.http.get(this.userUrl + "isExist/" + username);
    }

    signup(user: User): Observable<any> {
        return this.http.post(this.userUrl + "signup", user, {responseType: 'text'});
    }

}
