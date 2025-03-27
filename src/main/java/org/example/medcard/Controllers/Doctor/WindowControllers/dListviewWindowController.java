package org.example.medcard.Controllers.Doctor.WindowControllers;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Patient;

import java.net.URL;
import java.util.ResourceBundle;

public class dListviewWindowController {
    public Text selected_patient_info;
    public Text selected_patient_surname;
    public Text selected_patient_name;
    public Text selected_patient_fathername;

    public TextField searchfield;
    public Button searchfield_clear_button;
    public Button searchfield_filter_button;
    public Button searchfield_filter_button2;

    public VBox filters_container;
    public final ToggleGroup sortGroup = new ToggleGroup();

    public Button add_button;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchfield_clear_button.setOnAction(event -> onClear());
        add_button.setOnAction(event -> onAdd());
        searchfield_filter_button.setOnAction(event -> onFilter());
        searchfield_filter_button2.setOnAction(event -> onFilter());

        searchfield.textProperty().addListener((observable, oldValue, newValue) -> {
            filterList();
        });
        sortGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            sortList();
        });

        updateSelectedPatient(Model.getInstance().getSelectedPatient());
        updateList();
    }

    public void onClear() {
        searchfield.setText("");
    }

    public void onAdd() {}

    public void onFilter() {
        filters_container.setVisible(!filters_container.isVisible());
    }

    public void updateSelectedPatient(Patient patient) {
        if (patient == null) {
            selected_patient_info.setText("Пацієнт для роботи не обраний.");
            selected_patient_surname.setText("");
            selected_patient_name.setText("");
            selected_patient_fathername.setText("");
        } else {
            selected_patient_info.setText("Обраний пацієнт:");
            selected_patient_surname.setText(patient.getSurnameProperty().get());
            selected_patient_name.setText(patient.getNameProperty().get());
            selected_patient_fathername.setText(patient.getFathernameProperty().get());
        }
    }

    public void updateList() {}

    public void filterList() {}

    public void sortList() {}
}
