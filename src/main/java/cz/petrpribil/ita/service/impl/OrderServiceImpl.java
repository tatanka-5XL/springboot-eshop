package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.domain.Cart;
import cz.petrpribil.ita.domain.Order;
import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.exception.CartNotFoundException;
import cz.petrpribil.ita.exception.OrderNotFoundException;
import cz.petrpribil.ita.mapper.OrderMapper;
import cz.petrpribil.ita.model.OrderDto;
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
    @Transactional
    public OrderDto createOrder(Long cartId){
        log.debug("Creating order...");
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(cartId));
        Order order = new Order();
        List<Product> products = cart.getProducts();
        order.setProducts(products);
        order.setOrderStatus(Order.OrderStatus.NEW);
        orderRepository.save(order);
        cartRepository.delete(cart);
        OrderDto savedOrder = orderMapper.toDto(order);
        log.debug("Created order" + savedOrder);
        return savedOrder;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<OrderDto> findAll() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public OrderDto updateOrderStatus(Long id, Order.OrderStatus orderStatus) {
        log.debug("Status or order Nr. " + id + " is being updated");
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new OrderNotFoundException(id));
        order.setOrderStatus(orderStatus);
        OrderDto savedOrder = orderMapper.toDto(order);
        log.debug("Status of order " + id + " was updated to " + order.getOrderStatus());
        return savedOrder;
    }

}
