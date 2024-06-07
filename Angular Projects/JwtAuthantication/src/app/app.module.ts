import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSliderModule} from '@angular/material/slider';
import {MatSortModule} from '@angular/material/sort';
import {MatCardModule} from '@angular/material/card';
import { AuthInterceprer } from './service/auth-interceprer';
import { LoginServiceSisService } from './service/login-service-sis.service';
import { authGuard } from './guard/auth.guard';
import {MatTableModule} from '@angular/material/table';
import { UserRegisterComponent } from './user-register/user-register.component';
import { AdminRegisterComponent } from './admin-register/admin-register.component';
import {MatDialogModule} from '@angular/material/dialog';
import { DialogUpdateComponent } from './dialog-update/dialog-update.component';


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomeComponent,
    LoginComponent,
    DashboardComponent,
    UserRegisterComponent,
    AdminRegisterComponent,
    DialogUpdateComponent
  ],
  imports: [
    BrowserModule,
    // FormControl,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatPaginatorModule,
    MatSliderModule,
    MatSortModule,
    MatCardModule,
    MatTableModule,
    MatDialogModule
  ],
  providers: [LoginServiceSisService , [{provide:HTTP_INTERCEPTORS, useClass:AuthInterceprer,multi:true}]],
  bootstrap: [AppComponent]
})
export class AppModule { }
