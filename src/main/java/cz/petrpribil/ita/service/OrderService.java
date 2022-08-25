package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.OrderDto;
import cz.petrpribil.ita.model.OrderRequestDto;

import java.util.Collection;

public interface OrderService {
    OrderDto createOrder(Long cartId);
}
