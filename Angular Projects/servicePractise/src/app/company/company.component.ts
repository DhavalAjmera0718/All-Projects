import { Component ,OnInit } from '@angular/core';
import { DataProviderService } from '../service/data-provider.service';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit{
  companyList:any;
  constructor(private companydata:DataProviderService){}
  
  
  ngOnInit(): void {
   
    this.companyList=this.companydata.getData();
  }

}
