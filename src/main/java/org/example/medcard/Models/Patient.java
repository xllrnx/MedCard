package org.example.medcard.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Patient {

    private final int patientID;
    private final StringProperty surname;
    private final StringProperty name;
    private final StringProperty fathername;
    private final ObjectProperty<LocalDate> dateOfBirth;
    private final StringProperty address;
    private final StringProperty phone;
    private final StringProperty sex;
    private final StringProperty complaints;
    private final StringProperty medicalHistory;
    private final boolean status;

    private final ObservableList<TreatmentRecord> treatmentRecords;
    private final ObservableList<DiagnosisRecord> diagnosisRecords;
    private final ObservableList<TemperatureSheetRecord> temperatureSheetRecords;

    public Patient(int patientID, String surname, String name, String fathername, LocalDate dateOfBirth, String address, String phone, String sex, String complaints, String medicalHistory, boolean status, ObservableList<TreatmentRecord> treatmentRecords, ObservableList<DiagnosisRecord> diagnosisRecords, ObservableList<TemperatureSheetRecord> temperatureSheetRecords) {
        this.patientID = patientID;
        this.surname = new SimpleStringProperty(this, "surname", surname);
        this.name = new SimpleStringProperty(this, "name", name);
        this.fathername = new SimpleStringProperty(this, "fathername", fathername);
        this.dateOfBirth = new SimpleObjectProperty<>(this, "dateOfBirth", dateOfBirth);
        this.address = new SimpleStringProperty(this, "address", address);
        this.phone = new SimpleStringProperty(this, "phone", phone);
        this.sex = new SimpleStringProperty(this, "sex", sex);
        this.complaints = new SimpleStringProperty(this, "complaints", complaints);
        this.medicalHistory = new SimpleStringProperty(this, "medicalHistory", medicalHistory);
        this.status = status;

        this.treatmentRecords = treatmentRecords;
        this.diagnosisRecords = diagnosisRecords;
        this.temperatureSheetRecords = temperatureSheetRecords;
    }

    public int PatientID() {return patientID;}
    public StringProperty SurnameProperty() {return surname;}
    public StringProperty NameProperty() {return name;}
    public StringProperty FathernameProperty() {return fathername;}
    public ObjectProperty<LocalDate> DateOfBirthProperty() {return dateOfBirth;}
    public StringProperty AddressProperty() {return address;}
    public StringProperty PhoneProperty() {return phone;}
    public StringProperty Sex() {return sex;}
    public StringProperty ComplaintsProperty() {return complaints;}
    public StringProperty MedicalHistoryProperty() {return medicalHistory;}
    public boolean Status() {return status;}

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
