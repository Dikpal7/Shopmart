import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { MegamenuComponent } from "./Component/Megamenu/megamenu.component";
import { ProdResolverService } from "./Services/Resolver/prod-resolver.service";
import { LoginComponent } from "./Component/UserProfile/login/login.component";
import { SignupComponent } from "./Component/UserProfile/signup/signup.component";
import { ResetPasswordComponent } from "./Component/UserProfile/reset-password/reset-password.component";
import { AdminComponent } from "./Component/admin/admin.component";
import { AuthGuard } from "./Services/Auth/auth.guard";
import { DashboardComponent } from "./Component/dashboard/dashboard.component";
import { ProductsComponent } from "./Component/Product/products/products.component";
import { ItemsResolverService } from "./Services/Resolver/items-resolver.service";
import { ProductDetailComponent } from "./Component/Product/product-detail/product-detail.component";

const routes: Routes = [
  { path: "", redirectTo: "app/dashboard", pathMatch: "full" },
  {
    path: "app",
    component: MegamenuComponent,
    resolve: { data: ProdResolverService },
    children: [
      {
        path: "dashboard",
        component: DashboardComponent,
        pathMatch: "full",
      },
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

      {
        path: "items/:categoryId/:brandId",
        component: ProductsComponent,
        resolve: { data: ItemsResolverService },
        pathMatch: "full",
      },
      {
        path: "items/:categoryId/:brandId/:prodId",
        component: ProductsComponent,
        resolve: { data: ItemsResolverService },
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
