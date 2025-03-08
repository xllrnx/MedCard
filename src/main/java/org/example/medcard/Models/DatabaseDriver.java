package org.example.medcard.Models;

import org.example.medcard.Controllers.Utils.SQLStatements;

import java.sql.*;
import java.util.Properties;

public class DatabaseDriver {
    private Connection connection;

    public DatabaseDriver() {
        try {
            String url = System.getenv("DB_URL");
            Properties properties = new Properties();
            properties.put("user", System.getenv("DB_USERNAME"));
            properties.put("password", System.getenv("DB_PASSWORD"));
            properties.put("ssl", "false");
            connection = DriverManager.getConnection(url, properties);

            System.out.println(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /*
    * User Section
    * */
    public ResultSet getUserData(String login, String password) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.SEARCH_USER.getStatement());
            prepStatement.setString(1, login);
            prepStatement.setString(2, password);
            System.out.println(prepStatement);

            resultSet = statement.executeQuery(prepStatement.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /*
     * Nurse Section
     * */


    /*
     * Utility Methods
     * */

}
