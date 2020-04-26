import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";

import { MaterialAngularSelectModule } from "material-angular-select";
import { ThemeModule } from "theme";

import { DashboardModule } from "../dashboard/dashboard.module";
import { Dashboard2Component } from "./dashboard2.component";

@NgModule({
  imports: [
    CommonModule,
    ThemeModule,
    FormsModule,
    DashboardModule,
    MaterialAngularSelectModule,
  ],
  declarations: [Dashboard2Component],
})
export class Dashboard2Module {}
