import { Injectable } from "@angular/core";
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  CanActivateChild,
  UrlTree,
  RouterStateSnapshot,
} from "@angular/router";

import { AuthService } from "./auth.service";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class AuthGuard implements CanActivate, CanActivateChild {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate(next: ActivatedRouteSnapshot): boolean {
    return localStorage.getItem("isLoggedIn") == null;
  }

  canActivateChild(next: ActivatedRouteSnapshot): boolean {
    return localStorage.getItem("isLoggedIn") == null;
  }
}
