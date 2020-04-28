import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute } from "@angular/router";
import { AuthService } from "app/services";
import { Subject } from "rxjs";

@Component({
  selector: "app-reset-password",
  templateUrl: "./reset-password.component.html",
  styleUrls: [
    "../../../layouts/blank-layout-card/blank-layout-card.component.scss",
  ],
})
export class ResetPasswordComponent implements OnInit {
  ngUnsubscribe: Subject<any> = new Subject<any>();
  private newPassword;
  private confirmPassword;
  confirmationToken: string;
  error: any;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private authService: AuthService
  ) {}

  ngOnInit() {
    this.activatedRoute.queryParamMap.subscribe((queryParams) => {
      this.confirmationToken = queryParams.get("token");
    });

    // this.authService
    //   .verifyPasswordToken(this.confirmationToken)
    //   .subscribe((res) => {
    //     if (!res) {
    //       alert("link is not valid");
    //       this.router.navigate(["/pages/login"]);
    //     }
    //   });
  }

  resetPassword() {
    this.error = null;
    this.newPassword = (<HTMLInputElement>(
      document.getElementById("password")
    )).value;
    this.confirmPassword = (<HTMLInputElement>(
      document.getElementById("confirmPassword")
    )).value;
    if (
      this.newPassword === "" ||
      this.confirmPassword === "" ||
      this.newPassword !== this.confirmPassword
    )
      alert("Confirmation Password should be same as password!");
    else {
      var data = {
        newPassword: this.newPassword,
        confirmationToken: this.confirmationToken,
      };
      this.authService.resetPassword(data).subscribe((res) => {
        if (res) {
          alert("Password reset successfully!");
          this.router.navigate(["/pages/login"]);
        } else alert("Link is not valid!");
      });
    }
  }
}
