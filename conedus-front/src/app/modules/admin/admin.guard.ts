import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import * as bcryptjs from 'bcryptjs';

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    const user: string | null = localStorage.getItem('conedus-username');
    const pass: string | null = localStorage.getItem('conedus-pass');
    console.log('hace esto', user, pass);

    if(user == null || pass == null) return false;

    if(user == 'admin' && bcryptjs.compareSync('admin', pass.toString())){
      console.log('retorna ture')
      return true;
    } else {
      console.log('mal')
      return false;
    }
  }

}
