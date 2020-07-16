import { Component } from "@angular/core";
import { AuthService } from "./Services/Auth/auth.service";
import { Router, ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.scss"],
})
export class AppComponent {
  title = "Shopmart";

  constructor() {}

  ngOnInit() {}
}
