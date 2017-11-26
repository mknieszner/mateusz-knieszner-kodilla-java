package com.kodilla.jdbc;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class StoredPostTestSuite {

  @Test
  public void testUpdateVipLevels() throws SQLException {
    //Given
    DbManager dbManager = DbManager.INSTANCE;
    String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
    Statement statement = dbManager.getConnection().createStatement();
    statement.executeUpdate(sqlUpdate);

    //When
    String sqlProcedureCall = "CALL UpdateVipLevels()";
    statement.execute(sqlProcedureCall);

    //Then
    String sqlCheckTasble = "SELECT COUNT(*) AS HOW_MANY  FROM READERS WHERE VIP_LEVEL=\"Not set\"";
    ResultSet rs = statement.executeQuery(sqlCheckTasble);
    int howMany = -1;
    if (rs.next()) {
      howMany = rs.getInt("HOW_MANY");
      assertEquals(0, howMany);
    }
  }

  @Test
  public void testUpdateBestsellers() throws SQLException {
    //Given
    DbManager dbManager = DbManager.INSTANCE;
    String sqlUpdate = "UPDATE books SET BESTSELLER=2";
    Statement statement = dbManager.getConnection().createStatement();
    statement.executeUpdate(sqlUpdate);

    //When
    String sqlProcedureCall = "CALL UpdateBestsellers()";
    statement.execute(sqlProcedureCall);

    //Then
    String sqlCheckTasble = "SELECT COUNT(*) AS HOW_MANY  FROM books WHERE BESTSELLER=2";
    ResultSet rs = statement.executeQuery(sqlCheckTasble);
    int howMany = -1;
    if (rs.next()) {
      howMany = rs.getInt("HOW_MANY");
      assertEquals(0, howMany);
    }
  }

}
