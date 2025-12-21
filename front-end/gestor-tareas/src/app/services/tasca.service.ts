import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Tasca } from '../models/tasca.model';

@Injectable({
  providedIn: 'root',
})
export class TascaService {
  private apiUrl = 'http://localhost:8080/api/tasques';

  constructor(private http: HttpClient) {}

  // Obtener todas las tareas
  getTasques(): Observable<Tasca[]> {
    return this.http.get<Tasca[]>(this.apiUrl).pipe(catchError(this.handleError));
  }

  // Subir una tarea
  postTasques(tasca: Omit<Tasca, 'id'>): Observable<Tasca> {
    return this.http.post<Tasca>(this.apiUrl, tasca).pipe(catchError(this.handleError));
  }

  // Actualizar una tarea
  putTasques(tasca: Tasca): Observable<Tasca> {
    return this.http
      .put<Tasca>(`${this.apiUrl}/${tasca.id}`, tasca)
      .pipe(catchError(this.handleError));
  }

  // Eliminar una tarea
  deleteTasques(id: number): Observable<Tasca> {
    return this.http.delete<Tasca>(`${this.apiUrl}/${id}`).pipe(catchError(this.handleError));
  }

  // Error handler
  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'Error desconegut';

    if (error.error instanceof ErrorEvent) {
      // Error del cliente
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // Error del servidor
      errorMessage = `Codi d'error: ${error.status}, Missatge: ${error.message}`;
    }

    console.error(errorMessage);
    return throwError(() => new Error(errorMessage));
  }
}
