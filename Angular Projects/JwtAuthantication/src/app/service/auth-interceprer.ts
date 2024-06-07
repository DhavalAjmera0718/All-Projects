import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginServiceSisService } from "./login-service-sis.service";
import { Token } from "@angular/compiler";

@Injectable()
export class AuthInterceprer implements HttpInterceptor {


constructor(private service : LoginServiceSisService){}

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

       let newReq = req;
       let token =  this.service.getToken();
       console.log("INTERSEPTOR TOKEN --->" + token)

       if(token!=null){
        newReq= newReq.clone({setHeaders:{authorization:`Bearer ${token}`}})
       }

       console.log("Request after Interseptor " + newReq)
    
         return next.handle(newReq);
        



    }

}
