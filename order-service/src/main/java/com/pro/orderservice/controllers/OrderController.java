package com.pro.orderservice.controllers;

import com.pro.orderservice.dto.OrderItemResponse;
import com.pro.orderservice.dto.OrderRequest;
import com.pro.orderservice.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final  OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest){

        return  ResponseEntity.ok(orderService.createOrder(orderRequest));
    }

    @GetMapping()
    public ResponseEntity<List<OrderItemResponse>> getOrderItemBySkuCode(@RequestParam("skucode") List<String> skuCodes){

        return  ResponseEntity.ok(orderService.getOrderItems(skuCodes));
    }

}
