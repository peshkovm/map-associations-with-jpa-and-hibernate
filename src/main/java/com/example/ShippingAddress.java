package com.example;

import javax.persistence.Entity;
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
@Table(name = "product_table")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class ShippingAddress {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
  @SequenceGenerator(name = "product_sequence")
  private Long id;

  @OneToOne
  @JoinColumn(name = "customer_id", unique = true)
  Customer customer;

  @EqualsAndHashCode.Include @ToString.Include private int value;

  public ShippingAddress(int value) {
    this.value = value;
  }
}
