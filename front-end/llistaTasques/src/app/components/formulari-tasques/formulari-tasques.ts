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

  cargando = signal(false);
  titol:string = "";
  descripcio:string = "";

  constructor(private tascaService:TascaService) {

  }

  crearTasca() {
    this.cargando.set(true);
    const tascaRequest:TascaRequest = {titol:this.titol, descripcio:this.descripcio, feta:false}
    this.tascaService.createTasca(tascaRequest).subscribe({
      next:(data)=> {
        this.cargando.set(false);
        alert("Tasca creada!");
      }
    })
  }
}
