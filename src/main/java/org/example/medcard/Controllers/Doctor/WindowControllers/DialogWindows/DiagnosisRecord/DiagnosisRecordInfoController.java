package org.example.medcard.Controllers.Doctor.WindowControllers.DialogWindows.DiagnosisRecord;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.medcard.Models.Model;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DiagnosisRecordInfoController implements Initializable {

    public Text analysis;
    public Text cabinet;
    public Text prescription_date;
    public Text prescription_time;
    public Text author;
    public Text status;
    public Text executor;
    public Text result;
    public Text additional_info;

    public Button close_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        analysis.setText(Model.getInstance().getSelectedDiagnosisRecord().getAnalysis());
        cabinet.setText(Model.getInstance().getSelectedDiagnosisRecord().getCabinet());

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        prescription_date.setText(Model.getInstance().getSelectedDiagnosisRecord().getPrescriptionDate().format(dateFormatter));

        prescription_time.setText(Model.getInstance().getSelectedDiagnosisRecord().getPrescriptionTime().toString());
        author.setText(Model.getInstance().getSelectedDiagnosisRecord().getAuthor());
        status.setText(Model.getInstance().getSelectedDiagnosisRecord().getStatus());
        executor.setText(Model.getInstance().getSelectedDiagnosisRecord().getExecutor());
        result.setText(Model.getInstance().getSelectedDiagnosisRecord().getResults());
        additional_info.setText(Model.getInstance().getSelectedDiagnosisRecord().getAdditionalInfo());

        close_button.setOnAction(event -> onClose());
    }

    private void onClose() {
        Stage stage = (Stage) close_button.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }
}