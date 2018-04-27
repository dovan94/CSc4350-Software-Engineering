import { Injectable } from '@angular/core';


const TOKEN_KEY = "AuthToken";
const USERNAME = "Username";
const USER_ID = "UserID";


@Injectable()
export class TokenStorage {

    constructor() {}

    signOut() {
        window.sessionStorage.removeItem(TOKEN_KEY);
        window.sessionStorage.removeItem(USERNAME);
        window.sessionStorage.removeItem(USER_ID);
        window.sessionStorage.clear();
    }

    public getToken(): string {
        return sessionStorage.getItem(TOKEN_KEY);
    }
    public saveToken(token: string) {
        window.sessionStorage.removeItem(TOKEN_KEY);
        window.sessionStorage.setItem(TOKEN_KEY, token);
    }

    public getUsername(): string {
        return sessionStorage.getItem(USERNAME);
    }
    public saveUsername(username: string) {
        window.sessionStorage.removeItem(USERNAME);
        window.sessionStorage.setItem(USERNAME, username);
    }

    public getUserId(): string {
        return sessionStorage.getItem(USER_ID);
    }
    public saveUserId(id: string) {
        window.sessionStorage.removeItem(USER_ID);
        window.sessionStorage.setItem(USER_ID, id);
    }


}
