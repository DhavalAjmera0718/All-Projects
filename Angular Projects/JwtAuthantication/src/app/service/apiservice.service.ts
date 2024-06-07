import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiserviceService {

  constructor(private httpclient: HttpClient) { }

basurlUser  = "http://localhost:8090/user"


RegisterUser(obj:any){

  return this.httpclient.post(this.basurlUser+"/register" , obj , {responseType : 'json'})
}
GetStudentById(id:any) : Observable<any>
{
  return this.httpclient.get(this.basurlUser+"/getUser/" + id);
}

updateById(id:any , studentdata:any): Observable <any>
{
return this.httpclient.put(this.basurlUser + "/updateUser/" + id ,studentdata , {responseType : 'text'})
}

}
