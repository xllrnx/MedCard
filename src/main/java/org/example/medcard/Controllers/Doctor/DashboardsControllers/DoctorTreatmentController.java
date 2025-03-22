package org.example.medcard.Controllers.Doctor.DashboardsControllers;

import javafx.collections.transformation.FilteredList;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Records.TreatmentRecord;
import org.example.medcard.Views.CellFactories.TreatmentCellFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorTreatmentController extends DoctorDashboardController implements Initializable {

    public ListView<TreatmentRecord> treatment_listview;
    private FilteredList<TreatmentRecord> filteredTreatmentRecords;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DoctorControllerManager.setDoctorTreatmentController(this);

        updateSelectedPatient(Model.getInstance().getSelectedPatient());
        updateList();

        /*
        if(Model.getInstance().getSelectedPatient()) {
            treatment_listview.setItems(Model.getInstance().getTreatmentRecords(Model.getInstance().getSelectedPatient().PatientID()));
            treatment_listview.setCellFactory(e -> new TreatmentCellFactory());
        } else {

        }




        */

    }

    @Override
    public void updateList() {
        filteredTreatmentRecords = new FilteredList<>(Model.getInstance().getSelectedPatient().getTreatmentRecords(), p -> true);

        treatment_listview.setItems(filteredTreatmentRecords);
        treatment_listview.setCellFactory(e -> new TreatmentCellFactory());
    }
}
