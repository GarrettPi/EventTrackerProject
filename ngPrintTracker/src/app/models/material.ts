export class Material {

  id: number;
  name: string;
  cost: number;
  color: string;

  constructor(id: number, name: string, cost: number, color: string){
    this.id = id;
    this.name = name;
    this.cost = cost;
    this.color = color;
  }
}
