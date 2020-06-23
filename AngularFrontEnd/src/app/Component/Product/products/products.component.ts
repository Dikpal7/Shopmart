import {Component, OnInit} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import {Product} from "src/app/Model/Product";
import {ProdService} from "../../../Services/DataServices/prod.service";

@Component({
  selector: "app-products",
  templateUrl: "./products.component.html",
  styleUrls: ["./products.component.scss"],
})
export class ProductsComponent implements OnInit {
  imgSrc: any[];
  brandWiseProduct: Product[];

  constructor(private activatedRoute: ActivatedRoute, private prodService: ProdService) {
  }

  ngOnInit() {
    let allData = this.activatedRoute.snapshot.data.data;
    let categoryId = this.activatedRoute.snapshot.paramMap.get("categoryId");
    let brandId = this.activatedRoute.snapshot.paramMap.get("brandId");
    this.prodService.currentData.subscribe(data => this.brandWiseProduct = data);
  }

  getImgArrayLenght(index) {
    if (this.brandWiseProduct[index] != null && this.brandWiseProduct[index].prodImagesList != null)
      return this.brandWiseProduct[index].prodImagesList.length > 0;
    else return false;
  }
}
