import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Product } from "src/app/Model/Product";

@Component({
  selector: "app-products",
  templateUrl: "./products.component.html",
  styleUrls: ["./products.component.scss"],
})
export class ProductsComponent implements OnInit {
  imgSrc: any[];
  data: Product[];

  constructor(private activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.data = this.activatedRoute.snapshot.data.data;
    let category = this.activatedRoute.snapshot.paramMap.get("category");
    console.log(category);
  }

  getImgArrayLenght(index) {
    if (this.data[index] != null && this.data[index].prodImagesList != null)
      return this.data[index].prodImagesList.length > 0;
    else return false;
  }
}
