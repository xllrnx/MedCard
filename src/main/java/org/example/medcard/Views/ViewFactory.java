package org.example.medcard.Views;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.medcard.Controllers.Doctor.DoctorController;
import org.example.medcard.Utils.Logger.LoggerService;
import org.example.medcard.Utils.Enums.MenuOptions;
import org.slf4j.Logger;

import java.util.UUID;

public class ViewFactory {
    private static final Logger logger = LoggerService.getLogger(ViewFactory.class);
    //Doctor Views
    private final ObjectProperty<MenuOptions> doctorSelectedMenuItem;
    private AnchorPane doctorHelloView;
    private AnchorPane doctorWithoutPatientView;

    private AnchorPane doctorSelectPatientView;
    private AnchorPane doctorInformationView;

    private AnchorPane doctorTreatmentView;
    private AnchorPane doctorDiagnosisView;
    private AnchorPane doctorTemperatureSheetView;

    //Nurse Views
    private final ObjectProperty<MenuOptions> nurseSelectedMenuItem;
    private AnchorPane nurseHelloView;

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
    public AnchorPane getDoctorHelloView() {
        if (doctorHelloView == null) {
            try {
                logger.info("Спроба завантаження вікна DoctorHello.");
                doctorHelloView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/MessageWindows/DHello.fxml")).load();
                logger.info("Завантаження вікна DoctorHello успішне.");
            } catch (Exception e) {
                String errorId = UUID.randomUUID().toString();
                logger.error("Помилка завантаження вікна DoctorHello [ErrorID={}]", errorId);
            }
        }
        return doctorHelloView;
    }

