package org.example.medcard.Models;

import org.example.medcard.Utils.SQLStatements;

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
            System.out.println(prepStatement + "\n");

            resultSet = statement.executeQuery(prepStatement.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
/*
    /*
     * Doctor Section
     *
    public void createPerson(int person_id, String name, String surname, String fathername) {
        Statement statement;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.CREATE_PATIENT.getStatement());
            prepStatement.setInt(1, person_id);
            prepStatement.setString(2, name);
            prepStatement.setString(3, surname);
            prepStatement.setString(4, fathername);
            System.out.println(prepStatement);

            statement.executeUpdate(prepStatement.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPatient(int patient_id, int person_id, date date_of_birth, String address, String phone, String sex, String complaints, String medical_history, boolean status) {
        Statement statement;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.CREATE_PATIENT.getStatement());
            System.out.println(prepStatement);

            statement.executeUpdate(prepStatement.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/

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
