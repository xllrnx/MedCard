package org.example.medcard.Controllers.Doctor.CellsControllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Records.TemperatureSheetRecord;

import java.net.URL;
import java.util.ResourceBundle;

public class dTemperatureSheetCellController implements Initializable {

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

    public dTemperatureSheetCellController(TemperatureSheetRecord temperatureSheetRecord) {
        this.temperatureSheetRecord = temperatureSheetRecord;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        check_date.textProperty().bind(temperatureSheetRecord.getCheckDateStringProperty());

        morning_pulse.textProperty().bind(new SimpleStringProperty(String.valueOf(temperatureSheetRecord.getMorningPulse())));
        morning_temperature.textProperty().bind(new SimpleStringProperty(String.valueOf(temperatureSheetRecord.getMorningTemperature())));
        morning_systolic.textProperty().bind(new SimpleStringProperty(String.valueOf(temperatureSheetRecord.getMorningSystolic())));
        morning_diastolic.textProperty().bind(new SimpleStringProperty(String.valueOf(temperatureSheetRecord.getMorningDiastolic())));

        morning_info_button.setOnAction(event -> onInfo("morning"));
        morning_edit_button.setOnAction(event -> onEdit("morning"));

        evening_pulse.textProperty().bind(new SimpleStringProperty(String.valueOf(temperatureSheetRecord.getEveningPulse())));
        evening_temperature.textProperty().bind(new SimpleStringProperty(String.valueOf(temperatureSheetRecord.getEveningTemperature())));
        evening_systolic.textProperty().bind(new SimpleStringProperty(String.valueOf(temperatureSheetRecord.getEveningSystolic())));
        evening_diastolic.textProperty().bind(new SimpleStringProperty(String.valueOf(temperatureSheetRecord.getEveningDiastolic())));

        evening_info_button.setOnAction(event -> onInfo("evening"));
        evening_edit_button.setOnAction(event -> onEdit("evening"));
    }

    private void onInfo(String partOfDay) {
        Model.getInstance().setSelectedTemperatureSheetRecord(this.temperatureSheetRecord);
        //Model.getInstance().getViewFactory().showDoctorTemperatureSheetInfoWindow();
    }

    private void onEdit(String partOfDay) {
        Model.getInstance().setSelectedTemperatureSheetRecord(this.temperatureSheetRecord);
        //Model.getInstance().getViewFactory().showDoctorTemperatureSheetEditWindow();
    }
}
