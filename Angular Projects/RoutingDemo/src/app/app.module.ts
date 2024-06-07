import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { StudentlistComponent } from './studentlist/studentlist.component';
import { DetailsComponent } from './details/details.component';
import { WildcardComponent } from './wildcard/wildcard.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { StudentEducationdetailsComponent } from './student-educationdetails/student-educationdetails.component';
import { StudentMedicalinfoComponent } from './student-medicalinfo/student-medicalinfo.component';
import { RegistrationComponent } from './registration/registration.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    StudentlistComponent,
    DetailsComponent,
    WildcardComponent,
    NavBarComponent,
    StudentEducationdetailsComponent,
    StudentMedicalinfoComponent,
    RegistrationComponent
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
