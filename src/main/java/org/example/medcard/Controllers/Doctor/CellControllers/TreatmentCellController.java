package org.example.medcard.Controllers.Doctor.CellControllers;

import javafx.fxml.Initializable;
import org.example.medcard.Models.TreatmentRecord;

import java.net.URL;
import java.util.ResourceBundle;

public class TreatmentCellController implements Initializable {

    private final TreatmentRecord treatmentRecord;

    public TreatmentCellController(TreatmentRecord treatmentRecord) {
        this.treatmentRecord = treatmentRecord;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
