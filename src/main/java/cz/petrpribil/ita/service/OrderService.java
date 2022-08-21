package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.OrderDto;

import java.util.Collection;

public interface OrderService {
    Collection<OrderDto> findAll();
}
