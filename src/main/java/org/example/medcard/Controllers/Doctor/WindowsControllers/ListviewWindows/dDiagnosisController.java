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
import org.example.medcard.Controllers.Doctor.RecordsControllers.Patient.AddPatientController;
import org.example.medcard.Controllers.Doctor.RecordsControllers.Patient.DeletePatientController;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Records.DiagnosisRecord;
import org.example.medcard.Views.Doctor.CellFactories.DiagnosisCellFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class dDiagnosisController extends dListviewWindowController implements Initializable {

    public ListView<DiagnosisRecord> diagnosis_listview;
    private FilteredList<DiagnosisRecord> filteredDiagnosisRecords;
    private SortedList<DiagnosisRecord> sortedDiagnosisRecords;

    public RadioButton radio_from_newest, radio_from_oldest;
    public CheckBox check_status_done, check_status_planned, check_status_canceled;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);
        DoctorControllerManager.setDDiagnosisController(this);

        radio_from_newest.setToggleGroup(sortGroup);
        radio_from_newest.setSelected(true);
        radio_from_oldest.setToggleGroup(sortGroup);

        check_status_done.selectedProperty().addListener((observable, oldValue, newValue) -> filterList());
        check_status_planned.selectedProperty().addListener((observable, oldValue, newValue) -> filterList());
        check_status_canceled.selectedProperty().addListener((observable, oldValue, newValue) -> filterList());
    }

    @Override
    public void addRecord() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/RecordsWindows/Patient/AddPatient.fxml"));
        AddPatientController addPatientControllerController = new AddPatientController();
        loader.setController(addPatientControllerController);
        showDialogWindow(loader, (Stage) Model.getInstance().getViewFactory().getDoctorDiagnosisView().getScene().getWindow());
    }

    @Override
    public void deleteRecord() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/RecordsWindows/Patient/DeletePatient.fxml"));
        DeletePatientController deletePatientControllerController = new DeletePatientController();
        loader.setController(deletePatientControllerController);
        showDialogWindow(loader, (Stage) Model.getInstance().getViewFactory().getDoctorDiagnosisView().getScene().getWindow());
    }

    @Override
    public void updateList() {
        radio_from_newest.setSelected(true);
        check_status_done.setSelected(false);
        check_status_planned.setSelected(false);
        check_status_canceled.setSelected(false);
        searchfield.setText("");

        ObservableList<DiagnosisRecord> diagnosisRecords = Model.getInstance().getSelectedPatient().getDiagnosisRecords();
        diagnosisRecords.sort(Comparator.comparing((DiagnosisRecord diagnosisRecord) -> diagnosisRecord.getPrescriptionTimeProperty().get()).reversed());

        filteredDiagnosisRecords = new FilteredList<>(diagnosisRecords, p -> true);
        sortedDiagnosisRecords = new SortedList<>(filteredDiagnosisRecords);

        diagnosis_listview.setItems(sortedDiagnosisRecords);
        diagnosis_listview.setCellFactory(e -> new DiagnosisCellFactory());
        no_records_warning.setVisible(sortedDiagnosisRecords.isEmpty());
    }

    @Override
    public void filterList() {
        String lowerCaseFilter = searchfield.getText().trim().toLowerCase();

        filteredDiagnosisRecords.setPredicate(diagnosisRecord -> {

            String prescription = diagnosisRecord.getPrescriptionProperty().get().toLowerCase();
            String prescriptionTime = diagnosisRecord.getPrescriptionTimeStringProperty().get().toLowerCase();
            boolean containsFilter = prescription.contains(lowerCaseFilter) || prescriptionTime.contains(lowerCaseFilter);

            String status = diagnosisRecord.getStatusProperty().get();
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

    @Override
    public String getSelectedBoxes() {
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
            sortedDiagnosisRecords.setComparator(Comparator.comparing((DiagnosisRecord diagnosisRecord) -> diagnosisRecord.getPrescriptionTimeProperty().get()).reversed());
        }
        if (radio_from_oldest.isSelected()) {
            sortedDiagnosisRecords.setComparator(Comparator.comparing((DiagnosisRecord diagnosisRecord) -> diagnosisRecord.getPrescriptionTimeProperty().get()));
        }
    }
}
