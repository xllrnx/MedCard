package org.example.medcard.Controllers.Doctor;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorDiagnosisController implements Initializable {
    @FXML
    public Text doctor_surname;
    @FXML
    public Text doctor_name;
    @FXML
    public Text patient_surname;
    @FXML
    public Text patient_name;
    @FXML
    public Text patient_fathername;
    @FXML
    public Button choose_patient_button;
    @FXML
    public Button information_button;
    @FXML
    public Button treatment_button;
    @FXML
    public Button diagnosis_button;
    @FXML
    public Button temperature_sheet_button;
    @FXML
    public Button exit_button;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
