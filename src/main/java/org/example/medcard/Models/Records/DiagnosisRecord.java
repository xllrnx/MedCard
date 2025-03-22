package org.example.medcard.Models.Records;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class DiagnosisRecord {
    private final StringProperty prescription;
    private final ObjectProperty<LocalDate> prescribed_date;
    private final StringProperty status;
    private final StringProperty result;

    public DiagnosisRecord(String prescription, LocalDate prescribed_date, String status, String result) {
        this.prescription = new SimpleStringProperty(this, "prescription", prescription);
        this.prescribed_date = new SimpleObjectProperty<>(this, "prescribed_date", prescribed_date);
        this.status = new SimpleStringProperty(this, "status", status);
        this.result = new SimpleStringProperty(this, "result", result);
    }

    public StringProperty getPrescriptionProperty() {
        return prescription;
    }
    public ObjectProperty<LocalDate> getPrescribedDateProperty() {
        return prescribed_date;
    }
    public StringProperty getStatus() {
        return status;
    }
    public StringProperty getresultProperty() {return result;}
}
