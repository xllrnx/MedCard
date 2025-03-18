package org.example.medcard.Controllers.Doctor.AddRecordsControllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.medcard.Controllers.Doctor.DashboardsControllers.DoctorSelectPatientController;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;
import org.example.medcard.Models.Model;
import org.example.medcard.Utils.AddPatientErrors;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DoctorAddPatientController implements Initializable {

    public TextField surname_field;
    public TextField name_field;
    public TextField fathername_field;
    public DatePicker date_of_birth_field;

    public Text error_text;
    public Button confirm_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        confirm_button.setOnAction(event -> onConfirm());
    }

    private void onConfirm(){
        DoctorSelectPatientController selectPatientController = DoctorControllerManager.getDoctorSelectPatientController();
        Stage stage = (Stage) confirm_button.getScene().getWindow();

        String surname = surname_field.getText();
        String name = name_field.getText();
        String fathername = fathername_field.getText();
        LocalDate date_of_birth = date_of_birth_field.getValue();

        if (surname.isEmpty() || name.isEmpty() || fathername.isEmpty() || date_of_birth == null) {
            error_text.setText(AddPatientErrors.EMPTY_FIELDS.getError());
        } else if (date_of_birth.isAfter(LocalDate.now()) || date_of_birth.isBefore(LocalDate.now().minusYears(100))) {
            error_text.setText(AddPatientErrors.INCORRECT_DATE_VALUE.getError());
        } else {
            Model.getInstance().addPatient(surname, name, fathername, date_of_birth);
            selectPatientController.updatePatientsList();
            Model.getInstance().getViewFactory().closeStage(stage);
        }
    }
}
