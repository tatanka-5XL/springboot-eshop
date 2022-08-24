package cz.petrpribil.ita.mapper;

import cz.petrpribil.ita.domain.Cart;
import cz.petrpribil.ita.model.CartDto;
import cz.petrpribil.ita.model.CartRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(uses = CartMapper.class)
public interface CartMapper {

    Cart toDomain(CartRequestDto cartDto);
    CartDto toDto(Cart cart);
    void mergeCart(@MappingTarget Cart target, CartRequestDto source);
}
