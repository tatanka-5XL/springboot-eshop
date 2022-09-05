package cz.petrpribil.ita.service;

import cz.petrpribil.ita.domain.Order;
import cz.petrpribil.ita.model.OrderDto;

import java.util.Collection;

public interface OrderService {
    OrderDto createOrder(Long cartId);
    Collection<OrderDto> findAll();
    OrderDto updateOrderStatus(Long id, Order.OrderStatus orderStatus);


}
