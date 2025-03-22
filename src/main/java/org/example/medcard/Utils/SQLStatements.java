package org.example.medcard.Utils;

public enum SQLStatements {
    SEARCH_USER("select * from users join persons on users.person_id = persons.person_id where login = ? and password = ?"),
    GET_LAST_ID("select * from lastid where table_name = ?"),

    CREATE_PERSON("insert into persons values (?, ?, ?, ?)"),
    CREATE_PATIENT("insert into patients values (?, ?, ?, ?, ?, ?, ?, ?, ?)"),

    GET_PATIENTS("select * from patients join persons on patients.person_id = persons.person_id"),
    GET_TREATMENT_RECORDS("select * from treatment where patient_id = ?"),
    GET_DIAGNOSIS_RECORDS("select * from diagnosis where patient_id = ?"),
    GET_TEMPERATURE_SHEET_RECORDS("select * from temperaturesheet where patient_id = ?"),

    DELETE_PATIENT("delete from patients where patient_id = ?");

    private final String statement;
    SQLStatements(String statement){
        this.statement = statement;
    }

    public String getStatement() {
        return statement;
    }
}
