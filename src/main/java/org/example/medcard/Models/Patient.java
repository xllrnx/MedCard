package org.example.medcard.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Patient {
    private final StringProperty surname;
    private final StringProperty name;
    private final StringProperty fathername;
    private final ObjectProperty<LocalDate> dateOfBirth;
    private final StringProperty complaints;
    private final StringProperty medicalHistory;
    private final boolean status;

    public Patient(String surname, String name, String fathername, LocalDate dateOfBirth, String complaints, String medicalHistory, boolean status) {
        this.surname = new SimpleStringProperty(this, "surname", surname);
        this.name = new SimpleStringProperty(this, "name", name);
        this.fathername = new SimpleStringProperty(this, "fathername", fathername);
        this.dateOfBirth = new SimpleObjectProperty<>(this, "dateOfBirth", dateOfBirth);
        this.complaints = new SimpleStringProperty(this, "complaints", complaints);
        this.medicalHistory = new SimpleStringProperty(this, "medicalHistory", medicalHistory);
        this.status = status;
    }

    public StringProperty SurnameProperty() {return surname;}
    public StringProperty NameProperty() {return name;}
    public StringProperty FathernameProperty() {return fathername;}
    public ObjectProperty<LocalDate> DateOfBirthProperty() {return dateOfBirth;}
    public StringProperty ComplaintsProperty() {return complaints;}
    public StringProperty MedicalHistoryProperty() {return medicalHistory;}
    public boolean StatusProperty() {return status;}
}
