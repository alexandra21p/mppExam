package web.converter;

import org.springframework.stereotype.Component;
import core.model.Entity;
import web.dto.EntityDto;


@Component
public class EntityConverter extends BaseConverter<Entity, EntityDto> {
    @Override
    public Entity convertDtoToModel(EntityDto entityDto) {
        Entity now = Entity.builder()
                .name(entityDto.getName())
                .build();
        now.setId(entityDto.getId());
        return now;
    }

    @Override
    public EntityDto convertModelToDto(Entity client) {
        EntityDto nowDto = EntityDto.builder()
                .name(client.getName())
                .build();
        nowDto.setId(client.getId());
        return nowDto;
    }
}
