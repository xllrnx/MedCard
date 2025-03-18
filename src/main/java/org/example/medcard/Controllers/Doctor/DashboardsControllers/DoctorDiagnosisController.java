package org.example.medcard.Controllers.Doctor.DashboardsControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorDiagnosisController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DoctorControllerManager.setDoctorDiagnosisController(this);
    }

}
