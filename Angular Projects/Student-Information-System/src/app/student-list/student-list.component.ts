import { Component, OnInit } from '@angular/core';
import { StudentInformationSystem } from '../student-information-system';
import { StudentInformationSyatemService } from '../student-information-system.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

id:any;

  StudentInformationSystems: StudentInformationSystem[];
  constructor( private studentService : StudentInformationSyatemService , private router:Router) {
     this.StudentInformationSystems = [];
  }

  ngOnInit(): void {

    this.getStudents();
    
  }
  private getStudents()
  {
    this.studentService.getAllStudents().subscribe(data => {
      this.StudentInformationSystems = data ;
      console.error(data);
    });
  }
  /*************************************** updateEmployee ******************************************************************/  
  
  updateEmployee(name : any)
  {
    this.router.navigate(['update',name])
  }
 
/***************************************** DeleteById ****************************************************************/  
  DeleteById(name:any)
  {
    this.studentService.DeleteById(name).subscribe(data =>
      {
        console.log(name)
        console.log(data);
        this.getStudents();
      }, error => console.log(error)
      );
      
  }
  ViewDetails(name:any)
  {
    this.router.navigate([`view`,name])
  }
  
}

// this.StudentInformationSystems = [
// ]
// {
//   "enrollmentNo": "a5",
//   "password": "jadeja",
//   "name": "jadeja",
//   "gender": "male",
//   "branch": "SSC",
//   "contact": "9429355523",
//   "address": "Ghatlodia",
//   "city": "Ahmedabad",
//   "pinCode": 380061,
//   "securityKey": "180207",
//   "role": "ADMIN"
  
// },      {
//   "enrollmentNo": "a5",
//   "password": "jadeja",
//   "name": "jadeja",
//   "gender": "male",
//   "branch": "SSC",
//   "contact": "9429355523",
//   "address": "Ghatlodia",
//   "city": "Ahmedabad",
//   "pinCode": 380061,
//   "securityKey": "180207",
//   "role": "ADMIN"
  
// } ,   
// {
//   "enrollmentNo": "a5",
//   "password": "jadeja",
//   "name": "jadeja",
//   "gender": "male",
//   "branch": "SSC",
//   "contact": "9429355523",
//   "address": "Ghatlodia",
//   "city": "Ahmedabad",
//   "pinCode": 380061,
//   "securityKey": "180207",
//   "role": "ADMIN"
  
// }