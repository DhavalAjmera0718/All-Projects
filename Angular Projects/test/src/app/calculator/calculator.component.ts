import { Component } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent {

  title:String="calculator";
  public num1: number=0;
  public num2: number=0;
  public num3: number=0;
  add()
  {
    this.num3=this.num1+this.num2
  }
  sub()
  {
    this.num3=this.num1-this.num2
  }
  mul()
  {
    this.num3=this.num1*this.num2
  }
  div()
  {
    this.num3=this.num1/this.num2
  }


output:String='';

getdata(input:any)
{
  this.output=input;
}



username='';

}
