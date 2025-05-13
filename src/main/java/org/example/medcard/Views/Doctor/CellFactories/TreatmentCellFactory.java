package org.example.medcard.Views.Doctor.CellFactories;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import org.example.medcard.Controllers.Doctor.CellControllers.DTreatmentCellController;
import org.example.medcard.Models.Records.TreatmentRecord;

public class TreatmentCellFactory extends ListCell<TreatmentRecord> {
    @Override
    protected void updateItem(TreatmentRecord treatmentRecord, boolean empty) {
        super.updateItem(treatmentRecord, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Cells/TreatmentCell.fxml"));
            DTreatmentCellController controller = new DTreatmentCellController(treatmentRecord);
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
