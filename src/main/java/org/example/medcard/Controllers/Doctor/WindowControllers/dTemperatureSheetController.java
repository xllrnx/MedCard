package org.example.medcard.Controllers.Doctor.WindowControllers;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Records.TemperatureSheetRecord;
import org.example.medcard.Models.Records.TreatmentRecord;
import org.example.medcard.Views.CellFactories.TemperatureSheetCellFactory;
import org.example.medcard.Views.CellFactories.TreatmentCellFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class dTemperatureSheetController extends dListviewWindowController implements Initializable {

    public ListView<TemperatureSheetRecord> temperature_sheet_listview;
    private FilteredList<TemperatureSheetRecord> filteredTemperatureSheetRecords;
    private SortedList<TemperatureSheetRecord> sortedTemperatureSheetRecords;

    public RadioButton radio_from_newest, radio_from_oldest;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);
        DoctorControllerManager.setDTemperatureSheetController(this);

        radio_from_newest.setToggleGroup(sortGroup);
        radio_from_newest.setSelected(true);
        radio_from_oldest.setToggleGroup(sortGroup);
    }

    @Override
    public void onAdd() {
        //Model.getInstance().getViewFactory().showDAddTemperatureSheetRecordWindow();
    }

    @Override
    public void updateList() {
        radio_from_newest.setSelected(true);
        searchfield.setText("");

        ObservableList<TemperatureSheetRecord> temperatureSheetRecords = Model.getInstance().getSelectedPatient().getTemperatureSheetRecords();
        temperatureSheetRecords.sort(Comparator.comparing((TemperatureSheetRecord temperatureSheetRecord) -> temperatureSheetRecord.getCheckDateProperty().get()).reversed());

        filteredTemperatureSheetRecords = new FilteredList<>(temperatureSheetRecords, p -> true);
        sortedTemperatureSheetRecords = new SortedList<>(filteredTemperatureSheetRecords);

        temperature_sheet_listview.setItems(sortedTemperatureSheetRecords);
        temperature_sheet_listview.setCellFactory(e -> new TemperatureSheetCellFactory());
    }

    @Override
    public void filterList() {
        String lowerCaseFilter = searchfield.getText().trim().toLowerCase();

        filteredTemperatureSheetRecords.setPredicate(temperatureSheetRecord -> {
            String checkDate = temperatureSheetRecord.getCheckDateStringProperty().get().toLowerCase();
            if (lowerCaseFilter.isEmpty()) {
                return true;
            }
            return checkDate.contains(lowerCaseFilter);
        });
    }

    @Override
    public void sortList() {
        if (radio_from_newest.isSelected()) {
            sortedTemperatureSheetRecords.setComparator(Comparator.comparing((TemperatureSheetRecord temperatureSheetRecord) -> temperatureSheetRecord.getCheckDateProperty().get()).reversed());
        }
        if (radio_from_oldest.isSelected()) {
            sortedTemperatureSheetRecords.setComparator(Comparator.comparing((TemperatureSheetRecord temperatureSheetRecord) -> temperatureSheetRecord.getCheckDateProperty().get()));
        }
    }
}
