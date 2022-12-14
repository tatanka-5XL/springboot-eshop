package cz.petrpribil.ita.mapper;

import cz.petrpribil.ita.domain.Order;
import cz.petrpribil.ita.model.OrderDto;
import org.mapstruct.Mapper;

@Mapper(uses = ProductMapper.class)
public interface OrderMapper {
    OrderDto toDto(Order order);
}


