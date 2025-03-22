package org.example.medcard.Controllers.Doctor.DashboardsControllers;

import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;
import org.example.medcard.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorInformationController extends DoctorDashboardController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DoctorControllerManager.setDoctorInformationController(this);

        updateSelectedPatient(Model.getInstance().getSelectedPatient());
    }
}
