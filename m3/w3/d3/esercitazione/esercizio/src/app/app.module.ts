import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar.component';
import { HomePage } from './pages/home.page';
import { FormNewUserComponent } from './form/form-new-user.component';
import { AuthGuard } from './auth.guard';
import { FormsModule } from '@angular/forms';

const routes:Route[] = [
  {
    path:"",
    component:HomePage
  },
  {
    path:"active-posts",
    loadChildren:() => import('./pages/active/active.module').then(m => m.ActiveModule)
  },
  {
    path:"inactive-posts",
    loadChildren:() => import('./pages/inactive/inactive.module').then(m => m.InactiveModule),
    canActivate: [AuthGuard]
  },
  {
    path:"users",
    loadChildren:() => import('./pages/user/user.module').then(m => m.UserModule)
  },
  {
    path:'form',
    component: FormNewUserComponent,
    canDeactivate: [AuthGuard]
  },
  {
    path:"**",
    redirectTo:""
  }
]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomePage,
    FormNewUserComponent,
  ],
  imports: [
    FormsModule,
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
