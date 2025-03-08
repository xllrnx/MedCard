package org.example.medcard.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import org.example.medcard.Controllers.Doctor.PatientCellController;
import org.example.medcard.Models.Patient;

public class PatientCellFactory extends ListCell<Patient> {
    @Override
    protected void updateItem(Patient patient, boolean empty) {
        super.updateItem(patient, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/PatientCell.fxml"));
            PatientCellController controller = new PatientCellController(patient);
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
