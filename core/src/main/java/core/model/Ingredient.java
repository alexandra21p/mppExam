package core.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Alexandra on 20/06/2017.
 */
@javax.persistence.Entity
@Table(name = "ingredient")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Ingredient extends BaseEntity<Long>{
    @Column(name = "name")
    String name;
}
