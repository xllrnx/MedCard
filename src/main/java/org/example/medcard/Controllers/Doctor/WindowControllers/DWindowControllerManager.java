package org.example.medcard.Controllers.Doctor.WindowControllers;

import org.example.medcard.Controllers.Doctor.WindowControllers.ListviewWindows.DDiagnosisController;
import org.example.medcard.Controllers.Doctor.WindowControllers.ListviewWindows.DSelectPatientController;
import org.example.medcard.Controllers.Doctor.WindowControllers.ListviewWindows.DTemperatureSheetController;
import org.example.medcard.Controllers.Doctor.WindowControllers.ListviewWindows.DTreatmentController;

public class DWindowControllerManager {
    private static DHelloController dHelloController;
    private static DSelectPatientController dSelectPatientController;
    private static DInformationController dInformationController;
    private static DTreatmentController treatmentController;
    private static DDiagnosisController doctorDDiagnosisController;
    private static DTemperatureSheetController temperatureSheetController;


    public static DHelloController getDHelloController() {
        return dHelloController;
    }

    public static void setDHelloController(DHelloController dHelloController) {
        DWindowControllerManager.dHelloController = dHelloController;
    }

    public static DSelectPatientController getDSelectPatientController() {
        return dSelectPatientController;
    }

    public static void setDSelectPatientController(DSelectPatientController dSelectPatientController) {
        DWindowControllerManager.dSelectPatientController = dSelectPatientController;
    }

    public static DInformationController getDInformationController() {
        return dInformationController;
    }

    public static void setDInformationController(DInformationController dInformationController) {
        DWindowControllerManager.dInformationController = dInformationController;
    }

    public static DTreatmentController getDTreatmentController() {
        return treatmentController;
    }

    public static void setDTreatmentController(DTreatmentController treatmentController) {
        DWindowControllerManager.treatmentController = treatmentController;
    }

    public static DDiagnosisController getDDiagnosisController() {
        return doctorDDiagnosisController;
    }

    public static void setDDiagnosisController(DDiagnosisController doctorDDiagnosisController) {
        DWindowControllerManager.doctorDDiagnosisController = doctorDDiagnosisController;
    }

    public static DTemperatureSheetController getDTemperatureSheetController() {
        return temperatureSheetController;
    }

    public static void setDTemperatureSheetController(DTemperatureSheetController temperatureSheetController) {
        DWindowControllerManager.temperatureSheetController = temperatureSheetController;
    }
}
