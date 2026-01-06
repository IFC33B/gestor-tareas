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
  cargando = signal(true);
  constructor(private tascaService:TascaService) {

  }
  ngOnInit():void {
    this.cargarTasques();
  }
  cargarTasques():void {
    this.cargando.set(true);
    this.tascaService.getTasques().subscribe({
      next:(data)=> {
        this.tasques.set(data);
        this.cargando.set(false);
      }
    })
  }

}
