package org.example.medcard.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.medcard.Models.Records.DiagnosisRecord;
import org.example.medcard.Models.Records.TemperatureSheetRecord;
import org.example.medcard.Models.Records.TreatmentRecord;
import org.example.medcard.Views.ViewFactory;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;

    // User Data Section
    private final User user;
    private boolean userLoginSuccessFlag;

    // Patients Data Section
    private final ObservableList<Patient> patients;
    private Patient selectedPatient;
    private Patient patientToDelete;

    //Selected Records Data Section
    private TreatmentRecord selectedTreatmentRecord;
    private DiagnosisRecord selectedDiagnosisRecord;
    private TemperatureSheetRecord selectedTemperatureSheetRecord;

    private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();

        this.userLoginSuccessFlag = false;
        this.user = new User();

        this.patients = FXCollections.observableArrayList();
        this.selectedPatient = null;
        this.patientToDelete = null;

        this.selectedTreatmentRecord = null;
        this.selectedDiagnosisRecord = null;
        this.selectedTemperatureSheetRecord = null;
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

    // User Method Section
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
                new User();
                this.user.setType(resultSet.getString("type"));

                this.user.setSurname(resultSet.getString("surname"));
                this.user.setName(resultSet.getString("name"));
                this.user.setFatherName(resultSet.getString("fatherName"));

                System.out.println(this.user.toString() + "\n");

                this.userLoginSuccessFlag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Patients Method Section
    public Patient getSelectedPatient() {
        return selectedPatient;
    }

    public void setSelectedPatient(Patient patient) {
        this.selectedPatient = patient;
    }

    public Patient getPatientToDelete() {
        return patientToDelete;
    }

    public void setPatientToDelete(Patient patient) {
        this.patientToDelete = patient;
    }

    public ObservableList<Patient> getPatients() {
        return patients;
    }

    public void setPatients() {
        ResultSet resultSet = databaseDriver.getAllPatientsData();
        try {
            while(resultSet.next()) {

                int patientID = resultSet.getInt("patientID");

                String surname = resultSet.getString("surname");
                String name = resultSet.getString("name");
                String fathername = resultSet.getString("fatherName");

                LocalDate date = resultSet.getDate("dateOfBirth").toLocalDate();

                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String sex = resultSet.getString("sex");
                String complaints = resultSet.getString("complaints");
                String medicalHistory = resultSet.getString("medicalHistory");
                boolean status = resultSet.getBoolean("status");

                ObservableList<TreatmentRecord> treatmentRecords = getTreatmentRecords(patientID);
                ObservableList<DiagnosisRecord> diagnosisRecords = getDiagnosisRecords(patientID);
                ObservableList<TemperatureSheetRecord> temperatureSheetRecords = getTemperatureSheetRecords(patientID);

                patients.add(new Patient(patientID, surname, name, fathername, date, address, phone, sex, complaints, medicalHistory, status, treatmentRecords, diagnosisRecords, temperatureSheetRecords));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addPatient(String surname, String name, String fathername, LocalDate dateOfBirth) {
        int personID = databaseDriver.getLastPersonId();
        int patientID = databaseDriver.getLastPatientId();

        databaseDriver.createPerson(personID+1, surname, name, fathername);
        databaseDriver.createPatient(patientID+1, personID+1, dateOfBirth);

        ObservableList<TreatmentRecord> treatmentRecords = getTreatmentRecords(patientID+1);
        ObservableList<DiagnosisRecord> diagnosisRecords = getDiagnosisRecords(patientID+1);
        ObservableList<TemperatureSheetRecord> temperatureSheetRecords = getTemperatureSheetRecords(patientID+1);
        patients.add(new Patient(patientID+1, surname, name, fathername, dateOfBirth, "", "", "", "", "", true, treatmentRecords, diagnosisRecords, temperatureSheetRecords));
    }

    public void editPatient(Patient patient) {
        databaseDriver.editPatient(patient.getPatientID());
    }

    public void deletePatient(Patient patient) {
        databaseDriver.deletePatient(patient.getPatientID());
        patients.remove(patient);
    }

    // Utility Method Section
    public ObservableList<TreatmentRecord> getTreatmentRecords(int patientID) {
        ObservableList<TreatmentRecord> treatmentRecords = FXCollections.observableArrayList();
        ResultSet resultSet = databaseDriver.getTreatmentRecords(patientID);
        try {
            while(resultSet.next()) {
                String prescription = resultSet.getString("prescription");
                LocalDateTime prescriptionTime = resultSet.getTimestamp("prescriptionTime").toLocalDateTime();
                String status = resultSet.getString("status");
                String additionalInfo = resultSet.getString("additionalInfo");

                treatmentRecords.add(new TreatmentRecord(prescription, prescriptionTime, status, additionalInfo));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        treatmentRecords.sort(Comparator.comparing((TreatmentRecord record) -> record.getPrescriptionTimeProperty().get()).reversed());
        return treatmentRecords;
    }

    public ObservableList<DiagnosisRecord> getDiagnosisRecords(int patientID) {
        ObservableList<DiagnosisRecord> diagnosisRecords = FXCollections.observableArrayList();
        ResultSet resultSet = databaseDriver.getDiagnosisRecords(patientID);
        try {
            while(resultSet.next()) {
                String prescription = resultSet.getString("prescription");
                LocalDateTime prescriptionTime = resultSet.getTimestamp("prescriptionTime").toLocalDateTime();
                String status = resultSet.getString("status");
                String result = resultSet.getString("result");
                String additionalInfo = resultSet.getString("additionalInfo");

                diagnosisRecords.add(new DiagnosisRecord(prescription, prescriptionTime, status, result, additionalInfo));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        diagnosisRecords.sort(Comparator.comparing((DiagnosisRecord record) -> record.getPrescriptionTimeProperty().get()).reversed());
        return diagnosisRecords;
    }

    public ObservableList<TemperatureSheetRecord> getTemperatureSheetRecords(int patientID) {
        ObservableList<TemperatureSheetRecord> temperatureSheetRecords = FXCollections.observableArrayList();
        ResultSet resultSet = databaseDriver.getTemperatureSheerRecords(patientID);
        try {
            while(resultSet.next()) {
                LocalDate checkDate = resultSet.getDate("checkDate").toLocalDate();

                int morningPulse = resultSet.getInt("morningPulse");
                int morningSystolic = resultSet.getInt("morningSystolic");
                int morningDiastolic = resultSet.getInt("morningDiastolic");
                double morningTemperature = resultSet.getDouble("morningTemperature");

                int eveningPulse = resultSet.getInt("eveningPulse");
                int eveningSystolic = resultSet.getInt("eveningSystolic");
                int eveningDiastolic = resultSet.getInt("eveningDiastolic");
                double eveningTemperature = resultSet.getDouble("eveningTemperature");

                String additionalInfo = resultSet.getString("additionalInfo");

                temperatureSheetRecords.add(new TemperatureSheetRecord(checkDate, morningPulse, morningSystolic, morningDiastolic, morningTemperature, eveningPulse, eveningSystolic, eveningDiastolic, eveningTemperature, additionalInfo));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        temperatureSheetRecords.sort(Comparator.comparing((TemperatureSheetRecord record) -> record.getCheckDateProperty().get()).reversed());
        return temperatureSheetRecords;
    }

    // Selected Records Data Section
    public TreatmentRecord getSelectedTreatmentRecord() {
        return selectedTreatmentRecord;
    }
    public void setSelectedTreatmentRecord(TreatmentRecord treatmentRecord) {
        this.selectedTreatmentRecord = treatmentRecord;
    }

    public DiagnosisRecord getSelectedDiagnosisRecord() {
        return selectedDiagnosisRecord;
    }
    public void setSelectedDiagnosisRecord(DiagnosisRecord diagnosisRecord) {
        this.selectedDiagnosisRecord = diagnosisRecord;
    }

    public TemperatureSheetRecord getSelectedTemperatureSheetRecord() {
        return selectedTemperatureSheetRecord;
    }
    public void setSelectedTemperatureSheetRecord(TemperatureSheetRecord temperatureSheetRecord) {
        this.selectedTemperatureSheetRecord = temperatureSheetRecord;
    }
}
