import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {


  baseUrlAdmin = "http://localhost:8090/admin"
  
  constructor(private httpclient : HttpClient) { }

  getAllAdminData() : Observable<any>
  {
    return this.httpclient.get(  this.baseUrlAdmin+"/getalladminData")
  }
}
