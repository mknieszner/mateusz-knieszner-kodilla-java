package com.kodilla.patterns2.facade;

import org.springframework.stereotype.Service;

import java.util.Random;


/**
 *
 */
@Service
public class Authenticator {
  public boolean isAuthenticated(final Long userId) {
    final Random ramdom = new Random();
    return ramdom.nextBoolean();
  }
}
