import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HtmltopdfService {

  constructor(private http:HttpClient) { }

  getPdf(file:File){
    const formData = new FormData();
    formData.append('file', file);
    alert("FORM DATA----->| " + file)
    
    return this.http.post(`http://localhost:8090/htmlToPdf`,formData,{responseType:'blob'});
  }
}
