package com.pro.orderservice.repository;

import com.pro.orderservice.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
    @Query("SElECT e from OrderItem e where e.skuCode in (:skuCodes)")
    List<OrderItem> getAllOrderItemInSkuCode(List<String> skuCodes);

}
