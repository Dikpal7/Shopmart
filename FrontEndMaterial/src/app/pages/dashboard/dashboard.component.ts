import { Component, HostBinding, OnInit } from "@angular/core";

import { UpgradableComponent } from "theme/components/upgradable";

@Component({
  selector: "app-dashboard",
  styleUrls: ["./dashboard.component.scss"],
  templateUrl: "./dashboard.component.html",
})
export class DashboardComponent extends UpgradableComponent {
  @HostBinding("class.mdl-grid") private readonly mdlGrid = true;
  @HostBinding("class.mdl-grid--no-spacing")
  private readonly mdlGridNoSpacing = true;
}
