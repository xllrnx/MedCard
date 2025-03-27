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
import org.example.medcard.Models.Records.TreatmentRecord;
import org.example.medcard.Views.CellFactories.TreatmentCellFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class dTreatmentController extends dListviewWindowController implements Initializable {

    public ListView<TreatmentRecord> treatment_listview;
    private FilteredList<TreatmentRecord> filteredTreatmentRecords;
    private SortedList<TreatmentRecord> sortedTreatmentRecords;

    public RadioButton radio_from_newest, radio_from_oldest;
    public CheckBox check_status_done, check_status_planned, check_status_canceled;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);
        DoctorControllerManager.setDTreatmentController(this);

        radio_from_newest.setToggleGroup(sortGroup);
        radio_from_newest.setSelected(true);
        radio_from_oldest.setToggleGroup(sortGroup);

        check_status_done.selectedProperty().addListener((observable, oldValue, newValue) -> filterList());
        check_status_planned.selectedProperty().addListener((observable, oldValue, newValue) -> filterList());
        check_status_canceled.selectedProperty().addListener((observable, oldValue, newValue) -> filterList());
    }

    @Override
    public void onAdd() {
        //Model.getInstance().getViewFactory().showDAddTreatmentRecordWindow();
    }

    @Override
    public void updateList() {
        radio_from_newest.setSelected(true);
        check_status_done.setSelected(false);
        check_status_planned.setSelected(false);
        check_status_canceled.setSelected(false);
        searchfield.setText("");

        ObservableList<TreatmentRecord> treatmentRecords = Model.getInstance().getSelectedPatient().getTreatmentRecords();
        treatmentRecords.sort(Comparator.comparing((TreatmentRecord treatmentRecord) -> treatmentRecord.getPrescriptionTimeProperty().get()).reversed());

        filteredTreatmentRecords = new FilteredList<>(treatmentRecords, p -> true);
        sortedTreatmentRecords = new SortedList<>(filteredTreatmentRecords);

        treatment_listview.setItems(sortedTreatmentRecords);
        treatment_listview.setCellFactory(e -> new TreatmentCellFactory());
    }

    @Override
    public void filterList() {
        String lowerCaseFilter = searchfield.getText().trim().toLowerCase();

        filteredTreatmentRecords.setPredicate(treatmentRecord -> {
            String prescription = treatmentRecord.getPrescriptionProperty().get().toLowerCase();
            String prescriptionTime = treatmentRecord.getPrescriptionTimeStringProperty().get().toLowerCase();
            boolean containsFilter = prescription.contains(lowerCaseFilter) || prescriptionTime.contains(lowerCaseFilter);

            String status = treatmentRecord.getStatusProperty().get();
            String selectedBoxes = getSelectedBoxes();

            List<String> suitableStatuses = new ArrayList<>();
            switch (selectedBoxes) {
                case "tff" :
                    suitableStatuses.add("Виконано");
                    if (lowerCaseFilter.isEmpty()) {
                        return suitableStatuses.contains(status);
                    }
                    return suitableStatuses.contains(status) && containsFilter;
                case "ftf" :
                    suitableStatuses.add("Заплановано");
                    if (lowerCaseFilter.isEmpty()) {
                        return suitableStatuses.contains(status);
                    }
                    return suitableStatuses.contains(status) && containsFilter;
                case "fft" :
                    suitableStatuses.add("Скасовано");
                    if (lowerCaseFilter.isEmpty()) {
                        return suitableStatuses.contains(status);
                    }
                    return suitableStatuses.contains(status) && containsFilter;
                case "ttf" :
                    suitableStatuses.add("Виконано");
                    suitableStatuses.add("Заплановано");
                    if (lowerCaseFilter.isEmpty()) {
                        return suitableStatuses.contains(status);
                    }
                    return suitableStatuses.contains(status) && containsFilter;
                case "tft" :
                    suitableStatuses.add("Виконано");
                    suitableStatuses.add("Скасовано");
                    if (lowerCaseFilter.isEmpty()) {
                        return suitableStatuses.contains(status);
                    }
                    return suitableStatuses.contains(status) && containsFilter;
                case "ftt" :
                    suitableStatuses.add("Заплановано");
                    suitableStatuses.add("Скасовано");
                    if (lowerCaseFilter.isEmpty()) {
                        return suitableStatuses.contains(status);
                    }
                    return suitableStatuses.contains(status) && containsFilter;
                default :
                    if (lowerCaseFilter.isEmpty()) {
                        return true;
                    }
                    return containsFilter;
            }
        });
    }

    private String getSelectedBoxes() {
        String selectedBoxes = "";
        if (check_status_done.isSelected()) {
            selectedBoxes += "t";
        } else {
            selectedBoxes += "f";
        }
        if (check_status_planned.isSelected()) {
            selectedBoxes += "t";
        } else {
            selectedBoxes += "f";
        }
        if (check_status_canceled.isSelected()) {
            selectedBoxes += "t";
        } else {
            selectedBoxes += "f";
        }
        return selectedBoxes;
    }

    @Override
    public void sortList() {
        if (radio_from_newest.isSelected()) {
            sortedTreatmentRecords.setComparator(Comparator.comparing((TreatmentRecord treatmentRecord) -> treatmentRecord.getPrescriptionTimeProperty().get()).reversed());
        }
        if (radio_from_oldest.isSelected()) {
            sortedTreatmentRecords.setComparator(Comparator.comparing((TreatmentRecord treatmentRecord) -> treatmentRecord.getPrescriptionTimeProperty().get()));
        }
    }
}
