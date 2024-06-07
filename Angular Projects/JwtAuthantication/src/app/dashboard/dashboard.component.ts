import { Component, OnInit, ViewChild } from '@angular/core';
import { LoginServiceSisService } from '../service/login-service-sis.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatFormField } from '@angular/material/form-field';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';

import {
  MatDialog,
  MatDialogRef,
  MatDialogActions,
  MatDialogClose,
  MatDialogTitle,
  MatDialogContent,
} from '@angular/material/dialog';
import { DialogUpdateComponent } from '../dialog-update/dialog-update.component';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent implements OnInit {

  tableData: any;
  dataSource: any;
  displayColumns: string[] = ["enrollmentNo", "password", "name", "gender", "dob", "branch", "contact", "address", "city", "pinCode", "securityKey", "action"]
  @ViewChild(MatPaginator) paginator !: MatPaginator;
  @ViewChild(MatSort) matsort !: MatSort;
  @ViewChild(MatFormField) matform!: MatFormField

  searchValue: string = '';

  constructor(private service: LoginServiceSisService, private router: Router, private fb: FormBuilder, public dialog: MatDialog) {
    this.service.getAllUserData().subscribe({
      next: (resp) => {
        this.tableData = resp;
        console.log(this.tableData)
        this.dataSource = new MatTableDataSource(this.tableData);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.matsort;
        // this.dataSource.form=this.matform
        console.log("Data Source--->", this.dataSource)

      },
      error: (err) => {
        console.log(err);
      }
    })
  }

  ngOnInit(): void {}
  /**************************************************[ For OpeningDailog ]***************************************************************/
  openDialog(width: string, height: string, enrollmentNo: string): void {
    const dialogRef = this.dialog.open(DialogUpdateComponent, {
      width: width,
      height: height,
      data: { enrollmentNo: enrollmentNo }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.service.getAllUserData().subscribe({
        next: (resp) => {
          this.tableData = resp;
          console.log(this.tableData)
          this.dataSource = new MatTableDataSource(this.tableData);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.matsort;
          // this.dataSource.form=this.matform
          console.log("Data Source--->", this.dataSource)

        },
        error: (err) => {
          console.log(err);
        }
      })
      // You can handle the result here if needed
    });
  }

  /***************************************************[ GetAllUser_From_Admin_Data ]**************************************************************/
  GetAllUser_From_Admin_Data() {
    this.service.getAllUserData().subscribe({
      next: (resp) => {
        this.tableData = resp;
        console.log(resp)
        this.dataSource = new MatTableDataSource(this.tableData);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.matsort;
        // this.dataSource.form=this.matform
        console.log("Data Source--->", this.dataSource)

      },
      error: (err) => {
        console.log(err);
      }
    })

  }
  /*****************************************************************************************************************/
  filterchange(data: any) {

    const value = (data.target as HTMLInputElement).value
    this.dataSource.filter = value;

  }

  search(searchValue: string) {
    this.dataSource.filter = searchValue;
  }
  /***************************************************[ updateEmployee ]**************************************************************/
  updateEmployee(id: any) {
    this.router.navigate(['/userRegister', id])
  }

/*********************************************************[ USER DELETE BY ID USING ADMIN API ]********************************************************/

DeleteUserByAdmin(id:any)
{
  alert("User Has Been Deleted")
  this.service.DeleteUserByid_FromAdmin(id).subscribe(
    {
      next:(resp)=>{
      },
      error:(err)=>{
        console.log(err)
      }
    }
  )
}


}
