package org.example.medcard.Controllers.Doctor;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.example.medcard.Models.Patient;

import java.net.URL;
import java.util.ResourceBundle;

public class PatientCellController implements Initializable {
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
    }
}
