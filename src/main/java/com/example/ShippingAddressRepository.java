package com.example;

import org.springframework.data.repository.CrudRepository;

public interface ShippingAddressRepository extends CrudRepository<ShippingAddress, Long> {

  ShippingAddress findShippingAddressByCustomer(Customer customer);
}
