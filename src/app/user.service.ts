import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { User } from './user';

@Injectable()
export class UserService {
    private userUrl = "http://localhost:8080/api/users";
    
    constructor(private http: HttpClient) { }

    getUser(name: string): Observable<any> {
        return this.http.get(this.userUrl + name);
    }

    // checkExist(username: string): Observable<any> {
    //     return this.http.get(this.userUrl + "/" + username);
    // }

}
