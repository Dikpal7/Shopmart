import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable} from "rxjs";
import {environment} from "src/environments/environment";
import {Product} from "src/app/Model/Product";
import {ToastrService} from "ngx-toastr";
import {Brand} from "../../Model/Brand";

@Injectable({
  providedIn: "root",
})
export class ProdService {

  public productsData = new BehaviorSubject<Brand>(new Brand());
  currentData = this.productsData.asObservable();

  private url = `${environment.apiBaseUrl}/product`;
  private adminUrl = `${environment.apiBaseUrl}/admin`;

  constructor(private http: HttpClient, private toastr: ToastrService) {
  }

  // By subjectBehaviour Changing value on clink of link.
  changeProductValue(brandObj: Brand) {
    this.productsData.next(brandObj);
  }

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
