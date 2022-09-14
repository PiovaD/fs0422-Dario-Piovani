import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRouteSnapshot, CanActivate, CanDeactivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './auth/login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate, CanDeactivate<unknown>{

  constructor(private loginSvc: LoginService) {

  }

  canDeactivate(
    component: any,
    currentRoute: ActivatedRouteSnapshot
  ): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    let form: NgForm = component.form

    let exit: boolean = true

    if (form.dirty) exit = confirm("Sicuro di lasciare la pagina?")

    return exit;
  }

  canActivate(
    route: ActivatedRouteSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    let isUser: boolean = route.paramMap.get('id') == String(this.loginSvc.getLoggedToken()?.id);

    return (this.loginSvc.isLogged() || false) && (isUser || route.paramMap.get('id') == null);
  }


}
