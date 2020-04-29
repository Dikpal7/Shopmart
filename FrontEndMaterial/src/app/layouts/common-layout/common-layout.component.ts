import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

import { AuthService } from "@services/*";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-common-layout",
  templateUrl: "./common-layout.component.html",
})
export class CommonLayoutComponent implements OnInit {
  public user;
  public isLoggedIn: boolean;
  productCategory: any[];

  constructor(
    private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  public ngOnInit() {
    this.isLoggedIn = localStorage.getItem("isLoggedIn") === "true";
    this.authService.userData.subscribe((user) => (this.user = user));
    this.productCategory = this.route.snapshot.data.data;
  }

  public logout() {
    if (this.authService.logout()) window.location.reload();
  }

  public login() {
    this.router.navigate(["/pages/login"]);
  }
}
