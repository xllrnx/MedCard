package org.example.medcard.Models.Records;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TemperatureSheetRecord {

    private final ObjectProperty<LocalDate> checkDate;
    private final StringProperty checkDateString;

    private final int morningPulse;
    private final int morningSystolic;
    private final int morningDiastolic;
    private final double morningTemperature;

    private final int eveningPulse;
    private final int eveningSystolic;
    private final int eveningDiastolic;
    private final double eveningTemperature;

    private final StringProperty additionalInfo;

    public TemperatureSheetRecord(LocalDate checkDate, int morningPulse, int morningSystolic, int morningDiastolic, double morningTemperature, int eveningPulse, int eveningSystolic, int eveningDiastolic, double eveningTemperature, String additionalInfo) {
        this.checkDate = new SimpleObjectProperty<>(this, "checkDate", checkDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.checkDateString = new SimpleStringProperty(this, "checkDateString", checkDate.format(formatter));

        this.morningPulse = morningPulse;
        this.morningSystolic = morningSystolic;
        this.morningDiastolic = morningDiastolic;
        this.morningTemperature = morningTemperature;

        this.eveningPulse = eveningPulse;
        this.eveningSystolic = eveningSystolic;
        this.eveningDiastolic = eveningDiastolic;
        this.eveningTemperature = eveningTemperature;

        this.additionalInfo = new SimpleStringProperty(this, "additionalInfo", additionalInfo);

    }

    public ObjectProperty<LocalDate> getCheckDateProperty() {
        return checkDate;
    }
    public StringProperty getCheckDateStringProperty() {return checkDateString;}

    public int getMorningPulse() {
        return morningPulse;
    }
    public int getMorningSystolic() {
        return morningSystolic;
    }
    public int getMorningDiastolic() {
        return morningDiastolic;
    }
    public double getMorningTemperature() {
        return morningTemperature;
    }

    public int getEveningPulse() {
        return eveningPulse;
    }
    public int getEveningSystolic() {
        return eveningSystolic;
    }
    public int getEveningDiastolic() {
        return eveningDiastolic;
    }
    public double getEveningTemperature() {
        return eveningTemperature;
    }

    public StringProperty getAdditionalInfoProperty() {return additionalInfo;}
}
