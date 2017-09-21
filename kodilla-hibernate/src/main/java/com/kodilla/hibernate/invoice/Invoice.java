package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents invoice.
 */
@Entity
@Table(name = "INVOICES")
public class Invoice {
  private int id;
  private String number;
  private List<Item> items = new ArrayList<>();

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
      targetEntity = Item.class,
      cascade = CascadeType.ALL,
      fetch = FetchType.EAGER,
      mappedBy = "invoice"
  )
  public List<Item> getItems() {
    return Collections.unmodifiableList(items);
  }

  @NotNull
  @Column(name = "NUMBER")
  public String getNumber() {
    return number;
  }

  public void setNumber(final String number) {
    this.number = number;
  }

  public void setItems(final List<Item> items) {
    this.items = items;
  }

  public void setId(final int id) {
    this.id = id;
  }
}
