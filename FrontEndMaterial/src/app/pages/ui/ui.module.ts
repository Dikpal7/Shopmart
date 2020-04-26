import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { MaterialAngularSelectModule } from "material-angular-select";

import { ThemeModule } from "theme";

@NgModule({
  imports: [CommonModule, ThemeModule, MaterialAngularSelectModule],
  declarations: [],
  providers: [],
})
export class UIModule {}
