import {Component, OnInit} from "@angular/core";
import {PizzaService} from "./shared/pizza.service";

@Component({
    moduleId: module.id,
    selector: 'app-pizzas',
    templateUrl: './pizzas.component.html',
    styleUrls: ['./pizzas.component.css'],
})
export class PizzasComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}

