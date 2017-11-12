package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * TaxiOrderTestSuite.
 */
public class TaxiOrderTestSuite {
  @Test
  public void testBasicTaxiOrderGetCost() {
    //Given
    final TaxiOrder theOrder = new BasicTaxiOrder();

    //When
    final BigDecimal calculatedCost = theOrder.getCost();

    //Then
    assertEquals(new BigDecimal(5.00), calculatedCost);
  }

  @Test
  public void testBasicTaxiOrderGetDescription() {
    //Given
    final TaxiOrder theOrder = new BasicTaxiOrder();

    //When
    final String description = theOrder.getDescription();

    //Then
    assertEquals("Drive a course", description);
  }

  @Test
  public void testNetworkTaxiGetDescription() {
    //Given
    TaxiOrder theOrder = new BasicTaxiOrder();
    theOrder = new TaxiNetworkOrderDecorator(theOrder);

    //When
    final String description = theOrder.getDescription();

    //Then
    assertEquals("Drive a course by Network Taxi", description);
  }

  @Test
  public void testNetworkTaxiGetCost() {
    //Given
    TaxiOrder theOrder = new BasicTaxiOrder();
    theOrder = new TaxiNetworkOrderDecorator(theOrder);

    //When
    final BigDecimal calculatedCost = theOrder.getCost();

    //Then
    assertEquals(new BigDecimal(40.00), calculatedCost);
  }

  @Test
  public void testMyTaxiWithChildSeatGetCost() {
    //Given
    TaxiOrder theOrder = new BasicTaxiOrder();
    theOrder = new UberNetworkOrderDecorator(theOrder);
    theOrder = new ChildSeatDecorator(theOrder);

    //When
    final String description = theOrder.getDescription();

    //Then
    assertEquals("Drive a course by Uber Taxi + child seat", description);
  }

  @Test
  public void testMyTaxiWithChildSeatGetDescription() {
    TaxiOrder theOrder = new BasicTaxiOrder();
    theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
    theOrder = new ChildSeatDecorator(theOrder);

    //When
    final BigDecimal calculatedCost = theOrder.getCost();

    //Then
    assertEquals(new BigDecimal(37), calculatedCost);
  }

  @Test
  public void testVipTaxiWithChildSeatExpressGetCost() {
    TaxiOrder theOrder = new BasicTaxiOrder();
    theOrder = new TaxiNetworkOrderDecorator(theOrder);
    theOrder = new ChildSeatDecorator(theOrder);
    theOrder = new ExpressDecorator(theOrder);
    theOrder = new VipDecorator(theOrder);

    //When
    final BigDecimal calculatedCost = theOrder.getCost();

    //Then
    assertEquals(new BigDecimal(57), calculatedCost);
  }

  @Test
  public void testVipTaxiWithChildSeatExpressGetDescription() {
    TaxiOrder theOrder = new BasicTaxiOrder();
    theOrder = new TaxiNetworkOrderDecorator(theOrder);
    theOrder = new ChildSeatDecorator(theOrder);
    theOrder = new ExpressDecorator(theOrder);
    theOrder = new VipDecorator(theOrder);

    //When
    final String description = theOrder.getDescription();

    //Then
    assertEquals("Drive a course by Network Taxi + child seat + express service + variant VIP", description);
  }
}