    /**
     * Loads and returns the doctor's Without Patient view.
     *
     * @return AnchorPane containing the doctor's Without Patient view.
     */
    public AnchorPane getDoctorWithoutPatientView() {
        if (doctorWithoutPatientView == null) {
            try {
                logger.info("Спроба завантаження вікна DoctorWithoutPatient.");
                doctorWithoutPatientView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/MessageWindows/DWithoutPatient.fxml")).load();
                logger.info("Завантаження вікна DoctorWithoutPatient успішне.");
            } catch (Exception e) {
                String errorId = UUID.randomUUID().toString();
                logger.error("Помилка завантаження вікна DoctorWithoutPatient [ErrorID={}]", errorId);
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
                logger.info("Спроба завантаження вікна DoctorSelectPatient.");
                doctorSelectPatientView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/ListviewWindows/DSelectPatient.fxml")).load();
                logger.info("Завантаження вікна DoctorSelectPatient успішне.");
            } catch (Exception e) {
                String errorId = UUID.randomUUID().toString();
                logger.error("Помилка завантаження вікна DoctorSelectPatient [ErrorID={}]", errorId);
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
                logger.info("Спроба завантаження вікна DoctorInformation.");
                doctorInformationView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/DInformation.fxml")).load();
                logger.info("Завантаження вікна DoctorInformation успішне.");
            } catch (Exception e) {
                e.printStackTrace();
                String errorId = UUID.randomUUID().toString();
                logger.error("Помилка завантаження вікна DoctorInformation [ErrorID={}]", errorId);
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
                logger.info("Спроба завантаження вікна DoctorTreatment.");
                doctorTreatmentView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/ListviewWindows/DTreatment.fxml")).load();
                logger.info("Завантаження вікна DoctorTreatment успішне.");
            } catch (Exception e) {
                String errorId = UUID.randomUUID().toString();
                logger.error("Помилка завантаження вікна DoctorTreatment [ErrorID={}]", errorId);
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
                logger.info("Спроба завантаження вікна DoctorDiagnosis.");
                doctorDiagnosisView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/ListviewWindows/DDiagnosis.fxml")).load();
                logger.info("Завантаження вікна DoctorDiagnosis успішне.");
            } catch (Exception e) {
                String errorId = UUID.randomUUID().toString();
                logger.error("Помилка завантаження вікна DoctorDiagnosis [ErrorID={}]", errorId);
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
                logger.info("Спроба завантаження вікна DoctorTemperatureSheet.");
                doctorTemperatureSheetView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/ListviewWindows/DTemperatureSheet.fxml")).load();
                logger.info("Завантаження вікна DoctorTemperatureSheet успішне.");
            } catch (Exception e) {
                String errorId = UUID.randomUUID().toString();
                logger.error("Помилка завантаження вікна DoctorTemperatureSheet [ErrorID={}]", errorId);
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
    public AnchorPane getNurseHelloView() {
        if (nurseHelloView == null) {
            try {
                logger.info("Спроба завантаження вікна NurseHello.");
                nurseHelloView = new FXMLLoader(getClass().getResource("/Fxml/Nurse/nHello.fxml")).load();
                logger.info("Завантаження вікна NurseHello успішне.");
            } catch (Exception e) {
                String errorId = UUID.randomUUID().toString();
                logger.error("Помилка завантаження вікна NurseHello [ErrorID={}]", errorId);
            }
        }
        return nurseHelloView;
    }

    /**
     * Loads and returns the nurse's Select Patient view.
     *
     * @return AnchorPane containing the nurse's Select Patient view.
     */
    public AnchorPane getNurseSelectPatientView() {
        if (nurseSelectPatientView == null) {
            try {
                logger.info("Спроба завантаження вікна NurseSelectPatient.");
                nurseSelectPatientView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/ListviewWindows/DSelectPatient.fxml")).load();
                logger.info("Завантаження вікна NurseSelectPatient успішне.");
            } catch (Exception e) {
                String errorId = UUID.randomUUID().toString();
                logger.error("Помилка завантаження вікна NurseSelectPatient [ErrorID={}]", errorId);
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
                logger.info("Спроба завантаження вікна NurseInformation.");
                nurseInformationView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/DInformation.fxml")).load();
                logger.info("Завантаження вікна NurseInformation успішне.");
            } catch (Exception e) {
                String errorId = UUID.randomUUID().toString();
                logger.error("Помилка завантаження вікна NurseInformation [ErrorID={}]", errorId);
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
                logger.info("Спроба завантаження вікна NurseTreatment.");
                nurseTreatmentView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/ListviewWindows/DTreatment.fxml")).load();
                logger.info("Завантаження вікна NurseTreatment успішне.");
            } catch (Exception e) {
                String errorId = UUID.randomUUID().toString();
                logger.error("Помилка завантаження вікна NurseTreatment [ErrorID={}]", errorId);
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
                logger.info("Спроба завантаження вікна NurseDiagnosis.");
                nurseDiagnosisView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/ListviewWindows/DDiagnosis.fxml")).load();
                logger.info("Завантаження вікна NurseDiagnosis успішне.");
            } catch (Exception e) {
                String errorId = UUID.randomUUID().toString();
                logger.error("Помилка завантаження вікна NurseDiagnosis [ErrorID={}]", errorId);
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
                logger.info("Спроба завантаження вікна NurseTemperatureSheet.");
                nurseTemperatureSheetView = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/ListviewWindows/DTemperatureSheet.fxml")).load();
                logger.info("Завантаження вікна NurseTemperatureSheet успішне.");
            } catch (Exception e) {
                String errorId = UUID.randomUUID().toString();
                logger.error("Помилка завантаження вікна NurseTemperatureSheet [ErrorID={}]", errorId);
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
            logger.info("Спроба завантаження вікна LoginWindow.");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
            createStage(loader);
            logger.info("Завантаження вікна LoginWindow успішне.");
        } catch (Exception e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка завантаження вікна LoginWindow [ErrorID={}]", errorId);
        }
    }

    /*
        /**
         * Displays the doctor interface.
         */
    public void showDoctorWindow() {
        try {
            logger.info("Спроба завантаження вікна DoctorWindow.");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Doctor.fxml"));
            DoctorController doctorController = new DoctorController();
            loader.setController(doctorController);
            createStage(loader);
            logger.info("Завантаження вікна DoctorWindow успішне.");
        } catch (Exception e) {
            logger.error("Помилка завантаження вікна DoctorWindow: {}", e.getMessage(), e);
        }
    }

    public void showDoctorAddPatientWindow(Stage owner) {
        try {
            logger.info("Спроба завантаження вікна DoctorAddPatient.");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/DialogWindows/Patient/PatientAdd.fxml"));
            createStage(loader);
            logger.info("Завантаження вікна DoctorAddPatient успішне.");
        } catch (Exception e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка завантаження вікна DoctorAddPatient [ErrorID={}]", errorId);
        }
    }

    public void showDoctorDeletePatientWindow() {
        try {
            logger.info("Спроба завантаження вікна DoctorDeletePatient.");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Doctor/Windows/DialogWindows/Patient/PatientDelete.fxml"));
            createStage(loader);
            logger.info("Завантаження вікна DoctorDeletePatient успішне.");
        } catch (Exception e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка завантаження вікна DoctorDeletePatient [ErrorID={}]", errorId);
        }
    }

    /**
     * Displays the nurse interface.
     */
//    public void showNurseWindow() {
//        try {
//            logger.info("Спроба завантаження вікна NurseWindow.");
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Nurse/Nurse.fxml"));
//            NurseController nurseController = new NurseController();
//            loader.setController(nurseController);
//            createStage(loader);
//            logger.info("Завантаження вікна NurseWindow успішне.");
//        } catch (Exception e) {
//            String errorId = UUID.randomUUID().toString();
//            logger.error("Помилка завантаження вікна NurseWindow [ErrorID={}]", errorId);
//        }
//    }

    /**
     * Creates and displays a new stage from an FXML loader.
     *
     * @param loader FXMLLoader to load the scene.
     */
    public void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            logger.info("Спроба створення сцени.");
            scene = new Scene(loader.load());
            logger.info("Створення сцени успішне.");
        } catch (Exception e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка створення сцени [ErrorID={}]", errorId);
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
