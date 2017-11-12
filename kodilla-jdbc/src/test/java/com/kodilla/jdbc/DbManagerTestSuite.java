package com.kodilla.jdbc;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

/**
 * Test suite for database manager.
 */
public class DbManagerTestSuite {
  @Test
  public void testConnect() throws SQLException {
    //Given
    final Connection connection;

    //When
    connection = DbManager.INSTANCE.getConnection();

    // Then
    Assert.assertNotNull(connection);
  }

  @Test
  public void testSelectUsers() throws SQLException {
    //Given
    int counter = 0;
    final String sqlQuery = "SELECT * FROM USERS";

    //When
    try (final Statement statement = DbManager.INSTANCE.getConnection().createStatement();
         final ResultSet rs = statement.executeQuery(sqlQuery)) {
      while (rs.next()) {
        System.out.println(rs.getInt("ID") + ", "
            + rs.getString("FIRSTNAME") + ", "
            + rs.getString("LASTNAME"));
        counter++;
      }
    }

    //Then
    Assert.assertEquals(5, counter);
  }

//  @Test
//  public void testSelectUsersAndPosts() throws SQLException {
//    //Given
//    int counter = 0;
//    final String sqlQuery =
//        "SELECT\n" + "  FIRSTNAME,\n" + "  LASTNAME\n"
//            + "FROM POSTS P INNER JOIN USERS U\n"
//            + "   ON P.USER_ID = U.ID\n"
//            + "GROUP BY P.USER_ID\n"
//            + "HAVING COUNT(*) > 1;";
//
//    //When
//    try (final Statement statement = DbManager.INSTANCE.getConnection().createStatement();
//         final ResultSet rs = statement.executeQuery(sqlQuery)) {
//      while (rs.next()) {
//        System.out.println(rs.getString("FIRSTNAME") + ", " + rs.getString("LASTNAME"));
//        counter++;
//      }
//    }
//
//    //Then
//    Assert.assertEquals(1, counter);
//  }

  @Test
  public void testPreparedStatement() throws SQLException {
    //Given
    int counter = 0;
    final String sqlQuery = "SELECT * FROM USERS WHERE FIRSTNAME=?";

    //When
    try (final PreparedStatement preparedStatement = DbManager.INSTANCE.getConnection().prepareStatement(sqlQuery)) {
      preparedStatement.setString(1, "John");
      final ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        System.out.println(rs.getString("FIRSTNAME") + ", " + rs.getString("LASTNAME"));
        counter++;
      }
      rs.close();
    }

    //Then
    Assert.assertEquals(2, counter);
  }
}