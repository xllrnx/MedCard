package org.example.medcard.Views.CellFactories;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import org.example.medcard.Controllers.Doctor.CellControllers.dTemperatureSheetCellController;
import org.example.medcard.Models.Records.TemperatureSheetRecord;

public class TemperatureSheetCellFactory extends ListCell<TemperatureSheetRecord> {
    @Override
    protected void updateItem(TemperatureSheetRecord temperatureSheetRecord, boolean empty) {
        super.updateItem(temperatureSheetRecord, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Cells/TemperatureSheetCell.fxml"));
            dTemperatureSheetCellController controller = new dTemperatureSheetCellController(temperatureSheetRecord);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
