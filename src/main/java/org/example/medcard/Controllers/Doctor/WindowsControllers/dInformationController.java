package org.example.medcard.Controllers.Doctor.WindowsControllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Patient;

import java.net.URL;
import java.util.ResourceBundle;

public class dInformationController implements Initializable {
    public Text selected_patient_surname;
    public Text selected_patient_name;
    public Text selected_patient_fathername;
    public Text patient_surname;
    public Text patient_name;
    public Text patient_fathername;
    public Text patient_date_of_birth;
    public Text patient_complaints;
    public Text patient_medical_history;
    public Button edit_patient_info_button;
    public Button edit_complaints_button;
    public Button edit_medical_history_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DoctorControllerManager.setDInformationController(this);
        updateSelectedPatient(Model.getInstance().getSelectedPatient());
        updateInfo(Model.getInstance().getSelectedPatient());

        edit_patient_info_button.setOnAction(event -> onEditPatientInfo());
        edit_complaints_button.setOnAction(event -> onEditComplaints());
        edit_medical_history_button.setOnAction(event -> onEditMedicalHistory());
    }

    public void updateSelectedPatient(Patient patient) {
        selected_patient_surname.setText(patient.getSurnameProperty().get());
        selected_patient_name.setText(patient.getNameProperty().get());
        selected_patient_fathername.setText(patient.getFathernameProperty().get());
    }

    public void updateInfo(Patient patient) {
        patient_surname.setText(patient.getSurnameProperty().get());
        patient_name.setText(patient.getNameProperty().get());
        patient_fathername.setText(patient.getFathernameProperty().get());
        patient_date_of_birth.setText(patient.getDateOfBirthStringProperty().get());
        patient_complaints.setText(patient.getComplaintsProperty().get());
        patient_medical_history.setText(patient.getMedicalHistoryProperty().get());
    }


    public void onEditPatientInfo(){}
    public void onEditComplaints() {}
    public void onEditMedicalHistory() {}


}
