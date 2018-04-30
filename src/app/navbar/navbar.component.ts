import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { TokenStorage } from '../token.storage';
import { Router } from '@angular/router';
import { Location } from '@angular/common';



@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
    username: string;
    status: string;
    isLoggedin: boolean = false;
    isAdmin: boolean = false;

    constructor(private token: TokenStorage,
                private router: Router,
                private location: Location) { }

    ngOnInit() {
        this.username = this.token.getUsername();

        if (this.username == null) {
            this.status = "Login";
        } else {
            this.status = "Hi, " + this.token.getUsername();
            this.isLoggedin = true;
            if (this.token.getRole() === "admin") {
                this.isAdmin = true;
            }
        }
    }



    signOut(): void {
        this.token.signOut();
        this.isLoggedin = false;
        this.isAdmin = false;
        location.reload();
    }
}
