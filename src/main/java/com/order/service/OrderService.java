package com.order.service;

import com.order.client.CustomerRestClient;
import com.order.dto.Order;
import com.order.entity.OrderEntity;
import com.order.mapper.OrderMapper;
import com.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {


    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final CustomerRestClient customerRestClient;
    @Autowired
    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository, CustomerRestClient customerRestClient) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
        this.customerRestClient = customerRestClient;
    }


    public OrderEntity saveOrder(Order order){
        String customerId = customerRestClient.createCustomerDetail(order.getCustomer());

        OrderEntity orderEntity=orderMapper.toEntity(order);
        orderEntity.setCustomerId(customerId);
        return orderRepository.save(orderEntity);

    }

    public List<OrderEntity> getAllOrder() {
        return orderRepository.findAll();
    }

    public Optional<OrderEntity> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    public void deleteOrderById(String id) {
         orderRepository.deleteById(id);
    }
}
