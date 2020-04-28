import { Component, HostBinding, OnInit } from "@angular/core";

import { UpgradableComponent } from "theme/components/upgradable";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-dashboard",
  styleUrls: ["./dashboard.component.scss"],
  templateUrl: "./dashboard.component.html",
})
export class DashboardComponent extends UpgradableComponent implements OnInit {
  @HostBinding("class.mdl-grid") private readonly mdlGrid = true;
  @HostBinding("class.mdl-grid--no-spacing")
  private readonly mdlGridNoSpacing = true;
  data: any;

  ngOnInit() {
    this.data = this.route.snapshot.data;
    console.log(this.data);
  }

  constructor(private route: ActivatedRoute) {
    super();
  }
}
