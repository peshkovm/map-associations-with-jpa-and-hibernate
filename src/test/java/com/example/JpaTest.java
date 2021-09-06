package com.example;

import java.util.stream.StreamSupport;
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

    orderItem1.setOrder(order);
    orderItem2.setOrder(order);

    orderRepo.save(order);
    orderItemRepo.save(orderItem1);
    orderItemRepo.save(orderItem2);

    final var orderId = 1L;

    final var savedOrderItems1 =
        StreamSupport.stream(orderItemRepo.findAll().spliterator(), false)
            .filter(savedOrderItem -> savedOrderItem.getOrder().getId() == orderId)
            .toList();

    Assertions.assertEquals(savedOrderItems1.size(), 2);
    Assertions.assertEquals(savedOrderItems1.get(0), orderItem1);
    Assertions.assertEquals(savedOrderItems1.get(1), orderItem2);

    final var savedOrderItems2 = orderItemRepo.findOrderItemsByOrder(order);

    Assertions.assertEquals(savedOrderItems2.size(), 2);
    Assertions.assertEquals(savedOrderItems2.get(0), orderItem1);
    Assertions.assertEquals(savedOrderItems2.get(1), orderItem2);
  }
}
