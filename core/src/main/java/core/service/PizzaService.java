package core.service;

import core.model.Pizza;

import java.util.List;

/**
 * Created by Alexandra on 20/06/2017.
 */
public interface PizzaService {
    List<Pizza> findAll();
    Pizza findPizza(Long pizzaId);
    Pizza updatePizza(Long pizzaId, float price);
}
