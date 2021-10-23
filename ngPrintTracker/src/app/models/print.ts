import { Material } from "./material";
import { Printer } from "./printer";
import { Source } from "./source";

export class Print {
  id: number;
  name: string;
  duration: number;
  materialConsumed: number;
  photoUrl: string;
  printer: Printer;
  material: Material;
  source: Source;

  constructor(id: number, name: string, duration: number, materialConsumed: number, photoUrl: string, printer: Printer, material: Material, source: Source){
    this.name = name;
    this.id = id;
    this.duration = duration;
    this.photoUrl = photoUrl;
    this.printer = printer;
    this.materialConsumed = materialConsumed;
    this.material = material;
    this.source = source;
  }

}

