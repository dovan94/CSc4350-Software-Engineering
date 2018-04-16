import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest,
         HttpResponse, HttpHeaderResponse, HttpErrorResponse,
         HttpSentEvent, HttpProgressEvent, HttpUserEvent, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs/observable';
import { Router } from '@angular/router';
import { TokenStorage } from './token.storage';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';


const TOKEN_HEADER_KEY = 'Authorization';

@Injectable()
export class Interceptor implements HttpInterceptor {

    constructor(
        private token: TokenStorage,
        private router: Router
    ) {}

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let authReq = req;
        if (this.token.getToken() != null) {
            //clone the request to add the new header
            authReq = req.clone({ headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + this.token.getToken()) });
        }

        // send the newly created request
        return next.handle(authReq).do((err: any) => {
            if (err instanceof HttpErrorResponse) {
                console.log("error " + err);
                console.log('req url :: ' + req.url);
                if (err.status === 401) {
                    console.log("401 code");
                    this.router.navigate(['login']);
                }
            }
        });
    }
}
