import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Location } from '@angular/common';

import { AuthService } from '../auth.service';
import { UserService } from '../user.service';
import { TokenStorage } from '../token.storage';
import { User } from '../user';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    username: string;
    password: string;

    constructor(
        private authService: AuthService,
        private userService: UserService,
        private token: TokenStorage,
        private router: Router,
        private location: Location
    ) { }

    ngOnInit() {
    }

    login(): void {
        this.authService.attemptAuth(this.username, this.password)
            .subscribe(secretToken => {
                this.token.saveToken(secretToken);
                this.userService.getUser(this.username)
                    .subscribe((foundUser: User) => {
                        this.token.saveUsername(foundUser.username);
                        this.token.saveUserID(foundUser.user_id);
                        location.reload();
                        this.router.navigate(['books']);
                    })

            });


        //handle code 401

    }

}
