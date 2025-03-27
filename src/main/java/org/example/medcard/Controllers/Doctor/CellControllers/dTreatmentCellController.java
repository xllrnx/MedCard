package org.example.medcard.Controllers.Doctor.CellControllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.example.medcard.Models.Records.TreatmentRecord;
import org.example.medcard.Utils.TreatmentRecordStatuses;

import java.net.URL;
import java.util.ResourceBundle;

public class dTreatmentCellController implements Initializable {

    public Circle status_circle;
    public Text prescription;
    public Text prescription_time;
    public Button info_button;
    public Button edit_button;

    private final TreatmentRecord treatmentRecord;

    public dTreatmentCellController(TreatmentRecord treatmentRecord) {
        this.treatmentRecord = treatmentRecord;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tooltip tooltip = new Tooltip();
        Tooltip.install(status_circle, tooltip);
        tooltip.setShowDelay(Duration.millis(100));

        if (treatmentRecord.getStatusProperty().getValue().equals(TreatmentRecordStatuses.DONE.getStatus())) {
            status_circle.setFill(Color.GREEN);
            status_circle.setOnMouseEntered(event -> tooltip.setText("Виконано."));
        } else if (treatmentRecord.getStatusProperty().getValue().equals(TreatmentRecordStatuses.PLANNED.getStatus())) {
            status_circle.setFill(Color.GREY);
            status_circle.setOnMouseEntered(event -> tooltip.setText("Заплановано."));
        } else if (treatmentRecord.getStatusProperty().getValue().equals(TreatmentRecordStatuses.CANCELED.getStatus())) {
            status_circle.setFill(Color.RED);
            status_circle.setOnMouseEntered(event -> tooltip.setText("Скасовано."));
        } else {
            status_circle.setFill(Color.BLACK);
            status_circle.setOnMouseEntered(event -> tooltip.setText("Невідомо."));
        }

        prescription.textProperty().bind(treatmentRecord.getPrescriptionProperty());
        prescription_time.textProperty().bind(treatmentRecord.getPrescriptionTimeStringProperty());

        info_button.setOnAction(event -> onInfo());
        edit_button.setOnAction(event -> onEdit());
    }

    private void onInfo() {

    }

    private void onEdit() {

    }

}
