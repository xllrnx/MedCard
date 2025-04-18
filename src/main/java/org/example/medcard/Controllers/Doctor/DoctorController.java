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
                case SelectPatient :
                    doctor_parent.setCenter(Model.getInstance().getViewFactory().getDoctorSelectPatientView());
                    break;

                case Information :
                    if (Model.getInstance().getSelectedPatient() != null) {
                        doctor_parent.setCenter(Model.getInstance().getViewFactory().getDoctorInformationView());
                    } else {
                        doctor_parent.setCenter(Model.getInstance().getViewFactory().getDoctorWithoutPatientView());
                    }
                    break;

                case Treatment :
                    if (Model.getInstance().getSelectedPatient() != null) {
                        doctor_parent.setCenter(Model.getInstance().getViewFactory().getDoctorTreatmentView());
                    } else {
                        doctor_parent.setCenter(Model.getInstance().getViewFactory().getDoctorWithoutPatientView());
                    }
                    break;

                case Diagnosis :
                    if (Model.getInstance().getSelectedPatient() != null) {
                        doctor_parent.setCenter(Model.getInstance().getViewFactory().getDoctorDiagnosisView());
                    } else {
                        doctor_parent.setCenter(Model.getInstance().getViewFactory().getDoctorWithoutPatientView());
                    }
                    break;

                case TemperatureSheet :
                    if (Model.getInstance().getSelectedPatient() != null) {
                        doctor_parent.setCenter(Model.getInstance().getViewFactory().getDoctorTemperatureSheetView());
                    } else {
                        doctor_parent.setCenter(Model.getInstance().getViewFactory().getDoctorWithoutPatientView());
                    }
                    break;

                default :
                    doctor_parent.setCenter(Model.getInstance().getViewFactory().getDoctorHelloView());
                    break;
            }
        });
    }
}
