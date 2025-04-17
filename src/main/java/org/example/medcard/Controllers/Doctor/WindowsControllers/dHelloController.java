package org.example.medcard.Controllers.Doctor.WindowsControllers;

import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;
import org.example.medcard.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class dHelloController implements Initializable {

    public Text user_surname;
    public Text user_name;
    public Text user_fathername;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DoctorControllerManager.setDHelloController(this);

        user_surname.setText(Model.getInstance().getUser().getSurname());
        user_name.setText(Model.getInstance().getUser().getName());
        user_fathername.setText(Model.getInstance().getUser().getFatherName());
    }
}
