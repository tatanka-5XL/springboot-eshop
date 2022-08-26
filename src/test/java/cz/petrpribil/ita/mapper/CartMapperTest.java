package cz.petrpribil.ita.mapper;

import cz.petrpribil.ita.domain.Cart;
import cz.petrpribil.ita.model.CartDto;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static cz.petrpribil.ita.mother.CartMother.getTestCart;

public class CartMapperTest implements WithAssertions {

    private final CartMapper mockCartMapper = Mappers.getMapper(CartMapper.class);

    @Test
    void testToDto() {
        Cart testCart = getTestCart();
        CartDto resultToDomain = mockCartMapper.toDto(testCart);

        assertThat(resultToDomain.getId()).isEqualTo(testCart.getId());
    }

}
