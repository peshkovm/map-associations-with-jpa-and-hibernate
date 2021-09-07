package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaTest {

  @Autowired private CustomerRepository customerRepo;
  @Autowired private ShippingAddressRepository shippingAddressRepo;

  @Test
  @DisplayName("Select all order_items from item")
  void selectAllOrderItemsFromItem() {
    final var customer = new Customer(1);
    final var shippingAddress = new ShippingAddress(1);

    shippingAddress.setCustomer(customer);

    shippingAddressRepo.save(shippingAddress);

    final var customerId = 1L;

    final var savedShippingAddress =
        customerRepo.findById(customerId).orElseThrow().getShippingAddress();

    Assertions.assertEquals(savedShippingAddress, shippingAddress);
  }
}
