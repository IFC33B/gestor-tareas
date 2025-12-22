import { CommonModule } from '@angular/common';
import { Component, signal } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { TascaService } from '../../services/tasca.service';
import { Tasca } from '../../models/tasca.model';

@Component({
  selector: 'app-formulari-tasca',
  imports: [CommonModule, FormsModule],
  templateUrl: './formulari-tasca.html',
  styleUrl: './formulari-tasca.scss',
})
export class FormulariTasca {
  titol = '';
  descripcio = '';
  feta = false;
  submitted = signal(false);
  error = signal<string | null>(null);

  constructor(private tascaService: TascaService) {}

  ngOnInit(): void {}

  crearTasca(formulari: NgForm): void {
    this.submitted.set(false);
    this.error.set(null);

    const tasca: Omit<Tasca, 'id'> = {
      titol: this.titol,
      descripcio: this.descripcio,
      feta: this.feta,
    };

    this.tascaService.postTasques(tasca).subscribe({
      next: (dades) => {
        console.log('RESULT: ' + dades);
        this.submitted.set(true);
        this.tascaService.notificarTascaCreada();
      },
      error: (err) => {
        this.error.set('Error creant tasca!');
        this.submitted.set(true);
        console.error(err);
      },
    });
    formulari.resetForm();
  }
}
