package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * Represents invoice.
 */
@Entity
@Table(name = "INVOICES")
public class Invoice {
  private int id;
  private String number;
  private Set<Item> items = new HashSet<>();

  public Invoice(final String number) {
    this.number = number;
  }

  public Invoice() {
  }

  public void addItem(final Item item) {
    item.setInvoice(this);
    items.add(item);
  }

  @Id
  @NotNull
  @GeneratedValue
  @Column(name = "ID", unique = true)
  public int getId() {
    return id;
  }

  @NotNull
  @OneToMany(
      cascade = CascadeType.ALL,
      fetch = FetchType.EAGER,
      mappedBy = "invoice"
  )
  public Set<Item> getItems() {
    return Collections.unmodifiableSet(items);
  }

  @NotNull
  @Column(name = "NUMBER")
  public String getNumber() {
    return number;
  }

  public void setNumber(final String number) {
    this.number = number;
  }

  public void setItems(final Set<Item> items) {
    this.items = items;
  }

  public void setId(final int id) {
    this.id = id;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final Invoice invoice = (Invoice) o;

    return number.equals(invoice.number);
  }

  @Override
  public int hashCode() {
    return number.hashCode();
  }
}
