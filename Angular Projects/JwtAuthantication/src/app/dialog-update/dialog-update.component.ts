import { Component,OnInit,Inject  } from '@angular/core';
import { ApiserviceService } from '../service/apiservice.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-dialog-update',
  templateUrl: './dialog-update.component.html',
  styleUrls: ['./dialog-update.component.css']
})
export class DialogUpdateComponent implements OnInit {

  id: any
  studentEntity: any
  constructor(private service: ApiserviceService, private activatedRoute: ActivatedRoute, private router : Router, public dialogRef: MatDialogRef<DialogUpdateComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {}

    onClose(): void {
      this.dialogRef.close();
    }
 
  ngOnInit(): void {
    this.id = this.data.enrollmentNo;
    this.service.GetStudentById(this.id).subscribe(
      (resp) => {
        this.studentEntity = resp;
        console.log(resp);
      },
      (error) => console.log(error)
    );
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
  onSubmit()
  {
    this.service.updateById(this.id , this.studentEntity).subscribe( data2 => {
      // this.onClose();
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
