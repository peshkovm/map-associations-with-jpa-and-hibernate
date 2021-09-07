package com.example;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
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
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @MapsId
  @JoinColumn(name = "id")
  Customer customer;

  @EqualsAndHashCode.Include @ToString.Include private int value;

  public ShippingAddress(int value) {
    this.value = value;
  }
}
