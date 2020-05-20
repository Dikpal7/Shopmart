import { ProdAttribute } from "./ProdAttribute";

export class Product {
  productName: string;
  price: string;
  description: string;
  availableQuantity: number;
  brandId: number;
  secId: number;
  catId: number;
  prodAttributes: ProdAttribute[];
}
