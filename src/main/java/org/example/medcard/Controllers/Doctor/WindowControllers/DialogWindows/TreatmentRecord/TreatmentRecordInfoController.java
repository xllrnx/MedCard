package org.example.medcard.Controllers.Doctor.WindowControllers.DialogWindows.TreatmentRecord;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.medcard.Models.Model;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TreatmentRecordInfoController implements Initializable {

    public Text drug;
    public Text method;
    public Text prescription_date;
    public Text prescription_time;
    public Text author;
    public Text status;
    public Text executor;
    public Text additional_info;

    public Button close_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        drug.setText(Model.getInstance().getSelectedTreatmentRecord().getDrug());
        method.setText(Model.getInstance().getSelectedTreatmentRecord().getMethod());

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        prescription_date.setText(Model.getInstance().getSelectedTreatmentRecord().getPrescriptionDate().format(dateFormatter));

        prescription_time.setText(Model.getInstance().getSelectedTreatmentRecord().getPrescriptionTime().toString());
        author.setText(Model.getInstance().getSelectedTreatmentRecord().getAuthor());
        status.setText(Model.getInstance().getSelectedTreatmentRecord().getStatus());
        executor.setText(Model.getInstance().getSelectedTreatmentRecord().getExecutor());
        additional_info.setText(Model.getInstance().getSelectedTreatmentRecord().getAdditionalInfo());

        close_button.setOnAction(event -> onClose());
    }

    private void onClose() {
        Stage stage = (Stage) close_button.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }
}