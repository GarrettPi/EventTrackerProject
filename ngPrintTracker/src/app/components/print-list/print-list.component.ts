import { Component, OnInit } from '@angular/core';
import { Material } from 'src/app/models/material';
import { Print } from 'src/app/models/print';
import { Printer } from 'src/app/models/printer';
import { PrintService } from 'src/app/services/print.service';
import { PrinterService } from 'src/app/services/printer.service';

@Component({
  selector: 'app-print-list',
  templateUrl: './print-list.component.html',
  styleUrls: ['./print-list.component.css'],
})
export class PrintListComponent implements OnInit {

  constructor(private printSvc: PrintService, private printerSvc: PrinterService) { }
  prints: Print[] = [];
  printers: Printer[] = [];
  selected: Print | null = null;
  editing: boolean = false;
  editedPrint: Print | null = null;
  newPrint: Print = new Print(0,'',0,0,'',new Printer(0,''), new Material(0, '', 0, ''));
  newForm: boolean = false;

  ngOnInit(): void {
    this.loadPrints();
    this.loadPrinters();
  }
  loadPrinters(){
    this.printerSvc.index().subscribe(
      data => {
        this.printers = data;
      },
      err => {
        console.error('PrintListComponent.loadPrinters(): error loading printers');

      }
    )
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

  selectPrint(print: Print){
    this.selected = print;
    console.log('print '+print.id+' selected');

  }

  edit(print: Print){
    console.log(print);
    this.printSvc.update(print).subscribe(
      data => {
        console.log('update successful');
        this.loadPrints();
        this.editedPrint = null;
        this.selected = data;
      },
      err => {
        console.error('PrintListComponent.edit(): Error editing Print');
        console.error(err);
      }
    )
  }

  setEditPrint(): void {
    this.editedPrint = Object.assign({}, this.selected);
  }

  resetNewPrint(){
    this.newPrint = new Print(0,'',0,0,'',new Printer(0,''), new Material(0, '', 0, ''));
  }
}
