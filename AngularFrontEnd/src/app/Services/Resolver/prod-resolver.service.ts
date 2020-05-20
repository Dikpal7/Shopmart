import { Injectable } from "@angular/core";
import {
  Resolve,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
} from "@angular/router";
import { Observable, empty, EmptyError, observable, EMPTY } from "rxjs";
import { ProdService } from "../DataServices/prod.service";
import { catchError } from "rxjs/operators";

@Injectable({
  providedIn: "root",
})
export class ProdResolverService implements Resolve<Observable<any>> {
  constructor(private service: ProdService) {}

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
