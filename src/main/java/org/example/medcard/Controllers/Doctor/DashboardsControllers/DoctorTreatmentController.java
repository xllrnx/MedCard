package org.example.medcard.Controllers.Doctor.DashboardsControllers;

import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import org.example.medcard.Models.TreatmentRecord;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorTreatmentController implements Initializable {

    public Text selected_patient_surname;
    public Text selected_patient_name;
    public Text selected_patient_fathername;

    public ListView<TreatmentRecord> treatment_listview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        selected_patient_surname.setText("");
        selected_patient_name.setText("");
        selected_patient_fathername.setText("");

        /*
        if(Model.getInstance().getSelectedPatient()) {
            treatment_listview.setItems(Model.getInstance().getTreatmentRecords(Model.getInstance().getSelectedPatient().PatientID()));
            treatment_listview.setCellFactory(e -> new TreatmentCellFactory());
        } else {

        }




        */

    }
}
