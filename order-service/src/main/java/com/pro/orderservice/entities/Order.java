package com.pro.orderservice.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "tblOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String orderNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}
