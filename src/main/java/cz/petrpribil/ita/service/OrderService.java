package cz.petrpribil.ita.service;

import cz.petrpribil.ita.domain.Order;
import cz.petrpribil.ita.model.OrderDto;

import java.util.Collection;

public interface OrderService {

    /**
     * To create a new Order from a cart with a product
     * @param cartId
     * @return order with status NEW as {@link OrderDto}
     */
    OrderDto createOrder(Long cartId);

    /**
     * To update order actual status
     * @return order with updated status as {@link OrderDto}
     */
    Collection<OrderDto> findAll();
    OrderDto updateOrderStatus(Long id, Order.OrderStatus orderStatus);


}
