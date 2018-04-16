import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class AuthService {
    baseUrl = "http://localhost:8080/";

    constructor(private http: HttpClient) { }

    attemptAuth(username: string, password: string): Observable<any> {
        const credentials = {
            username: username,
            password: password
        };
        console.log("attemptAuth ::");
        return this.http.post(this.baseUrl + "token/generate-token", credentials, {responseType: 'text'});
    }

}
