package org.example.medcard.Controllers.Doctor.DashboardsControllers;

import javafx.scene.text.Text;
import org.example.medcard.Models.Patient;

public class DoctorDashboardController {
    public Text selected_patient_info;
    public Text selected_patient_surname;
    public Text selected_patient_name;
    public Text selected_patient_fathername;

    public void updateSelectedPatient(Patient patient) {
        if (patient == null) {
            selected_patient_info.setText("Пацієнт для роботи не обраний.");
            selected_patient_surname.setText("");
            selected_patient_name.setText("");
            selected_patient_fathername.setText("");
        } else {
            selected_patient_info.setText("Обраний пацієнт:");
            selected_patient_surname.setText(patient.getSurnameProperty().get());
            selected_patient_name.setText(patient.getNameProperty().get());
            selected_patient_fathername.setText(patient.getFathernameProperty().get());
        }

    }

    public void updateList() {}
}
