package org.example.medcard.Controllers.Doctor.WindowControllers;

import javafx.fxml.Initializable;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;
import org.example.medcard.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class dInformationController extends dListviewWindowController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DoctorControllerManager.setDInformationController(this);

        updateSelectedPatient(Model.getInstance().getSelectedPatient());
    }
}
