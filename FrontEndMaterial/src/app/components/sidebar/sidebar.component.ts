import { Component, Input } from "@angular/core";

import { SidebarComponent as BaseSidebarComponent } from "theme/components/sidebar";

@Component({
  selector: "app-sidebar",
  styleUrls: [
    "../../../theme/components/sidebar/sidebar.component.scss",
    "./sidebar.component.scss",
  ],
  templateUrl: "../../../theme/components/sidebar/sidebar.component.html",
})
export class SidebarComponent extends BaseSidebarComponent {
  public title = "Shopmart";
  public menu = [
    { name: "Sign in", link: "/pages/login", icon: "pages" },
    { name: "Sign up", link: "/pages/sign-up", icon: "pages" },
    { name: "404", link: "/pages/error", icon: "pages" },
  ];
}
