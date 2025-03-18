package org.example.medcard.Controllers.Doctor.DashboardsControllers;

import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.TreatmentRecord;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorTreatmentController implements Initializable {

    public Text selected_patient_info;
    public Text selected_patient_surname;
    public Text selected_patient_name;
    public Text selected_patient_fathername;

    public ListView<TreatmentRecord> treatment_listview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DoctorControllerManager.setDoctorTreatmentController(this);

        if (Model.getInstance().getSelectedPatient().PatientID() == -1) {
            selected_patient_info.setText("Пацієнт для роботи не обраний.");
        } else {
            selected_patient_info.setText("Обраний пацієнт:");
        }

        selected_patient_surname.setText(Model.getInstance().getSelectedPatient().SurnameProperty().get());
        System.out.printf("selected_patient_surname = " + selected_patient_surname.getText() + "\n");
        selected_patient_name.setText(Model.getInstance().getSelectedPatient().NameProperty().get());
        System.out.printf("selected_patient_name = " + selected_patient_name.getText() + "\n");
        selected_patient_fathername.setText(Model.getInstance().getSelectedPatient().FathernameProperty().get());
        System.out.printf("selected_patient_fathername = " + selected_patient_fathername.getText() + "\n");


        /*
        if(Model.getInstance().getSelectedPatient()) {
            treatment_listview.setItems(Model.getInstance().getTreatmentRecords(Model.getInstance().getSelectedPatient().PatientID()));
            treatment_listview.setCellFactory(e -> new TreatmentCellFactory());
        } else {

        }




        */

    }
}
