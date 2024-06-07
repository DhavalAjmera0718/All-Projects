
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { StudentserviceService } from '../service/studentservice.service';
import { StudentModelClass } from '../service/student-model-class';


@Component({
  selector: 'app-get-by-id',
  templateUrl: './get-by-id.component.html',
  styleUrls: ['./get-by-id.component.css']
})
export class GetByIdComponent {

  studentEntityData: any;
  isShow:boolean=false;
  student: StudentModelClass =  new StudentModelClass();
  id:any;
  file!:File;

  constructor(private fb: FormBuilder , private service : StudentserviceService) {
    
  }
  ngOnInit(): void {
    

  }
/*****************************************[ GET DATA BY ID ]*********************************************************************/ 
GetDataById(id: any) {
  this.service.GetdataByID(id).subscribe(resp => {
    this.student = resp;
    console.log(resp);
    
    this.isShow = true; // Show table when data is loaded
  }, error => {
    console.error('Error occurred while fetching data:', error);
    this.isShow = false; // Hide table when error occurs or no data is found
  });
}


/***************************************************************/

postdata(event:any)
{
this.file=  event.target.files[0];


}

uploadfile()
{
  this.service.PostFile(this.file).subscribe(data =>{
    console.log(data);
  })
}


}
