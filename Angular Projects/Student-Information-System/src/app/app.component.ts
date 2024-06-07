import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Student-Information-System';

  constructor(){

  }

  ngOnInit(){
      
  }
  reactiveForm = new FormGroup({
    user: new FormControl('dhaval'),
    password:new FormControl('dhaval'),
    email:new FormControl('dhaval@gmail.com'),
  })
  reactiveUser()
  {
    console.log(this.reactiveForm.value)
  }
}
