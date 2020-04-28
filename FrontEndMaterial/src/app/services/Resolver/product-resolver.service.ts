import { Injectable } from "@angular/core";
import {
  Resolve,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
} from "@angular/router";
import { Observable } from "rxjs";
import { ProductService } from "../dataService";

@Injectable({
  providedIn: "root",
})
export class ProductResolverService implements Resolve<Observable<any>> {
  resolve(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<any> {
    return this.service.getMainCategory();
  }
  constructor(private service: ProductService) {}
}
