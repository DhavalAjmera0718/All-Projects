import { Component } from '@angular/core';

@Component({
  selector: 'app-calc',
  templateUrl: './calc.component.html',
  styleUrls: ['./calc.component.css']
})
export class CalcComponent {

result:number=0;
calculator(a:string , b:string , c:string){

if(c==='add')
{
  this.result = parseInt(a)+parseInt(b);
}
if(c==='subs')
{
  this.result = parseInt(a)-parseInt(b);
}
if(c==='mul')
{
  this.result = parseInt(a)*parseInt(b);
}
if(c==='div')
{
  this.result = parseInt(a)/parseInt(b);
}

}
  
}
