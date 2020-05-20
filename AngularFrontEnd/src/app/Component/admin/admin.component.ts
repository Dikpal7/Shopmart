import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { FormGroup, FormBuilder, FormControl } from "@angular/forms";

@Component({
  selector: "app-admin",
  templateUrl: "./admin.component.html",
  styleUrls: ["./admin.component.scss"],
})
export class AdminComponent implements OnInit {
  productCategory: any[];
  categoryList: any[];
  brandsList: any[];
  temp: any[];
  adminForm: FormGroup;
  section: any;
  category: any;
  brand: any;
  productName: any;
  price: any;
  description: any;
  constructor(private route: ActivatedRoute, private fb: FormBuilder) {
    this.adminForm = this.fb.group({
      section: new FormControl(""),
      category: new FormControl(""),
      brand: new FormControl(""),
      productName: new FormControl(""),
      price: new FormControl(""),
      description: new FormControl(""),
    });
    this.section = this.adminForm.get("section");
    this.category = this.adminForm.get("category");
    this.brand = this.adminForm.get("brand");
    this.productName = this.adminForm.get("productName");
    this.price = this.adminForm.get("price");
    this.description = this.adminForm.get("description");
  }

  ngOnInit() {
    this.productCategory = this.route.snapshot.data.data;
  }

  onChangeSection(sectionId) {
    this.categoryList = this.productCategory.find((s) => s.id == sectionId);
    console.log(this.categoryList);
  }
}
