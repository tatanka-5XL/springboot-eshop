package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.model.OrderDto;
import cz.petrpribil.ita.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
