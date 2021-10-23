import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Material } from '../models/material';

@Injectable({
  providedIn: 'root'
})
export class MaterialService {

  private baseUrl = 'http://localhost:8087/';
  private url = this.baseUrl + 'api/materials';

  constructor(private http: HttpClient) { }

  index(): Observable<Material[]>{
    return this.http.get<Material[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('PrinterService.index(): Error retrieving printers list')

      })
    );
  }
}
