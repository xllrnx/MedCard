package org.example.medcard.Controllers.Doctor.RecordControllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;
import org.example.medcard.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class DeletePatientController implements Initializable  {
    public Text patient_surname;
    public Text patient_name;
    public Text patient_fathername;
    public Button confirm_button;
    public Button cancel_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        patient_surname.setText(Model.getInstance().getPatientToDelete().getSurnameProperty().getValue());
        patient_name.setText(Model.getInstance().getPatientToDelete().getNameProperty().getValue());
        patient_fathername.setText(Model.getInstance().getPatientToDelete().getFathernameProperty().getValue());

        confirm_button.setOnAction(event -> onConfirm());
        cancel_button.setOnAction(event -> onCancel());
    }

    private void onConfirm() {
        Stage stage = (Stage) confirm_button.getScene().getWindow();

        Model.getInstance().deletePatient(Model.getInstance().getPatientToDelete());

        if (Model.getInstance().getPatientToDelete() == Model.getInstance().getSelectedPatient()) {
            Model.getInstance().setSelectedPatient(null);
            DoctorControllerManager.getDSelectPatientController().updateSelectedPatient(null);
        }

        Model.getInstance().setPatientToDelete(null);

        DoctorControllerManager.getDSelectPatientController().updateList();
        Model.getInstance().getViewFactory().closeStage(stage);
    }

    private void onCancel() {
        Stage stage = (Stage) cancel_button.getScene().getWindow();

        Model.getInstance().setPatientToDelete(null);
        Model.getInstance().getViewFactory().closeStage(stage);
    }
}
