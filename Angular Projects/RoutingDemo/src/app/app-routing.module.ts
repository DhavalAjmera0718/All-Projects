import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { StudentlistComponent } from './studentlist/studentlist.component';
import { DetailsComponent } from './details/details.component';
import { WildcardComponent } from './wildcard/wildcard.component';
import { StudentMedicalinfoComponent } from './student-medicalinfo/student-medicalinfo.component';
import { StudentEducationdetailsComponent } from './student-educationdetails/student-educationdetails.component';
import { RegistrationComponent } from './registration/registration.component';

const routes: Routes = [
  {
    path:'',
    redirectTo:'home',
    pathMatch:'full'
  },
  {
    path:'home',
    component:HomeComponent    
  },
  {
    path:'template',
    component:RegistrationComponent    
  },
  {
    path:'studentlist',
    component:StudentlistComponent   ,
    children:[
      {
        path:'medicalinfo',
        component:StudentMedicalinfoComponent
      },
      {
        path:'educationinfo',
        component:StudentEducationdetailsComponent
      }
    ]  
  },
  {
    path:'studentlist/:id',
    component:StudentlistComponent,  
  },
  // {
  //   path:'details/:id',
  //   component:DetailsComponent    
  // },
  {
    path: 'details/:id',  
    component: DetailsComponent
  },

  
  {
    path:'**',
    component:WildcardComponent    
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
