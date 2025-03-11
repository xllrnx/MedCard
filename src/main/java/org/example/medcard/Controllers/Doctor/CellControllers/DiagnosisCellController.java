package org.example.medcard.Controllers.Doctor.CellControllers;

import javafx.fxml.Initializable;
import org.example.medcard.Models.DiagnosisRecord;

import java.net.URL;
import java.util.ResourceBundle;

public class DiagnosisCellController implements Initializable {

    private final DiagnosisRecord diagnosisRecord;

    public DiagnosisCellController(DiagnosisRecord diagnosisRecord) {
        this.diagnosisRecord = diagnosisRecord;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
