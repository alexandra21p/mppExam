package web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * Created by Alexandra on 14/06/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PizzasDto {
    private Set<PizzaDto> pizzas;
}
