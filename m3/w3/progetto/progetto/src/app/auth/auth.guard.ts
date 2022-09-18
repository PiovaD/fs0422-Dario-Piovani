import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanLoad, Route, Router, UrlSegment, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate, CanLoad {

  constructor(private authSvc: AuthService, private router: Router) {
  }

  canLoad(route: Route, segments: UrlSegment[]): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {

    return !(this.authSvc.isLogged() && this.router.navigate(['/posts']))
  }

  canActivate(route: ActivatedRouteSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    let isUser: boolean = route.paramMap.get('id') == String(this.authSvc.getLoggedUser()?.id);

    return ((this.authSvc.isLogged() || false) && (isUser || route.paramMap.get('id') == null) || this.router.navigate(['/posts']));
  }


}
