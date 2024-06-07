import { Component } from '@angular/core';

@Component({
  selector: 'app-withoutcss',
  templateUrl: './withoutcss.component.html',
  styles: [
    `
    p{
      color: black;
    }
    h1{
      background-color:orange;
    }
    `
  ]
})
export class WithoutcssComponent {

}
