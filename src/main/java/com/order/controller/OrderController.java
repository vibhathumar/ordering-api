package com.order.controller;


import com.order.dto.Order;
import com.order.entity.OrderEntity;
import com.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public OrderEntity saveOrder(@RequestBody Order order){

        log.info("Hello"+order);
        return orderService.saveOrder(order);
    }
    @GetMapping("/getAllOrder")
    public List<OrderEntity> getAllOrder(){
        return orderService.getAllOrder();
    }
    @GetMapping("/getOrderById/{id}")
    public Optional<OrderEntity> getOrderById(@PathVariable("id") String id){
        return orderService.getOrderById(id);
    }
    @DeleteMapping("/deleteOrderById/{id}")
    public void deleteOrderById(@PathVariable("id") String id){
         orderService.deleteOrderById(id);
    }
}
