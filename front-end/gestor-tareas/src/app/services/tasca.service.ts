import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Tasca, TascaRequest } from '../models';

@Injectable({
  providedIn: 'root',
})
export class TascaService {
  private apiURL = 'http://localhost:8080/api/tasques';

  constructor(private http: HttpClient) {};

  // Obtener todas las tasques
  getAllTasques(): Observable<Tasca[]> {
    return this.http.get<Tasca[]>(this.apiURL)
      .pipe(
        catchError(this.handleError)
      )
  }

  // Añadir una tarea
  createTarea(tascaRequest: TascaRequest): Observable<Tasca> {
    return this.http.post<Tasca>(this.apiURL, tascaRequest)
  }

  // Modificar tascas
  updateTasca(tasca: Tasca): Observable<Tasca> {
    return this.http.put<Tasca>(`${this.apiURL}/${tasca.id}`, tasca)
      .pipe(
        catchError(this.handleError)
      )
  }

  // Eliminar tasca
  deleteTasca(tasca: Tasca): Observable<void> {
    return this.http.delete<void>(`${this.apiURL}/${tasca.id}`)
      .pipe(
        catchError(this.handleError)
      )
  }

  // Gestión de errores
  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'Error desconocido';

    if (error.error instanceof ErrorEvent) {
      // Error del cliente
      errorMessage = `Error: ${error.error.message}`
    } else {
      // Error del servidor
      errorMessage = `Codigo de error: ${error.status}, Mensaje: ${error.message}`;
    }

    console.log(errorMessage);
    return throwError(() => Error(errorMessage))
  }
}
