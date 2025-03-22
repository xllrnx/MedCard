package org.example.medcard.Models.Records;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class TreatmentRecord {
    private final StringProperty prescription;
    private final ObjectProperty<LocalDate> prescribed_date;
    private final StringProperty status;
    //private final StringProperty additional_info;


    public TreatmentRecord(String prescription, LocalDate prescribed_date, String status/*, String additional_info*/) {
        this.prescription = new SimpleStringProperty(this, "prescription", prescription);
        this.prescribed_date = new SimpleObjectProperty<>(this, "prescribed_date", prescribed_date);
        this.status = new SimpleStringProperty(this, "status", status);
        //this.additional_info = new SimpleStringProperty(this, "additional_info", additional_info);
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
}
