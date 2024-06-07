import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentListComponent } from './student-list/student-list.component';
import { LoginComponent } from './login/login.component';
import { AddStudentComponent } from './add-student/add-student.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { ViewStudentdeyailsComponent } from './view-studentdeyails/view-studentdeyails.component';
import { TemplateDrivenFormComponent } from './template-driven-form/template-driven-form.component';
import { ReactiveFormComponent } from './reactive-form/reactive-form.component';


const routes: Routes = [
  { 
    path:'login'
    ,component:LoginComponent
  },
  {
     path:'sis' 
     , component:StudentListComponent
  },
  
  { 
    path:'addstudent' ,
    component:AddStudentComponent
  },
  {
    path:'home',
    component:HomeComponent
  },
  {
    path:'about',
    component:AboutComponent
  },
  {
    path:'update/:id',
    component:UpdateStudentComponent
  },
  {
    path:'update',
    component:UpdateStudentComponent
  },
  {
    path:'view/:name',
    component:ViewStudentdeyailsComponent
  },
  
  {
    path:'template',
    component:TemplateDrivenFormComponent
  },
  {
    path:'reactive',
    component:ReactiveFormComponent
  },

  
   {path:'',redirectTo:'home',pathMatch:'full'},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
