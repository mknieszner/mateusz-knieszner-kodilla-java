package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

/**
 *
 */
public class ChildSeatDecorator extends AbstractTaxiOrderDecorator {

  protected ChildSeatDecorator(final TaxiOrder taxiOrder) {
    super(taxiOrder);
  }

  @Override
  public BigDecimal getCost() {
    //hardcoded stub cost = 35
    return super.getCost().add(new BigDecimal(2));
  }

  @Override
  public String getDescription() {
    return super.getDescription() + " + child seat";
  }
}
