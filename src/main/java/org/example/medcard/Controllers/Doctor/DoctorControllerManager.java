package org.example.medcard.Controllers.Doctor;

import org.example.medcard.Controllers.Doctor.DashboardsControllers.*;

public class DoctorControllerManager {
    private static DoctorDashboardController doctorDashboardController;
    private static DoctorSelectPatientController doctorSelectPatientController;
    private static DoctorInformationController doctorInformationController;
    private static DoctorTreatmentController doctorTreatmentController;
    private static DoctorDiagnosisController doctorDiagnosisController;
    private static DoctorTemperatureSheetController doctorTemperatureSheetController;

    public static DoctorDashboardController getDoctorDashboardController() {
        return doctorDashboardController;
    }

    public static void setDoctorDashboardController(DoctorDashboardController doctorDashboardController) {
        DoctorControllerManager.doctorDashboardController = doctorDashboardController;
    }

    public static DoctorSelectPatientController getDoctorSelectPatientController() {
        return doctorSelectPatientController;
    }

    public static void setDoctorSelectPatientController(DoctorSelectPatientController doctorSelectPatientController) {
        DoctorControllerManager.doctorSelectPatientController = doctorSelectPatientController;
    }

    public static DoctorInformationController getDoctorInformationController() {
        return doctorInformationController;
    }

    public static void setDoctorInformationController(DoctorInformationController doctorInformationController) {
        DoctorControllerManager.doctorInformationController = doctorInformationController;
    }

    public static DoctorTreatmentController getDoctorTreatmentController() {
        return doctorTreatmentController;
    }

    public static void setDoctorTreatmentController(DoctorTreatmentController doctorTreatmentController) {
        DoctorControllerManager.doctorTreatmentController = doctorTreatmentController;
    }

    public static DoctorDiagnosisController getDoctorDiagnosisController() {
        return doctorDiagnosisController;
    }

    public static void setDoctorDiagnosisController(DoctorDiagnosisController doctorDiagnosisController) {
        DoctorControllerManager.doctorDiagnosisController = doctorDiagnosisController;
    }

    public static DoctorTemperatureSheetController getDoctorTemperatureSheetController() {
        return doctorTemperatureSheetController;
    }

    public static void setDoctorTemperatureSheetController(DoctorTemperatureSheetController doctorTemperatureSheetController) {
        DoctorControllerManager.doctorTemperatureSheetController = doctorTemperatureSheetController;
    }
}
