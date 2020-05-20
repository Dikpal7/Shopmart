import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: "root",
})
export class ProdService {
  private url = `${environment.apiBaseUrl}/product`;

  constructor(private http: HttpClient) {}

  getMainCategory(): Observable<any> {
    return this.http.get(`${this.url}/section`);
  }
}
