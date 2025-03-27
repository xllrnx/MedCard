package org.example.medcard.Utils;

public enum TreatmentRecordStatuses {
    DONE("Виконано"),
    PLANNED("Заплановано"),
    CANCELED("Скасовано");

    private final String status;
    TreatmentRecordStatuses(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
