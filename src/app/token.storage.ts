import { Injectable } from '@angular/core';

const TOKEN_KEY = "AuthToken";
const USERNAME = "Username";

@Injectable()
export class TokenStorage {

    constructor() {}

    signOut() {
        window.sessionStorage.removeItem(TOKEN_KEY);
        window.sessionStorage.removeItem(USERNAME);
        window.sessionStorage.clear();
    }

    public saveToken(token: string) {
        window.sessionStorage.removeItem(TOKEN_KEY);
        window.sessionStorage.setItem(TOKEN_KEY, token);
    }

    public getToken(): string {
        return sessionStorage.getItem(TOKEN_KEY);
    }

    public saveUsername(username: string) {
        window.sessionStorage.removeItem(USERNAME);
        window.sessionStorage.setItem(USERNAME, username);
    }

    public getUsername(): string {
        return sessionStorage.getItem(USERNAME);
    }
}
