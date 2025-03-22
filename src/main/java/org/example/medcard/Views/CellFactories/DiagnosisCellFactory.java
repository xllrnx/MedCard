package org.example.medcard.Views.CellFactories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import org.example.medcard.Controllers.Doctor.CellControllers.DiagnosisCellController;
import org.example.medcard.Controllers.Doctor.CellControllers.TreatmentCellController;
import org.example.medcard.Models.Records.DiagnosisRecord;

public class DiagnosisCellFactory extends ListCell<DiagnosisRecord> {
    @Override
    protected void updateItem(DiagnosisRecord diagnosisRecord, boolean empty) {
        super.updateItem(diagnosisRecord, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            //CellController controller = getController(record);
            //FXMLLoader loader = new FXMLLoader(getClass().getResource(getLoader(record)));

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Cells/DiagnosisCell.fxml"));
            DiagnosisCellController controller = new DiagnosisCellController(diagnosisRecord);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*private Object getController(Record record) {
        return switch (record) {
            case DiagnosisRecord -> new DiagnosisCellController(record);
            case TreatmentRecord -> new TreatmentCellController(record);
            default -> null;
        };
    }

    private String getLoader(Record record) {
        return switch (record) {
            case DiagnosisRecord -> "/Fxml/Doctor/Cells/DiagnosisCell.fxml";
            case TreatmentRecord -> "/Fxml/Doctor/Cells/TreatmentCell.fxml";
            default -> null;
        };
    }*/
}
