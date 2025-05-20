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
import org.example.medcard.Models.Records.DiagnosisRecord;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DDiagnosisCellController implements Initializable {

    public Circle status_circle;
    public Text analysis;
    public Text prescription_date;
    public Text prescription_time;
    public Button info_button;
    public Button edit_button;

    private final DiagnosisRecord diagnosisRecord;

    public DDiagnosisCellController(DiagnosisRecord diagnosisRecord) {
        this.diagnosisRecord = diagnosisRecord;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tooltip tooltip = new Tooltip();
        Tooltip.install(status_circle, tooltip);
        tooltip.setShowDelay(Duration.millis(100));
        switch (diagnosisRecord.getStatus()) {
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


        analysis.textProperty().bind(new SimpleObjectProperty<>(diagnosisRecord.getAnalysis()));
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        prescription_date.textProperty().bind(new SimpleObjectProperty<>(diagnosisRecord.getPrescriptionDate().format(dateFormatter)));
        prescription_time.textProperty().bind(new SimpleObjectProperty<>(diagnosisRecord.getPrescriptionTime().toString()));

        info_button.setOnAction(event -> onInfo());
        edit_button.setOnAction(event -> onEdit());
    }

    private void onInfo() {
        Model.getInstance().setSelectedDiagnosisRecord(this.diagnosisRecord);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/DialogWindows/DiagnosisRecord/DiagnosisRecordInfo.fxml"));
        DWindowControllerManager.getDDiagnosisController().showDialogWindow(loader, (Stage) Model.getInstance().getViewFactory().getDoctorDiagnosisView().getScene().getWindow());
    }

    private void onEdit() {
        Model.getInstance().setSelectedDiagnosisRecord(this.diagnosisRecord);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/DialogWindows/Patient/DiagnosisRecordEdit.fxml"));
        DWindowControllerManager.getDDiagnosisController().showDialogWindow(loader, (Stage) Model.getInstance().getViewFactory().getDoctorDiagnosisView().getScene().getWindow());
    }

}
