package org.example.medcard.Utils;

public enum AddPatientErrors {
    EMPTY_FIELDS("Необхідно заповнити всі поля!"),
    INCORRECT_TEXT_VALUE("Перевірте правильність введення даних!"),
    INCORRECT_DATE_VALUE("Значення дати некоректне!"),
    UNEXPECTED_ERROR("Виникла непередбачувана помилка!");

    private final String error;
    AddPatientErrors(String error){
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
