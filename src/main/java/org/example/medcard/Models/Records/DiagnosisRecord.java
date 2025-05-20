package org.example.medcard.Models.Records;

import java.time.LocalDate;
import java.time.LocalTime;

public class DiagnosisRecord {
    private String analysis;
    private String cabinet;

    private LocalDate prescriptionDate;
    private LocalTime prescriptionTime;

    private String status;
    private String results;
    private String additionalInfo;

    private String author;
    private String executor;

    public DiagnosisRecord(String analysis, String cabinet, LocalDate prescriptionDate, LocalTime prescriptionTime, String author, String executor, String status, String results, String additionalInfo) {
        this.analysis = analysis;
        this.cabinet = cabinet;
        this.prescriptionDate = prescriptionDate;
        this.prescriptionTime = prescriptionTime;
        this.author = author;
        this.executor = executor;
        this.status = status;
        this.results = results;
        this.additionalInfo = additionalInfo;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
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

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
