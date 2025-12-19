import { Component, signal } from '@angular/core';
import { TascaService } from '../../services/tasca.service';
import { TascaRequest } from '../../models';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-formulari-tasques',
  imports: [FormsModule],
  templateUrl: './formulari-tasques.html',
  styleUrl: './formulari-tasques.scss',
})
export class FormulariTasques {
  carregant = signal(false);
  error = signal<string | null>(null);

  // Datos del formulario
  titol: string = '';
  descripcio: string = '';

  constructor(private tascaService: TascaService) { }

  // Añadir tasca
  crearTasca() {
    // Creamos la tasca
    const tascaResquest: TascaRequest = {titol: this.titol, descripcio: this.descripcio, feta: false}

    // Servicio
    this.tascaService.createTarea(tascaResquest).subscribe({
      next: (dades) => {
        this.carregant.set(true);
        alert(`Tarea ${dades.titol} creada correctamente!`);
        this.carregant.set(false)
      },

      error: (err) => {
        this.error.set(err);
        console.log(err);
      }
    })
  }

  // Recargar página
  reload() {
    window.location.reload()
  }
}
