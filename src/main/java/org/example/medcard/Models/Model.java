package org.example.medcard.Models;

import org.example.medcard.Views.ViewFactory;

import java.sql.ResultSet;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;

    // User Data Section
    private User user;
    private boolean userLoginSuccessFlag;

    // Patient Data Section



    private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        // User Data section
        this.userLoginSuccessFlag = false;
        this.user = new User("", "", "", "");
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }
    public DatabaseDriver getDatabaseDriver() {
        return databaseDriver;
    }

    /*
    * User Method Section
    * */
    public boolean getUserLoginSuccessFlag() {
        return userLoginSuccessFlag;
    }

    public void setUserLoginSuccessFlag(boolean flag) {
        this.userLoginSuccessFlag = flag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void evaluateUserCredentials(String login, String password) {
        ResultSet resultSet = databaseDriver.getUserData(login, password);
        try {
            if(resultSet.next()) {
                this.user.setLogin(resultSet.getString("login"));

                this.user.setSurname(resultSet.getString("surname"));
                this.user.setName(resultSet.getString("name"));
                this.user.setFathername(resultSet.getString("fathername"));
                this.user.setType(resultSet.getString("type"));

                System.out.println(this.user.toString());

                this.userLoginSuccessFlag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
