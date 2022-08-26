package cz.petrpribil.ita.model;

import cz.petrpribil.ita.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {

    private Order.OrderStatus orderStatus;
    private List<ProductSimpleDto> products;
}
