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
import org.example.medcard.LoggerService;
import org.slf4j.Logger;

public class ViewFactory {
    private static final Logger logger = LoggerService.getLogger(ViewFactory.class);
    //Doctor Views
    private final ObjectProperty<MenuOptions> doctorSelectedMenuItem;
    private AnchorPane doctorHelloDashboardView;
    private AnchorPane doctorWithoutPatientView;

    private AnchorPane doctorSelectPatientView;
    private AnchorPane doctorInformationView;

    private AnchorPane doctorTreatmentView;
    private AnchorPane doctorDiagnosisView;
    private AnchorPane doctorTemperatureSheetView;

    //Nurse Views
    private final ObjectProperty<MenuOptions> nurseSelectedMenuItem;
    private AnchorPane nurseHelloDashboardView;

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
     *
     * @return ObjectProperty representing the selected doctor menu item.
     */
    public ObjectProperty<MenuOptions> getDoctorSelectedMenuItem() {
        return doctorSelectedMenuItem;
    }

    /**
     * Loads and returns the doctor's Dashboard view.
     *
     * @return AnchorPane containing the doctor's Dashboard view.
     */
    public AnchorPane getDoctorHelloDashboardView() {
        if (doctorHelloDashboardView == null) {
            try {
                doctorHelloDashboardView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/MessageWindows/dHello.fxml")).load();
            } catch (Exception e) {
                logger.error("Помилка завантаження вікна: {}", e.getMessage(), e);
            }
        }
        return doctorHelloDashboardView;
    }

    /**
     * Loads and returns the doctor's Without Patient view.
     *
     * @return AnchorPane containing the doctor's Without Patient view.
     */
    public AnchorPane getDoctorWithoutPatientView() {
        if (doctorWithoutPatientView == null) {
            try {
                doctorWithoutPatientView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/MessageWindows/dWithoutPatient.fxml")).load();
            } catch (Exception e) {
                logger.error("Помилка завантаження вікна: {}", e.getMessage(), e);
            }
        }
        return doctorWithoutPatientView;
    }

    /**
     * Loads and returns the doctor's Select Patient view.
     *
     * @return AnchorPane containing the doctor's Select Patient view.
     */
    public AnchorPane getDoctorSelectPatientView() {
        if (doctorSelectPatientView == null) {
            try {
                doctorSelectPatientView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/ListviewWindows/dSelectPatient.fxml")).load();
            } catch (Exception e) {
                logger.error("Помилка завантаження вікна: {}", e.getMessage(), e);
            }
        }
        return doctorSelectPatientView;
    }

    /**
     * Loads and returns the doctor's Information view.
     *
     * @return AnchorPane containing the doctor's Information view.
     */
    public AnchorPane getDoctorInformationView() {
        if (doctorInformationView == null) {
            try {
                doctorInformationView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/dInformation.fxml")).load();
            } catch (Exception e) {
                logger.error("Помилка завантаження вікна: {}", e.getMessage(), e);
            }
        }
        return doctorInformationView;
    }

    /**
     * Loads and returns the doctor's Treatment view.
     *
     * @return AnchorPane containing the doctor's Treatment view.
     */
    public AnchorPane getDoctorTreatmentView() {
        if (doctorTreatmentView == null) {
            try {
                doctorTreatmentView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/ListviewWindows/dTreatment.fxml")).load();
            } catch (Exception e) {
                logger.error("Помилка завантаження вікна: {}", e.getMessage(), e);
            }
        }
        return doctorTreatmentView;
    }

    /**
     * Loads and returns the doctor's Diagnosis view.
     *
     * @return AnchorPane containing the doctor's Diagnosis view.
     */
    public AnchorPane getDoctorDiagnosisView() {
        if (doctorDiagnosisView == null) {
            try {
                doctorDiagnosisView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/ListviewWindows/dDiagnosis.fxml")).load();
            } catch (Exception e) {
                logger.error("Помилка завантаження вікна: {}", e.getMessage(), e);
            }
        }
        return doctorDiagnosisView;
    }

    /**
     * Loads and returns the doctor's Temperature Sheet view.
     *
     * @return AnchorPane containing the doctor's Temperature Sheet view.
     */
    public AnchorPane getDoctorTemperatureSheetView() {
        if (doctorTemperatureSheetView == null) {
            try {
                doctorTemperatureSheetView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/ListviewWindows/dTemperatureSheet.fxml")).load();
            } catch (Exception e) {
                logger.error("Помилка завантаження вікна: {}", e.getMessage(), e);
            }
        }
        return doctorTemperatureSheetView;
    }

    // Nurse getView Methods

    /**
     * Returns the selected menu item for the nurse.
     *
     * @return ObjectProperty representing the selected nurse menu item.
     */
    public ObjectProperty<MenuOptions> getNurseSelectedMenuItem() {
        return nurseSelectedMenuItem;
    }

