package org.example.medcard.Controllers.Doctor.RecordsControllers.Patient;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;
import org.example.medcard.Controllers.Doctor.WindowsControllers.ListviewWindows.dSelectPatientController;
import org.example.medcard.Models.Model;
import org.example.medcard.Utils.AddPatientErrors;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddPatientController implements Initializable {

    public TextField surname_field;
    public TextField name_field;
    public TextField fathername_field;
    public DatePicker date_of_birth_field;

    public Text error_text;
    public Button confirm_button;
    public Button cancel_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        confirm_button.setOnAction(event -> onConfirm());
        cancel_button.setOnAction(event -> onCancel());
    }

    private void onConfirm() {
        String surname = surname_field.getText();
        String name = name_field.getText();
        String fathername = fathername_field.getText();
        LocalDate dateOfBirth = date_of_birth_field.getValue();

        if (surname.isEmpty() || name.isEmpty() || fathername.isEmpty() || dateOfBirth == null) {
            error_text.setText(AddPatientErrors.EMPTY_FIELDS.getError());
        } else if (dateOfBirth.isAfter(LocalDate.now()) || dateOfBirth.isBefore(LocalDate.now().minusYears(100))) {
            error_text.setText(AddPatientErrors.INCORRECT_DATE_VALUE.getError());
        } else {
            Model.getInstance().addPatient(surname, name, fathername, dateOfBirth);

            dSelectPatientController dSelectPatientController = DoctorControllerManager.getDSelectPatientController();
            dSelectPatientController.updateList();

            Stage stage = (Stage) confirm_button.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
        }
    }

    private void onCancel() {
        Stage stage = (Stage) cancel_button.getScene().getWindow();

        Model.getInstance().setPatientToDelete(null);
        Model.getInstance().getViewFactory().closeStage(stage);
    }

}
