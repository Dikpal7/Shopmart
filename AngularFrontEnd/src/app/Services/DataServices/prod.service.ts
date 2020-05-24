import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable, pipe } from "rxjs";
import { environment } from "src/environments/environment";
import { Product } from "src/app/Model/Product";

@Injectable({
  providedIn: "root",
})
export class ProdService {
  private url = `${environment.apiBaseUrl}/product`;
  private adminUrl = `${environment.apiBaseUrl}/admin`;

  constructor(private http: HttpClient) {}

  getMainCategory(): Observable<any> {
    return this.http.get(`${this.url}/section`);
  }

  addProduct(product: Product) {
    return this.http
      .post(`${this.adminUrl}/addProduct`, product)
      .subscribe((res) => {
        return res;
      });
  }
}
