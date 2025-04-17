package org.example.medcard.Controllers.Doctor.WindowsControllers.ListviewWindows;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;
import org.example.medcard.Controllers.Doctor.RecordsControllers.TemperatureSheetRecord.DeleteTemperatureSheetRecordController;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Records.TemperatureSheetRecord;
import org.example.medcard.Views.Doctor.CellFactories.TemperatureSheetCellFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;
import java.util.ResourceBundle;

public class dTemperatureSheetController extends dListviewWindowController implements Initializable {

    public ListView<TemperatureSheetRecord> temperature_sheet_listview;
    private ObservableList<TemperatureSheetRecord> temperatureSheetRecords;
    private FilteredList<TemperatureSheetRecord> filteredTemperatureSheetRecords;
    private SortedList<TemperatureSheetRecord> sortedTemperatureSheetRecords;

    public RadioButton radio_from_newest, radio_from_oldest;
    public CheckBox check_status_done, check_status_undone;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);
        DoctorControllerManager.setDTemperatureSheetController(this);

        radio_from_newest.setToggleGroup(sortGroup);
        radio_from_newest.setSelected(true);
        radio_from_oldest.setToggleGroup(sortGroup);
    }

    @Override
    public void addRecord() {
        boolean isToday = false;
        for (TemperatureSheetRecord record : temperatureSheetRecords) {
            if (Objects.equals(record.getCheckDateProperty().get(), LocalDate.now())) {
                isToday = true;
            }
        }
        if (!isToday) {
            //Model.getInstance().addTemperatureSheetRecord(Model.getInstance().getSelectedPatient());
        }
    }

    @Override
    public void deleteRecord() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/RecordsWindows/DeleteTemperatureSheetRecord.fxml"));
        DeleteTemperatureSheetRecordController deleteTemperatureSheetRecordController = new DeleteTemperatureSheetRecordController();
        loader.setController(deleteTemperatureSheetRecordController);
        showDialogWindow(loader, (Stage) Model.getInstance().getViewFactory().getDoctorTemperatureSheetView().getScene().getWindow());
    }

    @Override
    public void updateList() {
        radio_from_newest.setSelected(true);
        searchfield.setText("");

        temperatureSheetRecords = Model.getInstance().getSelectedPatient().getTemperatureSheetRecords();
        temperatureSheetRecords.sort(Comparator.comparing((TemperatureSheetRecord temperatureSheetRecord) -> temperatureSheetRecord.getCheckDateProperty().get()).reversed());

        filteredTemperatureSheetRecords = new FilteredList<>(temperatureSheetRecords, p -> true);
        sortedTemperatureSheetRecords = new SortedList<>(filteredTemperatureSheetRecords);

        temperature_sheet_listview.setItems(sortedTemperatureSheetRecords);
        temperature_sheet_listview.setCellFactory(e -> new TemperatureSheetCellFactory());
        no_records_warning.setVisible(sortedTemperatureSheetRecords.isEmpty());
    }

    @Override
    public void filterList() {
        String lowerCaseFilter = searchfield.getText().trim().toLowerCase();

//        filteredTemperatureSheetRecords.setPredicate(temperatureSheetRecord -> {
//
//            String checkDate = temperatureSheetRecord.getCheckDateStringProperty().get().toLowerCase();
//
//            String selectedBoxes = getSelectedBoxes();
//
//            switch (selectedBoxes) {
//                case "tf" :
//                    if (lowerCaseFilter.isEmpty()) {
//                        return patientStatus;
//                    }
//                    return patientStatus && checkDate.contains(lowerCaseFilter);
//                case "ft" :
//                    if (lowerCaseFilter.isEmpty()) {
//                        return !patientStatus;
//                    }
//                    return !patientStatus && checkDate.contains(lowerCaseFilter);
//                default :
//                    if (lowerCaseFilter.isEmpty()) {
//                        return true;
//                    }
//                    return checkDate.contains(lowerCaseFilter);
//            }
//        });
    }

    @Override
    public String getSelectedBoxes() {
        String selectedBoxes = "";
        if (check_status_done.isSelected()) {
            selectedBoxes += "t";
        } else {
            selectedBoxes += "f";
        }
        if (check_status_undone.isSelected()) {
            selectedBoxes += "t";
        } else {
            selectedBoxes += "f";
        }
        return selectedBoxes;
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
