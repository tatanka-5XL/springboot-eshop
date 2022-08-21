package cz.petrpribil.ita.mapper;

import cz.petrpribil.ita.domain.Cart;
import cz.petrpribil.ita.model.CartDto;
import org.mapstruct.Mapper;

@Mapper
public interface CartMapper {
    CartDto toDto(Cart cart);
}
