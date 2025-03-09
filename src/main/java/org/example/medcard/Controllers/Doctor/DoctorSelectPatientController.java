package org.example.medcard.Controllers.Doctor;


import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Patient;
import org.example.medcard.Views.PatientCellFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorSelectPatientController implements Initializable {


    public Text selected_patient_surname;
    public Text selected_patient_name;
    public Text selected_patient_fathername;
    public TextField search_field;
    public Button clear_searchfield_button;
    public Button add_button;
    public ListView<Patient> patients_listview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clear_searchfield_button.setOnAction(event -> onClear());
        initData();
        patients_listview.setItems(Model.getInstance().getPatients());
        patients_listview.setCellFactory(e -> new PatientCellFactory());
    }

    public void initData() {
        if (Model.getInstance().getPatients().isEmpty()) {
            Model.getInstance().setPatients();
        }
    }

    private void onClear() {
        search_field.setText("");
    }

}
