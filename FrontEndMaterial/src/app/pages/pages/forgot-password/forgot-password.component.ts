import { Component, HostBinding } from "@angular/core";
import { BlankLayoutCardComponent } from "app/components/blank-layout-card";
import { AuthService } from "app/services";

@Component({
  selector: "app-forgot-password",
  styleUrls: [
    "../../../components/blank-layout-card/blank-layout-card.component.scss",
  ],
  templateUrl: "./forgot-password.component.html",
})
export class ForgotPasswordComponent extends BlankLayoutCardComponent {
  private email;
  private isEmailExist;
  public error: string;

  constructor(private service: AuthService) {
    super();
  }

  SendEmail() {
    this.error = null;
    this.email = document.getElementById("e-mail");
    this.service.SendEmail(this.email.value).subscribe(
      (res: { success: boolean; message: string }) => {
        if (res.success) alert(res.message);
        else alert(res.message);
      },
      (error) => (this.error = error.message)
    );
  }
}
