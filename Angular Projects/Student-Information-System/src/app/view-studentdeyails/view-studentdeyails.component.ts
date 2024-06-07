import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { StudentInformationSyatemService } from '../student-information-system.service';
import { StudentInformationSystem } from '../student-information-system';

@Component({
  selector: 'app-view-studentdeyails',
  templateUrl: './view-studentdeyails.component.html',
  styleUrls: ['./view-studentdeyails.component.css']
})
export class ViewStudentdeyailsComponent implements OnInit{
  
  name:any;
  studentModel : StudentInformationSystem = new StudentInformationSystem();
  constructor(private activatedRouter : ActivatedRoute , private studentS:StudentInformationSyatemService){
    
  }
  
  ngOnInit(): void {

    this.name=this.activatedRouter.snapshot.params['name'];
   this.studentModel= new StudentInformationSystem();
   this.studentS.GetStudentById(this.name).subscribe(data => {
    this.studentModel = data;
   })
  }

}
