package org.example.medcard.Controllers.Doctor;

import org.example.medcard.Controllers.Doctor.WindowControllers.*;

public class DoctorControllerManager {
    private static dHelloController dHelloController;

    private static dSelectPatientController dSelectPatientController;

    private static dInformationController dInformationController;

    private static dTreatmentController treatmentController;

    private static dDiagnosisController doctorDDiagnosisController;

    private static dTemperatureSheetController temperatureSheetController;

    public static dHelloController getDHelloController() {
        return dHelloController;
    }

    public static void setDHelloController(dHelloController dHelloController) {
        DoctorControllerManager.dHelloController = dHelloController;
    }

    public static dSelectPatientController getDSelectPatientController() {
        return dSelectPatientController;
    }

    public static void setDSelectPatientController(dSelectPatientController dSelectPatientController) {
        DoctorControllerManager.dSelectPatientController = dSelectPatientController;
    }

    public static dInformationController getDInformationController() {
        return dInformationController;
    }

    public static void setDInformationController(dInformationController dInformationController) {
        DoctorControllerManager.dInformationController = dInformationController;
    }

    public static dTreatmentController getDTreatmentController() {
        return treatmentController;
    }

    public static void setDTreatmentController(dTreatmentController treatmentController) {
        DoctorControllerManager.treatmentController = treatmentController;
    }

    public static dDiagnosisController getDDiagnosisController() {
        return doctorDDiagnosisController;
    }

    public static void setDDiagnosisController(dDiagnosisController doctorDDiagnosisController) {
        DoctorControllerManager.doctorDDiagnosisController = doctorDDiagnosisController;
    }

    public static dTemperatureSheetController getDTemperatureSheetController() {
        return temperatureSheetController;
    }

    public static void setDTemperatureSheetController(dTemperatureSheetController temperatureSheetController) {
        DoctorControllerManager.temperatureSheetController = temperatureSheetController;
    }
}
