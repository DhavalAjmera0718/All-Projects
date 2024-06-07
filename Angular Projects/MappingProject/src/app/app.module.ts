import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveOneToManyComponent } from './reactive-one-to-many/reactive-one-to-many.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { GetByIdComponent } from './get-by-id/get-by-id.component';
import { GetAllAdminComponent } from './get-all-admin/get-all-admin.component';

@NgModule({
  declarations: [
    AppComponent,
    ReactiveOneToManyComponent,
    GetByIdComponent,
    GetAllAdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
