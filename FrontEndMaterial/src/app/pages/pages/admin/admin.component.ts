import { Component, OnInit } from "@angular/core";
import { BlankLayoutCardComponent } from "app/layouts/blank-layout-card";

@Component({
  selector: "app-admin",
  templateUrl: "./admin.component.html",
  styleUrls: [
    "../../../layouts/blank-layout-card/blank-layout-card.component.scss",
  ],
})
export class AdminComponent extends BlankLayoutCardComponent implements OnInit {
  constructor() {
    super();
  }

  ngOnInit() {}
}
