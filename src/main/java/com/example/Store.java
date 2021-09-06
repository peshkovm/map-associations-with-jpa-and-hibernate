package com.example;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "store_table")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Store {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_sequence")
  @SequenceGenerator(name = "store_sequence")
  private Long id;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "store_product_table",
      joinColumns = @JoinColumn(name = "store_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id"))
  Set<Product> products = new HashSet<>();

  @EqualsAndHashCode.Include @ToString.Include private int value;

  public Store(int value) {
    this.value = value;
  }
}
