import { Component, OnInit } from '@angular/core';
import { StudentserviceService } from '../service/studentservice.service';
import { StudentModelClass } from '../service/student-model-class';

@Component({
  selector: 'app-get-all-admin',
  templateUrl: './get-all-admin.component.html',
  styleUrls: ['./get-all-admin.component.css']
})
export class GetAllAdminComponent implements OnInit {


  allStudentData: StudentModelClass[] = [];

  constructor(private service: StudentserviceService) {
    this.allStudentData = [];
  }
  ngOnInit(): void {

    this.getallStudent()

  }
  getallStudent() {
    console.log("------------------->>>>>>>.")
    this.service.GetAllStudent().subscribe(data => {
      this.allStudentData = data;
      console.log('GET ALL DATA-------', data);
    })
  }


}
