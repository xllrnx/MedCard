package org.example.medcard.Controllers.Doctor.CellControllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.example.medcard.Controllers.Doctor.DashboardsControllers.DoctorSelectPatientController;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Patient;

import java.net.URL;
import java.util.ResourceBundle;

public class PatientCellController implements Initializable {

    //private DoctorSelectPatientController parentController;

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
        patient_surname.textProperty().bind(patient.SurnameProperty());
        patient_name.textProperty().bind(patient.NameProperty());
        patient_fathername.textProperty().bind(patient.FathernameProperty());
        patient_date_of_birth.textProperty().bind(patient.DateOfBirthProperty().asString());

        select_button.setOnAction(event -> onSelect());
        delete_button.setOnAction(event -> onDelete());

    }

    private void onSelect() {
        Model.getInstance().setSelectedPatient(this.patient);

        System.out.printf("Patient selected: " + this.patient.SurnameProperty().get()
                + " " + this.patient.NameProperty().get() + " " + this.patient.FathernameProperty().get() + "\n");
        System.out.println("Model selected patient: " + Model.getInstance().getSelectedPatient().SurnameProperty().get()
                + " " + Model.getInstance().getSelectedPatient().NameProperty().get() + " " + Model.getInstance().getSelectedPatient().FathernameProperty().get() + "\n");

        DoctorSelectPatientController selectPatientController = DoctorControllerManager.getDoctorSelectPatientController();
        selectPatientController.updateSelectedPatient(patient);

    }

    private void onDelete() {
    }
}
