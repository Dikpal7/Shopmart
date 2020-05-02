import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute } from "@angular/router";
import { AuthService } from "app/services";
import { Subject } from "rxjs";
import { BlankLayoutCardComponent } from "app/layouts/blank-layout-card";
import {
  FormBuilder,
  FormGroup,
  Validators,
  FormControl,
} from "@angular/forms";

@Component({
  selector: "app-reset-password",
  templateUrl: "./reset-password.component.html",
  styleUrls: [
    "../../../layouts/blank-layout-card/blank-layout-card.component.scss",
  ],
})
export class ResetPasswordComponent extends BlankLayoutCardComponent
  implements OnInit {
  private resetForm: FormGroup;
  private password;
  private confirmPassword;
  confirmationToken: string;
  error: any;

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private authService: AuthService
  ) {
    super();

    this.resetForm = this.fb.group({
      password: new FormControl("", Validators.required),
      confirmPassword: new FormControl("", Validators.required),
    });
    this.password = this.resetForm.get("password").value;
    this.confirmPassword = this.resetForm.get("confirmPassword").value;
  }

  ngOnInit() {
    this.activatedRoute.queryParamMap.subscribe((queryParams) => {
      this.confirmationToken = queryParams.get("token");
    });
    this.resetForm.valueChanges.subscribe(() => {
      this.error = null;
    });
  }

  resetPassword() {
    this.error = null;
    if (this.password != this.confirmPassword)
      alert("Confirmation Password should be same as password!");
    else {
      var data = {
        newPassword: this.resetForm.get("password").value,
        confirmationToken: this.confirmationToken,
      };
      this.authService.resetPassword(data).subscribe((res) => {
        if (res) {
          alert("Password reset successfully!");
          this.router.navigate(["/pages/login"]);
        } else alert("link is not valid to resest password!");
      });
    }
  }
}
