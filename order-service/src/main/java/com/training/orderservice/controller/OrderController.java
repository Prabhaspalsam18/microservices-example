package com.training.orderservice.controller;

import com.training.orderservice.model.Order;
import com.training.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping
    public String getOrder() {
        return "order";
    }

    @PostMapping
    public Order creatOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }
}
