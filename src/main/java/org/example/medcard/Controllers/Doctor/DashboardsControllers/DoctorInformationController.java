package org.example.medcard.Controllers.Doctor.DashboardsControllers;

import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorInformationController implements Initializable {
    public Text selected_patient_surname;
    public Text selected_patient_name;
    public Text selected_patient_fathername;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DoctorControllerManager.setDoctorInformationController(this);
    }
}
