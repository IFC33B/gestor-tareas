import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export interface TascaModel {
  id?: number; // opcional
  titol: string;
  descripcio: string;
  feta: boolean;
}
