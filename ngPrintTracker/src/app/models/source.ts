export class Source {

  id: number;
  name: string;
  url: string;

  constructor(id: number, name: string, url: string) {
    this.name = name;
    this.id = id;
    this.url = url;
  }
}
