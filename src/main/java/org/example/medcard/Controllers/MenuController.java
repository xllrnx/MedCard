package org.example.medcard.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.medcard.Models.Model;
import org.example.medcard.Views.DoctorMenuOptions;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    public ImageView user_icon;
    public Label user_surname;
    public Label user_name;
    public Button select_patient_button;
    public Button information_button;
    public Button treatment_button;
    public Button diagnosis_button;
    public Button temperature_sheet_button;
    public Button exit_button;

    /**
     * Initializes the doctor's main menu, setting the doctor's name and surname,
     * and adding event handlers for the buttons.
     * @param url URL of the FXML resource.
     * @param resourceBundle resource bundle containing localized strings.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user_surname.setText(Model.getInstance().getUser().getSurname());
        user_name.setText(Model.getInstance().getUser().getName());
        addListeners();
    }

    /**
     * Adds event listeners to the menu buttons.
     */
    private void addListeners() {
        select_patient_button.setOnAction(event -> onSelectPatient());
        information_button.setOnAction(event -> onInformation());
        treatment_button.setOnAction(event -> onTreatment());
        diagnosis_button.setOnAction(event -> onDiagnosis());
        temperature_sheet_button.setOnAction(event -> onTemperatureSheet());
        exit_button.setOnAction(event -> onExit());
    }

    /**
     * Sets the doctor's menu selection to "Select Patient".
     */
    private void onSelectPatient() {
        updateButtonStyle(select_patient_button);
        Model.getInstance().getViewFactory().getDoctorSelectedMenuItem().set(DoctorMenuOptions.SelectPatient);
    }

    /**
     * Sets the doctor's menu selection to "Information".
     */
    private void onInformation() {
        updateButtonStyle(information_button);
        Model.getInstance().getViewFactory().getDoctorSelectedMenuItem().set(DoctorMenuOptions.Information);
    }

    /**
     * Sets the doctor's menu selection to "Treatment".
     */
    private void onTreatment() {
        updateButtonStyle(treatment_button);
        Model.getInstance().getViewFactory().getDoctorSelectedMenuItem().set(DoctorMenuOptions.Treatment);
    }

    /**
     * Sets the doctor's menu selection to "Diagnosis".
     */
    private void onDiagnosis() {
        updateButtonStyle(diagnosis_button);
        Model.getInstance().getViewFactory().getDoctorSelectedMenuItem().set(DoctorMenuOptions.Diagnosis);
    }

    /**
     * Sets the doctor's menu selection to "Temperature Sheet".
     */
    private void onTemperatureSheet() {
        updateButtonStyle(temperature_sheet_button);
        Model.getInstance().getViewFactory().getDoctorSelectedMenuItem().set(DoctorMenuOptions.TemperatureSheet);
    }

    /**
     * Closes the doctor's current window and opens the login window.
     */
    private void onExit() {
        Stage stage = (Stage) exit_button.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();

        Model.getInstance().setUserLoginSuccessFlag(false);
    }

    /**
     * Updates the style of the buttons, ensuring that only the selected button
     * has the "selected_button" style class, while removing it from all other buttons.
     *
     * @param selectedButton the button that was selected and should have the "selected_button" style class applied.
     */
    public void updateButtonStyle(Button selectedButton) {
        // List of all buttons
        Button[] buttons = {
                select_patient_button,
                information_button,
                treatment_button,
                diagnosis_button,
                temperature_sheet_button,
        };

        // Iterate over all buttons and remove the "selected_button" style class from all buttons except the selected one
        for (Button button : buttons) {
            if (button != selectedButton) {
                System.out.println("Removing selected_button from: " + button.getText());
                button.getStyleClass().remove("selected_button");
            }
        }

        // Add the "selected_button" style class to the selected button if it doesn't already contain it
        if (!selectedButton.getStyleClass().contains("selected_button")) {
            System.out.println("Adding selected_button to: " + selectedButton.getText());
            selectedButton.getStyleClass().add("selected_button");
        }
    }
    
}
