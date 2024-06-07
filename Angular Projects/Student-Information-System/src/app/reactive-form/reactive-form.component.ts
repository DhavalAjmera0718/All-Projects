import { Component } from '@angular/core';
import { FormControl, FormGroup ,Validators} from '@angular/forms';
import { StudentInformationSyatemService } from '../student-information-system.service';
import { StudentInformationSystem } from '../student-information-system';


@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.css']
})
export class ReactiveFormComponent {

id:any
  studentEntity :  StudentInformationSystem =  new StudentInformationSystem();
constructor(private service : StudentInformationSyatemService){}


   reactiveForm = new FormGroup({
      name: new FormControl(this.studentEntity ,[Validators.required]),
      password:new FormControl('dhaval',[Validators.required , Validators.minLength(5 )]),
      contact:new FormControl('dhaval@gmail.com',[Validators.email]),
      enrollmentNo:new FormControl(),
      gender:new FormControl(),
      branch:new FormControl(),
      city:new FormControl(),
      address:new FormControl(),
      pinCode:new FormControl(),
      securityKey:new FormControl(),
      role:new FormControl(),
    
  })
  reactiveUser()
  {
    this.service.Registerstudent(this.reactiveForm.value).subscribe(data=>{
      console.log(data);
      this.studentEntity=data;
    })
    
  }

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  get user()
  {
     return this.reactiveForm.get('user')
  }
  get password()
  {
     return this.reactiveForm.get('password')
  }
  get email()
  {
     return this.reactiveForm.get('email')
  }
  

}
