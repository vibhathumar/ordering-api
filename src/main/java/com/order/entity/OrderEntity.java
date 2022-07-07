package com.order.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="orderDetails")
@Data
public class OrderEntity {

    @Id
    @Column(name="Id")
    private String id;

    @Column(name="state")
    private String state;

    @Column(name="orderDetails")
    private String orderDetails;

    @Column(name="customerId")
    private String customerId;

}
