package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Represents product.
 */
@Entity
@Table(name = "PRODUCTS")
public class Product {
  private int id;
  private String name;

  public Product(final String name) {
    this.name = name;
  }

  public Product() {
  }

  @Id
  @GeneratedValue
  @NotNull
  @Column(name = "ID", unique = true)
  public int getId() {
    return id;
  }

  @NotNull
  @Column(name = "NAME")
  public String getName() {
    return name;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public void setName(final String name) {
    this.name = name;
  }
}
