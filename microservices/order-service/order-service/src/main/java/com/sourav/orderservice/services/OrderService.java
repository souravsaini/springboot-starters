package com.sourav.orderservice.services;

import com.sourav.orderservice.dto.OrderItemsDTO;
import com.sourav.orderservice.dto.OrderRequest;
import com.sourav.orderservice.models.Order;
import com.sourav.orderservice.models.OrderItems;
import com.sourav.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest) {
        List<OrderItems> orderItems = orderRequest.getOrderItemsDTO()
                .stream()
                .map(orderItemsDTO -> mapToDTO(orderItemsDTO))
                .toList();

        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderItems(orderItems)
                .build();

        orderRepository.save(order);
    }

    private OrderItems mapToDTO(OrderItemsDTO orderItemsDTO) {
        OrderItems orderItems = OrderItems.builder()
                .price(orderItemsDTO.getPrice())
                .quantity(orderItemsDTO.getQuantity())
                .skuCode(orderItemsDTO.getSkuCode())
                .build();

        return orderItems;
    }
}
