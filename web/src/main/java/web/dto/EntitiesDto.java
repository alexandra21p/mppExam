package web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EntitiesDto implements Serializable {
    private Set<EntityDto> entities;
}
