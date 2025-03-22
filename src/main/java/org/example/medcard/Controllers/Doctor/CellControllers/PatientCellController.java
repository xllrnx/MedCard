package org.example.medcard.Controllers.Doctor.CellControllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import org.example.medcard.Controllers.Doctor.DashboardsControllers.*;
import org.example.medcard.Controllers.Doctor.DoctorController;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Patient;

import java.net.URL;
import java.util.ResourceBundle;

public class PatientCellController implements Initializable {

    public Circle status_circle;
    public Text patient_surname;
    public Text patient_name;
    public Text patient_fathername;
    public Text patient_date_of_birth;
    public Button select_button;
    public Button delete_button;

    private final Patient patient;

    public PatientCellController(Patient patient) {
        this.patient = patient;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if (patient.getStatus()) {
            status_circle.setFill(Color.GREEN);
        } else {
            status_circle.setFill(Color.RED);
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

        updateController(DoctorControllerManager.getDoctorSelectPatientController());
        updateController(DoctorControllerManager.getDoctorInformationController());
        updateController(DoctorControllerManager.getDoctorTreatmentController());
        updateController(DoctorControllerManager.getDoctorDiagnosisController());
        updateController(DoctorControllerManager.getDoctorTemperatureSheetController());
    }

    private void updateController(DoctorDashboardController controller) {
        if (controller != null) {
            controller.updateSelectedPatient(patient);
            controller.updateList();
        }
    }


    private void onDelete() {
        Model.getInstance().setPatientToDelete(this.patient);
        Model.getInstance().getViewFactory().showDoctorDeletePatientWindow();
    }
}
