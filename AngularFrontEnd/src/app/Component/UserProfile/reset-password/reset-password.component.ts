import { Component, OnInit } from "@angular/core";
import {
  FormGroup,
  FormBuilder,
  Validators,
  FormControl,
} from "@angular/forms";
import { AuthService } from "src/app/Services/Auth/auth.service";
import { Router, ActivatedRoute } from "@angular/router";
import { ToastrService } from "ngx-toastr";

@Component({
  selector: "app-reset-password",
  templateUrl: "./reset-password.component.html",
  styleUrls: ["./reset-password.component.scss"],
})
export class ResetPasswordComponent implements OnInit {
  resetPwdForm: FormGroup;
  error: any;
  password: any;
  cnfPassword: any;
  confirmationToken: string;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private toastr: ToastrService
  ) {
    this.resetPwdForm = this.fb.group({
      password: new FormControl("", Validators.required),
      cnfPassword: new FormControl("", Validators.required),
    });
    this.password = this.resetPwdForm.get("password");
    this.cnfPassword = this.resetPwdForm.get("cnfPassword");
  }

  ngOnInit() {
    this.activatedRoute.queryParamMap.subscribe((queryParams) => {
      this.confirmationToken = queryParams.get("token");
    });
    this.error = null;
  }

  resetPassword() {
    this.error = null;
    if (this.password.value != this.cnfPassword.value)
      this.toastr.warning(
        "Confirmation Password should be same as password!!",
        "Shopmart"
      );
    else {
      var data = {
        newPassword: this.password.value,
        confirmationToken: this.confirmationToken,
      };
      this.authService.resetPassword(data).subscribe((res) => {
        if (res) {
          this.toastr.success("Password reset successfully!", "Shopmart");
          this.router.navigate(["/app/login"]);
        } else this.toastr.warning("Password reset link expired!", "Shopmart");
      });
    }
  }
}
