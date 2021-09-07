package com.example;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer_table")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
  @SequenceGenerator(name = "customer_sequence")
  private Long id;

  @EqualsAndHashCode.Include @ToString.Include private int value;

  public Customer(int value) {
    this.value = value;
  }
}
