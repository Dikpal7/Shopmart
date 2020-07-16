import { Brand } from "./Brand";
import { MasterSpecification } from "./MasterSpecification";

export class Category {
  id: number;
  categoryName: string;
  sec_id: number;
  brandsList: Brand[];
  masterSpecList: MasterSpecification[];
}
