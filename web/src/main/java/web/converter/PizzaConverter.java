package web.converter;

import org.springframework.stereotype.Component;
import core.model.Pizza;
import web.dto.PizzaDto;

/**
 * Created by cosmin on 14/06/2017.
 */
@Component
public class PizzaConverter extends BaseConverter<Pizza, PizzaDto> {
    @Override
    public Pizza convertDtoToModel(PizzaDto pizzaDto) {
        Pizza now = Pizza.builder()
                .name(pizzaDto.getName())
                .description(pizzaDto.getDescription())
                .price(pizzaDto.getPrice())
                .build();
        now.setId(pizzaDto.getId());
        return now;
    }

    @Override
    public PizzaDto convertModelToDto(Pizza pizza) {
        PizzaDto now = PizzaDto.builder()
                .name(pizza.getName())
                .description(pizza.getDescription())
                .price(pizza.getPrice())
                .build();
        now.setId(pizza.getId());
        return now;
    }
}
