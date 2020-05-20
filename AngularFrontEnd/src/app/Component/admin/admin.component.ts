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
  adminForm: FormGroup;
  section: any;
  category: any;
  brand: any;
  constructor(private route: ActivatedRoute, private fb: FormBuilder) {
    this.adminForm = this.fb.group({
      section: new FormControl(""),
      category: new FormControl(""),
      brand: new FormControl(""),
    });
    this.section = this.adminForm.get("section").value;
    this.category = this.adminForm.get("category");
    this.brand = this.adminForm.get("brand");
  }

  ngOnInit() {
    this.productCategory = this.route.snapshot.data.data;
    console.log(this.section);
  }
}
