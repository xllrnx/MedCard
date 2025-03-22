package org.example.medcard.Controllers.Doctor;

import org.example.medcard.Controllers.Doctor.RecordsControllers.*;
import org.example.medcard.Controllers.Doctor.DashboardsControllers.*;

public class DoctorControllerManager {
    private static DoctorHelloDashboardController doctorDashboardController;

    private static DoctorSelectPatientController doctorSelectPatientController;
    private static DoctorAddPatientController doctorAddPatientController;

    private static DoctorInformationController doctorInformationController;

    private static DoctorTreatmentController doctorTreatmentController;
    private static DoctorAddTreatmentRecordController doctorAddTreatmentRecordController;

    private static DoctorDiagnosisController doctorDiagnosisController;
    private static DoctorAddDiagnosisRecordController doctorAddDiagnosisRecordController;

    private static DoctorTemperatureSheetController doctorTemperatureSheetController;
    private static DoctorAddTemperatureSheetRecordController doctorAddTemperatureSheetRecordController;

    public static DoctorHelloDashboardController getDoctorDashboardController() {
        return doctorDashboardController;
    }

    public static void setDoctorDashboardController(DoctorHelloDashboardController doctorDashboardController) {
        DoctorControllerManager.doctorDashboardController = doctorDashboardController;
    }

    public static DoctorSelectPatientController getDoctorSelectPatientController() {
        return doctorSelectPatientController;
    }

    public static void setDoctorSelectPatientController(DoctorSelectPatientController doctorSelectPatientController) {
        DoctorControllerManager.doctorSelectPatientController = doctorSelectPatientController;
    }

    public static DoctorAddPatientController getDoctorAddPatientController() {
        return doctorAddPatientController;
    }

    public static void setDoctorAddPatientController(DoctorAddPatientController doctorAddPatientController) {
        DoctorControllerManager.doctorAddPatientController = doctorAddPatientController;
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

    public static DoctorAddTreatmentRecordController getDoctorAddTreatmentRecordController() {
        return doctorAddTreatmentRecordController;
    }

    public static void setDoctorAddTreatmentRecordController(DoctorAddTreatmentRecordController doctorAddTreatmentRecordController) {
        DoctorControllerManager.doctorAddTreatmentRecordController = doctorAddTreatmentRecordController;
    }

    public static DoctorDiagnosisController getDoctorDiagnosisController() {
        return doctorDiagnosisController;
    }

    public static void setDoctorDiagnosisController(DoctorDiagnosisController doctorDiagnosisController) {
        DoctorControllerManager.doctorDiagnosisController = doctorDiagnosisController;
    }

    public static DoctorAddDiagnosisRecordController getDoctorAddDiagnosisRecordController() {
        return doctorAddDiagnosisRecordController;
    }

    public static void setDoctorAddDiagnosisRecordController(DoctorAddDiagnosisRecordController doctorAddDiagnosisRecordController) {
        DoctorControllerManager.doctorAddDiagnosisRecordController = doctorAddDiagnosisRecordController;
    }

    public static DoctorTemperatureSheetController getDoctorTemperatureSheetController() {
        return doctorTemperatureSheetController;
    }

    public static void setDoctorTemperatureSheetController(DoctorTemperatureSheetController doctorTemperatureSheetController) {
        DoctorControllerManager.doctorTemperatureSheetController = doctorTemperatureSheetController;
    }

    public static DoctorAddTemperatureSheetRecordController getDoctorAddTemperatureSheetRecordController() {
        return doctorAddTemperatureSheetRecordController;
    }

    public static void setDoctorAddTemperatureSheetRecordController(DoctorAddTemperatureSheetRecordController doctorAddTemperatureSheetRecordController) {
        DoctorControllerManager.doctorAddTemperatureSheetRecordController = doctorAddTemperatureSheetRecordController;
    }
}
