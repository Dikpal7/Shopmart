import { Injectable } from "@angular/core";
import {
  Resolve,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
} from "@angular/router";
import { Observable, empty } from "rxjs";
import { ProductService } from "../dataService";
import { catchError } from "rxjs/operators";

@Injectable({
  providedIn: "root",
})
export class ProductResolverService implements Resolve<Observable<any>> {
  constructor(private service: ProductService) {}

  resolve(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<any> {
    return this.service.getMainCategory().pipe(
      catchError((error) => {
        return empty();
      })
    );
  }
}
