package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "order_item_table")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class OrderItem {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_sequence")
  @SequenceGenerator(name = "order_item_sequence")
  private Long id;

  @EqualsAndHashCode.Include @ToString.Include private int value;

  public OrderItem(int value) {
    this.value = value;
  }
}
