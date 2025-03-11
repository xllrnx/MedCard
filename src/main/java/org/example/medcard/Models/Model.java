package org.example.medcard.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.medcard.Views.ViewFactory;

import java.sql.ResultSet;
import java.time.LocalDate;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;

    // User Data Section
    private User user;
    private boolean userLoginSuccessFlag;

    // Patient Data Section
    private final ObservableList<Patient> patients;
    private Patient selectedPatient;



    private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        // User Data section
        this.userLoginSuccessFlag = false;
        this.user = new User("", "", "", "");

        this.patients = FXCollections.observableArrayList();
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }
    public DatabaseDriver getDatabaseDriver() {
        return databaseDriver;
    }

    /*
    * User Method Section
    * */
    public boolean getUserLoginSuccessFlag() {
        return userLoginSuccessFlag;
    }

    public void setUserLoginSuccessFlag(boolean flag) {
        this.userLoginSuccessFlag = flag;
    }

    public User getUser() {
        return user;
    }

    public void evaluateUserCredentials(String login, String password) {
        ResultSet resultSet = databaseDriver.getUserData(login, password);
        try {
            if(resultSet.next()) {
                this.user.setLogin(resultSet.getString("login"));

                this.user.setSurname(resultSet.getString("surname"));
                this.user.setName(resultSet.getString("name"));
                this.user.setFathername(resultSet.getString("fathername"));
                this.user.setType(resultSet.getString("type"));

                System.out.println(this.user.toString());

                this.userLoginSuccessFlag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /*
    *
    * */

    public Patient getSelectedPatient() {
        return selectedPatient;
    }

    public ObservableList<Patient> getPatients() {
        return patients;
    }

    public ObservableList<Patient> setPatients() {
        ObservableList<TreatmentRecord> treatmentRecords;
        ObservableList<DiagnosisRecord> diagnosisRecords;
        ObservableList<TemperatureSheetRecord> temperatureSheetRecords;

        ResultSet resultSet = databaseDriver.getAllPatientsData();
        try {
            while(resultSet.next()) {

                int patientID = resultSet.getInt("patient_id");

                String surname = resultSet.getString("surname");
                String name = resultSet.getString("name");
                String fathername = resultSet.getString("fathername");

                String[] dateParts = resultSet.getString("date_of_birth").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));

                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String sex = resultSet.getString("sex");

                String complaints = resultSet.getString("complaints");
                String medicalHistory = resultSet.getString("medical_history");
                boolean status = resultSet.getBoolean("status");
                treatmentRecords = getTreatmentRecords(patientID);
                diagnosisRecords = getDiagnosisRecords(patientID);
                temperatureSheetRecords = getTemperatureSheetRecords(patientID);

                patients.add(new Patient(patientID, surname, name, fathername, date, address, phone, sex, complaints, medicalHistory, status, treatmentRecords, diagnosisRecords, temperatureSheetRecords));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patients;
    }

    /*
     * Utility Method Section
     * */
    public ObservableList<TreatmentRecord> getTreatmentRecords(int patientID ) {
        ObservableList<TreatmentRecord> treatmentRecords = null;
        ResultSet resultSet = databaseDriver.getTreatmentRecords(patientID);
        try {
            while(resultSet.next()) {
                String prescription = resultSet.getString("prescription");
                String[] dateParts = resultSet.getString("prescribed_date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                boolean status = resultSet.getBoolean("status");

                treatmentRecords.add(new TreatmentRecord(prescription, date, status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return treatmentRecords;
    }

    public ObservableList<DiagnosisRecord> getDiagnosisRecords(int patientID ) {
        ObservableList<DiagnosisRecord> diagnosisRecords = null;
        ResultSet resultSet = databaseDriver.getDiagnosisRecords(patientID);
        try {
            while(resultSet.next()) {
                String prescription = resultSet.getString("prescription");
                String[] dateParts = resultSet.getString("prescribed_date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                boolean status = resultSet.getBoolean("status");
                String result = resultSet.getString("result");

                diagnosisRecords.add(new DiagnosisRecord(prescription, date, status, result));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return diagnosisRecords;
    }

    public ObservableList<TemperatureSheetRecord> getTemperatureSheetRecords(int patientID ) {
        ObservableList<TemperatureSheetRecord> temperatureSheetRecords = null;
        ResultSet resultSet = databaseDriver.getTemperatureSheerRecords(patientID);
        try {
            while(resultSet.next()) {

                String[] dateParts = resultSet.getString("check_date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));

                String prescription = resultSet.getString("part_of_day");
                int pulse = resultSet.getInt("pulse");
                int systolicPressure = resultSet.getInt("systolic_pressure");
                int diastolicPressure = resultSet.getInt("diastolic_pressure");
                double temperature = resultSet.getDouble("temperature");

                temperatureSheetRecords.add(new TemperatureSheetRecord(date, prescription, pulse, systolicPressure, diastolicPressure, temperature));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temperatureSheetRecords;
    }

}
