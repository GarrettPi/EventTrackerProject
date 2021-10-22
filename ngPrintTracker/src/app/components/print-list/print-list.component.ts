import { Component, OnInit } from '@angular/core';
import { Print } from 'src/app/models/print';
import { PrintService } from 'src/app/services/print.service';

@Component({
  selector: 'app-print-list',
  templateUrl: './print-list.component.html',
  styleUrls: ['./print-list.component.css']
})
export class PrintListComponent implements OnInit {

  constructor(private printSvc: PrintService) { }
  prints: Print[] = [];

  ngOnInit(): void {
    this.loadPrints();
  }

  loadPrints(){
    this.printSvc.index().subscribe(
      data => {
        this.prints = data;
      },
      err => {
        console.error('PrintListComponent.reloadPrints(): Error Loading Prints');
        console.error(err);
      }
    )
  }
}
