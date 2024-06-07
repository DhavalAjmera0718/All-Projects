import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PipeUseComponent } from './pipe-use/pipe-use.component';
import { FactPipe } from './fact.pipe';


@NgModule({
  declarations: [
    AppComponent,
    PipeUseComponent,
    FactPipe,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
