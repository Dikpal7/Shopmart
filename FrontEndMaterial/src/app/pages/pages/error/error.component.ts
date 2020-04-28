import { Component, HostBinding } from "@angular/core";

import { BlankLayoutCardComponent } from "app/layouts/blank-layout-card";

@Component({
  selector: "app-error",
  styleUrls: [
    "../../../components/blank-layout-card/blank-layout-card.component.scss",
  ],
  templateUrl: "./error.component.html",
})
export class ErrorComponent extends BlankLayoutCardComponent {}
