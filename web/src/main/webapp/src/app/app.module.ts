import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {AppRoutingModule} from "./app-routing.module";

import { AppComponent } from './app.component';
import {PizzaListComponent} from "./pizzas/pizza-list/pizza-list.component";
import {PizzaService} from "./pizzas/shared/pizza.service";
import {PizzasComponent} from "./pizzas/pizzas.component";

@NgModule({
  declarations: [
    AppComponent,
    PizzaListComponent,
    //PizzasComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [PizzaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
