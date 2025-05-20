package org.example.medcard.Controllers.Doctor.WindowControllers.DialogWindows.Patient;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.medcard.Controllers.Doctor.WindowControllers.DWindowControllerManager;
import org.example.medcard.Controllers.Doctor.WindowControllers.ListviewWindows.DSelectPatientController;
import org.example.medcard.Models.Model;
import org.example.medcard.Utils.Enums.AddRecordErrors;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

public class AddPatientController implements Initializable {

    public TextField surname_field;
    public TextField name_field;
    public TextField fathername_field;
    public TextField date_of_birth_field;

    public Text error_text;
    public Button confirm_button;
    public Button cancel_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        confirm_button.setOnAction(event -> onConfirm());
        cancel_button.setOnAction(event -> onCancel());
    }

    private void onConfirm() {
        String surname = surname_field.getText().trim();
        String name = name_field.getText().trim();
        String fathername = fathername_field.getText().trim();

        String dateOfBirthString = date_of_birth_field.getText().trim();
        System.out.println(dateOfBirthString);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateOfBirth = null;
        try {
            dateOfBirth = LocalDate.parse(dateOfBirthString, dateFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("Некоректна дата або формат. Використовуйте dd-MM-yyyy");
        }

        if (surname.isEmpty() || name.isEmpty() || fathername.isEmpty() || dateOfBirth == null) {
            error_text.setText(org.example.medcard.Utils.Enums.AddRecordErrors.EMPTY_FIELDS.getError());
        } else if (dateOfBirth.isAfter(LocalDate.now()) || dateOfBirth.isBefore(LocalDate.now().minusYears(100))) {
            error_text.setText(AddRecordErrors.INCORRECT_DATE_VALUE.getError());
        } else {
            Model.getInstance().addPatient(surname, name, fathername, dateOfBirth);

            DSelectPatientController dSelectPatientController = DWindowControllerManager.getDSelectPatientController();
            dSelectPatientController.updateList();

            Stage stage = (Stage) confirm_button.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
        }
    }

    private void onCancel() {
        Stage stage = (Stage) cancel_button.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }
}
