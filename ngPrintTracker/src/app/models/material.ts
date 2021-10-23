import { MaterialType } from "./material-type";

export class Material {

  id: number;
  name: string;
  cost: number;
  color: string;
  materialType: MaterialType;

  constructor(id: number, name: string, cost: number, color: string, materialType: MaterialType){
    this.id = id;
    this.name = name;
    this.cost = cost;
    this.color = color;
    this.materialType = materialType;
  }
}
