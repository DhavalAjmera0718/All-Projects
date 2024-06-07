import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { LoginServiceSisService } from '../service/login-service-sis.service';
import { ApiserviceService } from '../service/apiservice.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {

  id: any
  studentEntity: any
  constructor(private service: ApiserviceService, private activatedRoute: ActivatedRoute , private router : Router) { }

  ngOnInit(): void {
      this.id = this.activatedRoute.snapshot.params['id']
      console.log(this.id)
      this.service.GetStudentById(this.id).subscribe(data => {
      this.studentEntity = data;
    },
     error => console.log(error));
  }


  reactiveForm = new FormGroup({
    name: new FormControl(),
    password: new FormControl('dhaval', [Validators.required, Validators.minLength(5)]),
    contact: new FormControl('dhaval@gmail.com', [Validators.email]),
    enrollmentNo: new FormControl(),
    gender: new FormControl(),
    branch: new FormControl(),
    city: new FormControl(),
    address: new FormControl(),
    pinCode: new FormControl(),
    securityKey: new FormControl(),
    role: new FormControl(),

  })

  saveuser() {
    this.service.RegisterUser(this.reactiveForm.value).subscribe({
      next: (resp) => {
        alert("Data Has Been saved....!!")
        console.log("Response From Saveuser---> ", resp)
        this.studentEntity = resp
      },
      error: (err) => {
        console.log(err)
      }
    })
  }


  onSubmit()
  {
    this.service.updateById(this.id , this.studentEntity).subscribe( data2 => {
      this.router.navigate(['dasboard'])
      // window.location.reload()
    })
  }
  get user() {
    return this.reactiveForm.get('user')
  }
  get password() {
    return this.reactiveForm.get('password')
  }
  get email() {
    return this.reactiveForm.get('email')
  }

}
