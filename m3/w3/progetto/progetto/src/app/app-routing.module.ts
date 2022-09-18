import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth/auth.guard';
import { PostsComponent } from './pages/posts/posts.component';

const routes: Routes = [
  {
    path: 'posts',
    component: PostsComponent
  },
  {
    path: 'login',
    loadChildren: () => import('./auth/login/login.module').then(m => m.LoginModule),
    canLoad: [AuthGuard]
  },
  {
    path: 'register',
    loadChildren: () => import('./auth/register/register.module').then(m => m.RegisterModule),
    canLoad: [AuthGuard]
  },
  {
    path: 'users',
    loadChildren: () => import('./auth/users/users.module').then(m => m.UsersModule)
  },
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
