package cz.petrpribil.ita.mapper;

import cz.petrpribil.ita.domain.Cart;
import cz.petrpribil.ita.model.CartDto;
import cz.petrpribil.ita.model.CartRequestDto;
import org.mapstruct.Mapper;

@Mapper(uses = CartMapper.class)
public interface CartMapper {

    Cart toDomain(CartRequestDto cartDto);
    CartDto toDto(Cart cart);

}
