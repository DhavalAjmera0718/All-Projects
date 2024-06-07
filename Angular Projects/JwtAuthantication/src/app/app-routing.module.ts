import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { authGuard } from './guard/auth.guard';
import { UserRegisterComponent } from './user-register/user-register.component';
import { AdminRegisterComponent } from './admin-register/admin-register.component';

const routes: Routes = [
  {
    path:'home',
    component:HomeComponent
  },
  {
    path:'dasboard',
    component:DashboardComponent,
    canActivate:[authGuard]
  },
  {
    path:'userRegister/:id',
    component:UserRegisterComponent,
    // canActivate:[authGuard]
  },
  {
    path:'login',
    component:LoginComponent
  },
  {
    path:'  ',
    component:AdminRegisterComponent,
      canActivate:[authGuard]
  },
  {
    path:'userRegister',
    component:UserRegisterComponent,
    canActivate:[authGuard]
  },
  {
    path:'navbar',
    component:NavBarComponent
  },
  {
    path:'',
    redirectTo:'home',
    pathMatch:'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
