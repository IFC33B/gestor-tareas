import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tasca } from '../models/tasca.model';

@Injectable({
  providedIn: 'root',
})
export class TascaService {

  private apiUrl = 'http://localhost:8080/api/tasques';

  constructor(private http: HttpClient) {};

  // Obtener todas las tareas
  getTasques(): Observable<Tasca[]> {
    return this.http.get<Tasca[]>(this.apiUrl);
  }

  // Crear tarea
  createTasca(tasca: Tasca): Observable<Tasca> {
    return this.http.post<Tasca>(this.apiUrl, tasca);
  }

  // Actualizar tarea
  updateTasca(id: number, tasca: Tasca): Observable<Tasca> {
    return this.http.put<Tasca>(`${this.apiUrl}/${id}`, tasca);
  }

  // Eliminar tarea
  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
