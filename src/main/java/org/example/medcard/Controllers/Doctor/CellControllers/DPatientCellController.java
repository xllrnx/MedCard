package org.example.medcard.Controllers.Doctor.CellControllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.medcard.Controllers.Doctor.WindowControllers.DWindowControllerManager;
import org.example.medcard.Controllers.Doctor.WindowControllers.ListviewWindows.DListviewWindowController;
import org.example.medcard.Models.Model;
import org.example.medcard.Models.Patient;

import java.net.URL;
import java.util.ResourceBundle;

public class DPatientCellController implements Initializable {

    public Circle status_circle;
    public Text surname;
    public Text name;
    public Text fathername;
    public Text date_of_birth;
    public Button select_button;
    public Button delete_button;

    private final Patient patient;

    public DPatientCellController(Patient patient) {
        this.patient = patient;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tooltip tooltip = new Tooltip();
        Tooltip.install(status_circle, tooltip);
        tooltip.setShowDelay(Duration.millis(100));
        if (patient.getStatus()) {
            status_circle.setFill(Color.GREEN);
            status_circle.setOnMouseEntered(event -> tooltip.setText("На стаціонарі."));
        } else {
            status_circle.setFill(Color.RED);
            status_circle.setOnMouseEntered(event -> tooltip.setText("Виписаний."));
        }

        surname.textProperty().bind(patient.getSurnameProperty());
        name.textProperty().bind(patient.getNameProperty());
        fathername.textProperty().bind(patient.getFathernameProperty());
        date_of_birth.textProperty().bind(patient.getDateOfBirthStringProperty());

        select_button.setOnAction(event -> onSelect());
        delete_button.setOnAction(event -> onDelete());
    }

    private void onSelect() {
        Model.getInstance().setSelectedPatient(this.patient);

        System.out.printf("Patient selected: " + this.patient.getSurnameProperty().get()
                + " " + this.patient.getNameProperty().get() + " " + this.patient.getFathernameProperty().get() + "\n");
        System.out.println("Model selected patient: " + Model.getInstance().getSelectedPatient().getSurnameProperty().get()
                + " " + Model.getInstance().getSelectedPatient().getNameProperty().get() + " " + Model.getInstance().getSelectedPatient().getFathernameProperty().get() + "\n");

        DWindowControllerManager.getDSelectPatientController().updateSelectedPatient(this.patient);
        if (DWindowControllerManager.getDInformationController() != null) {
            DWindowControllerManager.getDInformationController().updateSelectedPatient(this.patient);
        }
        updateListController(DWindowControllerManager.getDTreatmentController());
        updateListController(DWindowControllerManager.getDDiagnosisController());
        updateListController(DWindowControllerManager.getDTemperatureSheetController());
    }
    
    private void updateListController(DListviewWindowController controller) {
        if (controller != null) {
            controller.updateSelectedPatient(this.patient);
            controller.updateList();
        }
    }

    private void onDelete() {
        Model.getInstance().setPatientToDelete(this.patient);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/RecordsWindows/Patient/DeletePatient.fxml"));
        DWindowControllerManager.getDSelectPatientController().showDialogWindow(loader, (Stage) Model.getInstance().getViewFactory().getDoctorSelectPatientView().getScene().getWindow());
    }
}
