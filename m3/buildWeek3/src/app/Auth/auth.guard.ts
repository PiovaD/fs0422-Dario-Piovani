import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanLoad, Route, Router, RouterStateSnapshot, UrlSegment, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate, CanLoad {

  constructor(private authSvc: AuthService, private router: Router) {
  }

  canLoad(route: Route, segments: UrlSegment[]): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {

    return !(this.authSvc.getLoggedUser() && this.router.navigate(['/']))
  }

  canActivate(route: ActivatedRouteSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    let isUser: boolean = route.paramMap.get('id') == String(this.authSvc.getLoggedUser()?.user.id);

    return ((this.authSvc.getLoggedUser() || false) && (isUser || route.paramMap.get('id') == null) || this.router.navigate(['/']));
  }
}
