import { Component, OnInit } from '@angular/core';
import { StudentInformationSystem } from '../student-information-system';
import { StudentInformationSyatemService } from '../student-information-system.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit{

students : StudentInformationSystem =  new StudentInformationSystem();
constructor(private studentservice: StudentInformationSyatemService , private router :Router)
{}
ngOnInit(): void {
 
}

redgisterStudent()
{
  this.studentservice.Registerstudent(this.students).subscribe(data=>{
    console.log(data);
    this.gotoStudentList();
  },
  error => console.log(error));
}
gotoStudentList(){
  this.router.navigate(['/sis'])
}

onSubmit(){
  console.log(this.students)
  this.redgisterStudent();
}
}
