package com.order.mapper;

import com.order.dto.Order;
import com.order.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order toDto(OrderEntity orderEntity){
        Order order=new Order();

        order.setId(orderEntity.getId());
        order.setState(orderEntity.getState());
        order.setOrderDetails(orderEntity.getOrderDetails());
       // order.setCustomer(orderEntity.getCustomer());
        return order;
    }

    public OrderEntity toEntity(Order order){
        OrderEntity orderEntity=new OrderEntity();

        orderEntity.setId(order.getId());
        orderEntity.setState(order.getState());
        orderEntity.setOrderDetails(order.getOrderDetails());
        orderEntity.setCustomerId("1");
        return orderEntity;
    }
}
