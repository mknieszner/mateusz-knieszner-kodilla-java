package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Data base Manager.
 */
public enum DbManager {
  INSTANCE;
  private Connection conn;

  DbManager() {
    final Properties connectionProps = new Properties();
    connectionProps.put("user", "kodilla_user");
    connectionProps.put("password", "kodilla_password");
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kodilla_course?serverTimezone=Europe/Warsaw"
          + "&useSSL=False", connectionProps);
    } catch (SQLException e) {
      throw new RuntimeException("SQLException" + e.toString());
    }
  }

  public Connection getConnection() {
    return conn;
  }
}