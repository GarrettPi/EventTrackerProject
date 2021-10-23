import { Material } from "./material";
import { Printer } from "./printer";

export class Print {
  id: number;
  name: string;
  duration: number;
  materialConsumed: number;
  photoUrl: string;
  printer: Printer;
  material: Material;

  constructor(id: number, name: string, duration: number, materialConsumed: number, photoUrl: string, printer: Printer, material: Material){
    this.name = name;
    this.id = id;
    this.duration = duration;
    this.photoUrl = photoUrl;
    this.printer = printer;
    this.materialConsumed = materialConsumed;
    this.material = material;
  }

}

