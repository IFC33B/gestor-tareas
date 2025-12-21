import { Component, OnInit, signal } from '@angular/core';
import { Tasca } from '../../models/tasca.model';
import { TascaService } from '../../services/tasca.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-llista-tasques',
  imports: [CommonModule],
  templateUrl: './llista-tasques.html',
  styleUrl: './llista-tasques.scss',
})
export class LlistaTasques implements OnInit {
  tasques = signal<Tasca[]>([]);
  carregant = signal(true);
  error = signal<string | null>(null);

  constructor(private tascaService: TascaService) {}

  ngOnInit(): void {
    this.carregarTasques();
  }

  carregarTasques(): void {
    this.carregant.set(true);
    this.error.set(null);

    this.tascaService.getTasques().subscribe({
      next: (dades) => {
        this.tasques.set(dades);
        this.carregant.set(false);
      },
      error: (err) => {
        this.error.set('Error carregant usuaris!');
        this.carregant.set(false);
        console.error(err);
      },
    });
  }
}
