import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TascaService } from '../../services/tasca.service';
import { Tasca } from '../../models/tasca';

@Component({
  selector: 'app-tasques',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './tasques.component.html',
  styleUrl: './tasques.component.css'
})
export class TasquesComponent implements OnInit {

  tasques: Tasca[] = [];
  novaTasca: Tasca = {
    titol: '',
    descripcio: '',
    feta: false
  };

  constructor(private tascaService: TascaService) {}

  ngOnInit(): void {
    this.carregarTasques();
  }

  carregarTasques(): void {
    this.tascaService.getAllTasques().subscribe({
      next: (data) => this.tasques = data,
      error: (error) => console.error('Error carregant tasques:', error)
    });
  }

  afegirTasca(): void {
    if (this.novaTasca.titol.trim()) {
      this.tascaService.createTasca(this.novaTasca).subscribe({
        next: () => {
          this.carregarTasques();
          this.novaTasca = { titol: '', descripcio: '', feta: false };
        },
        error: (error) => console.error('Error creant tasca:', error)
      });
    }
  }

  canviarEstat(tasca: Tasca): void {
    if (tasca.id) {
      this.tascaService.updateTasca(tasca.id, tasca).subscribe({
        next: () => this.carregarTasques(),
        error: (error) => console.error('Error actualitzant tasca:', error)
      });
    }
  }

  eliminarTasca(id: number | undefined): void {
    if (id) {
      this.tascaService.deleteTasca(id).subscribe({
        next: () => this.carregarTasques(),
        error: (error) => console.error('Error eliminant tasca:', error)
      });
    }
  }
}
