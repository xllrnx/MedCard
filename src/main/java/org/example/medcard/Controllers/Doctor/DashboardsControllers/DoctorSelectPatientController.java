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

public class DoctorSelectPatientController implements Initializable {

    public Text selected_patient_info;
    public Text selected_patient_surname;
    public Text selected_patient_name;
    public Text selected_patient_fathername;

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

        if (Model.getInstance().getSelectedPatient().PatientID() == -1) {
            selected_patient_info.setText("Пацієнт для роботи не обраний.");
        } else {
            selected_patient_info.setText("Обраний пацієнт:");
        }

        selected_patient_surname.setText(Model.getInstance().getSelectedPatient().SurnameProperty().get());
        System.out.printf("selected_patient_surname = " + selected_patient_surname.getText() + "\n");
        selected_patient_name.setText(Model.getInstance().getSelectedPatient().NameProperty().get());
        System.out.printf("selected_patient_name = " + selected_patient_name.getText() + "\n");
        selected_patient_fathername.setText(Model.getInstance().getSelectedPatient().FathernameProperty().get());
        System.out.printf("selected_patient_fathername = " + selected_patient_fathername.getText() + "\n");

        updatePatientsList();
    }

    private void onClear() {
        search_field.setText("");
    }

    private void onAdd() {
        Model.getInstance().getViewFactory().showDoctorAddPatientWindow();
    }

    public void updateSelectedPatient(Patient patient) {
        System.out.printf("(update window)Patient selected: " + patient.SurnameProperty().get()
                + " " + patient.NameProperty().get() + " " + patient.FathernameProperty().get() + "\n");
        selected_patient_info.setText("Обраний пацієнт:");
        selected_patient_surname.setText(patient.SurnameProperty().get());
        selected_patient_name.setText(patient.NameProperty().get());
        selected_patient_fathername.setText(patient.FathernameProperty().get());
    }

    public void updatePatientsList() {
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

            String patientName = patient.SurnameProperty().get().toLowerCase() + " " +
                    patient.NameProperty().get().toLowerCase() + " " +
                    patient.FathernameProperty().get().toLowerCase();
            return patientName.contains(lowerCaseFilter);
        });
    }
}
