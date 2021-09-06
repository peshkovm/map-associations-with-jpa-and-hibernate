package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaTest {

  @Autowired private OrderRepository orderRepo;
  @Autowired private OrderItemRepository orderItemRepo;

  @Test
  @DisplayName("Select all order_items from item")
  void selectAllOrderItemsFromItem() {
    final var order = new Order(1);
    final var orderItem1 = new OrderItem(1);
    final var orderItem2 = new OrderItem(2);

    order.getItems().add(orderItem1);
    order.getItems().add(orderItem2);

    orderItemRepo.save(orderItem1);
    orderItemRepo.save(orderItem2);
    orderRepo.save(order);

    final var orderId = 1L;

    final var savedOrderItems1 = orderRepo.findById(orderId).orElseThrow().getItems();

    Assertions.assertEquals(savedOrderItems1.size(), 2);
    Assertions.assertEquals(savedOrderItems1.get(0), orderItem1);
    Assertions.assertEquals(savedOrderItems1.get(1), orderItem2);
  }
}
