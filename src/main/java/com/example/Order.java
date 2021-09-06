package com.example;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "order_table")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
  @SequenceGenerator(name = "order_sequence")
  private Long id;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
  List<OrderItem> items = new ArrayList<>();

  @EqualsAndHashCode.Include
  @ToString.Include
  private int value;

  public Order(int value) {
    this.value = value;
  }
}
