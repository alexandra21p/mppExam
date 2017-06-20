package core.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by Alexandra on 20/06/2017.
 */
@Entity
@Table(name = "pizza")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Pizza extends BaseEntity<Long> {
    @Column(name = "name", nullable = false, length = 20, unique = true)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private float price;

    @OneToMany(fetch = FetchType.EAGER)
    @OrderColumn
    @JoinColumn(name="INGR_ID")
    Ingredient[] ingredients;
}
