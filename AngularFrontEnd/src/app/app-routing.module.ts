import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { MegamenuComponent } from "./Component/Megamenu/megamenu.component";
import { ProdResolverService } from "./Services/Resolver/prod-resolver.service";
import { AppComponent } from "./app.component";
import { LoginComponent } from "./Component/UserProfile/login/login.component";
import { SignupComponent } from "./Component/UserProfile/signup/signup.component";
import { ResetPasswordComponent } from "./Component/UserProfile/reset-password/reset-password.component";
import { AdminComponent } from "./Component/admin/admin.component";

const routes: Routes = [
  { path: "", redirectTo: "app", pathMatch: "full" },
  {
    path: "app",
    component: MegamenuComponent,
    resolve: { data: ProdResolverService },
    children: [
      {
        path: "login",
        component: LoginComponent,
        pathMatch: "full",
      },
      { path: "sign-up", component: SignupComponent, pathMatch: "full" },
      {
        path: "reset-password",
        component: ResetPasswordComponent,
        pathMatch: "full",
      },
      {
        path: "admin",
        component: AdminComponent,
        resolve: { data: ProdResolverService },
        pathMatch: "full",
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
