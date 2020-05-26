import { Component, OnInit, ViewChild, ElementRef } from "@angular/core";
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
import { ProdService } from "src/app/Services/DataServices/prod.service";
import { ToastrService } from "ngx-toastr";

@Component({
  selector: "app-admin",
  templateUrl: "./admin.component.html",
  styleUrls: ["./admin.component.scss"],
})
export class AdminComponent implements OnInit {
  @ViewChild("imgFile", { static: false }) fileDropEl: ElementRef;

  productCategory: any[];
  adminForm: FormGroup;
  masterSpecsList: MasterSpecification[];
  categoryObj: Category;
  sectionObj: Section;
  prodAttributeList: FormArray;
  imgFilesArray: any[] = [];
  sec_id: any;
  cat_id: any;
  imgUrl: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private prodService: ProdService,
    private toastr: ToastrService
  ) {
    this.adminForm = this.fb.group({
      sec_id: new FormControl("", Validators.required),
      cat_id: new FormControl("", Validators.required),
      brand_id: new FormControl("", Validators.required),
      product: new FormControl("", Validators.required),
      price: new FormControl("", Validators.required),
      desc: new FormControl("", Validators.required),
      availableQuantity: new FormControl("", Validators.required),
      prodAttributeList: this.fb.array([]),
    });

    this.sec_id = this.adminForm.get("sec_id");
    this.cat_id = this.adminForm.get("cat_id");
    this.prodAttributeList = this.adminForm.get(
      "prodAttributeList"
    ) as FormArray;
  }

  ngOnInit() {
    this.productCategory = this.route.snapshot.data.data;
  }

  onChangeSection(sectionId) {
    this.sectionObj = this.productCategory.find(
      (s) => s.id == parseInt(sectionId, 10)
    );
    this.cat_id.value = "";
  }

  onChangeCatVal(catId) {
    this.prodAttributeList.clear;
    this.categoryObj = this.sectionObj.categoryList.find(
      (x) => x.id === parseInt(catId, 10)
    );
    this.masterSpecsList = this.categoryObj.masterSpecList;

    if (this.masterSpecsList.length > 0) {
      for (
        let i = this.prodAttributeList.length;
        i < this.masterSpecsList.length;
        i++
      ) {
        this.prodAttributeList.push(this.addControls(i));
      }
    }
  }

  addControls(index): FormGroup {
    return this.fb.group({
      keyName: this.masterSpecsList[index].name,
      valueName: "",
    });
  }

  getKeyName(index) {
    if (this.masterSpecsList != null && this.masterSpecsList.length > 0)
      return this.masterSpecsList[index].name;
    else return "";
  }

  getSpecArrayLenght() {
    if (this.masterSpecsList != null) return this.masterSpecsList.length > 0;
    else return false;
  }

  fileBrowseHandler(files) {
    this.prepareFilesList(files);
  }
  onFileDropped($event) {
    this.prepareFilesList($event);
  }

  uploadFilesSimulator(index: number) {
    setTimeout(() => {
      if (index === this.imgFilesArray.length) {
        return;
      } else {
        const progressInterval = setInterval(() => {
          if (this.imgFilesArray[index].progress === 100) {
            clearInterval(progressInterval);
            this.uploadFilesSimulator(index + 1);
          } else {
            this.imgFilesArray[index].progress += 5;
          }
        }, 200);
      }
    }, 1000);
  }

  prepareFilesList(files: Array<any>) {
    for (const item of files) {
      item.progress = 0;
      this.imgFilesArray.push(item);
      // const reader = new FileReader();
      // reader.readAsDataURL(item);
      // reader.onload = (e: any) => {
      //   this.imgUrl.push(e.target.result);
      // };
    }
    this.fileDropEl.nativeElement.value = "";
    this.uploadFilesSimulator(0);
  }

  deleteFile(index: number) {
    if (this.imgFilesArray[index].progress < 100) {
      this.toastr.warning("upload in progress...", "Shopmart");
      return;
    }
    this.imgFilesArray.splice(index, 1);
  }

  formatBytes(bytes, decimals = 2) {
    if (bytes === 0) {
      return "0 Bytes";
    }
    const k = 1024;
    const dm = decimals <= 0 ? 0 : decimals;
    const sizes = ["Bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"];
    const i = Math.floor(Math.log(bytes) / Math.log(k));
    return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)) + " " + sizes[i];
  }

  saveProduct() {
    console.log(this.adminForm.getRawValue());
  }
}
