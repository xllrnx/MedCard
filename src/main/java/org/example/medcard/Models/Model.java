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
    private final User user;
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
        this.selectedPatient = new Patient(-1, "", "", "",
                LocalDate.of(2000, 1, 1), "", "", "", "", "",
                true, null, null, null);
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public static void resetModel() {
        model = null;
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

                System.out.println(this.user.toString() + "\n");

                this.userLoginSuccessFlag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /*
    * Patient Method Section
    * */

    public Patient getSelectedPatient() {
        return selectedPatient;
    }

    public void setSelectedPatient(Patient patient) {
        this.selectedPatient = patient;
    }

    public ObservableList<Patient> getPatients() {
        return patients;
    }

    public void setPatients() {
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

                LocalDate date = resultSet.getDate("date_of_birth").toLocalDate();

                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String sex = resultSet.getString("sex");

                String complaints = resultSet.getString("complaints");
                String medicalHistory = resultSet.getString("medical_history");
                boolean status = resultSet.getBoolean("status");
                treatmentRecords = getTreatmentRecords(patientID);
                diagnosisRecords = getDiagnosisRecords(patientID);
                temperatureSheetRecords = getTemperatureSheetRecords(patientID);

                boolean isInPatients = false;
                for (Patient patient : patients) {
                    if (patient.PatientID() == patientID) {
                        isInPatients = true;
                    }
                }
                if (!isInPatients) {
                    patients.add(new Patient(patientID, surname, name, fathername, date, address, phone, sex, complaints, medicalHistory, status, treatmentRecords, diagnosisRecords, temperatureSheetRecords));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addPatient(String surname, String name, String fathername, LocalDate date_of_birth) {
        int personID = databaseDriver.getLastPersonId();
        int patientID = databaseDriver.getLastPatientId();

        databaseDriver.createPerson(personID+1, surname, name, fathername);
        databaseDriver.createPatient(patientID+1, personID+1, date_of_birth);
    }



    /*
     * Utility Method Section
     * */
    public ObservableList<TreatmentRecord> getTreatmentRecords(int patientID ) {
        ObservableList<TreatmentRecord> treatmentRecords = FXCollections.observableArrayList();
        ResultSet resultSet = databaseDriver.getTreatmentRecords(patientID);
        try {
            while(resultSet.next()) {
                String prescription = resultSet.getString("prescription");
                LocalDate date = resultSet.getDate("prescribed_date").toLocalDate();
                boolean status = resultSet.getBoolean("status");

                treatmentRecords.add(new TreatmentRecord(prescription, date, status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return treatmentRecords;
    }

    public ObservableList<DiagnosisRecord> getDiagnosisRecords(int patientID ) {
        ObservableList<DiagnosisRecord> diagnosisRecords = FXCollections.observableArrayList();
        ResultSet resultSet = databaseDriver.getDiagnosisRecords(patientID);
        try {
            while(resultSet.next()) {
                String prescription = resultSet.getString("prescription");
                LocalDate date = resultSet.getDate("prescribed_date").toLocalDate();boolean status = resultSet.getBoolean("status");
                String result = resultSet.getString("result");

                diagnosisRecords.add(new DiagnosisRecord(prescription, date, status, result));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return diagnosisRecords;
    }

    public ObservableList<TemperatureSheetRecord> getTemperatureSheetRecords(int patientID ) {
        ObservableList<TemperatureSheetRecord> temperatureSheetRecords = FXCollections.observableArrayList();
        ResultSet resultSet = databaseDriver.getTemperatureSheerRecords(patientID);
        try {
            while(resultSet.next()) {

                LocalDate date = resultSet.getDate("check_date").toLocalDate();
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
