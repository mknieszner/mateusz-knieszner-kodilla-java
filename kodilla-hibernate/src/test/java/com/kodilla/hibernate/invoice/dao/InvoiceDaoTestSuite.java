package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Test Suite for InvoiceDao class.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
  @Autowired
  InvoiceDao invoiceDao;

  @Test
  public void testInvoiceDaoSave() {
    //Given
    final Invoice invoice = getPreparedInvoice();

    //When
    invoiceDao.save(invoice);

    //Then
    Assert.assertEquals(invoice.getItems().size(), invoiceDao.findOne(invoice.getId()).getItems().size());

    //CleanUp
    invoiceDao.delete(invoice.getId());
  }

  private Invoice getPreparedInvoice() {
    final Invoice invoice = new Invoice("1/1/2017");
    final Item item1 = new Item(new Product("product1"), new BigDecimal(1), 2, new BigDecimal(1));
    final Item item2 = new Item(new Product("product2"), new BigDecimal(2), 1, new BigDecimal(1));
    final Item item3 = new Item(new Product("product3"), new BigDecimal(3), 5, new BigDecimal(1));
    final Item item4 = new Item(new Product("product4"), new BigDecimal(4), 2, new BigDecimal(1));
    final Item item5 = new Item(new Product("product4"), new BigDecimal(5), 1, new BigDecimal(1));
    invoice.addItem(item1);
    invoice.addItem(item2);
    invoice.addItem(item3);
    invoice.addItem(item4);
    invoice.addItem(item5);
    return invoice;
  }
}
