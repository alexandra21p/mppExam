package web.dto;

import core.model.Ingredient;
import lombok.*;

/**
 * Created by Alexandra on 14/06/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class PizzaDto extends BaseDto {
    private String name;
    private String description;
    private float price;
    private Ingredient[] ingredients;
}
