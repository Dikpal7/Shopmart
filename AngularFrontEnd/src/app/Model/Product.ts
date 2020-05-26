import { ProdAttribute } from "./ProdAttribute";
import { ProdImages } from "./ProdImages";

export class Product {
  id: number;
  product: string;
  price: string;
  desc: string;
  availableQuantity: number;
  brand_id: number;
  sec_id: number;
  cat_id: number;
  prodAttributeList: ProdAttribute[] = [];
  prodImagesList: ProdImages[] = [];
}
