import { Component } from '@angular/core';

@Component({
  selector: 'app-pipe-use',
  templateUrl: './pipe-use.component.html',
  styleUrls: ['./pipe-use.component.css']
})
export class PipeUseComponent {

  name:string= "Hello I am From Pipe From Controller"

  array1=[
    {
      'name':'',
      'city':'ahmedabad',
      'phoneNumber':8128401450
    },
    {
      'name':'',
      'city':'ahmedabad',
      'phoneNumber':8128401450  
    },
 
  ]

  money:number=34500.1294

  mydate  = new Date;

  number1:number=5;

}
