import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";

import { ThemeModule } from "theme";
import { ComponentsComponent } from "./components.component";
@NgModule({
  imports: [CommonModule, ThemeModule, FormsModule],
  exports: [ComponentsComponent],
  declarations: [ComponentsComponent],
})
export class ComponentsModule {}
