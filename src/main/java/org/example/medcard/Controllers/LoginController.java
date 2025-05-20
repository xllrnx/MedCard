package org.example.medcard.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.medcard.Models.Model;
import org.example.medcard.Utils.Enums.LoginErrors;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField login_field;
    public PasswordField password_field;
    public Text error_text;
    public Button login_button;

    /**
     * Initializes the login window and sets up the login button action.
     *
     * @param url            URL of the FXML resource.
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

            if (Model.getInstance().getUserLoginSuccessFlag()) {
                Stage stage = (Stage) login_button.getScene().getWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
                Model.getInstance().getViewFactory().showDoctorWindow();
            } else {
                error_text.setText(LoginErrors.INCORRECT_LOGIN_PASSWORD.getError());
            }
        }
    }
}
