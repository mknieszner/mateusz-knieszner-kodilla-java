package com.kodilla.patterns2.facade;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Aspect Facade Watcher.
 */
@Aspect
@Component
public class FacadeWatcher {
  private static final Logger LOGGER = LoggerFactory.getLogger(com.kodilla.patterns2.facade.FacadeWatcher.class);

  @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))"
      + "&& args(order, userId) && target(obj)")
  public void logEvent(final OrderDto order, final Long userId, final Object obj) {
    LOGGER.info(String.format("Class: %s, Args: (Order: %s, UserId: %d)", obj.getClass().getName(), order, userId));
  }

  @Around("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
  public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint)throws Throwable {
    final Object result;
    try {
      final long begin = System.currentTimeMillis();
      result = proceedingJoinPoint.proceed();
      final long end = System.currentTimeMillis();
      LOGGER.info("Time consumed : " + (end - begin) + "[ms]");
    } catch (Throwable throwable) {
      LOGGER.error(throwable.getMessage());
      throw throwable;
    }
    return result;
  }
}