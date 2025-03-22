package org.example.medcard.Controllers.Doctor.DashboardsControllers;

import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Records.DiagnosisRecord;
import org.example.medcard.Views.CellFactories.DiagnosisCellFactory;
import org.example.medcard.Views.CellFactories.TemperatureSheetCellFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorDiagnosisController extends DoctorDashboardController implements Initializable {

    public ListView<DiagnosisRecord> diagnosis_listview;
    private FilteredList<DiagnosisRecord> filteredDiagnosisRecords;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DoctorControllerManager.setDoctorDiagnosisController(this);

        updateSelectedPatient(Model.getInstance().getSelectedPatient());
    }

    @Override
    public void updateList() {
        filteredDiagnosisRecords = new FilteredList<>(Model.getInstance().getSelectedPatient().getDiagnosisRecords(), p -> true);

        diagnosis_listview.setItems(filteredDiagnosisRecords);
        diagnosis_listview.setCellFactory(e -> new DiagnosisCellFactory());
    }

}
