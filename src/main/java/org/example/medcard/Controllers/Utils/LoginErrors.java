package org.example.medcard.Controllers.Utils;

public enum LoginErrors {
    EMPTY_FIELDS("Необхідно заповнити обидва поля!"),
    INCORRECT_TYPE("Перевірте тип аккаунту!"),
    INCORRECT_LOGIN_PASSWORD("Неправильний логін/пароль!"),
    UNEXPECTED_ERROR("Виникла непередбачувана помилка!");

    private final String error;
    LoginErrors(String error){
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
