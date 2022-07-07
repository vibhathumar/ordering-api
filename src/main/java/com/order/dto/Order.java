package com.order.dto;

import lombok.Data;

@Data
public class Order {
    private String id;
    private String state;
    private String orderDetails;
    private Customer customer;

}
