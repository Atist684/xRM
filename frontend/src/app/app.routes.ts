import { Routes } from '@angular/router';
import { authGuardGuard } from './security/auth-guard';

export const routes: Routes = [
    { path: 'report', canActivate: [authGuardGuard], title: "Report", loadComponent: () => import('./page/report/report').then(comp => comp.Report) },
    { path: 'partners', canActivate: [authGuardGuard], title: "Partners", loadComponent: () => import('./page/partner/partner').then(comp => comp.Partner) },
    { path: 'tasks', canActivate: [authGuardGuard], title: "Tasks", loadComponent: () => import('./page/task/task').then(comp => comp.Task) },
];