    /**
     * Loads and returns the nurse's Dashboard view.
     *
     * @return AnchorPane containing the nurse's Dashboard view.
     */
    public AnchorPane getNurseHelloDashboardView() {
        if (nurseHelloDashboardView == null) {
            try {
                nurseHelloDashboardView = new FXMLLoader(getClass().getResource("/Fxml/Nurse/NurseDashboard.fxml")).load();
            } catch (Exception e) {
                logger.error("Помилка завантаження вікна: {}", e.getMessage(), e);
            }
        }
        return nurseHelloDashboardView;
    }

    /**
     * Loads and returns the nurse's Select Patient view.
     *
     * @return AnchorPane containing the nurse's Select Patient view.
     */
    public AnchorPane getNurseSelectPatientView() {
        if (nurseSelectPatientView == null) {
            try {
                nurseSelectPatientView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/ListviewWindows/dSelectPatient.fxml")).load();
            } catch (Exception e) {
                logger.error("Помилка завантаження вікна: {}", e.getMessage(), e);
            }
        }
        return nurseSelectPatientView;
    }

    /**
     * Loads and returns the nurse's Information view.
     *
     * @return AnchorPane containing the nurse's Information view.
     */
    public AnchorPane getNurseInformationView() {
        if (nurseInformationView == null) {
            try {
                nurseInformationView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/dInformation.fxml")).load();
            } catch (Exception e) {
                logger.error("Помилка завантаження вікна: {}", e.getMessage(), e);
            }
        }
        return nurseInformationView;
    }

    /**
     * Loads and returns the nurse's Treatment view.
     *
     * @return AnchorPane containing the nurse's Treatment view.
     */
    public AnchorPane getNurseTreatmentView() {
        if (nurseTreatmentView == null) {
            try {
                nurseTreatmentView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/ListviewWindows/dTreatment.fxml")).load();
            } catch (Exception e) {
                logger.error("Помилка завантаження вікна: {}", e.getMessage(), e);
            }
        }
        return nurseTreatmentView;
    }

    /**
     * Loads and returns the nurse's Diagnosis view.
     *
     * @return AnchorPane containing the nurse's Diagnosis view.
     */
    public AnchorPane getNurseDiagnosisView() {
        if (nurseDiagnosisView == null) {
            try {
                nurseDiagnosisView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/ListviewWindows/dDiagnosis.fxml")).load();
            } catch (Exception e) {
                logger.error("Помилка завантаження вікна: {}", e.getMessage(), e);
            }
        }
        return nurseDiagnosisView;
    }

    /**
     * Loads and returns the nurse's Temperature Sheet view.
     *
     * @return AnchorPane containing the nurse's Temperature Sheet view.
     */
    public AnchorPane getNurseTemperatureSheetView() {
        if (nurseTemperatureSheetView == null) {
            try {
                nurseTemperatureSheetView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/ListviewWindows/dTemperatureSheet.fxml")).load();
            } catch (Exception e) {
                logger.error("Помилка завантаження вікна: {}", e.getMessage(), e);
            }
        }
        return nurseTemperatureSheetView;
    }

    // Show window methods

    /**
     * Displays the login window.
     */
    public void showLoginWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
            createStage(loader);
        } catch (Exception e) {
            logger.error("Помилка завантаження вікна: {}", e.getMessage(), e);
        }
    }

    /*
        /**
         * Displays the doctor interface.
         */
    public void showDoctorWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Doctor.fxml"));
            DoctorController doctorController = new DoctorController();
            loader.setController(doctorController);
            createStage(loader);
        } catch (Exception e) {
            logger.error("Помилка завантаження вікна: {}", e.getMessage(), e);
        }
    }

    public void showDoctorAddPatientWindow(Stage owner) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/RecordsWindows/Patient/AddPatient.fxml"));
            createStage(loader);
        } catch (Exception e) {
            logger.error("Помилка завантаження вікна: {}", e.getMessage(), e);
        }
    }

    public void showDoctorDeletePatientWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/RecordsWindows/Patient/DeletePatient.fxml"));
            createStage(loader);
        } catch (Exception e) {
            logger.error("Помилка завантаження вікна: {}", e.getMessage(), e);
        }
    }

    /**
     * Displays the nurse interface.
     */
    public void showNurseWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Nurse/Nurse.fxml"));
            NurseController nurseController = new NurseController();
            loader.setController(nurseController);
            createStage(loader);
        } catch (Exception e) {
            logger.error("Помилка завантаження вікна: {}", e.getMessage(), e);
        }
    }

    /**
     * Creates and displays a new stage from an FXML loader.
     *
     * @param loader FXMLLoader to load the scene.
     */
    public void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            logger.error("Помилка створення вікна: {}", e.getMessage(), e);
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
     *
     * @param stage The stage to close.
     */
    public void closeStage(Stage stage) {
        stage.close();
    }
}
