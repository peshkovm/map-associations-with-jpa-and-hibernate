package com.example;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "shipping_address_table")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class ShippingAddress {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipping_address_sequence")
  @SequenceGenerator(name = "shipping_address_sequence")
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "customer_id", unique = true)
  Customer customer;

  @EqualsAndHashCode.Include @ToString.Include private int value;

  public ShippingAddress(int value) {
    this.value = value;
  }
}
