package org.example.medcard.Controllers.Doctor.WindowControllers.DialogWindows.TemperatureSheetRecord;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.medcard.Models.Model;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TemperatureSheetRecordInfoController implements Initializable {

    public Text check_date;
    public Text check_time;
    public Text pulse;
    public Text temperature;
    public Text systolic;
    public Text diastolic;
    public Text executor;
    public Text additional_info;

    public Button close_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        check_date.setText(Model.getInstance().getSelectedTemperatureSheetRecord().getCheckDate().format(dateFormatter));

        if (Model.getInstance().getSelectedTemperatureSheetRecordPoD().equals("morning")) {
            if (Model.getInstance().getSelectedTemperatureSheetRecord().getMorningCheckTime() == null) {
                check_time.setText("Записи відсутні");
            } else {
                check_time.setText(Model.getInstance().getSelectedTemperatureSheetRecord().getMorningCheckTime().toString());
            }
            if (Model.getInstance().getSelectedTemperatureSheetRecord().getMorningPulse() == -1) {
                pulse.setText("Записи відсутні");
            } else {
                pulse.setText(String.valueOf(Model.getInstance().getSelectedTemperatureSheetRecord().getMorningPulse()));
            }
            if (Model.getInstance().getSelectedTemperatureSheetRecord().getMorningTemperature() == -1) {
                temperature.setText("Записи відсутні");
            } else {
                temperature.setText(String.valueOf(Model.getInstance().getSelectedTemperatureSheetRecord().getMorningTemperature()));
            }
            if (Model.getInstance().getSelectedTemperatureSheetRecord().getMorningSystolic() == -1) {
                systolic.setText("Записи відсутні");
            } else {
                systolic.setText(String.valueOf(Model.getInstance().getSelectedTemperatureSheetRecord().getMorningSystolic()));
            }
            if (Model.getInstance().getSelectedTemperatureSheetRecord().getMorningDiastolic() == -1) {
                diastolic.setText("Записи відсутні");
            } else {
                diastolic.setText(String.valueOf(Model.getInstance().getSelectedTemperatureSheetRecord().getMorningDiastolic()));
            }
            executor.setText(String.valueOf(Model.getInstance().getSelectedTemperatureSheetRecord().getMorningExecutor()));
            additional_info.setText(Model.getInstance().getSelectedTemperatureSheetRecord().getMorningAdditionalInfo());
        } else {
            if (Model.getInstance().getSelectedTemperatureSheetRecord().getEveningCheckTime() == null) {
                check_time.setText("Записи відсутні");
            } else {
                check_time.setText(Model.getInstance().getSelectedTemperatureSheetRecord().getEveningCheckTime().toString());
            }
            if (Model.getInstance().getSelectedTemperatureSheetRecord().getEveningPulse() == -1) {
                pulse.setText("Записи відсутні");
            } else {
                pulse.setText(String.valueOf(Model.getInstance().getSelectedTemperatureSheetRecord().getEveningPulse()));
            }
            if (Model.getInstance().getSelectedTemperatureSheetRecord().getEveningTemperature() == -1) {
                temperature.setText("Записи відсутні");
            } else {
                temperature.setText(String.valueOf(Model.getInstance().getSelectedTemperatureSheetRecord().getEveningTemperature()));
            }
            if (Model.getInstance().getSelectedTemperatureSheetRecord().getEveningSystolic() == -1) {
                systolic.setText("Записи відсутні");
            } else {
                systolic.setText(String.valueOf(Model.getInstance().getSelectedTemperatureSheetRecord().getEveningSystolic()));
            }
            if (Model.getInstance().getSelectedTemperatureSheetRecord().getEveningDiastolic() == -1) {
                diastolic.setText("Записи відсутні");
            } else {
                diastolic.setText(String.valueOf(Model.getInstance().getSelectedTemperatureSheetRecord().getEveningDiastolic()));
            }
            executor.setText(String.valueOf(Model.getInstance().getSelectedTemperatureSheetRecord().getEveningExecutor()));
            additional_info.setText(Model.getInstance().getSelectedTemperatureSheetRecord().getEveningAdditionalInfo());
        }

        close_button.setOnAction(event -> onClose());
    }

    private void onClose() {
        Stage stage = (Stage) close_button.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }
}