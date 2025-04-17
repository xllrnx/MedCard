package org.example.medcard.Controllers.Doctor.CellsControllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;
import org.example.medcard.Controllers.Doctor.WindowsControllers.ListviewWindows.dListviewWindowController;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Patient;

import java.net.URL;
import java.util.ResourceBundle;

public class dPatientCellController implements Initializable {

    public Circle status_circle;
    public Text patient_surname;
    public Text patient_name;
    public Text patient_fathername;
    public Text patient_date_of_birth;
    public Button select_button;
    public Button delete_button;

    private final Patient patient;

    public dPatientCellController(Patient patient) {
        this.patient = patient;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tooltip tooltip = new Tooltip();
        Tooltip.install(status_circle, tooltip);
        tooltip.setShowDelay(Duration.millis(100));
        if (patient.getStatus()) {
            status_circle.setFill(Color.GREEN);
            status_circle.setOnMouseEntered(event -> tooltip.setText("На стаціонарі."));
        } else {
            status_circle.setFill(Color.RED);
            status_circle.setOnMouseEntered(event -> tooltip.setText("Виписаний."));
        }

        patient_surname.textProperty().bind(patient.getSurnameProperty());
        patient_name.textProperty().bind(patient.getNameProperty());
        patient_fathername.textProperty().bind(patient.getFathernameProperty());
        patient_date_of_birth.textProperty().bind(patient.getDateOfBirthStringProperty());

        select_button.setOnAction(event -> onSelect());
        delete_button.setOnAction(event -> onDelete());
    }

    private void onSelect() {
        Model.getInstance().setSelectedPatient(this.patient);

        System.out.printf("Patient selected: " + this.patient.getSurnameProperty().get()
                + " " + this.patient.getNameProperty().get() + " " + this.patient.getFathernameProperty().get() + "\n");
        System.out.println("Model selected patient: " + Model.getInstance().getSelectedPatient().getSurnameProperty().get()
                + " " + Model.getInstance().getSelectedPatient().getNameProperty().get() + " " + Model.getInstance().getSelectedPatient().getFathernameProperty().get() + "\n");

        DoctorControllerManager.getDSelectPatientController().updateSelectedPatient(this.patient);
        if (DoctorControllerManager.getDInformationController() != null) {
            DoctorControllerManager.getDInformationController().updateSelectedPatient(this.patient);
        }
        updateListController(DoctorControllerManager.getDTreatmentController());
        updateListController(DoctorControllerManager.getDDiagnosisController());
        updateListController(DoctorControllerManager.getDTemperatureSheetController());
    }
    
    private void updateListController(dListviewWindowController controller) {
        if (controller != null) {
            controller.updateSelectedPatient(this.patient);
            controller.updateList();
        }
    }

    private void onDelete() {
        Model.getInstance().setPatientToDelete(this.patient);
        DoctorControllerManager.getDSelectPatientController().deleteRecord();
    }
}
