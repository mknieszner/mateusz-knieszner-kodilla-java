package com.kodilla.patterns.singleton;

import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.time.LocalDate;

/**
 * Test suite for Logger class.
 */
public class LoggerTestSuite {
  @Rule
  public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

  @Test
  public void testLog() {
    //Given
    final String testLog = "test log";
    //When
    Logger.INSTANCE.log(testLog);

    //Then
    Assert.assertEquals("Log: [" + testLog + "]\n", systemOutRule.getLogWithNormalizedLineSeparator());
  }

  @Test
  public void testGetLastLog() {
    //Given
    final String testLog = "test get log";
    Logger.INSTANCE.log(testLog);

    //When
    final String result = Logger.INSTANCE.getLastLog();

    //Then
    Assert.assertEquals(testLog, result);
  }
}