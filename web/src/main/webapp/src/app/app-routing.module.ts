import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PizzaListComponent} from "./pizzas/pizza-list/pizza-list.component";
import {PizzasComponent} from "./pizzas/pizzas.component";


//noinspection TypeScriptValidateTypes
const routes: Routes = [

    { path: 'pizzashop2010/pizzas', component: PizzaListComponent},
    //{ path: 'pizzashop2010', component: PizzasComponent}
];

@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}
