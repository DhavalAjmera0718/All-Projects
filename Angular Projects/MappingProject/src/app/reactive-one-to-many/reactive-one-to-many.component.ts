import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { StudentserviceService } from '../service/studentservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reactive-one-to-many',
  templateUrl: './reactive-one-to-many.component.html',
  styleUrls: ['./reactive-one-to-many.component.css']
})
export class ReactiveOneToManyComponent implements OnInit {


  studentEntityData: any;

  constructor(private fb: FormBuilder , private service : StudentserviceService , private router :Router) {

    this.studentEntityData = this.fb.group({
      sid: [],
      sname: [],
      department: [],
      cid: [],
      name: [],
      fee: []
    })
  }
  ngOnInit(): void {

  }

  saveStdentData(){
    console.log("Form Data ------------", this.studentEntityData.value);

    let payload = {
      sid:this.studentEntityData.value.sid,
      sname:this.studentEntityData.value.sname,
      department:this.studentEntityData.value.department,
      course:{

        cid:this.studentEntityData.value.cid,
        name:this.studentEntityData.value.name,
        fee:this.studentEntityData.value.fee,
        

      }
    }

    console.log("PayLoad Data- ",payload)
    this.service.SaveData(payload).subscribe(data => {
      console.log("Data Hase Been Saved From Save method" , data)
      
    })   
  }

  OnSubmit()
  {
    this.saveStdentData();
    this.router.navigate(['getalldata'])
  }
/*****************************************[ GET DATA BY ID ]*********************************************************************/ 
GetDataById(id:any){
  return this.service.GetdataByID(id).subscribe({
    next:(resp)=>{
      console.log("Response Drom GetByID" + resp)
    }
  })
}







}
