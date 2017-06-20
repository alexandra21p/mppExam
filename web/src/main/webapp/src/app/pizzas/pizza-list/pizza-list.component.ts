import {Component, OnInit} from '@angular/core';
import {Pizza} from "../shared/pizza.model";
import {PizzaService} from "../shared/pizza.service";
import {Router} from "@angular/router";


@Component({
    moduleId: module.id,
    selector: 'app-pizza-list',
    templateUrl: './pizza-list.component.html',
    styleUrls: ['./pizza-list.component.css'],
})
export class PizzaListComponent implements OnInit {
    errorMessage: string;
    pizzas: Pizza[];
    selectedPizza: Pizza;
    price: number = null;

    constructor(private pizzaService: PizzaService,
                private router: Router) {
    }

    ngOnInit(): void {
        this.getPizzas();
    }

    getPizzas() {
        this.pizzaService.getPizzas()
            .subscribe(
                pizzas => this.pizzas = pizzas,
                error => this.errorMessage = <any>error
            );
    }

    onSelect(pizza: Pizza): void {
        this.selectedPizza = pizza;
        //this.router.navigate(['/student/detail', this.selectedPizza.id]);
    }

    updateAll(): void {
      let body = this.price;
      console.log(this.price);
      this.pizzaService
        .updateAll(body)
        .subscribe(pizzas => this.pizzas = pizzas);

    }

  update(pizza: Pizza): void {
    this.selectedPizza = pizza;
    console.log(pizza);
    this.pizzaService.update(pizza);
  }





}
