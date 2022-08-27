package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.domain.Order;
import cz.petrpribil.ita.model.OrderDto;
import cz.petrpribil.ita.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("cart/{cartId}")
    public OrderDto createOrder(@PathVariable("cartId") Long cartId) {
        return orderService.createOrder(cartId);
    }

    @PostMapping
    public Collection<OrderDto> findAll(){
        return orderService.findAll();
    }

    @PostMapping("{orderId}/status/{status}")
    public OrderDto updateOrderStatus(@PathVariable("orderId") Long id, @PathVariable("status") Order.OrderStatus orderStatus){
        return orderService.updateOrderStatus(id, orderStatus);
    }

}

