package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.mapper.OrderMapper;
import cz.petrpribil.ita.model.OrderDto;
import cz.petrpribil.ita.repository.OrderRepository;
import cz.petrpribil.ita.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    @Override
    public Collection<OrderDto> findAll() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }
}
