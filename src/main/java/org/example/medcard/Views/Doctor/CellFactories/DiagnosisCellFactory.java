package org.example.medcard.Views.Doctor.CellFactories;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import org.example.medcard.Controllers.Doctor.CellControllers.DDiagnosisCellController;
import org.example.medcard.Models.Records.DiagnosisRecord;

public class DiagnosisCellFactory extends ListCell<DiagnosisRecord> {
    @Override
    protected void updateItem(DiagnosisRecord diagnosisRecord, boolean empty) {
        super.updateItem(diagnosisRecord, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Cells/DiagnosisCell.fxml"));
            DDiagnosisCellController controller = new DDiagnosisCellController(diagnosisRecord);
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
