package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaTest {

  @Autowired private StoreRepository storeRepo;
  @Autowired private ProductRepository productRepo;

  @Test
  @DisplayName("Select all order_items from item")
  void selectAllOrderItemsFromItem() {
    final var store = new Store(1);
    final var product1 = new Product(1);
    final var product2 = new Product(2);

    store.getProducts().add(product1);
    store.getProducts().add(product2);
    product1.getStores().add(store);
    product2.getStores().add(store);

    productRepo.save(product1);
    productRepo.save(product2);
    storeRepo.save(store);

    final var storeId = 1L;

    final var savedProducts = storeRepo.findById(storeId).orElseThrow().getProducts();

    Assertions.assertEquals(savedProducts.size(), 2);
    Assertions.assertEquals(savedProducts.stream().toList().get(0), product1);
    Assertions.assertEquals(savedProducts.stream().toList().get(1), product2);
  }
}
