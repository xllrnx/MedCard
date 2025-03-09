package org.example.medcard.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class TreatmentRecord {
    private final StringProperty prescription;
    private final ObjectProperty<LocalDate> prescribed_date;
    private final boolean status;

    public TreatmentRecord(String prescription, LocalDate prescribed_date, boolean status) {
        this.prescription = new SimpleStringProperty(this, "prescription", prescription);
        this.prescribed_date = new SimpleObjectProperty<>(this, "prescribed_date", prescribed_date);
        this.status = status;
    }

    public StringProperty PrescriptionProperty() {
        return prescription;
    }
    public ObjectProperty<LocalDate> prescribed_dateProperty() {
        return prescribed_date;
    }
    public boolean Status() {
        return status;
    }
}
