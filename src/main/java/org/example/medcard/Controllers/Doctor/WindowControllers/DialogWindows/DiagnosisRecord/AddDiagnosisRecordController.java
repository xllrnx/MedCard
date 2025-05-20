package org.example.medcard.Controllers.Doctor.WindowControllers.DialogWindows.DiagnosisRecord;


import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.medcard.Controllers.Doctor.WindowControllers.DWindowControllerManager;
import org.example.medcard.Controllers.Doctor.WindowControllers.ListviewWindows.DDiagnosisController;
import org.example.medcard.Models.Model;
import org.example.medcard.Utils.Enums.AddRecordErrors;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

public class AddDiagnosisRecordController implements Initializable {
    public TextField analysis_field;
    public TextField cabinet_field;
    public TextField prescription_date_field;
    public TextField prescription_time_field;


    public Text error_text;
    public Button confirm_button;
    public Button cancel_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        confirm_button.setOnAction(event -> onConfirm());
        cancel_button.setOnAction(event -> onCancel());
    }

    private void onConfirm() {
        String analysis = analysis_field.getText().trim();
        String cabinet = cabinet_field.getText().trim();

        String prescriptionDateString = prescription_date_field.getText().trim();
        System.out.println(prescriptionDateString);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate prescriptionDate = null;
        try {
            prescriptionDate = LocalDate.parse(prescriptionDateString, dateFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("Некоректна дата або формат. Використовуйте dd-MM-yyyy");
        }

        String prescriptionTimeString = prescription_time_field.getText().trim();
        System.out.println(prescriptionTimeString);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime prescriptionTime = null;
        try {
            prescriptionTime = LocalTime.parse(prescriptionTimeString, timeFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("Некоректна дата або формат. Використовуйте hh:mm");
        }

        if (analysis.isEmpty() || cabinet.isEmpty() || prescriptionDate == null || prescriptionTime == null) {
            error_text.setText(AddRecordErrors.EMPTY_FIELDS.getError());
        } else if (LocalDateTime.of(prescriptionDate, prescriptionTime).isBefore(LocalDateTime.now()) || prescriptionDate.isAfter(LocalDate.now().plusMonths(2))) {
            error_text.setText(org.example.medcard.Utils.Enums.AddRecordErrors.INCORRECT_DATE_VALUE.getError());
        } else {
            Model.getInstance().addDiagnosisRecord(analysis, cabinet, prescriptionDate, prescriptionTime);

            DDiagnosisController dDiagnosisController = DWindowControllerManager.getDDiagnosisController();
            dDiagnosisController.updateList();

            Stage stage = (Stage) confirm_button.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
        }
    }

    private void onCancel() {
        Stage stage = (Stage) cancel_button.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }
}
