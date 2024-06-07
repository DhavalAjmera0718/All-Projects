import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class SISInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const myToken=localStorage.getItem("jwtToken");
    const colReq=request.clone({
      headers:request.headers.set('Authorization',"Bearer "+myToken)
      
    });
    return next.handle(colReq);

  }
}
