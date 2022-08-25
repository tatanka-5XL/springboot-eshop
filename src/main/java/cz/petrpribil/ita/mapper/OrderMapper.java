package cz.petrpribil.ita.mapper;

import cz.petrpribil.ita.domain.Order;
import cz.petrpribil.ita.model.OrderDto;
import cz.petrpribil.ita.model.OrderRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(uses = ProductMapper.class)
public interface OrderMapper {
    Order toDomain(OrderRequestDto orderDto);
    OrderDto toDto(Order order);
    void mergeOrder(@MappingTarget Order target, OrderRequestDto source);
}


