package web.controller;

import core.model.Pizza;
import core.service.PizzaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import web.converter.PizzaConverter;
import web.dto.PizzaDto;
import web.dto.PizzasDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexandra on 14/06/2017.
 */
@RestController
public class PizzaController {
   //private static final Logger log = LoggerFactory.getLogger(PizzaController.class);
   private static final Logger log = LogManager.getLogger(PizzaController.class);

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private PizzaConverter pizzaConverter;

    
    @RequestMapping(value = "/pizzashop2010/pizzas", method = RequestMethod.GET)
    public PizzasDto getPizzas() {
        log.trace("getPizzas");

        List<Pizza> pizzas = pizzaService.findAll();

        log.trace("getPizzas: pizzas = {}", pizzas);

        return new PizzasDto(pizzaConverter.convertModelsToDtos(pizzas));
    }

    @RequestMapping(value = "/pizzashop2010/pizzas",  method = RequestMethod.POST)
        public Map<String, PizzaDto> updatePizza(
                @RequestBody final Map<String, PizzaDto> pizzaDtoMap) {
            log.trace("updatePizza: pizzaDtoMap = {}", pizzaDtoMap);

            PizzaDto pizzaDto = pizzaDtoMap.get("pizza");
            Pizza pizza = pizzaService.updatePizza(pizzaDto.getId(), pizzaDto.getPrice());

            Map<String, PizzaDto> result = new HashMap<>();
            result.put("pizza", pizzaConverter.convertModelToDto(pizza));

            log.trace("updatePizza: result = {}", result);

            return result;
    }

    @RequestMapping(value = "/pizzashop2010/pizzas",  method = RequestMethod.PUT)
    public PizzasDto updateAllPizzas(
            @RequestBody final float price) {
        log.trace("updatePizzas: price = {}", price);

        List<Pizza> pizzas = pizzaService.findAll();

        log.trace("getPizzas: pizzas = {}", pizzas);
        for (Pizza p : pizzas) {
            float oldPrice = p.getPrice();
            p.setPrice(oldPrice + price);
        }

        log.trace("updatePizzas: done");
        return new PizzasDto(pizzaConverter.convertModelsToDtos(pizzas));
    }
    
}
