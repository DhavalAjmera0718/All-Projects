import { Component } from '@angular/core';
import { DataProviderService } from '../service/data-provider.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent {

studentList:any;

  constructor(private Data : DataProviderService)
  {
   this.studentList = this.Data.getData();
    //  console.log(this.studentList);
  }

}
