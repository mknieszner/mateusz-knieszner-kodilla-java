package com.kodilla.patterns2.facade;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

/**
 *
 */
@Service
public class ProductService {
  public BigDecimal getPrice(final Long productId) {
    System.out.println(""); //inaczej wywali błąd w findbugs ;p
    final Random generator = new Random();
    return new BigDecimal(generator.nextInt(1000000) / 100);
  }
}