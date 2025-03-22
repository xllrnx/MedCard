package org.example.medcard.Controllers.Doctor.CellControllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import org.example.medcard.Models.Records.TreatmentRecord;

import java.net.URL;
import java.util.ResourceBundle;

public class TreatmentCellController implements Initializable {

    public Circle status_circle;
    public Text prescription;
    public Text prescription_date;
    public Button info_button;
    public Button edit_button;

    private final TreatmentRecord treatmentRecord;

    public TreatmentCellController(TreatmentRecord treatmentRecord) {
        this.treatmentRecord = treatmentRecord;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (treatmentRecord.getStatus().getValue().equals("done")) {
            status_circle.setFill(Color.GREEN);
        } else if (treatmentRecord.getStatus().getValue().equals("planned")) {
            status_circle.setFill(Color.GREY);
        } else {
            status_circle.setFill(Color.RED);
        }

        prescription.textProperty().bind(treatmentRecord.getPrescriptionProperty());
        prescription_date.textProperty().bind(treatmentRecord.getPrescribedDateProperty().asString());

        info_button.setOnAction(event -> onInfo());
        edit_button.setOnAction(event -> onEdit());
    }

    private void onInfo() {

    }

    private void onEdit() {

    }

}
