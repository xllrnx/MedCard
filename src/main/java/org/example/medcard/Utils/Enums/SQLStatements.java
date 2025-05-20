package org.example.medcard.Utils.Enums;

public enum SQLStatements {
    GET_USER_PASSWORD("select password from Users where login = ?"),
    GET_USER_DATA("select * from Users join Persons on Users.personID = Persons.personID where login = ?"),

    CREATE_PERSON("insert into Persons (surname, name, fatherName) values (?, ?, ?)"),

    GET_PATIENTS("select * from Patients join Persons on Patients.personID = Persons.personID"),
    CREATE_PATIENT("insert into Patients (personID, dateOfBirth, address, phone, sex, complaints, medicalHistory, status) " +
            "values (?, ?, null, null, null, null, null, ?)"),
    DELETE_PATIENT("delete from Patients where patientID = ?"),


    GET_TREATMENT_RECORDS("""
            select tr.*,
                p.fatherName as "authorFatherName", p.name as "authorName", p.surname as "authorSurname",
                p2.fatherName as "executorFatherName", p2.name as "executorName", p2.surname as "executorSurname"
            from treatmentRecords tr left join persons p on tr.authorID = p.personID left join persons p2 on tr.executorID = p2.personID
            where tr.patientID = ?;"""),


    GET_DIAGNOSIS_RECORDS("""
            select dr.*,
                p.fatherName as "authorFatherName", p.name as "authorName", p.surname as "authorSurname",
                p2.fatherName as "executorFatherName", p2.name as "executorName", p2.surname as "executorSurname"
            from diagnosisRecords dr left join persons p on dr.authorID = p.personID left join persons p2 on dr.executorID = p2.personID
            where dr.patientID = ?;"""),


    GET_TEMPERATURE_SHEET_RECORDS("""
            select tsr.*,
                pm.fatherName as "morningExecutorFatherName", pm.name as "morningExecutorName", pm.surname as "morningExecutorSurname",
                pe.fatherName as "eveningExecutorFatherName", pe.name as "eveningExecutorName", pe.surname as "eveningExecutorSurname"
            from temperatureSheetRecords tsr left join persons pm on tsr.morningExecutorID = pm.personID left join persons pe on tsr.eveningExecutorID = pe.personID
            where tsr.patientID = ?;"""),
    CREATE_TEMPERATURE_SHEET_RECORD("insert into temperatureSheetRecords (patientID, checkDate, " +
            "morningCheckTime, morningPulse, morningSystolic, morningDiastolic, morningTemperature, morningExecutorID, morningAdditionalInfo, " +
            "eveningCheckTime, eveningPulse, eveningSystolic, eveningDiastolic, eveningTemperature, eveningExecutorID, eveningAdditionalInfo) " +
            "values (?, ?, null, null, null, null, null, null, null, null, null, null, null, null, null, null)"),

    GET_LAST_ID("select %s from %s order by %s desc limit 1"),


    EDIT_PATIENT("update Patients set patientID = ? where patientID = ?"); //edit

    private final String statement;

    SQLStatements(String statement) {
        this.statement = statement;
    }

    public String getStatement() {
        return statement;
    }
}
