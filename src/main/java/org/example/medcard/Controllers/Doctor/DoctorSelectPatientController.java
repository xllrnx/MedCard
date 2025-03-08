package org.example.medcard.Controllers.Doctor;


import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorSelectPatientController implements Initializable {


    public Text selected_patient_surname;
    public Text selected_patient_name;
    public Text selected_patient_fathername;
    public TextField search_field;
    public Button clear_searchfield_button;
    public Button add_button;
    public ListView patients_listview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clear_searchfield_button.setOnAction(event -> onClear());
    }

    private void onClear() {
        search_field.setText("");
    }

}
