package org.example.medcard.Controllers;

import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.medcard.Utils.LoginErrors;
import org.example.medcard.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField login_field;
    public PasswordField password_field;
    public Text error_text;
    public Button login_button;

    /**
     * Initializes the login window and sets up the login button action.
     * @param url URL of the FXML resource.
     * @param resourceBundle resource bundle containing localized strings.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_button.setOnAction(event -> onLogin());
    }

    /**
     * Handles the login process, checking user credentials and opening the corresponding window.
     */
    private void onLogin() {
        String ulogin = login_field.getText();
        String upassword = password_field.getText();

        if (ulogin.isEmpty() || upassword.isEmpty()) {
            error_text.setText(LoginErrors.EMPTY_FIELDS.getError());
        } else {
            Model.getInstance().evaluateUserCredentials(ulogin, upassword);
            Stage stage = (Stage) login_button.getScene().getWindow();

            if (Model.getInstance().getUserLoginSuccessFlag()) {
                Model.getInstance().getViewFactory().closeStage(stage);
                Model.getInstance().getViewFactory().showDoctorWindow();
                /*
                if (Objects.equals(Model.getInstance().getUser().getType(), AccountTypes.DOCTOR.getType())) {
                    Model.getInstance().getViewFactory().closeStage(stage);
                    Model.getInstance().getViewFactory().showDoctorWindow();
                } else if (Objects.equals(Model.getInstance().getUser().getType(), AccountTypes.NURSE.getType())) {
                    Model.getInstance().getViewFactory().closeStage(stage);
                    Model.getInstance().getViewFactory().showNurseWindow();
                } else {
                    error_text.setText(LoginErrors.INCORRECT_TYPE.getError());
                }
                */
            } else {
                error_text.setText(LoginErrors.INCORRECT_LOGIN_PASSWORD.getError());
            }
        }
    }
}
