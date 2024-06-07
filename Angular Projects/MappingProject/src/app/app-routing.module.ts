import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveOneToManyComponent } from './reactive-one-to-many/reactive-one-to-many.component';
import { GetByIdComponent } from './get-by-id/get-by-id.component';
import { GetAllAdminComponent } from './get-all-admin/get-all-admin.component';

const routes: Routes = [
  {
    path:'onetomany',
    component:ReactiveOneToManyComponent
  },
  {
    path:'getbyid',
    component:GetByIdComponent
  },
  {
    path:'getalldata',
    component:GetAllAdminComponent
  },
  
  {
    path:'',
    redirectTo:'onetomany',
    pathMatch:'full'
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
