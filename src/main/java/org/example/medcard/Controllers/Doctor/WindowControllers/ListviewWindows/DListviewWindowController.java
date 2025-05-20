package org.example.medcard.Controllers.Doctor.WindowControllers.ListviewWindows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.medcard.Utils.Logger.LoggerService;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Patient;
import org.slf4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

public abstract class DListviewWindowController {
    private static final Logger logger = LoggerService.getLogger(DListviewWindowController.class);
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

    public Text no_records_warning;

    public Button add_button;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchfield_clear_button.setOnAction(event -> onClear());
        add_button.setOnAction(event -> addRecord());
        searchfield_filter_button.setOnAction(event -> onFilter());
        searchfield_filter_button2.setOnAction(event -> onFilter());

        searchfield.textProperty().addListener((observable, oldValue, newValue) -> filterList());
        sortGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> sortList());

        updateSelectedPatient(Model.getInstance().getSelectedPatient());
        updateList();
    }

    public void updateSelectedPatient(Patient patient) {
        if (patient == null) {
            selected_patient_info.setText("Пацієнт для роботи не обраний.");
            selected_patient_surname.setText("");
            selected_patient_name.setText("");
            selected_patient_fathername.setText("");
        } else {
            selected_patient_info.setText("Обраний пацієнт: ");
            selected_patient_surname.setText(patient.getSurname());
            selected_patient_name.setText(patient.getName());
            selected_patient_fathername.setText(patient.getFathername());
        }
    }

    public void onClear() {
        searchfield.setText("");
    }
    public void onFilter() {
        filters_container.setVisible(!filters_container.isVisible());
    }

    public abstract void addRecord();

    public void showDialogWindow(FXMLLoader loader, Stage owner) {
        try {
            logger.info("Спроба створення діалогового вікна.");
            Scene scene = new Scene(loader.load());
            logger.info("Створення діалогового вікна успішне.");

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            dialogStage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/AppIcon.png"))));
            dialogStage.setTitle("MedCard");
            dialogStage.setResizable(false);
            dialogStage.setScene(scene);

            owner.getScene().getRoot().setEffect(new BoxBlur(10, 10, 3));

            dialogStage.setOnShown(event -> {
                double centerX = owner.getX() + (owner.getWidth() - dialogStage.getWidth()) / 2 ;
                double centerY = owner.getY() + (owner.getHeight() - dialogStage.getHeight()) / 2;
                System.out.println("centerX: " + centerX + " centerY: " + centerY);
                dialogStage.setX(centerX);
                dialogStage.setY(centerY);
            });

            dialogStage.showAndWait();
            owner.getScene().getRoot().setEffect(null);
        } catch (Exception e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка створення діалогового вікна [ErrorID={}]", errorId);
        }
    }

    public abstract void updateList();
    public abstract void filterList();
    public abstract String getSelectedBoxes();
    public abstract void sortList();
}
