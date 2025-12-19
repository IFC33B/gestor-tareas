import { Routes } from '@angular/router';
import { LlistaTasques } from './components/llista-tasques/llista-tasques';
import { FormulariTasques } from './components/formulari-tasques/formulari-tasques';

export const routes: Routes = [
    {path: '', redirectTo: '/tasques', pathMatch: 'full'},
    {path: 'tasques', component: LlistaTasques},
    {path: 'formulari', component: FormulariTasques}
];
