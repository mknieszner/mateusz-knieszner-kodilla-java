package com.kodilla.patterns.singleton;

import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;

/**
 * Test suite for Logger class.
 */
public class LoggerTestSuite {

  @BeforeClass
  public static void beforeClass() {
    Logger.getInstance();
  }

  @Rule
  public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

  @Test
  public void testLog() {
    //Given

    //When
    Logger.getInstance().log("test log");

    //Then
    Assert.assertEquals("Log: [test log]\n", systemOutRule.getLogWithNormalizedLineSeparator());
  }

  @Test
  public void testGetLastLog() {
    //Given
    Logger.getInstance().log("test get log");

    //When
    final String result = Logger.getInstance().getLastLog();

    //Then
    Assert.assertEquals("test get log", result);
  }
}