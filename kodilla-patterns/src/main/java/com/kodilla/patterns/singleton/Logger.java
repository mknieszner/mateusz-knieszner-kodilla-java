package com.kodilla.patterns.singleton;

/**
 * Holds last log.
 * Singleton Class.
 */
public enum Logger {
  INSTANCE;
  private String lastLog = "";

  void log(final String log) {
    lastLog = log;
    System.out.println("Log: [" + lastLog + "]");
  }

  public String getLastLog() {
    return lastLog;
  }
}