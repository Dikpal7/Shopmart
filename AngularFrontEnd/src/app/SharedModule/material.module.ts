import { NgModule } from "@angular/core";
import {
  MatButtonModule,
  MatInputModule,
  MatCardModule,
} from "@angular/material";

const allMatModules = [MatButtonModule, MatInputModule, MatCardModule];

@NgModule({
  exports: [allMatModules],
  imports: [allMatModules],
})
export class MaterialModule {}
