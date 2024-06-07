import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CarmovingComponent } from './carmoving/carmoving.component';
import { WithoutcssComponent } from './withoutcss/withoutcss.component';
import { LoginuserComponent } from './loginuser/loginuser.component';
import { CalculatorComponent } from './calculator/calculator.component';




@NgModule({
  declarations: [
    AppComponent,
    CarmovingComponent,
    WithoutcssComponent,
    LoginuserComponent,
    CalculatorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
