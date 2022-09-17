import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PostsComponent } from './pages/posts/posts.component';

const routes: Routes = [
  {
    path: 'posts',
    component: PostsComponent
  },
  { path: 'login', loadChildren: () => import('./user/login/login.module').then(m => m.LoginModule) },
  { path: 'register', loadChildren: () => import('./user/register/register.module').then(m => m.RegisterModule) },
  { path: 'users', loadChildren: () => import('./pages/users/users.module').then(m => m.UsersModule) },
  {
    path: '**',
    redirectTo: '/posts'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
