package com.tarazgroup.tws.model.pub;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */
public class PubDB {

    private final String dbName;

    public PubDB(String dbName) {
        this.dbName = dbName;
    }

    public String getDbName() {
        return dbName;
    }
}
