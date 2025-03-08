package org.example.medcard.Models;

public class User {
    private static User instance;
    String login;
    String type;
    String surname;
    String name;
    String fathername;

    public User() {
    }

    public User(String username, String surname, String name, String fathername) {
        this.login = username;
        this.surname = surname;
        this.name = name;
        this.fathername = fathername;
    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    public static void setInstance(User instance) {
        User.instance = instance;
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

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", type='" + type + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", fathername='" + fathername + '\'' +
                '}';
    }
}
