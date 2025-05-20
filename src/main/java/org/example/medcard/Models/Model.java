package org.example.medcard.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.medcard.Utils.BCrypt.DataHasher;
import org.example.medcard.Utils.Logger.LoggerService;
import org.example.medcard.Models.Records.DiagnosisRecord;
import org.example.medcard.Models.Records.TemperatureSheetRecord;
import org.example.medcard.Models.Records.TreatmentRecord;
import org.example.medcard.Views.ViewFactory;
import org.slf4j.Logger;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.UUID;

public class Model {
    //Model Parts Data Section
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    private final Logger logger = LoggerService.getLogger(Model.class);

    // User Data Section
    private final User user;
    private boolean userLoginSuccessFlag;

    // Patients Data Section
    private final ObservableList<Patient> patients;
    private Patient selectedPatient;
    private Patient patientToDelete;

    //Selected Records Data Section
    private TreatmentRecord selectedTreatmentRecord;
    private DiagnosisRecord selectedDiagnosisRecord;
    private TemperatureSheetRecord selectedTemperatureSheetRecord;
    private String selectedTemperatureSheetRecordPoD;

    private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();

        this.userLoginSuccessFlag = false;
        this.user = new User();

        this.patients = FXCollections.observableArrayList();

        this.selectedPatient = null;
        this.patientToDelete = null;

