import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";

import { LayoutsModule } from "./layouts";
import { CommonLayoutComponent } from "./layouts/common-layout";
import { DashboardComponent } from "./pages/dashboard";

@NgModule({
  imports: [
    RouterModule.forRoot(
      [
        { path: "", redirectTo: "app/dashboard", pathMatch: "full" },
        {
          path: "app",
          component: CommonLayoutComponent,
          children: [
            {
              path: "dashboard",
              component: DashboardComponent,
              pathMatch: "full",
            },
            { path: "**", redirectTo: "/pages/404" },
          ],
        }, // add 'canActivate: AuthGuard' for catching unauth users
        {
          path: "pages",
          loadChildren: "./pages/pages/pages.module#PagesModule",
        },
        { path: "**", redirectTo: "/pages/404" },
      ],
      { useHash: true }
    ),
    LayoutsModule,
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {}
