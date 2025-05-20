package org.example.medcard.Controllers.Doctor.WindowControllers.DialogWindows.TreatmentRecord;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.medcard.Controllers.Doctor.WindowControllers.DWindowControllerManager;
import org.example.medcard.Controllers.Doctor.WindowControllers.ListviewWindows.DTreatmentController;
import org.example.medcard.Models.Model;
import org.example.medcard.Utils.Enums.AddRecordErrors;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddTreatmentRecordController implements Initializable {
    public TextField drug_field;
    public TextField method_field;
    public DatePicker date_field;
    public TextField time_field;
    public TextField additional_info_field;

    public Text error_text;
    public Button confirm_button;
    public Button cancel_button;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        confirm_button.setOnAction(event -> onConfirm());
        cancel_button.setOnAction(event -> onCancel());
    }


    private void onConfirm() {
        String drug = drug_field.getText();
        String method = method_field.getText();
        LocalDate date = date_field.getValue();
        String time = time_field.getText();
        String additionalInfo = additional_info_field.getText();

        if (drug.isEmpty() || method.isEmpty() || date == null || time.isEmpty()) {
            error_text.setText(AddRecordErrors.EMPTY_FIELDS.getError());
        } else if (date.isBefore(LocalDate.now())) {
            error_text.setText(org.example.medcard.Utils.Enums.AddRecordErrors.INCORRECT_DATE_VALUE.getError());
        } else {
            //Model.getInstance().addTreatmentRecord();

            DTreatmentController dTreatmentController = DWindowControllerManager.getDTreatmentController();
            dTreatmentController.updateList();

            Stage stage = (Stage) confirm_button.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
        }
    }

    private void onCancel() {
        Stage stage = (Stage) cancel_button.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }
}
