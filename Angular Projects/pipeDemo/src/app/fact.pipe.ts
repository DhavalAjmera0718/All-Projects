import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'fact'
})
export class FactPipe implements PipeTransform {

  transform(value: any, ...args: number[]): unknown {
    // return value * value;                         /* SQURE*/ 
    // let a = args[0]                                /** POWER */
    // return Math.pow(value,a);

    let f = 1;
    for(let i =value; i>=1; i--)
    {
      f=f*i;
    }
    return f;
  }

}
