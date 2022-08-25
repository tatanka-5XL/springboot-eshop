package cz.petrpribil.ita.mapper;

import cz.petrpribil.ita.domain.Cart;
import cz.petrpribil.ita.domain.ProductGroup;
import cz.petrpribil.ita.model.CartDto;
import cz.petrpribil.ita.model.ProductGroupDto;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static cz.petrpribil.ita.mother.CartMother.getTestCart;
import static cz.petrpribil.ita.mother.CartMother.getTestCartDto;
import static cz.petrpribil.ita.mother.ProductGroupMother.getTestProductGroup;

public class CartMapperTest implements WithAssertions {

    private final CartMapper mockCartMapper = Mappers.getMapper(CartMapper.class);

    @Test
    void testToDto() {
        Cart testCart = getTestCart();
        CartDto resultToDomain = mockCartMapper.toDto(testCart);

        assertThat(resultToDomain.getCartId()).isEqualTo(testCart.getId());
    }

}
