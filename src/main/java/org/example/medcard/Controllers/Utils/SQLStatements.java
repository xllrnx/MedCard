package org.example.medcard.Controllers.Utils;

public enum SQLStatements {
    SEARCH_USER("select * from users join persons on users.person_id = persons.person_id where login = ? and password = ?");

    private final String statement;
    SQLStatements(String statement){
        this.statement = statement;
    }

    public String getStatement() {
        return statement;
    }
}
