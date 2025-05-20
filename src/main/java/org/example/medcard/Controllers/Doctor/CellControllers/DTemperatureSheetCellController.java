package org.example.medcard.Controllers.Doctor.CellControllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.medcard.Controllers.Doctor.WindowControllers.DWindowControllerManager;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Records.TemperatureSheetRecord;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DTemperatureSheetCellController implements Initializable {

    public Text check_date;

    public Text morning_pulse;
    public Text morning_temperature;
    public Text morning_systolic;
    public Text morning_diastolic;
    public Button morning_info_button;
    public Button morning_edit_button;

    public Text evening_pulse;
    public Text evening_temperature;
    public Text evening_systolic;
    public Text evening_diastolic;
    public Button evening_info_button;
    public Button evening_edit_button;

    private final TemperatureSheetRecord temperatureSheetRecord;

    public DTemperatureSheetCellController(TemperatureSheetRecord temperatureSheetRecord) {
        this.temperatureSheetRecord = temperatureSheetRecord;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        check_date.textProperty().bind(new SimpleObjectProperty<>(temperatureSheetRecord.getCheckDate().format(dateFormatter)));

        if (temperatureSheetRecord.getMorningPulse() == -1) {
            morning_pulse.setText("");
        } else {
            morning_pulse.setText(String.valueOf(temperatureSheetRecord.getMorningPulse()));
        }
        if (temperatureSheetRecord.getMorningPulse() == -1) {
            morning_temperature.setText("");
        } else {
            morning_temperature.setText(String.valueOf(temperatureSheetRecord.getMorningTemperature()));
        }
        if (temperatureSheetRecord.getMorningPulse() == -1) {
            morning_systolic.setText("");
        } else {
            morning_systolic.setText(String.valueOf(temperatureSheetRecord.getMorningSystolic()));
        }
        if (temperatureSheetRecord.getMorningPulse() == -1) {
            morning_diastolic.setText("");
        } else {
            morning_diastolic.setText(String.valueOf(temperatureSheetRecord.getMorningDiastolic()));
        }

        morning_info_button.setOnAction(event -> onInfo("morning"));
        morning_edit_button.setOnAction(event -> onEdit("morning"));

        if (temperatureSheetRecord.getEveningPulse() == -1) {
            evening_pulse.setText("");
        } else {
            evening_pulse.setText(String.valueOf(temperatureSheetRecord.getEveningPulse()));
        }
        if (temperatureSheetRecord.getEveningTemperature() == -1) {
            evening_temperature.setText("");
        } else {
            evening_temperature.setText(String.valueOf(temperatureSheetRecord.getEveningTemperature()));
        }
        if (temperatureSheetRecord.getEveningSystolic() == -1) {
            evening_systolic.setText("");
        } else {
            evening_systolic.setText(String.valueOf(temperatureSheetRecord.getEveningSystolic()));
        }
        if (temperatureSheetRecord.getEveningDiastolic() == -1) {
            evening_diastolic.setText("");
        } else {
            evening_diastolic.setText(String.valueOf(temperatureSheetRecord.getEveningDiastolic()));
        }

        evening_info_button.setOnAction(event -> onInfo("evening"));
        evening_edit_button.setOnAction(event -> onEdit("evening"));
    }

    private void onInfo(String partOfDay) {
        Model.getInstance().setSelectedTemperatureSheetRecordPoD(partOfDay);
        Model.getInstance().setSelectedTemperatureSheetRecord(this.temperatureSheetRecord);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/DialogWindows/TemperatureSheetRecord/TemperatureSheetRecordInfo.fxml"));
        DWindowControllerManager.getDTemperatureSheetController().showDialogWindow(loader, (Stage) Model.getInstance().getViewFactory().getDoctorTemperatureSheetView().getScene().getWindow());
    }

    private void onEdit(String partOfDay) {
        Model.getInstance().setSelectedTemperatureSheetRecordPoD(partOfDay);
        Model.getInstance().setSelectedTemperatureSheetRecord(this.temperatureSheetRecord);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/DialogWindows/TemperatureSheetRecord/TemperatureSheetRecordEdit.fxml"));
        DWindowControllerManager.getDTemperatureSheetController().showDialogWindow(loader, (Stage) Model.getInstance().getViewFactory().getDoctorTemperatureSheetView().getScene().getWindow());
    }
}
