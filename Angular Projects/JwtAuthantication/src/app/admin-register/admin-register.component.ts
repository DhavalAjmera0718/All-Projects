import { Component ,OnInit} from '@angular/core';
import { AdminServiceService } from '../service/admin-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-register',
  templateUrl: './admin-register.component.html',
  styleUrls: ['./admin-register.component.css']
})
export class AdminRegisterComponent implements OnInit{

  adminalldata:any;

  constructor(private adminservice: AdminServiceService, private router: Router) { }
  ngOnInit(): void {
    this.getAdminData()

  }


  getAdminData()
  {
    this.adminservice.getAllAdminData().subscribe(data => {
     this.adminalldata=data;
     console.log("Admin Data --------> " , this.adminalldata)
    })

  }

}
