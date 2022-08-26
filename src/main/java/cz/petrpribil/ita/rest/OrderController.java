package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.model.OrderDto;
import cz.petrpribil.ita.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/orders")
@CrossOrigin("http://localhost:8088")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("cart/{cartId}")
    public OrderDto createOrder(@PathVariable("cartId") Long cartId) {
        return orderService.createOrder(cartId);
    }
}

