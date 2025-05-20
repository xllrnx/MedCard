package org.example.medcard.Models.Records;

import java.time.LocalDate;
import java.time.LocalTime;

public class TemperatureSheetRecord {

    private LocalDate checkDate;

    private LocalTime morningCheckTime;
    private int morningPulse;
    private int morningSystolic;
    private int morningDiastolic;
    private double morningTemperature;
    private String morningExecutor;
    private String morningAdditionalInfo;

    private LocalTime eveningCheckTime;
    private int eveningPulse;
    private int eveningSystolic;
    private int eveningDiastolic;
    private double eveningTemperature;
    private String eveningExecutor;
    private String eveningAdditionalInfo;


    public TemperatureSheetRecord(LocalDate checkDate, LocalTime morningCheckTime, int morningPulse, int morningSystolic, int morningDiastolic, double morningTemperature, String morningExecutor, String morningAdditionalInfo, LocalTime eveningCheckTime, int eveningPulse, int eveningSystolic, int eveningDiastolic, double eveningTemperature, String eveningExecutor, String eveningAdditionalInfo) {
        this.checkDate = checkDate;

        this.morningCheckTime = morningCheckTime;
        this.morningPulse = morningPulse;
        this.morningSystolic = morningSystolic;
        this.morningDiastolic = morningDiastolic;
        this.morningTemperature = morningTemperature;
        this.morningExecutor = morningExecutor;
        this.morningAdditionalInfo = morningAdditionalInfo;

        this.eveningCheckTime = eveningCheckTime;
        this.eveningPulse = eveningPulse;
        this.eveningSystolic = eveningSystolic;
        this.eveningDiastolic = eveningDiastolic;
        this.eveningTemperature = eveningTemperature;
        this.eveningExecutor = eveningExecutor;
        this.eveningAdditionalInfo = eveningAdditionalInfo;
    }

    public LocalDate getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(LocalDate checkDate) {
        this.checkDate = checkDate;
    }

    public LocalTime getMorningCheckTime() {
        return morningCheckTime;
    }

    public void setMorningCheckTime(LocalTime morningCheckTime) {
        this.morningCheckTime = morningCheckTime;
    }

    public int getMorningPulse() {
        return morningPulse;
    }

    public void setMorningPulse(int morningPulse) {
        this.morningPulse = morningPulse;
    }

    public int getMorningSystolic() {
        return morningSystolic;
    }

    public void setMorningSystolic(int morningSystolic) {
        this.morningSystolic = morningSystolic;
    }

    public int getMorningDiastolic() {
        return morningDiastolic;
    }

    public void setMorningDiastolic(int morningDiastolic) {
        this.morningDiastolic = morningDiastolic;
    }

    public double getMorningTemperature() {
        return morningTemperature;
    }

    public void setMorningTemperature(double morningTemperature) {
        this.morningTemperature = morningTemperature;
    }

    public String getMorningExecutor() {
        return morningExecutor;
    }

    public void setMorningExecutor(String morningExecutor) {
        this.morningExecutor = morningExecutor;
    }

    public String getMorningAdditionalInfo() {
        return morningAdditionalInfo;
    }

    public void setMorningAdditionalInfo(String morningAdditionalInfo) {
        this.morningAdditionalInfo = morningAdditionalInfo;
    }

    public LocalTime getEveningCheckTime() {
        return eveningCheckTime;
    }

    public void setEveningCheckTime(LocalTime eveningCheckTime) {
        this.eveningCheckTime = eveningCheckTime;
    }

    public int getEveningPulse() {
        return eveningPulse;
    }

    public void setEveningPulse(int eveningPulse) {
        this.eveningPulse = eveningPulse;
    }

    public int getEveningSystolic() {
        return eveningSystolic;
    }

    public void setEveningSystolic(int eveningSystolic) {
        this.eveningSystolic = eveningSystolic;
    }

    public int getEveningDiastolic() {
        return eveningDiastolic;
    }

    public void setEveningDiastolic(int eveningDiastolic) {
        this.eveningDiastolic = eveningDiastolic;
    }

    public double getEveningTemperature() {
        return eveningTemperature;
    }

    public void setEveningTemperature(double eveningTemperature) {
        this.eveningTemperature = eveningTemperature;
    }

    public String getEveningExecutor() {
        return eveningExecutor;
    }

    public void setEveningExecutor(String eveningExecutor) {
        this.eveningExecutor = eveningExecutor;
    }

    public String getEveningAdditionalInfo() {
        return eveningAdditionalInfo;
    }

    public void setEveningAdditionalInfo(String eveningAdditionalInfo) {
        this.eveningAdditionalInfo = eveningAdditionalInfo;
    }
}
