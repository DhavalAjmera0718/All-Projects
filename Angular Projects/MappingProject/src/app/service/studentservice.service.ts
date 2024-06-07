import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StudentModelClass } from './student-model-class';

@Injectable({
  providedIn: 'root'
})
export class StudentserviceService{





  constructor(private http:HttpClient) { }
  private basurl = "http://localhost:8090"

  SaveData(saveDataObj:any){

  return this.http.post(this.basurl+"/SaveData" , saveDataObj , {responseType : 'text'}) 
  }


  GetdataByID(id:any) : Observable<any>
  {
    return this.http.get<any>(this.basurl+"/GetDataById/"+id , {responseType : 'json'})
  }


  GetAllStudent() : Observable<StudentModelClass[]>
  {
    return this.http.get<StudentModelClass[]>(this.basurl+"/getallStudent" , {responseType : 'json'})
  }

PostFile(file:File)
{
 const alldata=new FormData()
  alldata.append("file",file)
  return this.http.post(this.basurl+"/SaveData",alldata , {responseType : 'text'})
}


}
