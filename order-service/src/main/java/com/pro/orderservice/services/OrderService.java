package com.pro.orderservice.services;

import com.pro.orderservice.dto.OrderItemReqeust;
import com.pro.orderservice.dto.OrderItemResponse;
import com.pro.orderservice.dto.OrderRequest;
import com.pro.orderservice.entities.Order;
import com.pro.orderservice.entities.OrderItem;
import com.pro.orderservice.repository.OrderItemRepository;
import com.pro.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
private  final OrderRepository repository;
private final OrderItemRepository itemRepository;

 public String  createOrder(OrderRequest orderRequest){

    Order o = Order.builder().orderNumber(UUID.randomUUID().toString())
            .orderItems(orderRequest.getOrderItemList()
                    .stream()
                    .map(x->mapOrderItem(x))
                    .collect(Collectors.toList()
                    )).build();

    repository.save(o);
    return  o.getOrderNumber();
 }

    private OrderItem mapOrderItem(OrderItemReqeust x) {
      return OrderItem.builder().price(x.getPrice()).skuCode(x.getSkuCode()).quantity(x.getQuantity()).build();

    }

    public List<OrderItemResponse> getOrderItems(List<String> skuCodes) {

      var result= itemRepository.getAllOrderItemInSkuCode(skuCodes);
    return   result.stream()
            .map(x->OrderItemResponse.builder()
                    .id(x.getId())
                    .price(x.getPrice())
                    .quantity(x.getQuantity())
                    .skuCode(x.getSkuCode())
                    .build())
            .collect(Collectors.toList());
    }
}
