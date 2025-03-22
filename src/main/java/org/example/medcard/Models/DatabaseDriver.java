package org.example.medcard.Models;

import org.example.medcard.Utils.SQLStatements;

import java.sql.*;
import java.time.LocalDate;
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
            System.out.println(prepStatement + "\n");

            resultSet = statement.executeQuery(prepStatement.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /*
     * Doctor Section
     */
    public void createPerson(int personID, String surname, String name, String fathername) {
        Statement statement;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.CREATE_PERSON.getStatement());
            prepStatement.setInt(1, personID);
            prepStatement.setString(2, surname);
            prepStatement.setString(3, name);
            prepStatement.setString(4, fathername);
            System.out.println(prepStatement);

            statement.executeUpdate(prepStatement.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPatient(int patientID, int personID, LocalDate date_of_birth) {
        Statement statement;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.CREATE_PATIENT.getStatement());
            prepStatement.setInt(1, patientID);
            prepStatement.setInt(2, personID);

            prepStatement.setDate(3, Date.valueOf(date_of_birth));

            prepStatement.setString(4, "");
            prepStatement.setString(5, "");
            prepStatement.setString(6, "");
            prepStatement.setString(7, "");
            prepStatement.setString(8, "");
            prepStatement.setBoolean(9, true);

            System.out.println(prepStatement);

            statement.executeUpdate(prepStatement.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePatient(int patientID) {
        Statement statement;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.DELETE_PATIENT.getStatement());
            prepStatement.setInt(1, patientID);

            System.out.println(prepStatement);

            statement.executeUpdate(prepStatement.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * Utility Methods
     * */
    public int getLastPersonId() {
        Statement statement;
        ResultSet resultSet = null;
        int id = 0;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.GET_LAST_ID.getStatement());
            prepStatement.setString(1, "persons");
            System.out.println(prepStatement + "\n");

            resultSet = statement.executeQuery(prepStatement.toString());
            resultSet.next();
            id = resultSet.getInt("last_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public int getLastPatientId() {
        Statement statement;
        ResultSet resultSet = null;
        int id = 0;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.GET_LAST_ID.getStatement());
            prepStatement.setString(1, "patients");
            System.out.println(prepStatement + "\n");

            resultSet = statement.executeQuery(prepStatement.toString());
            resultSet.next();
            id = resultSet.getInt("last_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public ResultSet getAllPatientsData() {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.GET_PATIENTS.getStatement());
            System.out.println(prepStatement);

            resultSet = statement.executeQuery(prepStatement.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getTreatmentRecords(int patientID) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.GET_TREATMENT_RECORDS.getStatement());
            prepStatement.setInt(1, patientID);
            System.out.println(prepStatement);

            resultSet = statement.executeQuery(prepStatement.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getDiagnosisRecords(int patientID) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.GET_DIAGNOSIS_RECORDS.getStatement());
            prepStatement.setInt(1, patientID);
            System.out.println(prepStatement);

            resultSet = statement.executeQuery(prepStatement.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getTemperatureSheerRecords(int patientID) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.GET_TEMPERATURE_SHEET_RECORDS.getStatement());
            prepStatement.setInt(1, patientID);
            System.out.println(prepStatement + "\n");

            resultSet = statement.executeQuery(prepStatement.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

}
