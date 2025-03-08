package org.example.medcard.Views;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.medcard.Controllers.Doctor.DoctorController;
import org.example.medcard.Controllers.Nurse.NurseController;

public class ViewFactory {
    //Doctor Views
    private final ObjectProperty<DoctorMenuOptions> doctorSelectedMenuItem;
    private AnchorPane doctorDashboardView;
    private AnchorPane doctorSelectPatientView;
    private AnchorPane doctorInformationView;
    private AnchorPane doctorTreatmentView;
    private AnchorPane doctorDiagnosisView;
    private AnchorPane doctorTemperatureSheetView;

    //Nurse Views
    private final ObjectProperty<NurseMenuOptions> nurseSelectedMenuItem;
    private AnchorPane nurseDashboardView;
    private AnchorPane nurseSelectPatientView;
    private AnchorPane nurseInformationView;
    private AnchorPane nurseTreatmentView;
    private AnchorPane nurseDiagnosisView;
    private AnchorPane nurseTemperatureSheetView;

    /**
     * Constructor initializes properties for doctor and nurse views.
     */
    public ViewFactory() {
        this.doctorSelectedMenuItem = new SimpleObjectProperty<>();
        this.nurseSelectedMenuItem = new SimpleObjectProperty<>();
    }

    // Doctor getView Methods
    /**
     * Returns the selected menu item for the doctor.
     * @return ObjectProperty representing the selected doctor menu item.
     */
    public ObjectProperty<DoctorMenuOptions> getDoctorSelectedMenuItem() {
        return doctorSelectedMenuItem;
    }

    /**
     * Loads and returns the doctor's Dashboard view.
     * @return AnchorPane containing the doctor's Dashboard view.
     */
    public AnchorPane getDoctorDashboardView() {
        if (doctorDashboardView == null) {
            try {
                doctorDashboardView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/DoctorDashboard.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return doctorDashboardView;
    }

    /**
     * Loads and returns the doctor's Select Patient view.
     * @return AnchorPane containing the doctor's Select Patient view.
     */
    public AnchorPane getDoctorSelectPatientView() {
        if (doctorSelectPatientView == null) {
            try {
                doctorSelectPatientView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/DoctorSelectPatient.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return doctorSelectPatientView;
    }

    /**
     * Loads and returns the doctor's Information view.
     * @return AnchorPane containing the doctor's Information view.
     */
    public AnchorPane getDoctorInformationView() {
        if (doctorInformationView == null) {
            try {
                doctorInformationView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/DoctorInformation.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return doctorInformationView;
    }

    /**
     * Loads and returns the doctor's Treatment view.
     * @return AnchorPane containing the doctor's Treatment view.
     */
    public AnchorPane getDoctorTreatmentView() {
        if (doctorTreatmentView == null) {
            try {
                doctorTreatmentView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/DoctorTreatment.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return doctorTreatmentView;
    }

    /**
     * Loads and returns the doctor's Diagnosis view.
     * @return AnchorPane containing the doctor's Diagnosis view.
     */
    public AnchorPane getDoctorDiagnosisView() {
        if (doctorDiagnosisView == null) {
            try {
                doctorDiagnosisView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/DoctorDiagnosis.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return doctorDiagnosisView;
    }

    /**
     * Loads and returns the doctor's Temperature Sheet view.
     * @return AnchorPane containing the doctor's Temperature Sheet view.
     */
    public AnchorPane getDoctorTemperatureSheetView() {
        if (doctorTemperatureSheetView == null) {
            try {
                doctorTemperatureSheetView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/DoctorTemperatureSheet.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return doctorTemperatureSheetView;
    }

    // Nurse getView Methods
    /**
     * Returns the selected menu item for the nurse.
     * @return ObjectProperty representing the selected nurse menu item.
     */
    public ObjectProperty<NurseMenuOptions> getNurseSelectedMenuItem() {
        return nurseSelectedMenuItem;
    }

    /**
     * Loads and returns the nurse's Dashboard view.
     * @return AnchorPane containing the nurse's Dashboard view.
     */
    public AnchorPane getNurseDashboardView() {
        if (nurseDashboardView == null) {
            try {
                nurseDashboardView = new FXMLLoader(getClass().getResource("/Fxml/Nurse/NurseDashboard.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return nurseDashboardView;
    }

    /**
     * Loads and returns the nurse's Select Patient view.
     * @return AnchorPane containing the nurse's Select Patient view.
     */
    public AnchorPane getNurseSelectPatientView() {
        if (nurseSelectPatientView == null) {
            try {
                nurseSelectPatientView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/DoctorSelectPatient.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return nurseSelectPatientView;
    }

    /**
     * Loads and returns the nurse's Information view.
     * @return AnchorPane containing the nurse's Information view.
     */
    public AnchorPane getNurseInformationView() {
        if (nurseInformationView == null) {
            try {
                nurseInformationView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/DoctorInformation.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return nurseInformationView;
    }

    /**
     * Loads and returns the nurse's Treatment view.
     * @return AnchorPane containing the nurse's Treatment view.
     */
    public AnchorPane getNurseTreatmentView() {
        if (nurseTreatmentView == null) {
            try {
                nurseTreatmentView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/DoctorTreatment.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return nurseTreatmentView;
    }

    /**
     * Loads and returns the nurse's Diagnosis view.
     * @return AnchorPane containing the nurse's Diagnosis view.
     */
    public AnchorPane getNurseDiagnosisView() {
        if (nurseDiagnosisView == null) {
            try {
                nurseDiagnosisView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/DoctorDiagnosis.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return nurseDiagnosisView;
    }

    /**
     * Loads and returns the nurse's Temperature Sheet view.
     * @return AnchorPane containing the nurse's Temperature Sheet view.
     */
    public AnchorPane getNurseTemperatureSheetView() {
        if (nurseTemperatureSheetView == null) {
            try {
                nurseTemperatureSheetView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/DoctorTemperatureSheet.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return nurseTemperatureSheetView;
    }

    // Show window methods
    /**
     * Displays the login window.
     */
    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }

    /**
     * Displays the doctor interface.
     */
    public void showDoctorWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Doctor.fxml"));
        DoctorController doctorController = new DoctorController();
        loader.setController(doctorController);
        createStage(loader);
    }

    /**
     * Displays the nurse interface.
     */
    public void showNurseWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Nurse/Nurse.fxml"));
        NurseController nurseController = new NurseController();
        loader.setController(nurseController);
        createStage(loader);
    }

    /**
     * Creates and displays a new stage from an FXML loader.
     * @param loader FXMLLoader to load the scene.
     */
    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/AppIcon.png"))));
        stage.setTitle("MedCard");
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Closes the given stage.
     * @param stage The stage to close.
     */
    public void closeStage(Stage stage) {
        stage.close();
    }
}
