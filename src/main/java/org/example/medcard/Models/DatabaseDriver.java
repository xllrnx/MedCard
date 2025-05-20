package org.example.medcard.Models;

import org.example.medcard.Utils.Logger.LoggerService;
import org.example.medcard.Utils.Enums.SQLStatements;
import org.slf4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;
import java.util.UUID;

public class DatabaseDriver {
    private Connection connection;
    private PreparedStatement prepStatement;
    private static final Logger logger = LoggerService.getLogger(DatabaseDriver.class);

    public DatabaseDriver() {
        try {
            logger.info("Спроба підключення до БД. url = {}, user = {}", System.getenv("DB_URL"), System.getenv("DB_USERNAME"));
            String url = System.getenv("DB_URL");
            Properties properties = new Properties();
            properties.put("user", System.getenv("DB_USERNAME"));
            properties.put("password", System.getenv("DB_PASSWORD"));
            properties.put("ssl", "false");
            connection = DriverManager.getConnection(url, properties);

            logger.info("Підключення до БД успішне.");
            logger.info("Підключення: {}", connection);

        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка підключення до БД [ErrorID={}]", errorId, e);
        }
    }

    // User Section
    public ResultSet getUserPassword(String login) {
        ResultSet resultSet = null;
        try {
            prepStatement = connection.prepareStatement(SQLStatements.GET_USER_PASSWORD.getStatement());
            prepStatement.setString(1, login);

            logger.info("Спроба виконання запиту getUserPassword({}).", prepStatement);

            resultSet = prepStatement.executeQuery();
            logger.info("Виконання запиту getUserPassword({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту getUserPassword, [ErrorID={}]", errorId, e);
        }
        return resultSet;
    }
    public ResultSet getUserData(String login) {
        ResultSet resultSet = null;
        try {
            prepStatement = connection.prepareStatement(SQLStatements.GET_USER_DATA.getStatement());
            prepStatement.setString(1, login);

            logger.info("Спроба виконання запиту getUserData({}).", prepStatement);

            resultSet = prepStatement.executeQuery();
            logger.info("Виконання запиту getUserData({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту getUserData, [ErrorID={}]", errorId, e);
        }
        return resultSet;
    }

    // Doctor Section
    public void createPerson(String surname, String name, String fathername) {
        try {
            prepStatement = connection.prepareStatement(SQLStatements.CREATE_PERSON.getStatement());
            prepStatement.setString(1, surname);
            prepStatement.setString(2, name);
            prepStatement.setString(3, fathername);

            logger.info("Спроба виконання запиту createPerson({}).", prepStatement);

            prepStatement.executeUpdate();
            logger.info("Виконання запиту createPerson({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту createPerson, [ErrorID={}]", errorId, e);
        }
    }

    public void createPatient(int personID, LocalDate date_of_birth) {
        try {
            prepStatement = connection.prepareStatement(SQLStatements.CREATE_PATIENT.getStatement());
            prepStatement.setInt(1, personID);
            prepStatement.setDate(2, Date.valueOf(date_of_birth));
            prepStatement.setBoolean(8, true);

            logger.info("Спроба виконання запиту createPatient({}).", prepStatement);

            prepStatement.executeUpdate();
            logger.info("Виконання запиту createPatient({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту createPatient, [ErrorID={}]", errorId, e);
        }
    }

    public void deletePatient(int patientID) {
        try {
            prepStatement = connection.prepareStatement(SQLStatements.DELETE_PATIENT.getStatement());
            prepStatement.setInt(1, patientID);

            logger.info("Спроба виконання запиту deletePatient({}).", prepStatement);

            prepStatement.executeUpdate();
            logger.info("Виконання запиту deletePatient({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту deletePatient, [ErrorID={}]", errorId, e);
        }
    }

    public void editPatient(int patientID) {
        try {
            prepStatement = connection.prepareStatement(SQLStatements.EDIT_PATIENT.getStatement());
            prepStatement.setInt(1, patientID);

            logger.info("Спроба виконання запиту editPatient({}).", prepStatement);

            prepStatement.executeUpdate();
            logger.info("Виконання запиту editPatient({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту editPatient, [ErrorID={}]", errorId, e);
        }
    }

