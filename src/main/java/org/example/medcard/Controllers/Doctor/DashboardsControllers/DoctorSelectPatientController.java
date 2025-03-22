package org.example.medcard.Controllers.Doctor.DashboardsControllers;

import javafx.collections.transformation.FilteredList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.example.medcard.Controllers.Doctor.DoctorControllerManager;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Patient;
import org.example.medcard.Views.CellFactories.PatientCellFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorSelectPatientController extends DoctorDashboardController implements Initializable {

    public TextField search_field;
    public Button clear_searchfield_button;

    public Button add_button;
    public ListView<Patient> patients_listview;
    private FilteredList<Patient> filteredPatients;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clear_searchfield_button.setOnAction(event -> onClear());
        add_button.setOnAction(event -> onAdd());

        DoctorControllerManager.setDoctorSelectPatientController(this);

        updateSelectedPatient(Model.getInstance().getSelectedPatient());
        updateList();
    }

    private void onClear() {
        search_field.setText("");
    }

    private void onAdd() {
        Model.getInstance().getViewFactory().showDoctorAddPatientWindow();
    }

    @Override
    public void updateList() {
        Model.getInstance().setPatients();

        filteredPatients = new FilteredList<>(Model.getInstance().getPatients(), p -> true);

        patients_listview.setItems(filteredPatients);
        patients_listview.setCellFactory(e -> new PatientCellFactory());

        search_field.textProperty().addListener((observable, oldValue, newValue) -> {
            filterPatientList(newValue);
        });
    }

    private void filterPatientList(String searchText) {
        filteredPatients.setPredicate(patient -> {
            if (searchText == null || searchText.isEmpty()) {
                return true;
            }

            String lowerCaseFilter = search_field.getText().trim().toLowerCase();

            String patientName = patient.getSurnameProperty().get().toLowerCase() + " " +
                    patient.getNameProperty().get().toLowerCase() + " " +
                    patient.getFathernameProperty().get().toLowerCase();
            return patientName.contains(lowerCaseFilter);
        });
    }
}
