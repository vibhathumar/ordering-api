package com.order.controller;


import com.order.dto.Order;
import com.order.entity.OrderEntity;
import com.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("api/v1/order")
public class OrderController {


    public final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/postOrder")
    public OrderEntity Order(@RequestBody Order order){

        log.info("Hello"+order);
        return orderService.saveOrder(order);
    }
}
