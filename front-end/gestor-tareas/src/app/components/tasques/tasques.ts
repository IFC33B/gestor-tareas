import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TascaService } from '../../services/tasca.service';
import { Tasca } from '../../models/tasca.model';

@Component({
  selector: 'app-tasques',
  imports: [CommonModule],
  templateUrl: './tasques.html',
  styleUrl: './tasques.scss',
})
export class Tasques implements OnInit {
  tasques: Tasca[] = [];

  constructor(private tascaService: TascaService) {}

  ngOnInit(): void {
    this.CargarTasques();
  }

  CargarTasques(): void {
    this.tascaService.getTasques().subscribe({
      next: (data) => this.tasques = data,
      error: (err) => console.error('Error cargando tareas', err)
    });
  }
}
