package org.example.medcard.Utils;

public enum SQLStatements {
    SEARCH_USER("select * from Users join Persons on Users.personID = Persons.personID where login = ? and password = ?"),
    GET_LAST_ID("select * from LastID where tableName = ?"),

    CREATE_PERSON("insert into Persons values (?, ?, ?, ?)"),
    CREATE_PATIENT("insert into Patients values (?, ?, ?, ?, ?, ?, ?, ?, ?)"),

    GET_PATIENTS("select * from Patients join Persons on Patients.personID = Persons.personID"),
    GET_TREATMENT_RECORDS("select * from Treatment where patientID = ?"),
    GET_DIAGNOSIS_RECORDS("select * from Diagnosis where patientID = ?"),
    GET_TEMPERATURE_SHEET_RECORDS("select * from TemperatureSheet where patientID = ?"),

    DELETE_PATIENT("delete from Patients where patientID = ?"),
    EDIT_PATIENT("update Patients set patientID = ? where patientID = ?"); //edit

    private final String statement;
    SQLStatements(String statement){
        this.statement = statement;
    }

    public String getStatement() {
        return statement;
    }
}
