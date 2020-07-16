import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { BehaviorSubject, Observable, of } from "rxjs";
import { map } from "rxjs/operators";

import { environment } from "../../../environments/environment";

const tokenName = "token";

@Injectable({
  providedIn: "root",
})
export class AuthService {
  private isLogged$ = new BehaviorSubject(false);
  private url = `${environment.apiBaseUrl}/api/auth`;
  private username;

  constructor(private http: HttpClient) {}

  public get isLoggedIn(): boolean {
    return this.isLogged$.value;
  }

  public login(data): Observable<any> {
    return this.http
      .post(`${this.url}/signin`, {
        usernameOrEmail: data["username"],
        password: data["password"],
      })
      .pipe(
        map((res: { accessToken: string; username: any }) => {
          this.username = res.username;
          localStorage.setItem(tokenName, res.accessToken);
          localStorage.setItem("username", res.username);
          localStorage.setItem("isLoggedIn", "true");
          this.isLogged$.next(true);
          return this.username;
        })
      );
  }

  public logout() {
    localStorage.clear();
    this.username = null;
    this.isLogged$.next(false);
    return true;
  }

  public signup(data): Observable<any> {
    return this.http.post(`${this.url}/register`, data).pipe(
      map((res) => {
        return res;
      })
    );
  }

  public get authToken(): string {
    return localStorage.getItem(tokenName);
  }

  public get userData(): Observable<any> {
    // send current user or load data from backend using token
    return this.loadUser();
  }

  public SendEmail(email): Observable<any> {
    return this.http.post(`${this.url}/sendEmail`, email).pipe(
      map((res) => {
        return res;
      })
    );
  }

  public resetPassword(data): Observable<any> {
    return this.http
      .post(`${this.url}/resetPassword`, {
        newPassword: data["newPassword"],
        confirmationToken: data["confirmationToken"],
      })
      .pipe(
        map((res) => {
          return res;
        })
      );
  }

  public verifyPasswordToken(token): Observable<boolean> {
    return this.http.post(`${this.url}/verifyToken`, token).pipe(
      map((res: { isExists: boolean }) => {
        return res.isExists;
      })
    );
  }

  private loadUser(): Observable<any> {
    //use request to load user data with token
    if (localStorage.getItem("username") && localStorage.getItem("token")) {
      this.username = {
        username: localStorage.getItem("username"),
      };
    } else this.username = null;
    return of(this.username);
  }
}
