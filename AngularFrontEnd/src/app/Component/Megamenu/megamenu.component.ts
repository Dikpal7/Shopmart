import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../Services/Auth/auth.service";
import {ProdService} from "../../Services/DataServices/prod.service";
import {Product} from "../../Model/Product";
import {Brand} from "../../Model/Brand";

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
    private activatedRoute: ActivatedRoute,
    private prodService: ProdService
  ) {
  }

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

  public getLatestValueOnClick(brandObj: Brand) {
    this.prodService.changeProductValue(brandObj);
  }
}
