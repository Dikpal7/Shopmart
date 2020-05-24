import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import {
  FormGroup,
  FormBuilder,
  FormControl,
  FormArray,
  Validators,
} from "@angular/forms";
import { Section } from "src/app/Model/Section";
import { Category } from "src/app/Model/Category";
import { MasterSpecification } from "src/app/Model/MasterSpecification";
import { Product } from "src/app/Model/Product";
import { ProdAttribute } from "src/app/Model/ProdAttribute";
import { ProdService } from "src/app/Services/DataServices/prod.service";

@Component({
  selector: "app-admin",
  templateUrl: "./admin.component.html",
  styleUrls: ["./admin.component.scss"],
})
export class AdminComponent implements OnInit {
  productCategory: any[];
  adminForm: FormGroup;
  specsArrayList: MasterSpecification[];
  section: any;
  category: any;
  brand: any;
  productName: any;
  price: any;
  description: any;
  quantity: any;
  sectionObj: Section;
  categoryObj: Category;
  productObj: Product;
  prodAtbObj: ProdAttribute;

  constructor(
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private prodService: ProdService
  ) {
    this.adminForm = this.fb.group({
      section: new FormControl("", Validators.required),
      category: new FormControl("", Validators.required),
      brand: new FormControl("", Validators.required),
      productName: new FormControl("", Validators.required),
      price: new FormControl("", Validators.required),
      description: new FormControl("", Validators.required),
      quantity: new FormControl("", Validators.required),

      specsArray: new FormArray([]),
    });
    this.section = this.adminForm.get("section");
    this.category = this.adminForm.get("category");
    this.brand = this.adminForm.get("brand");
    this.productName = this.adminForm.get("productName");
    this.price = this.adminForm.get("price");
    this.description = this.adminForm.get("description");
    this.quantity = this.adminForm.get("quantity");
  }

  ngOnInit() {
    this.productCategory = this.route.snapshot.data.data;
  }

  getFormArray() {
    return this.adminForm.get("specsArray") as FormArray;
  }

  onChangeSection(sectionId) {
    this.sectionObj = this.productCategory.find(
      (s) => s.id == parseInt(sectionId, 10)
    );
    this.category.value = "";
  }

  onChangeCatVal(catId) {
    this.getFormArray().clear;
    this.categoryObj = this.sectionObj.categoryList.find(
      (x) => x.id === parseInt(catId, 10)
    );
    this.specsArrayList = this.categoryObj.masterSpecList;

    if (this.specsArrayList.length > 0) {
      for (
        let i = this.getFormArray().length;
        i < this.specsArrayList.length;
        i++
      ) {
        this.getFormArray().push(
          this.fb.group({
            keyName: [""],
            valueName: [""],
          })
        );
      }
    }
  }

  getKeyName(index) {
    if (this.specsArrayList != null && this.specsArrayList.length > 0)
      return this.specsArrayList[index].name;
    else return null;
  }
  getSpecArrayLenght() {
    if (this.specsArrayList != null) return this.specsArrayList.length > 0;
    else return false;
  }

  saveProduct() {
    this.productObj = new Product();
    this.productObj.product = this.productName.value;
    this.productObj.price = this.price.value;
    this.productObj.desc = this.description.value;
    this.productObj.availableQuantity = parseInt(this.quantity.value, 10);
    this.productObj.sec_id = parseInt(this.section.value, 10);
    this.productObj.cat_id = parseInt(this.category.value, 10);
    this.productObj.brand_id = parseInt(this.brand.value, 10);
    if (this.getSpecArrayLenght()) {
      for (let i = 0; i < this.specsArrayList.length; i++) {
        this.prodAtbObj = new ProdAttribute();
        this.prodAtbObj.brand_id = parseInt(this.brand.value, 10);
        this.prodAtbObj.cat_id = parseInt(this.category.value, 10);
        this.prodAtbObj.keyName = (<HTMLInputElement>(
          document.getElementById("keyName" + i)
        )).value;
        this.prodAtbObj.valueName = (<HTMLInputElement>(
          document.getElementById("valueName" + i)
        )).value;
        this.productObj.prodAttributeList.push(this.prodAtbObj);
      }
    } 
    this.prodService.addProduct(this.productObj);
  }
}
