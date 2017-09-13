package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Test suite for database manager;
 */
public class DbManagerTestSuite {
  private DbManager dbManager;
  private Statement statement;
  private String sqlQuery;
  private ResultSet rs;


  @Test
  public void testConnect() throws SQLException {
    //Given

    //When
    dbManager = DbManager.getInstance();

    //Then
    Assert.assertNotNull(dbManager.getConnection());
  }

  @Test
  public void testSelectUsers() throws SQLException {
    //Given
    dbManager = DbManager.getInstance();

    //When
    sqlQuery = "SELECT * FROM USERS";
    statement = dbManager.getConnection().createStatement();
    rs = statement.executeQuery(sqlQuery);

    //Then
    int counter = 0;
    while (rs.next()) {
      System.out.println(rs.getInt("ID") + ", " + rs.getString("FIRSTNAME") + ", " + rs.getString("LASTNAME"));
      counter++;
    }
    rs.close();
    statement.close();
    Assert.assertEquals(5, counter);
  }

  @Test
  public void testSelectUsersAndPosts() throws SQLException {
    //Given
    dbManager = DbManager.getInstance();

    //When
    sqlQuery = "SELECT FIRSTNAME, LASTNAME FROM POSTS P, USERS U WHERE P.USER_ID = U.ID GROUP BY P.USER_ID\n HAVING COUNT(*) > 1;";
    statement = dbManager.getConnection().createStatement();
    rs = statement.executeQuery(sqlQuery);

    //Then
    int counter = 0;
    while (rs.next()) {
      System.out.println(rs.getString("FIRSTNAME") + ", " + rs.getString("LASTNAME"));
      counter++;
    }
    rs.close();
    statement.close();
    Assert.assertEquals(1, counter);
  }
}