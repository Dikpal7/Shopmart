import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

import { AuthService } from "@services/*";

@Component({
  selector: "app-common-layout",
  templateUrl: "./common-layout.component.html",
})
export class CommonLayoutComponent implements OnInit {
  public user;
  public isLoggedIn: boolean;

  constructor(private authService: AuthService, private router: Router) {}

  public ngOnInit() {
    this.isLoggedIn = this.authService.isLoggedIn;
    this.authService.userData.subscribe((user) => (this.user = user));
  }

  public logout() {
    if (this.authService.logout()) window.location.reload();
  }

  public login() {
    this.router.navigate(["/pages/login"]);
  }
}
