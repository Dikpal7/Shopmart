import { Component, OnInit } from "@angular/core";
import { ToastrService } from "ngx-toastr";
import {
  FormGroup,
  FormControl,
  FormBuilder,
  Validators,
} from "@angular/forms";
import { AuthService } from "src/app/Services/Auth/auth.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.scss"],
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  forgetPwdForm: FormGroup;
  username: any;
  password: any;
  error: any;
  email: any;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router,
    private toastr: ToastrService
  ) {
    this.loginForm = this.fb.group({
      username: new FormControl("", Validators.required),
      password: new FormControl("", Validators.required),
    });
    this.username = this.loginForm.get("username");
    this.password = this.loginForm.get("password");

    this.forgetPwdForm = this.fb.group({
      email: new FormControl("", Validators.required),
    });
    this.email = this.forgetPwdForm.get("email");
  }

  ngOnInit() {
    this.error = null;
    this.forgetPwdForm.reset();
  }

  public login() {
    this.error = null;
    if (this.loginForm.valid) {
      this.authService.login(this.loginForm.getRawValue()).subscribe(
        (res) => {
          this.router.navigate([""]);
          window.location.replace("");
        },

        (error) => (
          (this.error = error.message),
          this.toastr.error("Incorrect Credentials", "Shopmart")
        )
      );
    }
  }

  public sendResetLink() {
    this.error = null;
    this.authService.SendEmail(this.email.value).subscribe(
      (res) => {
        this.error = null;
      },
      (error) => (
        (this.error = error.message),
        this.toastr.error("Email does not exist!", "Shopmart")
      )
    );
    if (this.error == null) {
      this.toastr.success("Password Reset link send successfully!", "Shopmart");
    }
  }
}
