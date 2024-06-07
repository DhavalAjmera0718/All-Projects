import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CalculatorComponent } from './calculator/calculator.component';
import { CarmovingComponent } from './carmoving/carmoving.component';
import { LoginuserComponent } from './loginuser/loginuser.component';
import { WithoutcssComponent } from './withoutcss/withoutcss.component';
const routes: Routes = [
  {
    path:'calculator',
    component:CalculatorComponent
  },
  {
    path:'carmoving',
    component:CarmovingComponent
  },
  {
    path:'loginuser',
    component:LoginuserComponent
  },
  {
    path:'',
    component:WithoutcssComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
