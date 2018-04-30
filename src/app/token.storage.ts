import { Injectable } from '@angular/core';


const TOKEN_KEY = "AuthToken";
const USERNAME = "Username";
const USER_ID = "UserID";
const USER_ROLE = "User";


@Injectable()
export class TokenStorage {

    constructor() {}

    signOut() {
        window.sessionStorage.removeItem(TOKEN_KEY);
        window.sessionStorage.removeItem(USERNAME);
        window.sessionStorage.removeItem(USER_ID);
        window.sessionStorage.removeItem(USER_ROLE);
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

    public getRole(): string {
        return sessionStorage.getItem(USER_ROLE);
    }
    public saveRole(role: string) {
        window.sessionStorage.removeItem(USER_ROLE);
        window.sessionStorage.setItem(USER_ROLE, role);
    }

}
