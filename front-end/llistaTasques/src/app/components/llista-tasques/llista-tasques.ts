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
  ferTasca(tasca:Tasca, checked:boolean):void {
    if (checked) {
      tasca.feta = true;
    }
    else {
      tasca.feta = false;
    }
    this.tascaService.updateTasca(tasca).subscribe({
      next:(data)=> {
        this.tasques.update(llista=>
          llista.map(t=>
            t.id == tasca.id ? t = data : t
          )
        )
      }
    });
  }
  borrarTasca(id:number) {
    this.tascaService.deleteTasca(id).subscribe({
      next:(data)=> {
        this.tasques.update(llista=>
          llista.filter(t=>
            t.id != id
          )
        )
      }
    })
  }

}
