import { Component } from '@angular/core';
import { TasquesComponent } from './components/tasques/tasques.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [TasquesComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class AppComponent {
}
