package com.github.marschall.transactionquerytimeouttest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import javax.sql.DataSource;

final class QueryTimeoutUtil {

  private final DataSource dataSource;

  QueryTimeoutUtil(DataSource dataSource) {
    Objects.requireNonNull(dataSource, "dataSource");
    this.dataSource = dataSource;
  }

  int getQueryTimeout() {
    try (Connection connection = this.dataSource.getConnection();
         PreparedStatement statement = connection.prepareStatement("SELECT 1 FROM dual")) {
      try (ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()) {
          resultSet.getInt(1);
        }
      }
      return statement.getQueryTimeout();
    } catch (SQLException e) {
      throw new RuntimeException("could not get query timeout", e);
    }
  }

}
