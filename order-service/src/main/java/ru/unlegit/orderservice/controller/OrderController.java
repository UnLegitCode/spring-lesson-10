package ru.unlegit.orderservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.unlegit.orderservice.dto.OrderCreateDto;
import ru.unlegit.orderservice.dto.OrderDto;
import ru.unlegit.orderservice.service.OrderService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> listOrders() {
        return orderService.listOrders();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto creteOrder(@RequestBody OrderCreateDto dto) {
        return orderService.create(dto);
    }
}