import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StudentInformationSystem } from './student-information-system';
@Injectable({
  providedIn: 'root'
})
export class StudentInformationSyatemService {

  constructor( private HttpClient : HttpClient) { }

  private baseUrl:String = "http://localhost:8092/user/user/";
 
  getAllStudents():Observable<StudentInformationSystem[]>
  {
    return this.HttpClient.get<StudentInformationSystem[]>(`${this.baseUrl}getAllUser`);
  }

  Registerstudent(registerstudent:any) : Observable<any>
  {
    return this.HttpClient.post(`${this.baseUrl}register-user`,registerstudent,{responseType: 'text' as 'json'} );
  }

  GetStudentById(id:any) : Observable<StudentInformationSystem>
  {
    return this.HttpClient.get<StudentInformationSystem>(`${this.baseUrl}getUser/${id}`);
  }

  updateById(id:any , studentdata:StudentInformationSystem): Observable <object>
  {
  return  this.HttpClient.put(`${this.baseUrl}updateUser/${id}` , studentdata,{responseType: 'text' as 'json'});
  }

  DeleteById(name :any) : Observable<Object>
  {
    return this.HttpClient.get(`${this.baseUrl}delete_user/${name}`,{responseType: 'text' as 'json'})
  }

}
