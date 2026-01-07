import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Tasques } from './components/tasques/tasques';

@Component({
  selector: 'app-root',
  imports: [
    RouterOutlet,
    Tasques
  ],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('gestor-tareas');
}
