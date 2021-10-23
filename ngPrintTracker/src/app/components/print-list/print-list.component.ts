import { Component, OnInit } from '@angular/core';
import { Material } from 'src/app/models/material';
import { MaterialType } from 'src/app/models/material-type';
import { Print } from 'src/app/models/print';
import { Printer } from 'src/app/models/printer';
import { Source } from 'src/app/models/source';
import { MaterialService } from 'src/app/services/material.service';
import { PrintService } from 'src/app/services/print.service';
import { PrinterService } from 'src/app/services/printer.service';
import { SourceService } from 'src/app/services/source.service';

@Component({
  selector: 'app-print-list',
  templateUrl: './print-list.component.html',
  styleUrls: ['./print-list.component.css'],
})
export class PrintListComponent implements OnInit {

  constructor(private printSvc: PrintService, private printerSvc: PrinterService, private materialSvc: MaterialService, private sourceSvc: SourceService) { }
  prints: Print[] = [];
  printers: Printer[] = [];
  materials: Material[] = [];
  sources: Source[] = [];
  selected: Print | null = null;
  editing: boolean = false;
  editedPrint: Print | null = null;
  newPrint: Print = new Print(0, '', 0, 0, '', new Printer(0, ''), new Material(0, '', 0, '', new MaterialType(0, '')), new Source(0, '', ''));
  newForm: boolean = false;

  ngOnInit(): void {
    this.loadPrints();
    this.loadPrinters();
    this.loadMaterials();
    this.loadSources();
  }

  loadPrinters() {
    this.printerSvc.index().subscribe(
      data => {
        this.printers = data;
      },
      err => {
        console.error('PrintListComponent.loadPrinters(): error loading printers');

      }
    )
  }

  loadMaterials() {
    this.materialSvc.index().subscribe(
      data => {
        this.materials = data;
      },
      err => {
        console.error('PrintListComponent.loadMaterials(): error loading materials');

      }
    )
  }

  loadPrints() {
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

  loadSources() {
    this.sourceSvc.index().subscribe(
      data => {
        this.sources = data;
      },
      err => {
        console.error('PrintListComponent.reloadPrints(): Error Loading Sources');
        console.error(err);
      }
    )
  }

  selectPrint(print: Print) {
    this.selected = print;
    console.log('print ' + print.id + ' selected');

  }

  edit(print: Print) {
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

  resetNewPrint() {
    this.newPrint = new Print(0, '', 0, 0, '', new Printer(0, ''), new Material(0, '', 0, '', new MaterialType(0, '')), new Source(0, '', ''));
  }

  createPrint(print: Print) {
    console.log(print);

    this.printSvc.create(print).subscribe(
      data => {
        console.log('created correctly');
        this.loadPrints();
        this.resetNewPrint();
        // this.selected = data;
        this.newForm = false;
      },
      err => {
        console.error('PrintListComponent.edit(): Error creating Print');
        console.error(err);
      }
    )
  }

  delete(id: number){
    this.printSvc.delete(id).subscribe(
      data => {
        console.log('Print deleted Successfully');
        this.selected = null;
        location.reload();
        // this.loadPrints;
      },
      err => {
        console.log('PrintListComponent.edit(): Error deleting Print');
        console.log(err);
      }
    )
  }

  calcCost(mat: number, cost: number){
    return Math.round((mat*cost)*100)/100;
  }
}
