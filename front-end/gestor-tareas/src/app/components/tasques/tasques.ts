import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { TascaService } from '../../services/tasca.service';
import { Tasca } from '../../models/tasca.model';

@Component({
  selector: 'app-tasques',
  imports: [CommonModule, FormsModule],
  templateUrl: './tasques.html',
  styleUrl: './tasques.scss',
})
export class Tasques implements OnInit {
  tasques: Tasca[] = [];

  // guardar datos del formulario
  novaTasca: Tasca = {
    titol: '',
    descripcio: '',
    feta: false
  };


  constructor(private tascaService: TascaService) {}

  ngOnInit(): void {
    this.cargarTasques();
  }

  // mostrar lista de tareas
  cargarTasques(): void {
    this.tascaService.getTasques().subscribe({
      next: (data) => this.tasques = data,
      error: (err) => console.error('Error cargando tareas', err)
    });
  }

  // crear tarea
  crearTasca(): void {
    this.tascaService.createTasca(this.novaTasca).subscribe({
      next: () => {
        this.cargarTasques();
        this.novaTasca = { titol: '', descripcio: '', feta: false };
      },
      error: err => console.error('Error creando tarea', err)
    });
  }

  eliminarTasca(id: number): void {
    this.tascaService.delete(id).subscribe({
      next: () => this.cargarTasques(),
      error: err => console.error('Error eliminando tarea', err)
    });
  }
}
