import { CanActivateFn, Router } from '@angular/router';
import { LoginServiceSisService } from '../service/login-service-sis.service';
import {inject} from '@angular/core';


export const authGuard: CanActivateFn = (route, state) => {

return inject(LoginServiceSisService).isLoggedIn() ? true : inject(Router).createUrlTree(["/login"])

};
