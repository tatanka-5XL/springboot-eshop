package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.model.OrderDto;
import cz.petrpribil.ita.model.OrderRequestDto;
import cz.petrpribil.ita.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("api/v1/orders")
@CrossOrigin("http://localhost:8088")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @GetMapping
    public Collection<OrderDto> findAll() {
        return orderService.findAll();
    }

    @PostMapping("cart/{cart_id}")
    public OrderDto createOrder(@PathVariable("cart_id") Long cart_id, @Valid @RequestBody OrderRequestDto orderRequestDto) {
        return orderService.createOrder(cart_id, orderRequestDto);
    }
}

