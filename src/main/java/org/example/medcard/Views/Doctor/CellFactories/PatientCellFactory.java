package org.example.medcard.Views.Doctor.CellFactories;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import org.example.medcard.Controllers.Doctor.CellsControllers.dPatientCellController;
import org.example.medcard.Models.Patient;

public class PatientCellFactory extends ListCell<Patient> {
    @Override
    protected void updateItem(Patient patient, boolean empty) {
        super.updateItem(patient, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Cells/PatientCell.fxml"));
            dPatientCellController controller = new dPatientCellController(patient);
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
