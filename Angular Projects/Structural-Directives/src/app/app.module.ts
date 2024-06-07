import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CalcComponent } from './calc/calc.component';
import { IfElseComponent } from './if-else/if-else.component';
import { ForLoopComponent } from './for-loop/for-loop.component';

@NgModule({
  declarations: [
    AppComponent,
    IfElseComponent,
    CalcComponent,
    ForLoopComponent
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
