package org.example.medcard.Controllers.Nurse;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import org.example.medcard.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class NurseController implements Initializable {

    public BorderPane nurse_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getNurseSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal) {
                case SelectPatient -> nurse_parent.setCenter(Model.getInstance().getViewFactory().getNurseSelectPatientView());
                case Information -> nurse_parent.setCenter(Model.getInstance().getViewFactory().getNurseInformationView());
                case Treatment -> nurse_parent.setCenter(Model.getInstance().getViewFactory().getNurseTreatmentView());
                case Diagnosis -> nurse_parent.setCenter(Model.getInstance().getViewFactory().getNurseDiagnosisView());
                case TemperatureSheet -> nurse_parent.setCenter(Model.getInstance().getViewFactory().getNurseTemperatureSheetView());


                default -> nurse_parent.setCenter(Model.getInstance().getViewFactory().getNurseHelloView());
            }
        });
    }
}
