import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './auth/login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private loginSvc: LoginService) {

  }

  canActivate(
    route: ActivatedRouteSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    let isUser: boolean = route.paramMap.get('id') == String(this.loginSvc.getLoggedToken()?.id);

    return (this.loginSvc.isLogged() || false) && (isUser || route.paramMap.get('id') == null);
  }


}
