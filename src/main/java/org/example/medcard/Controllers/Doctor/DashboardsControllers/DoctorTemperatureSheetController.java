package org.example.medcard.Controllers.Doctor.DashboardsControllers;

import javafx.collections.transformation.FilteredList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Records.TemperatureSheetRecord;
import org.example.medcard.Models.Records.TreatmentRecord;
import org.example.medcard.Views.CellFactories.TemperatureSheetCellFactory;
import org.example.medcard.Views.CellFactories.TreatmentCellFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorTemperatureSheetController extends DoctorDashboardController implements Initializable {

    public ListView<TemperatureSheetRecord> temperature_sheet_listview;
    private FilteredList<TemperatureSheetRecord> filteredTemperatureSheetRecords;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DoctorControllerManager.setDoctorTemperatureSheetController(this);

        updateSelectedPatient(Model.getInstance().getSelectedPatient());
    }

    @Override
    public void updateList() {
        filteredTemperatureSheetRecords = new FilteredList<>(Model.getInstance().getSelectedPatient().getTemperatureSheetRecords(), p -> true);

        temperature_sheet_listview.setItems(filteredTemperatureSheetRecords);
        temperature_sheet_listview.setCellFactory(e -> new TemperatureSheetCellFactory());
    }

}
