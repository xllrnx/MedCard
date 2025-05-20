package org.example.medcard.Models;

import javafx.collections.ObservableList;
import org.example.medcard.Models.Records.DiagnosisRecord;
import org.example.medcard.Models.Records.TemperatureSheetRecord;
import org.example.medcard.Models.Records.TreatmentRecord;

import java.time.LocalDate;

public class Patient {

    private final int patientID;
    private String surname;
    private String name;
    private String fathername;

    private LocalDate dateOfBirth;

    private String address;
    private String phone;
    private String sex;
    private String complaints;
    private String medicalHistory;
    private boolean status;

    private final ObservableList<TreatmentRecord> treatmentRecords;
    private final ObservableList<DiagnosisRecord> diagnosisRecords;
    private final ObservableList<TemperatureSheetRecord> temperatureSheetRecords;

    public Patient(int patientID, String surname, String name, String fathername, LocalDate dateOfBirth, String address, String phone, String sex, String complaints, String medicalHistory, boolean status, ObservableList<TreatmentRecord> treatmentRecords, ObservableList<DiagnosisRecord> diagnosisRecords, ObservableList<TemperatureSheetRecord> temperatureSheetRecords) {

        this.patientID = patientID;
        this.surname = surname;
        this.name = name;
        this.fathername = fathername;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
        this.sex = sex;
        this.complaints = complaints;
        this.medicalHistory = medicalHistory;
        this.status = status;

        this.treatmentRecords = treatmentRecords;
        this.diagnosisRecords = diagnosisRecords;
        this.temperatureSheetRecords = temperatureSheetRecords;
    }

    public int getPatientID() {
        return patientID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ObservableList<TreatmentRecord> getTreatmentRecords() {
        return treatmentRecords;
    }

    public ObservableList<DiagnosisRecord> getDiagnosisRecords() {
        return diagnosisRecords;
    }

    public ObservableList<TemperatureSheetRecord> getTemperatureSheetRecords() {
        return temperatureSheetRecords;
    }
}
