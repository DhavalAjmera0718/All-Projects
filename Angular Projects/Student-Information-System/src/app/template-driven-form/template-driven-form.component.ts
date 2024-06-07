import { Component } from '@angular/core';
import { StudentInformationSystem } from '../student-information-system';

@Component({
  selector: 'app-template-driven-form',
  templateUrl: './template-driven-form.component.html',
  styleUrls: ['./template-driven-form.component.css']
})
export class TemplateDrivenFormComponent {


  checkboxData :string [] = [];
  // students : StudentInformationSystem =  new StudentInformationSystem();
  onSubmit(item:any){
    // item.value.elective = this.checkboxData;
    console.log(item);
  }
getelectiveData(e:any)
{
  console.log("---------->>>>>" , e.target.value);
  console.log(" checkbox status---------->>>>>" , e.target.checked);

  let value = e.target.value;
  let checkeStatus = e.target.checked;

  if(checkeStatus)
  {
    this.checkboxData.push(value);
  }
  else
  {
    console.warn("********* ELSE PART**********");
  }
  console.log( "CheckBox Data ----------> ", this.checkboxData)

}

}
