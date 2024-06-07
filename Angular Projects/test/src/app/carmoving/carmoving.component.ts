import { Component } from '@angular/core';

@Component({
  selector: 'app-carmoving',
  templateUrl: './carmoving.component.html',
  styleUrls: ['./carmoving.component.css']
})
export class CarmovingComponent {
  CarName:String="Lembogini"
  Carprice:Number=200000
  CarOwner:String="Raj"

  getCar()
  {
    return "Something went worng.....!";
  }



}
