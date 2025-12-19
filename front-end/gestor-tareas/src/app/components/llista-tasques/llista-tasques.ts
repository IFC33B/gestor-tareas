import { Component, signal } from '@angular/core';
import { Tasca } from '../../models';
import { TascaService } from '../../services/tasca.service';

@Component({
  selector: 'app-llista-tasques',
  imports: [],
  templateUrl: './llista-tasques.html',
  styleUrl: './llista-tasques.scss',
})
export class LlistaTasques {
  tasques = signal<Tasca[]>([]);
  carregant = signal(true);
  error = signal<string | null>(null);

  constructor(private tascaService: TascaService) { }

  ngOnInit(): void {
    this.carregarTasques();
  }

  // Cargar tasques
  carregarTasques(): void {
    this.carregant.set(true);
    this.error.set(null);

    // Servicio
    this.tascaService.getAllTasques().subscribe({
      next: (dades) => {
        this.tasques.set(dades);
        this.carregant.set(false);
      },

      error: (err) => {
        this.error.set('Error al cargar las tareas');
        this.carregant.set(false);
        console.log(err);
      }
    })
  }

  // Marcar tasques como completadas
  completarTasca(tasca: Tasca, checked: boolean): void {
    this.error.set(null);

    // Marcamos como completado si el check está marcado
    if (checked) {
      tasca.feta = true;
    } else {
      tasca.feta = false;
    }

    // Servicio
    this.tascaService.updateTasca(tasca).subscribe({
      next: (dades) => {
        this.tasques.update(llista =>
          llista.map(t =>
            t.id === tasca.id
              ? t = dades
              : t
          )
        );
      },

      error: (err) => {
        this.error.set('Error al actualizar la tarea');
        console.log(err);
      }
    })
  }


  // Eliminar tarea
  eliminarTasca(tasca: Tasca): void {
    this.error.set(null);

    this.tascaService.deleteTasca(tasca).subscribe(
      () => {
        this.tasques.update(llista => llista.filter(t => t.id !== tasca.id));
      },
      (err) => {
        this.error.set('Error al elimnar la tarea');
        console.error(err);
      }
    );
  }
}
