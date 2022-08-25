package cz.petrpribil.ita.mapper;

import cz.petrpribil.ita.domain.Order;
import cz.petrpribil.ita.model.OrderDto;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static cz.petrpribil.ita.mother.OrderMother.getTestOrder;

public class OrderMapperTest implements WithAssertions {

    private final OrderMapper mockOrderMapper = Mappers.getMapper(OrderMapper.class);

    @Test
    void testToDto() {
        Order testOrder = getTestOrder();
        OrderDto resultToDomain = mockOrderMapper.toDto(testOrder);

        assertThat(resultToDomain.getOrderId()).isEqualTo(testOrder.getId());
    }

}
