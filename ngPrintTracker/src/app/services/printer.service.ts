import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Printer } from '../models/printer';

@Injectable({
  providedIn: 'root'
})
export class PrinterService {

  private baseUrl = 'http://localhost:8087/';
  private url = this.baseUrl + 'api/printers';

  constructor(private http: HttpClient) { }

  index(): Observable<Printer[]>{
    return this.http.get<Printer[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('PrinterService.index(): Error retrieving printers list')

      })
    );
  }
}
