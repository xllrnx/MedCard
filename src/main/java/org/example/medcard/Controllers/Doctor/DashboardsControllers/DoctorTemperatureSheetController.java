package org.example.medcard.Controllers.Doctor.DashboardsControllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorTemperatureSheetController implements Initializable {
    public Text doctor_surname;
    public Text doctor_name;
    public Text patient_surname;
    public Text patient_name;
    public Text patient_fathername;
    public Button choose_patient_button;
    public Button information_button;
    public Button treatment_button;
    public Button diagnosis_button;
    public Button temperature_sheet_button;
    public Button exit_button;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DoctorControllerManager.setDoctorTemperatureSheetController(this);
    }

}
