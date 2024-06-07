import { Component, OnInit } from '@angular/core';
import { StudentInformationSyatemService } from '../student-information-system.service';
import { StudentInformationSystem } from '../student-information-system';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit{

id:any;

  student : StudentInformationSystem =  new StudentInformationSystem();
  constructor(private studentservice : StudentInformationSyatemService
     , private activatedRoute :  ActivatedRoute , private router : Router){}

  ngOnInit(): void {
   this.id=this.activatedRoute.snapshot.params['id']
   console.log(this.id)
    this.studentservice.GetStudentById(this.id).subscribe(data => {
      this.student=data;
    } , error=> console.log(error));
  }

  onSubmit()
  {
    this.studentservice.updateById(this.id , this.student).subscribe( data2 => {
      this.gotoStudentList();
    })
  }

gotoStudentList()
{
  this.router.navigate(['sis'])
}

}
