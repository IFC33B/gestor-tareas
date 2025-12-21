import { Component } from '@angular/core';
import { FormulariTasca } from '../formulari-tasca/formulari-tasca';
import { LlistaTasques } from '../llista-tasques/llista-tasques';

@Component({
  selector: 'app-home-page',
  imports: [LlistaTasques],
  templateUrl: './home-page.html',
  styleUrl: './home-page.scss',
})
export class HomePage {}
