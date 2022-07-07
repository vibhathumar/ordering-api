package com.order.service;

import com.order.dto.Order;
import com.order.entity.OrderEntity;
import com.order.mapper.OrderMapper;
import com.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
    }


    public OrderEntity saveOrder(Order order){
        OrderEntity orderEntity=orderMapper.toEntity(order);
        return orderRepository.save(orderEntity);

    }
}
