import { Printer } from "./printer";

export class Print {
  id: number;
  name: string;
  duration: number;
  photoUrl: string;
  printer: Printer;

  constructor(id: number, name: string, duration: number, photoUrl: string, printer: Printer){
    this.name = name;
    this.id = id;
    this.duration = duration;
    this.photoUrl = photoUrl;
    this.printer = printer;
  }


}

