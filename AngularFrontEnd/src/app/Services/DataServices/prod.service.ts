import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable, pipe } from "rxjs";
import { environment } from "src/environments/environment";
import { Product } from "src/app/Model/Product";
import { ToastrService } from "ngx-toastr";

@Injectable({
  providedIn: "root",
})
export class ProdService {
  private url = `${environment.apiBaseUrl}/product`;
  private adminUrl = `${environment.apiBaseUrl}/admin`;

  constructor(private http: HttpClient, private toastr: ToastrService) {}

  getMainCategory(): Observable<any> {
    return this.http.get(`${this.url}/section`);
  }

  addProduct(product: Product) {
    return this.http
      .post(`${this.adminUrl}/addProduct`, product)
      .subscribe((res: { success: boolean; message: string }) => {
        if (res.success)
          this.toastr.success("Product added successfully!", "Shopmart");
        else this.toastr.error("Error while adding Product!", "Shopmart");
        return res.success;
      });
  }

  getAllProducts(): Observable<any> {
    return this.http.get(`${this.url}/items`);
  }
}
