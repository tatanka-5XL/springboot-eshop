package cz.petrpribil.ita.model;

import cz.petrpribil.ita.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private Instant createdAt;
    private Order.OrderStatus orderStatus;
    private Collection<ProductSimpleDto> products;

}
