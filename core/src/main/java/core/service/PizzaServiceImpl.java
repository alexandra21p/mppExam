package core.service;

import core.model.Pizza;
import core.repository.PizzaRepository;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Alexandra on 20/06/2017.
 */
@Service
public class PizzaServiceImpl implements PizzaService {
    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(PizzaServiceImpl.class);

    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    @Transactional
    public List<Pizza> findAll() {
        log.trace("findAll");

        List<Pizza> pizzas = pizzaRepository.findAll();

        log.trace("findAll: pizzas = {}", pizzas);

        return pizzas;
    }

    @Override
    public Pizza findPizza(Long pizzaId) {
        log.trace("findPizza: pizzaId = {}", pizzaId);

        Pizza pizza = pizzaRepository.findOne(pizzaId);

        log.trace("findPizza: pizza = {}", pizza);

        return pizza;
    }

    @Override
    @Transactional
    public Pizza updatePizza(Long pizzaId, float price) {
        log.trace("updatePizza: pizzaId = {}, price = {}",
                pizzaId, price);

        Pizza pizza = pizzaRepository.findOne(pizzaId);
        pizza.setPrice(price);

        log.trace("updatePizza: pizza = {}", pizza);

        return pizza;
    }
}
