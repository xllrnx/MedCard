package org.example.medcard.Models.Records;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DiagnosisRecord {
    private final StringProperty prescription;

    private final ObjectProperty<LocalDateTime> prescriptionTime;
    private final StringProperty prescriptionTimeString;

    private final StringProperty status;
    private final StringProperty result;
    private final StringProperty additionalInfo;

    public DiagnosisRecord(String prescription, LocalDateTime prescriptionTime, String status, String result, String additionalInfo) {
        this.prescription = new SimpleStringProperty(this, "prescription", prescription);

        this.prescriptionTime = new SimpleObjectProperty<>(this, "prescriptionTime", prescriptionTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        this.prescriptionTimeString = new SimpleStringProperty(this, "prescriptionTimeString", prescriptionTime.format(formatter));

        this.status = new SimpleStringProperty(this, "status", status);
        this.result = new SimpleStringProperty(this, "result", result);
        this.additionalInfo = new SimpleStringProperty(this, "additionalInfo", additionalInfo);
    }

    public StringProperty getPrescriptionProperty() {
        return prescription;
    }
    public ObjectProperty<LocalDateTime> getPrescriptionTimeProperty() {
        return prescriptionTime;
    }
    public StringProperty getPrescriptionTimeStringProperty() {
        return prescriptionTimeString;
    }
    public StringProperty getStatusProperty() {
        return status;
    }
    public StringProperty getResultProperty() {return result;}
    public StringProperty getAdditionalInfoProperty() {return additionalInfo;}
}
