package pl.sda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountJdbcDaoImpl {

    void insert(int balance, String number) {
        try (Connection connection = getConnection()) {
            insertAccount(connection, balance, number);
        } catch (SQLException ex) {
            System.out.println("Błąd połączenia z bazą " + ex.getMessage());
        }
    }

    private void insertAccount(Connection connection, int balance, String number) throws SQLException {
        String query = "insert into account(balance, number) " + "values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, balance);
        preparedStatement.setString(2, number);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private Connection getConnection() throws SQLException {
        String jdbcUrl = "jdbc:h2:tcp://localhost/~/test";
        return DriverManager.getConnection(jdbcUrl, "sa", "");
    }
}
