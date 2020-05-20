import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute } from "@angular/router";
import { AuthService } from "../../Services/Auth/auth.service";

@Component({
  selector: "app-megamenu",
  templateUrl: "./megamenu.component.html",
  styleUrls: ["./megamenu.component.scss"],
})
export class MegamenuComponent implements OnInit {
  public user;
  public isLoggedIn: boolean;
  productCategory: any[];

  constructor(
    private authService: AuthService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.isLoggedIn = localStorage.getItem("isLoggedIn") === "true";
    this.authService.userData.subscribe((user) => (this.user = user));
    this.productCategory = this.activatedRoute.snapshot.data.data;
  }

  public logout() {
    if (this.authService.logout()) {
      window.location.replace("app");
    }
  }

  public loginBtn() {
    this.router.navigate(["app/login"]);
  }
}
