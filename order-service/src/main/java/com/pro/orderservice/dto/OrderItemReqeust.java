package com.pro.orderservice.dto;

import lombok.Data;

@Data
public class OrderItemReqeust {
    private long id;
    private String skuCode;
    private double price;
    private int quantity;
}

