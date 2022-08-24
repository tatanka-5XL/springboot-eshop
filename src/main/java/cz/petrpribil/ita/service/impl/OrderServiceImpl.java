package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.domain.Cart;
import cz.petrpribil.ita.domain.Order;
import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.exception.CartNotFoundException;
import cz.petrpribil.ita.mapper.OrderMapper;
import cz.petrpribil.ita.model.OrderDto;
import cz.petrpribil.ita.model.OrderRequestDto;
import cz.petrpribil.ita.repository.CartRepository;
import cz.petrpribil.ita.repository.OrderRepository;
import cz.petrpribil.ita.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CartRepository cartRepository;


    @Override
    public Collection<OrderDto> findAll() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public OrderDto createOrder(Long cart_id, OrderRequestDto orderDto){
        log.debug("Creating order...");
        Order order = orderMapper.toDomain(orderDto);
        Cart cart = cartRepository.findById(cart_id)
                .orElseThrow(() -> new CartNotFoundException(cart_id));
        List<Product> products = cart.getProducts();
        order.setProducts(products);
        orderRepository.save(order);
        OrderDto savedOrder = orderMapper.toDto(order);
        log.debug("Created order" + savedOrder);
        return savedOrder;
    }

}
