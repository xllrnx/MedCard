package org.example.medcard.Utils.Enums;

public enum AddRecordErrors {
    EMPTY_FIELDS("Необхідно заповнити всі поля!"),
    INCORRECT_TEXT_VALUE("Перевірте правильність введення даних!"),
    INCORRECT_DATE_VALUE("Значення дати некоректне!"),
    UNEXPECTED_ERROR("Виникла непередбачувана помилка!");

    private final String error;
    AddRecordErrors(String error){
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
