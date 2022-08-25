package cz.petrpribil.ita.mother;

import cz.petrpribil.ita.domain.Order;
import cz.petrpribil.ita.model.OrderDto;

public class OrderMother {
    private OrderMother(){

    }

    public static Order getTestOrder(){
        return (Order) new Order()
                .setId(300L);
    }

    public static OrderDto getTestOrderDto(){
        return new OrderDto()
                .setOrderId(300L);
    }
}
