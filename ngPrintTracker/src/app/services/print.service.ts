import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Print } from '../models/print';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PrintService {

  private baseUrl = 'http://localhost:8087/';
  private url = this.baseUrl + 'api/prints';

  constructor(private http: HttpClient) { }

  index(): Observable<Print[]> {
    return this.http.get<Print[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('PrintsService.index(): error retrieving Prints list');
      })
    );
  }

  update(print: Print){
    console.log('updating print');
    return this.http.put<Print>(this.url+"/"+print.id, print).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError("PrintService.update(): error updating print");
      })
    );
  }
}
