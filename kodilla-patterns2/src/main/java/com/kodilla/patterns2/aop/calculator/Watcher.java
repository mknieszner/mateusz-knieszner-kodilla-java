package com.kodilla.patterns2.aop.calculator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 *
 */
@Aspect
@Component
public class Watcher {
  private static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

  @Before("execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))"
      + "&& args(theNumber) && target(obj)")
  public void logEvent(final BigDecimal theNumber, final Object obj) {
    LOGGER.info("Class: " + obj.getClass().getName() + ", Args: " + theNumber);
  }

  @Around("execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))")
  public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    final Object result;
    try {
      final long begin = System.currentTimeMillis();
      result = proceedingJoinPoint.proceed();
      final long end = System.currentTimeMillis();
      LOGGER.info("Time consumed: " + (end - begin) + "[ms]");
    } catch (Throwable throwable) {
      LOGGER.error(throwable.getMessage());
      throw throwable;
    }
    return result;
  }
}
