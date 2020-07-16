import {Component, OnInit} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import {Product} from "src/app/Model/Product";
import {ProdService} from "../../../Services/DataServices/prod.service";
import {MasterSpecification} from "../../../Model/MasterSpecification";

@Component({
  selector: "app-products",
  templateUrl: "./products.component.html",
  styleUrls: ["./products.component.scss"],
})
export class ProductsComponent implements OnInit {
  imgSrc: any[];
  brandWiseProduct: Product[];
  catId: number;

  constructor(private activatedRoute: ActivatedRoute, private prodService: ProdService) {
  }

  ngOnInit() {
    let allData = this.activatedRoute.snapshot.data.data;
    this.prodService.currentData.subscribe(data =>
    {
      this.brandWiseProduct = data.productList,
        this.catId = data.cat_id
    });
  }

  getImgArrayLenght(index) {
    if (this.brandWiseProduct[index] != null && this.brandWiseProduct[index].prodImagesList != null)
      return this.brandWiseProduct[index].prodImagesList.length > 0;
    else return false;
  }
}
