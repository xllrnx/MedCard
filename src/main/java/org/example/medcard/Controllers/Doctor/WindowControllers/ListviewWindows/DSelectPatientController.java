package org.example.medcard.Controllers.Doctor.WindowControllers.ListviewWindows;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import org.example.medcard.Controllers.Doctor.WindowControllers.DWindowControllerManager;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Patient;
import org.example.medcard.Views.Doctor.CellFactories.PatientCellFactory;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class DSelectPatientController extends DListviewWindowController implements Initializable {

    public ListView<Patient> patients_listview;
    private FilteredList<Patient> filteredPatients;
    private SortedList<Patient> sortedPatients;

    public RadioButton radio_default, radio_alphabetical, radio_reverse_alphabetical, radio_from_youngest, radio_from_oldest;
    public CheckBox check_status_true, check_status_false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);
        DWindowControllerManager.setDSelectPatientController(this);

        radio_default.setToggleGroup(sortGroup);
        radio_default.setSelected(true);
        radio_alphabetical.setToggleGroup(sortGroup);
        radio_reverse_alphabetical.setToggleGroup(sortGroup);
        radio_from_youngest.setToggleGroup(sortGroup);
        radio_from_oldest.setToggleGroup(sortGroup);

        check_status_true.selectedProperty().addListener((observable, oldValue, newValue) -> filterList());
        check_status_false.selectedProperty().addListener((observable, oldValue, newValue) -> filterList());
    }

    @Override
    public void addRecord() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/DialogWindows/Patient/PatientAdd.fxml"));
        showDialogWindow(loader, (Stage) Model.getInstance().getViewFactory().getDoctorSelectPatientView().getScene().getWindow());
    }

    @Override
    public void updateList() {
        if (Model.getInstance().getPatients().isEmpty()) {
            Model.getInstance().setPatients();
        }

        radio_default.setSelected(true);
        check_status_true.setSelected(false);
        check_status_false.setSelected(false);
        searchfield.setText("");

        ObservableList<Patient> patients = Model.getInstance().getPatients();
        patients.sort(Comparator.comparing(Patient::getPatientID).reversed());
        filteredPatients = new FilteredList<>(patients, p -> true);
        sortedPatients = new SortedList<>(filteredPatients);

        patients_listview.setItems(sortedPatients);
        patients_listview.setCellFactory(e -> new PatientCellFactory());
        no_records_warning.setVisible(sortedPatients.isEmpty());
    }

    @Override
    public void filterList() {
        String lowerCaseFilter = searchfield.getText().trim().toLowerCase();

        filteredPatients.setPredicate(patient -> {

            String patientName = patient.getSurname().toLowerCase() + " " +
                    patient.getName().toLowerCase() + " " +
                    patient.getFathername().toLowerCase();
            String dateOfBirth = patient.getDateOfBirth().toString().toLowerCase();
            boolean containsFilter = patientName.contains(lowerCaseFilter) || dateOfBirth.contains(lowerCaseFilter);

            boolean patientStatus = patient.getStatus();
            String selectedBoxes = getSelectedBoxes();

            switch (selectedBoxes) {
                case "tf":
                    if (lowerCaseFilter.isEmpty()) {
                        return patientStatus;
                    }
                    return patientStatus && containsFilter;
                case "ft":
                    if (lowerCaseFilter.isEmpty()) {
                        return !patientStatus;
                    }
                    return !patientStatus && containsFilter;
                default:
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
        if (check_status_true.isSelected()) {
            selectedBoxes += "t";
        } else {
            selectedBoxes += "f";
        }
        if (check_status_false.isSelected()) {
            selectedBoxes += "t";
        } else {
            selectedBoxes += "f";
        }
        return selectedBoxes;
    }

    @Override
    public void sortList() {
        if (radio_default.isSelected()) {
            sortedPatients.setComparator(Comparator.comparing(Patient::getPatientID).reversed());
        }
        if (radio_alphabetical.isSelected()) {
            sortedPatients.setComparator(Comparator.comparing(Patient::getSurname));
        }
        if (radio_reverse_alphabetical.isSelected()) {
            sortedPatients.setComparator(Comparator.comparing(Patient::getSurname).reversed());
        }
        if (radio_from_youngest.isSelected()) {
            sortedPatients.setComparator(Comparator.comparing(Patient::getDateOfBirth).reversed());
        }
        if (radio_from_oldest.isSelected()) {
            sortedPatients.setComparator(Comparator.comparing(Patient::getDateOfBirth));
        }
    }
}
