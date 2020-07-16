import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { MegamenuComponent } from "./Component/Megamenu/megamenu.component";
import { HttpClientModule } from "@angular/common/http";
import { LoginComponent } from "./Component/UserProfile/login/login.component";
import { SignupComponent } from "./Component/UserProfile/signup/signup.component";
import { ResetPasswordComponent } from "./Component/UserProfile/reset-password/reset-password.component";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ToastrModule } from "ngx-toastr";
import { AdminComponent } from "./Component/admin/admin.component";
import { MaterialModule } from "./SharedModule/material.module";
import { FileDrapDropDirective } from "./Component/Directive/file-drap-drop.directive";
import { ProgressComponent } from "./Component/admin/progress/progress.component";
import { ProductDetailComponent } from "./Component/Product/product-detail/product-detail.component";
import { ProductsComponent } from "./Component/Product/products/products.component";
import { DashboardComponent } from "./Component/dashboard/dashboard.component";

@NgModule({
  declarations: [
    AppComponent,
    MegamenuComponent,
    LoginComponent,
    SignupComponent,
    ResetPasswordComponent,
    AdminComponent,
    FileDrapDropDirective,
    ProgressComponent,
    ProductDetailComponent,
    ProductsComponent,
    DashboardComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MaterialModule,
    ToastrModule.forRoot(),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
