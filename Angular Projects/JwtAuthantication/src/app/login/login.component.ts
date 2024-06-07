import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
import { LoginServiceSisService } from '../service/login-service-sis.service';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';





@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userdata = {
    username: '',
    password: ''
  }
  tableData: any;
  reactiveForm: any;

  constructor(private service: LoginServiceSisService, private fb: FormBuilder, private router: Router) {

    this.reactiveForm = this.fb.group({
      username: [],
      password: []

    })
  }
  ngOnInit(): void {

  }

  onSubmit() {
    if ((this.userdata.username != '' && this.userdata.password != '') && this.userdata.username != null && this.userdata.password != null) {
      console.log("Data Hase been Submited")
      this.service.TokenGeneration(this.userdata).subscribe(
        (response: any) => {

           const payload= this.service.LoginUser(response.jwtToken)
           if(payload.authorities==="ROLE_ADMIN"){
             
             this.router.navigate(['/admin'])
            //  window.location.reload();
            }
            else{
              this.router.navigate(['/dasboard'])
              // window.location.reload();
            }
            
         
          // console.log(response.jwtToken)
          // this.service.LoginUser(response.jwtToken)
          // this.router.navigate(['dasboard'])
        }, (error: any) => {
          console.error("Error:", error);
          alert("Error occurred while logging in. Please try again.");
        }
      )

    }
    else {
      alert("Invalid Userid Password...!! ")
    }
  }

  /********************************************** All function from SPRING AFTER authentcation*******************************************************************************/


}
