import {Injectable} from '@angular/core';
import {Http, Response, Headers} from "@angular/http";

import {Pizza} from "./pizza.model";

import {Observable} from "rxjs";
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';


@Injectable()
export class PizzaService {
    private pizzasUrl = 'http://localhost:8080/api/pizzashop2010/pizzas';
    private pizzaUrl = 'http://localhost:8080/api/pizza';
    private headers = new Headers({'Content-Type': 'application/json'});

    constructor(private http: Http) {
    }

    getPizzas(): Observable<Pizza[]> {
        //noinspection TypeScriptUnresolvedFunction
      return this.http.get(this.pizzasUrl)
            .map(this.extractData)
            .catch(this.handleError);
    }

    private extractData(res: Response) {
        let body = res.json();
        return body.pizzas || {};
    }

    private handleError(error: Response | any) {
        let errMsg: string;
        if (error instanceof Response) {
            const body = error.json() || '';
            const err = body.error || JSON.stringify(body);
            errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
        } else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        return Observable.throw(errMsg);
    }

    getPizza(id: number): Observable<Pizza> {
      //noinspection TypeScriptUnresolvedVariable,TypeScriptUnresolvedFunction
      return this.getPizzas()
            .map(pizzas => pizzas.find(pizza => pizza.id === id));
    }

    update(pizza: Pizza): Observable<Pizza> {
      console.log("inside service client: ", pizza);
      //const url = `${this.pizzaUrl}/${pizza.id}`;
      //noinspection TypeScriptUnresolvedVariable,TypeScriptUnresolvedFunction,TypeScriptValidateTypes
      return this.http
        .put(this.pizzasUrl, JSON.stringify({"pizza": pizza}), {headers: this.headers})
        .map(this.extractPizzaData)
        .catch(this.handleError);
    }

    private extractPizzaData(res: Response) {
      let body = res.json();
      return body.pizza || {};
    }

    updateAll(body: number): Observable<Pizza[]> {
      console.log(this.headers);
      //noinspection TypeScriptUnresolvedFunction,TypeScriptValidateTypes
      return this.http.put(this.pizzasUrl, JSON.stringify(body), {headers: this.headers})
        .map(this.extractData)
        .catch(this.handleError);
    }
}
