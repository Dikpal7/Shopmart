import { Component, OnInit } from "@angular/core";
import {
  FormGroup,
  FormControl,
  FormBuilder,
  Validators,
} from "@angular/forms";
import { AuthService } from "src/app/Services/Auth/auth.service";
import { Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";

@Component({
  selector: "app-signup",
  templateUrl: "./signup.component.html",
  styleUrls: ["./signup.component.scss"],
})
export class SignupComponent implements OnInit {
  signUpForm: FormGroup;
  username: any;
  password: any;
  email: any;
  error: any;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router,
    private toastr: ToastrService
  ) {
    this.signUpForm = this.fb.group({
      username: new FormControl("", Validators.required),
      email: new FormControl("", Validators.required),
      password: new FormControl("", Validators.required),
    });
    this.username = this.signUpForm.get("username");
    this.email = this.signUpForm.get("email");
    this.password = this.signUpForm.get("password");
  }

  ngOnInit() {
    this.authService.logout();
    this.error = null;
  }

  public signUp() {
    this.error = null;
    if (this.signUpForm.valid) {
      this.authService.signup(this.signUpForm.getRawValue()).subscribe(
        (res: { success: boolean; message: string }) => {
          if (res.success) this.router.navigate(["/app/login"]);
          else this.error = res.message;
        },
        (error) => {
          this.error = error.message;
          this.toastr.warning(
            "Username or EmailId already present!",
            "Shopmart"
          );
        }
      );
    }
  }
}
