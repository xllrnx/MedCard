package org.example.medcard.Models.Records;

import java.time.LocalDate;
import java.time.LocalTime;

public class TreatmentRecord {
    private String drug;
    private String method;

    private LocalDate prescriptionDate;
    private LocalTime prescriptionTime;

    private String status;
    private String additionalInfo;

    private String author;
    private String executor;

    public TreatmentRecord(String drug, String method, LocalDate prescriptionDate, LocalTime prescriptionTime, String author, String executor, String status, String additionalInfo) {
        this.drug = drug;
        this.method = method;
        this.prescriptionDate = prescriptionDate;
        this.prescriptionTime = prescriptionTime;
        this.author = author;
        this.executor = executor;
        this.status = status;
        this.additionalInfo = additionalInfo;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public LocalDate getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(LocalDate prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public LocalTime getPrescriptionTime() {
        return prescriptionTime;
    }

    public void setPrescriptionTime(LocalTime prescriptionTime) {
        this.prescriptionTime = prescriptionTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