        this.selectedTreatmentRecord = null;
        this.selectedDiagnosisRecord = null;
        this.selectedTemperatureSheetRecord = null;
        this.selectedTemperatureSheetRecordPoD = null;
    }

    //Model Parts Method Section
    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public static void resetModel() {
        model = null;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public DatabaseDriver getDatabaseDriver() {
        return databaseDriver;
    }


    // User Method Section
    public boolean getUserLoginSuccessFlag() {
        return userLoginSuccessFlag;
    }

    public void setUserLoginSuccessFlag(boolean flag) {
        this.userLoginSuccessFlag = flag;
    }

    public User getUser() {
        return user;
    }


    public void evaluateUserCredentials(String login, String password) {
        ResultSet resultSet = databaseDriver.getUserPassword(login);
        try {
            logger.info("Перевірка даних користувача для входу.");
            String storedHashedPassword = null;
            if (resultSet.next()) {
                storedHashedPassword = resultSet.getString("password");
                logger.info("{}\n", user);
            }
            logger.info("Перевірка даних користувача для входу успішне.");

            if (storedHashedPassword != null && DataHasher.checkData(password, storedHashedPassword)) {
                setUser(login);
                setUserLoginSuccessFlag(true);
            }

        } catch (Exception e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка перевірки даних користувача для входу [ErrorID={}]", errorId, e);
        }
    }

    public void setUser(String login) {
        ResultSet resultSet = databaseDriver.getUserData(login);
        try {
            logger.info("Перевірка даних користувача для входу.");
            if (resultSet.next()) {
                user.setUserID(resultSet.getInt("userID"));
                user.setType(resultSet.getString("type"));
                user.setSurname(resultSet.getString("surname"));
                user.setName(resultSet.getString("name"));
                user.setFatherName(resultSet.getString("fatherName"));
                setUserLoginSuccessFlag(true);

                System.out.println(user + "\n");
                logger.info("{}\n", user);
            }
            logger.info("Перевірка даних користувача для входу успішне.");
        } catch (Exception e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка перевірки даних користувача для входу [ErrorID={}]", errorId, e);
        }
    }


    // Patients Method Section
    public Patient getSelectedPatient() {
        return selectedPatient;
    }

    public void setSelectedPatient(Patient patient) {
        this.selectedPatient = patient;
    }

    public Patient getPatientToDelete() {
        return patientToDelete;
    }

    public void setPatientToDelete(Patient patient) {
        this.patientToDelete = patient;
    }

    public ObservableList<Patient> getPatients() {
        return patients;
    }

    public void setPatients() {
        ResultSet resultSet = databaseDriver.getAllPatientsData();
        try {
            logger.info("Спроба додавання пацієнта з БД.");
            while (resultSet.next()) {

                int patientID = resultSet.getInt("patientID");

                String surname = resultSet.getString("surname");
                String name = resultSet.getString("name");
                String fathername = resultSet.getString("fatherName");
                LocalDate dateOfBirth = resultSet.getDate("dateOfBirth").toLocalDate();


                String address = (String) resultSet.getObject("address");
                if (address == null) {
                    address = "Записи відсутні";
                }

                String phone = resultSet.getString("phone");
                String sex = resultSet.getString("sex");
                String complaints = resultSet.getString("complaints");
                String medicalHistory = resultSet.getString("medicalHistory");
                boolean status = resultSet.getBoolean("status");

                ObservableList<TreatmentRecord> treatmentRecords = getTreatmentRecords(patientID);
                ObservableList<DiagnosisRecord> diagnosisRecords = getDiagnosisRecords(patientID);
                ObservableList<TemperatureSheetRecord> temperatureSheetRecords = getTemperatureSheetRecords(patientID);

                patients.add(new Patient(patientID, surname, name, fathername, dateOfBirth, address, phone, sex, complaints, medicalHistory, status, treatmentRecords, diagnosisRecords, temperatureSheetRecords));
            }
            logger.info("Додавання пацієнта з БД успішне.");
        } catch (Exception e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка додавання пацієнта з БД [ErrorID={}]", errorId);
        }
    }

    public void addPatient(String surname, String name, String fathername, LocalDate dateOfBirth) {
        databaseDriver.createPerson(surname, name, fathername);
        int personID = databaseDriver.getLastPersonId();
        databaseDriver.createPatient(personID, dateOfBirth);
        int patientID = databaseDriver.getLastPatientId();
        patients.add(new Patient(patientID, surname, name, fathername, dateOfBirth, "", "", "", "", "", true, FXCollections.observableArrayList(), FXCollections.observableArrayList(), FXCollections.observableArrayList()));
    }

    public void editPatient(Patient patient) {
        databaseDriver.editPatient(patient.getPatientID());
    }

    public void deletePatient(Patient patient) {
        databaseDriver.deletePatient(patient.getPatientID());
        patients.remove(patient);
    }


    // Treatment Records Method Section
    public ObservableList<TreatmentRecord> getTreatmentRecords(int patientID) {
        ObservableList<TreatmentRecord> treatmentRecords = FXCollections.observableArrayList();
        ResultSet resultSet = databaseDriver.getTreatmentRecords(patientID);
        try {
            logger.info("Спроба додавання записів про лікування з БД.");
            while (resultSet.next()) {
                String drug = resultSet.getString("drug");
                String method = resultSet.getString("method");

                LocalDate prescriptionDate = resultSet.getDate("prescriptionDate").toLocalDate();
                LocalTime prescriptionTime = resultSet.getTime("prescriptionTime").toLocalTime();

                String status = resultSet.getString("status");
                if (status == null) {
                    status = "Невідомо";
                }

                String additionalInfo = (String) resultSet.getObject("additionalInfo");
                if (additionalInfo == null) {
                    additionalInfo = "Записи відсутні";
                }

                String authorSurname = resultSet.getString("authorSurname");
                String authorName = resultSet.getString("authorName");
                String authorFathername = resultSet.getString("authorFathername");
                String author = authorSurname + " " + authorName + " " + authorFathername;

                String executor = "Записи відсутні";
                Integer executorID = (Integer) resultSet.getObject("executorID");
                if (executorID != null) {
                    String executorSurname = resultSet.getString("executorSurname");
                    String executorName = resultSet.getString("executorName");
                    String executorFathername = resultSet.getString("executorFathername");
                    executor = executorSurname + " " + executorName + " " + executorFathername;
                }

                treatmentRecords.add(new TreatmentRecord(drug, method, prescriptionDate, prescriptionTime, author, executor, status, additionalInfo));
            }
            logger.info("Додавання записів про лікування з БД успішне.");
        } catch (Exception e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка додавання записів про лікування з БД [ErrorID={}]", errorId, e);
        }
        treatmentRecords.sort(Comparator.comparing(TreatmentRecord::getPrescriptionDate).reversed().thenComparing(TreatmentRecord::getPrescriptionTime, Comparator.reverseOrder()));
        return treatmentRecords;
    }



    //Diagnosis Records Method Section
    public ObservableList<DiagnosisRecord> getDiagnosisRecords(int patientID) {
        ObservableList<DiagnosisRecord> diagnosisRecords = FXCollections.observableArrayList();
        ResultSet resultSet = databaseDriver.getDiagnosisRecords(patientID);
        try {
            logger.info("Спроба додавання записів про діагностику з БД.");
            while (resultSet.next()) {
                String analysis = resultSet.getString("analysis");
                String cabinet = resultSet.getString("cabinet");

                LocalDate prescriptionDate = resultSet.getDate("prescriptionDate").toLocalDate();
                LocalTime prescriptionTime = resultSet.getTime("prescriptionTime").toLocalTime();

                String status = (String) resultSet.getObject("status");
                if (status == null) {
                    status = "Невідомо";
                }
                String results = (String) resultSet.getObject("results");
                if (results == null) {
                    results = "Записи відсутні";
                }
                String additionalInfo = (String) resultSet.getObject("additionalInfo");
                if (additionalInfo == null) {
                    additionalInfo = "Записи відсутні";
                }


                String authorSurname = resultSet.getString("authorSurname");
                String authorName = resultSet.getString("authorName");
                String authorFathername = resultSet.getString("authorFathername");
                String author = authorSurname + " " + authorName + " " + authorFathername;


                String executor = "Записи відсутні";
                Integer executorID = (Integer) resultSet.getObject("executorID");
                if (executorID != null) {
                    String executorSurname = resultSet.getString("executorSurname");
                    String executorName = resultSet.getString("executorName");
                    String executorFathername = resultSet.getString("executorFathername");
                    executor = executorSurname + " " + executorName + " " + executorFathername;
                }

                diagnosisRecords.add(new DiagnosisRecord(analysis, cabinet, prescriptionDate, prescriptionTime, author, executor, status, results, additionalInfo));
            }
            logger.info("Додавання записів про діагностику з БД успішне.");
        } catch (Exception e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка додавання записів про діагностику з БД [ErrorID={}]", errorId);
        }
        diagnosisRecords.sort(Comparator.comparing(DiagnosisRecord::getPrescriptionDate).reversed().thenComparing(DiagnosisRecord::getPrescriptionTime, Comparator.reverseOrder()));
        return diagnosisRecords;
    }

    public ObservableList<TemperatureSheetRecord> getTemperatureSheetRecords(int patientID) {
        ObservableList<TemperatureSheetRecord> temperatureSheetRecords = FXCollections.observableArrayList();
        ResultSet resultSet = databaseDriver.getTemperatureSheerRecords(patientID);
        try {
            logger.info("Спроба додавання записів температурного листа з БД.");
            while (resultSet.next()) {
                //Can't be null
                LocalDate checkDate = resultSet.getDate("checkDate").toLocalDate();

                //Morning info
                java.sql.Time morningCheckTimeSQL = resultSet.getTime("morningCheckTime");
                LocalTime morningCheckTime;
                if (morningCheckTimeSQL == null) {
                    morningCheckTime = null;
                } else {
                    morningCheckTime = morningCheckTimeSQL.toLocalTime();
                }

                Integer morningPulse = (Integer) resultSet.getObject("morningPulse");
                if (morningPulse == null) {
                    morningPulse = -1;
                }
                Integer morningSystolic = (Integer) resultSet.getObject("morningSystolic");
                if (morningSystolic == null) {
                    morningSystolic = -1;
                }
                Integer morningDiastolic = (Integer) resultSet.getObject("morningDiastolic");
                if (morningDiastolic == null) {
                    morningDiastolic = -1;
                }
                BigDecimal morningTemperatureBD = (BigDecimal) resultSet.getObject("morningTemperature");
                double morningTemperature;
                if (morningTemperatureBD == null) {
                    morningTemperature = (double) -1;
                } else {
                    morningTemperature = morningTemperatureBD.doubleValue();
                }
                String morningExecutor = "Відсутній(-ня)";
                Integer morningExecutorID = (Integer) resultSet.getObject("morningExecutorID");
                if (morningExecutorID != null) {
                    String executorSurname = resultSet.getString("morningExecutorSurname");
                    String executorName = resultSet.getString("morningExecutorName");
                    String executorFathername = resultSet.getString("morningExecutorFathername");
                    morningExecutor = executorSurname + " " + executorName + " " + executorFathername;
                }
                String morningAdditionalInfo = resultSet.getString("morningAdditionalInfo");
                if (morningAdditionalInfo == null) {
                    morningAdditionalInfo = "Відсутня";
                }

                //Evening info
                java.sql.Time eveningCheckTimeSQL = resultSet.getTime("eveningCheckTime");
                LocalTime eveningCheckTime;
                if (eveningCheckTimeSQL == null) {
                    eveningCheckTime = null;
                } else {
                    eveningCheckTime = eveningCheckTimeSQL.toLocalTime();
                }
                Integer eveningPulse = (Integer) resultSet.getObject("eveningPulse");
                if (eveningPulse == null) {
                    eveningPulse = -1;
                }
                Integer eveningSystolic = (Integer) resultSet.getObject("eveningSystolic");
                if (eveningSystolic == null) {
                    eveningSystolic = -1;
                }
                Integer eveningDiastolic = (Integer) resultSet.getObject("eveningDiastolic");
                if (eveningDiastolic == null) {
                    eveningDiastolic = -1;
                }
                BigDecimal eveningTemperatureBD = (BigDecimal) resultSet.getObject("eveningTemperature");
                double eveningTemperature;
                if (eveningTemperatureBD == null) {
                    eveningTemperature = (double) -1;
                } else {
                    eveningTemperature = eveningTemperatureBD.doubleValue();
                }
                String eveningAdditionalInfo = resultSet.getString("eveningAdditionalInfo");
                if (eveningAdditionalInfo == null) {
                    eveningAdditionalInfo = "Відсутня";
                }
                String eveningExecutor = "Відсутній(-ня)";
                Integer eveningExecutorID = (Integer) resultSet.getObject("eveningExecutorID");
                if (eveningExecutorID != null) {
                    String executorSurname = resultSet.getString("eveningExecutorSurname");
                    String executorName = resultSet.getString("eveningExecutorName");
                    String executorFathername = resultSet.getString("eveningExecutorFathername");
                    eveningExecutor = executorSurname + " " + executorName + " " + executorFathername;
                }

                temperatureSheetRecords.add(new TemperatureSheetRecord(checkDate, morningCheckTime, morningPulse, morningSystolic, morningDiastolic, morningTemperature, morningExecutor, morningAdditionalInfo, eveningCheckTime, eveningPulse, eveningSystolic, eveningDiastolic, eveningTemperature, eveningExecutor, eveningAdditionalInfo));
                System.out.println(new TemperatureSheetRecord(checkDate, morningCheckTime, morningPulse, morningSystolic, morningDiastolic, morningTemperature, morningExecutor, morningAdditionalInfo, eveningCheckTime, eveningPulse, eveningSystolic, eveningDiastolic, eveningTemperature, eveningExecutor, eveningAdditionalInfo));
            }
            logger.info("Додавання записів температурного листа з БД успішне.");
        } catch (Exception e) {
            String errorId = UUID.randomUUID().toString();
            logger.error("Помилка додавання записів температурного листа з БД [ErrorID={}]", errorId, e);
        }
        temperatureSheetRecords.sort(Comparator.comparing(TemperatureSheetRecord::getCheckDate).reversed());
        return temperatureSheetRecords;
    }


    // Selected Records Data Section
    public TreatmentRecord getSelectedTreatmentRecord() {
        return selectedTreatmentRecord;
    }

    public void setSelectedTreatmentRecord(TreatmentRecord treatmentRecord) {
        this.selectedTreatmentRecord = treatmentRecord;
    }

    public DiagnosisRecord getSelectedDiagnosisRecord() {
        return selectedDiagnosisRecord;
    }

    public void setSelectedDiagnosisRecord(DiagnosisRecord diagnosisRecord) {
        this.selectedDiagnosisRecord = diagnosisRecord;
    }

    public TemperatureSheetRecord getSelectedTemperatureSheetRecord() {
        return selectedTemperatureSheetRecord;
    }

    public void setSelectedTemperatureSheetRecord(TemperatureSheetRecord temperatureSheetRecord) {
        this.selectedTemperatureSheetRecord = temperatureSheetRecord;
    }

    public String getSelectedTemperatureSheetRecordPoD() {
        return selectedTemperatureSheetRecordPoD;
    }

    public void setSelectedTemperatureSheetRecordPoD(String selectedTemperatureSheetRecordPoD) {
        this.selectedTemperatureSheetRecordPoD = selectedTemperatureSheetRecordPoD;
    }

    public void addDiagnosisRecord(String analysis, String cabinet, LocalDate prescriptionDate, LocalTime prescriptionTime) {
        String author = getUser().getSurname() + " " + getUser().getName() + " " + getUser().getFatherName();
        getSelectedPatient().getDiagnosisRecords().add(new DiagnosisRecord(analysis, cabinet, prescriptionDate, prescriptionTime, author, "Відсутній(-ня)", "Заплановано", "Відсутні", "Відсутня"));
    }

    public void addTemperatureSheetRecord() {
        getDatabaseDriver().addTemperatureSheetRecord(getSelectedPatient().getPatientID());
        getSelectedPatient().getTemperatureSheetRecords().add(new TemperatureSheetRecord(LocalDate.now(), null, -1, -1, -1, -1, "Відсутній(-ня)", "Відсутня", null, -1, -1, -1, -1, "Відсутній(-ня)", "Відсутня"));
    }

}
