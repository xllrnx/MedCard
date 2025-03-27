package org.example.medcard.Models;

public class User {
    String login;
    String type;
    String surname;
    String name;
    String fatherName;

    public User() {
    }

    public User(String username, String surname, String name, String fatherName) {
        this.login = username;
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String username) {
        this.login = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", type='" + type + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                '}';
    }
}
