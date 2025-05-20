package org.example.medcard.Controllers.Doctor.CellControllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.medcard.Controllers.Doctor.WindowControllers.DWindowControllerManager;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Records.TreatmentRecord;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DTreatmentCellController implements Initializable {

    public Circle status_circle;
    public Text drug;
    public Text prescription_date;
    public Text prescription_time;

    public Button info_button;
    public Button edit_button;

    private final TreatmentRecord treatmentRecord;

    public DTreatmentCellController(TreatmentRecord treatmentRecord) {
        this.treatmentRecord = treatmentRecord;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tooltip tooltip = new Tooltip();
        Tooltip.install(status_circle, tooltip);
        tooltip.setShowDelay(Duration.millis(100));
        switch (treatmentRecord.getStatus()) {
            case "Виконано":
                status_circle.setFill(Color.GREEN);
                status_circle.setOnMouseEntered(event -> tooltip.setText("Виконано"));
                break;
            case "Заплановано" :
                status_circle.setFill(Color.GREY);
                status_circle.setOnMouseEntered(event -> tooltip.setText("Заплановано"));
                break;
            case "Скасовано" :
                status_circle.setFill(Color.RED);
                status_circle.setOnMouseEntered(event -> tooltip.setText("Скасовано"));
                break;
            default :
                status_circle.setFill(Color.WHITE);
                status_circle.setOnMouseEntered(event -> tooltip.setText("Невідомо"));
                break;
        }

        drug.textProperty().bind(new SimpleObjectProperty<>(treatmentRecord.getDrug()));
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        prescription_date.textProperty().bind(new SimpleObjectProperty<>(treatmentRecord.getPrescriptionDate().format(dateFormatter)));
        prescription_time.textProperty().bind(new SimpleObjectProperty<>(treatmentRecord.getPrescriptionTime().toString()));

        info_button.setOnAction(event -> onInfo());
        edit_button.setOnAction(event -> onEdit());
    }

    private void onInfo() {
        Model.getInstance().setSelectedTreatmentRecord(this.treatmentRecord);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/DialogWindows/TreatmentRecord/TreatmentRecordInfo.fxml"));
        DWindowControllerManager.getDTreatmentController().showDialogWindow(loader, (Stage) Model.getInstance().getViewFactory().getDoctorTreatmentView().getScene().getWindow());
    }

    private void onEdit() {
        Model.getInstance().setSelectedTreatmentRecord(this.treatmentRecord);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/DialogWindows/TreatmentRecord/TreatmentRecordEdit.fxml"));
        DWindowControllerManager.getDTreatmentController().showDialogWindow(loader, (Stage) Model.getInstance().getViewFactory().getDoctorTreatmentView().getScene().getWindow());
    }
}