    // Patient Methods
    public ResultSet getAllPatientsData() {
        ResultSet resultSet = null;
        try {
            prepStatement = connection.prepareStatement(SQLStatements.GET_PATIENTS.getStatement());

            logger.info("Спроба виконання запиту getAllPatientsData({}).", prepStatement);

            resultSet = prepStatement.executeQuery();
            logger.info("Виконання запиту getAllPatientsData({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту getAllPatientsData, [ErrorID={}]", errorId, e);
        }
        return resultSet;
    }

    // Utility Methods
    public int getLastPersonId() {
        ResultSet resultSet;
        int id = 0;
        try {
            String column = "personID";
            String table = "persons";

            String query = String.format(SQLStatements.GET_PATIENTS.getStatement(), column, table, column);
            Statement statement = connection.createStatement();

            logger.info("Спроба виконання запиту getLastPersonId({}).", query);

            resultSet = statement.executeQuery(query);
            resultSet.next();
            id = resultSet.getInt("personID");
            logger.info("Виконання запиту getLastPersonId({}) успішне.", query);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту getLastPersonId, [ErrorID={}]", errorId, e);
        }
        return id;
    }

    public int getLastPatientId() {
        ResultSet resultSet;
        int id = 0;
        try {
            String column = "patientID";
            String table = "patients";

            String query = String.format(SQLStatements.GET_PATIENTS.getStatement(), column, table, column);
            Statement statement = connection.createStatement();

            logger.info("Спроба виконання запиту getLastPatientId({}).", prepStatement);

            resultSet = statement.executeQuery(query);
            resultSet.next();
            id = resultSet.getInt("patientID");
            logger.info("Виконання запиту getLastPatientId({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту getLastPatientId, [ErrorID={}]", errorId, e);
        }
        return id;
    }

    public ResultSet getTreatmentRecords(int patientID) {
        ResultSet resultSet = null;
        try {
            prepStatement = connection.prepareStatement(SQLStatements.GET_TREATMENT_RECORDS.getStatement());
            prepStatement.setInt(1, patientID);
            logger.info("Спроба виконання запиту getTreatmentRecords({}).", prepStatement);

            resultSet = prepStatement.executeQuery();
            logger.info("Виконання запиту getTreatmentRecords({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту getTreatmentRecords, [ErrorID={}]", errorId);
        }
        return resultSet;
    }

    public ResultSet getDiagnosisRecords(int patientID) {
        ResultSet resultSet = null;
        try {
            prepStatement = connection.prepareStatement(SQLStatements.GET_DIAGNOSIS_RECORDS.getStatement());
            prepStatement.setInt(1, patientID);
            logger.info("Спроба виконання запиту getDiagnosisRecords({}).", prepStatement);

            resultSet = prepStatement.executeQuery();
            logger.info("Виконання запиту getDiagnosisRecords({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту getDiagnosisRecords, [ErrorID={}]", errorId);
        }
        return resultSet;
    }

    public ResultSet getTemperatureSheerRecords(int patientID) {
        ResultSet resultSet = null;
        try {
            prepStatement = connection.prepareStatement(SQLStatements.GET_TEMPERATURE_SHEET_RECORDS.getStatement());
            prepStatement.setInt(1, patientID);
            logger.info("Спроба виконання запиту getTemperatureSheerRecords({}).", prepStatement);

            resultSet = prepStatement.executeQuery();
            logger.info("Виконання запиту getTemperatureSheerRecords({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту getTemperatureSheerRecords, [ErrorID={}]", errorId);
        }
        return resultSet;
    }

    public void addTemperatureSheetRecord(int patientID) {
        try {
            prepStatement = connection.prepareStatement(SQLStatements.CREATE_TEMPERATURE_SHEET_RECORD.getStatement());
            prepStatement.setInt(1, patientID);
            prepStatement.setDate(2, Date.valueOf(LocalDate.now()));
            logger.info("Спроба виконання запиту addTemperatureSheetRecord({}).", prepStatement);

            prepStatement.executeUpdate();
            logger.info("Виконання запиту addTemperatureSheetRecord({}) успішне.", prepStatement);
        } catch (SQLException e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка виконання запиту addTemperatureSheetRecord, [ErrorID={}]", errorId, e);
        }
    }

}
