import { Component, OnInit } from '@angular/core';
import { LoginServiceSisService } from '../service/login-service-sis.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {


  public loggedin = false;

  constructor(private service: LoginServiceSisService , private router:Router){}
  ngOnInit(): void {
  this.loggedin=this.service.isLoggedIn()
  console.log(this.loggedin)

    
  }
  
LogoutUser(){
  this.service.LogOut();
  localStorage.removeItem("role");
  localStorage.removeItem("username");
  this.router.navigate(['/login']);
  window.location.reload()

}


}
