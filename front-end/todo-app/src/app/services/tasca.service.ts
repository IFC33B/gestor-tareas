import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tasca } from '../models/tasca';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TascaService {

  private apiUrl = `${environment.apiUrl}/api/tasques`;

  constructor(private http: HttpClient) { }

  //obtener todas las tareas
  getAllTasques(): Observable<Tasca[]> {
    return this.http.get<Tasca[]>(this.apiUrl);
  }

  // nueva tarea
  createTasca(tasca: Tasca): Observable<Tasca> {
    return this.http.post<Tasca>(this.apiUrl, tasca);
  }

  // actualizar tarea
  updateTasca(id: number, tasca: Tasca): Observable<Tasca> {
    return this.http.put<Tasca>(`${this.apiUrl}/${id}`, tasca);
  }

  // etyliminar tarea
  deleteTasca(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
