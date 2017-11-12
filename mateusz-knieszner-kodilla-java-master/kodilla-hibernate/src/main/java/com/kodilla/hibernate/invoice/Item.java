package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Represents invoice item.
 */
@Entity
@Table(name = "ITEMS")
public class Item {
  private int id;
  private Product product;
  private BigDecimal price;
  private int quantity;
  private BigDecimal value;
  private Invoice invoice;


  public Item(final Product product, final BigDecimal price, final int quantity, final BigDecimal value) {
    this.product = product;
    this.price = price;
    this.quantity = quantity;
    this.value = value;
  }

  public Item() {
  }

  @Id
  @NotNull
  @GeneratedValue
  @Column(name = "ID", unique = true)
  public int getId() {
    return id;
  }

  @NotNull
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "PRUDUCT_ID")
  public Product getProduct() {
    return product;
  }

  @NotNull
  @ManyToOne
  @JoinColumn(name = "INVOICE_ID")
  public Invoice getInvoice() {
    return invoice;
  }

  @NotNull
  @Column(name = "PRICE")
  public BigDecimal getPrice() {
    return price;
  }

  @NotNull
  @Column(name = "QUANTITY")
  public int getQuantity() {
    return quantity;
  }

  @NotNull
  @Column(name = "VALUE")
  public BigDecimal getValue() {
    return value;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public void setQuantity(final int quantity) {
    this.quantity = quantity;
  }

  public void setValue(final BigDecimal value) {
    this.value = value;
  }

  public void setPrice(final BigDecimal price) {
    this.price = price;
  }

  public void setInvoice(final Invoice invoice) {
    this.invoice = invoice;
  }

  public void setProduct(final Product product) {
    this.product = product;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final Item item = (Item) o;

    if (quantity != item.quantity) {
      return false;
    }
    if (!product.equals(item.product)) {
      return false;
    }
    if (price.compareTo(item.price) != 0) {
      return false;
    }
    if (value.compareTo(item.value) != 0) {
      return false;
    }
    return invoice.equals(item.invoice);
  }

  @Override
  public int hashCode() {
    int result = product.hashCode();
    result = 31 * result + price.stripTrailingZeros().hashCode();
    result = 31 * result + quantity;
    result = 31 * result + value.stripTrailingZeros().hashCode();
    result = 31 * result + invoice.hashCode();
    return result;
  }
}
