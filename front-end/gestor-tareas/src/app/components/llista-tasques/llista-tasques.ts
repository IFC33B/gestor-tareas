import { Component, OnInit, signal } from '@angular/core';
import { Tasca } from '../../models/tasca.model';
import { TascaService } from '../../services/tasca.service';
import { CommonModule } from '@angular/common';
import { Subscription } from 'rxjs';

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

  private sub?: Subscription;

  constructor(private tascaService: TascaService) {}

  ngOnInit(): void {
    this.carregarTasques();

    this.sub = this.tascaService.tascaCreada$.subscribe(() => {
      this.carregarTasques();
    });
  }

  ngOnDestroy(): void {
    this.sub?.unsubscribe();
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
