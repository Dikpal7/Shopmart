import { Injectable } from "@angular/core";
import { ProdService } from "../DataServices/prod.service";
import {
  Resolve,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
} from "@angular/router";
import { Observable, empty } from "rxjs";
import { catchError, map } from "rxjs/operators";
import { Product } from "src/app/Model/Product";

@Injectable({
  providedIn: "root",
})
export class ItemsResolverService implements Resolve<Observable<any>> {
  constructor(private service: ProdService) {}

  resolve(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<any> {
    return this.service.getAllProducts().pipe(
      map((res: { data: Product[]; msg: string }) => {
        return res.data;
      }),
      catchError((error) => {
        return empty();
      })
    );
  }
}
