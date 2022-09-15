import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistratiComponent } from './login/registrati/registrati.component';

const routes: Routes = [
  {
    path: '',
    component: RegistratiComponent
  },
  {
    path: 'login',
    loadChildren: () => import('./login/login/login.module').then(m => m.LoginModule)
  },
  {
    path: 'home',
    loadChildren: () => import('./pages/logged-home/logged-home.module').then(m => m.LoggedHomeModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
