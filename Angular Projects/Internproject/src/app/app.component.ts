import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Internproject';
  displayText:String='';
  getvalue(name:any)
  {
    // alert(name)
    console.warn(name);
    this.displayText=name;
  }
  count=0;
  counter(type:String)
  {
    type=='add' ? this.count++ : this.count--;
  }
}  