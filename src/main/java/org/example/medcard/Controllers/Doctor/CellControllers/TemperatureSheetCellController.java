package org.example.medcard.Controllers.Doctor.CellControllers;

import javafx.fxml.Initializable;
import org.example.medcard.Models.Records.TemperatureSheetRecord;

import java.net.URL;
import java.util.ResourceBundle;

public class TemperatureSheetCellController implements Initializable {

    private final TemperatureSheetRecord temperatureSheetRecord;

    public TemperatureSheetCellController(TemperatureSheetRecord temperatureSheetRecord) {
        this.temperatureSheetRecord = temperatureSheetRecord;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
