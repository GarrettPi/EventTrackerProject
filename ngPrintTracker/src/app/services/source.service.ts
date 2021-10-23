import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Print } from '../models/print';
import { Source } from '../models/source';

@Injectable({
  providedIn: 'root'
})
export class SourceService {

  private baseUrl = 'http://localhost:8087/';
  private url = this.baseUrl + 'api/sources';

  constructor(private http: HttpClient) { }

  index(): Observable<Source[]> {
    return this.http.get<Source[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('SourceService.index(): error retrieving source list');
      })
    );
  }
}
