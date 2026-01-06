import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tasca, TascaRequest } from '../models';

@Injectable({
  providedIn: 'root',
})
export class TascaService {
  private apiUrl = "http://localhost:8080/api/tasques";

  constructor(private http:HttpClient) {

  }

  getTasques():Observable<Tasca[]> {
    return this.http.get<Tasca[]>(this.apiUrl);
  }

  createTasca(tasca:TascaRequest):Observable<Tasca> {
    return this.http.post<Tasca>(this.apiUrl, tasca);
  }

  updateTasca(tasca:Tasca):Observable<Tasca> {
    return this.http.put<Tasca>(`${this.apiUrl}/${tasca.id}`, tasca);
  }

  deleteTasca(tasca:Tasca):Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${tasca.id}`);
  }
}
