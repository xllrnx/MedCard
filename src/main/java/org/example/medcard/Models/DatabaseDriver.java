package org.example.medcard.Models;

import org.example.medcard.LoggerService;
import org.example.medcard.Utils.SQLStatements;
import org.slf4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;
import java.util.UUID;

public class DatabaseDriver {
    private Connection connection;
    private static final Logger logger = LoggerService.getLogger(DatabaseDriver.class);

    public DatabaseDriver() {
        try {
            logger.info("Спроба підключення до БД. url = {}, user = {}", System.getenv("DB_URL"), System.getenv("DB_URL"));
            String url = System.getenv("DB_URL");
            Properties properties = new Properties();
            properties.put("user", System.getenv("DB_URL"));
            properties.put("password", System.getenv("DB_PASSWORD"));
            properties.put("ssl", "false");
            connection = DriverManager.getConnection(url, properties);

            logger.info("Підключення до БД успішне.");
            logger.info("Підключення: " + connection);

        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка підключення до БД [ErrorID={}]", errorId);
        }
    }

    // User Section
    public ResultSet getUserData(String login, String password) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.SEARCH_USER.getStatement());
            prepStatement.setString(1, login);
            prepStatement.setString(2, password);

            logger.info("Спроба виконання запиту getUserData({}).", prepStatement);

            resultSet = statement.executeQuery(prepStatement.toString());
            logger.info("Виконання запиту getUserData({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту getUserData, [ErrorID={}]", errorId);
        }
        return resultSet;
    }

    // Doctor Section
    public void createPerson(int personID, String surname, String name, String fathername) {
        Statement statement;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.CREATE_PERSON.getStatement());
            prepStatement.setInt(1, personID);
            prepStatement.setString(2, surname);
            prepStatement.setString(3, name);
            prepStatement.setString(4, fathername);

            logger.info("Спроба виконання запиту createPerson({}).", prepStatement);

            statement.executeUpdate(prepStatement.toString());
            logger.info("Виконання запиту createPerson({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту createPerson, [ErrorID={}]", errorId);
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

            logger.info("Спроба виконання запиту createPatient({}).", prepStatement);

            statement.executeUpdate(prepStatement.toString());
            logger.info("Виконання запиту createPatient({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту createPatient, [ErrorID={}]", errorId);
        }
    }

    public void deletePatient(int patientID) {
        Statement statement;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.DELETE_PATIENT.getStatement());
            prepStatement.setInt(1, patientID);

            logger.info("Спроба виконання запиту deletePatient({}).", prepStatement);

            statement.executeQuery(prepStatement.toString());
            logger.info("Виконання запиту deletePatient({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту deletePatient, [ErrorID={}]", errorId);
        }
    }

    public void editPatient(int patientID) {
        Statement statement;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.EDIT_PATIENT.getStatement());
            prepStatement.setInt(1, patientID);

            logger.info("Спроба виконання запиту editPatient({}).", prepStatement);

            statement.executeUpdate(prepStatement.toString());
            logger.info("Виконання запиту editPatient({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту editPatient, [ErrorID={}]", errorId);
        }
    }

    // Patient Methods
    public ResultSet getAllPatientsData() {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.GET_PATIENTS.getStatement());

            logger.info("Спроба виконання запиту getAllPatientsData({}).", prepStatement);

            resultSet = statement.executeQuery(prepStatement.toString());
            logger.info("Виконання запиту getAllPatientsData({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту getAllPatientsData, [ErrorID={}]", errorId);
        }
        return resultSet;
    }

    // Utility Methods
    public int getLastPersonId() {
        Statement statement;
        ResultSet resultSet = null;
        int id = 0;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.GET_LAST_ID.getStatement());
            prepStatement.setString(1, "persons");
            logger.info("Спроба виконання запиту getLastPersonId({}).", prepStatement);

            resultSet = statement.executeQuery(prepStatement.toString());
            resultSet.next();
            id = resultSet.getInt("lastID");
            logger.info("Виконання запиту getLastPersonId({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту getLastPersonId, [ErrorID={}]", errorId);
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

            logger.info("Спроба виконання запиту getLastPatientId({}).", prepStatement);

            resultSet = statement.executeQuery(prepStatement.toString());
            resultSet.next();
            id = resultSet.getInt("lastID");
            logger.info("Виконання запиту getLastPatientId({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту getLastPatientId, [ErrorID={}]", errorId);
        }
        return id;
    }

    public ResultSet getTreatmentRecords(int patientID) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();

            PreparedStatement prepStatement = connection.prepareStatement(SQLStatements.GET_TREATMENT_RECORDS.getStatement());
            prepStatement.setInt(1, patientID);
            logger.info("Спроба виконання запиту getTreatmentRecords({}).", prepStatement);

            resultSet = statement.executeQuery(prepStatement.toString());
            logger.info("Виконання запиту getTreatmentRecords({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту getTreatmentRecords, [ErrorID={}]", errorId);
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
            logger.info("Спроба виконання запиту getDiagnosisRecords({}).", prepStatement);

            resultSet = statement.executeQuery(prepStatement.toString());
            logger.info("Виконання запиту getDiagnosisRecords({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту getDiagnosisRecords, [ErrorID={}]", errorId);
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
            logger.info("Спроба виконання запиту getTemperatureSheerRecords({}).", prepStatement);

            resultSet = statement.executeQuery(prepStatement.toString());
            logger.info("Виконання запиту getTemperatureSheerRecords({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту getTemperatureSheerRecords, [ErrorID={}]", errorId);
        }
        return resultSet;
    }
}
