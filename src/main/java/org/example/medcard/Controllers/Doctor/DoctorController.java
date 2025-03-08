package org.example.medcard.Controllers.Doctor;


import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import org.example.medcard.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorController implements Initializable {

    public BorderPane doctor_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getDoctorSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal) {
                case SelectPatient -> doctor_parent.setCenter(Model.getInstance().getViewFactory().getDoctorSelectPatientView());
                case Information -> doctor_parent.setCenter(Model.getInstance().getViewFactory().getDoctorInformationView());
                case Treatment -> doctor_parent.setCenter(Model.getInstance().getViewFactory().getDoctorTreatmentView());
                case Diagnosis -> doctor_parent.setCenter(Model.getInstance().getViewFactory().getDoctorDiagnosisView());
                case TemperatureSheet -> doctor_parent.setCenter(Model.getInstance().getViewFactory().getDoctorTemperatureSheetView());


                default -> doctor_parent.setCenter(Model.getInstance().getViewFactory().getDoctorDashboardView());
            }
        });
    }
}
