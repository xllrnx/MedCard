package org.example.medcard.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class TemperatureSheetRecord {

    private final ObjectProperty<LocalDate> check_date;
    private final StringProperty part_of_day;
    private final int pulse;
    private final int systolic_pressure;
    private final int diastolic_pressure;
    private final double temperature;


    public TemperatureSheetRecord(LocalDate checkDate, String partOfDay, int pulse, int systolicPressure, int diastolicPressure, double temperature) {

        check_date = new SimpleObjectProperty<>(this, "checkDate", checkDate);
        part_of_day = new SimpleStringProperty(this, "partOfDay", partOfDay);
        this.pulse = pulse;
        systolic_pressure = systolicPressure;
        diastolic_pressure = diastolicPressure;
        this.temperature = temperature;
    }

    public ObjectProperty<LocalDate> check_dateProperty() {
        return check_date;
    }

    public StringProperty part_of_dayProperty() {
        return part_of_day;
    }

    public int getPulse() {
        return pulse;
    }

    public int getSystolic_pressure() {
        return systolic_pressure;
    }

    public int getDiastolic_pressure() {
        return diastolic_pressure;
    }

    public double getTemperature() {
        return temperature;
    }
}
