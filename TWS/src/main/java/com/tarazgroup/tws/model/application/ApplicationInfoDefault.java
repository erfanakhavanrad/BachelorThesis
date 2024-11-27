package com.tarazgroup.tws.model.application;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class ApplicationInfoDefault implements Serializable {
    private BigDecimal perComID;

    private String name;

    private String family;

    private String fatherName;

    private String latinName;

    private String address;

    private Boolean isAdmin;

    private Boolean isMale;

    private BigDecimal serverID;

    private String serverIDs;

    private BigDecimal activeYearID;

    private BigDecimal defaultServerID;


    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public String getServerIDs() {
        return serverIDs;
    }

    public void setServerIDs(String serverIDs) {
        this.serverIDs = serverIDs;
    }

    public BigDecimal getActiveYearID() {
        return activeYearID;
    }

    public void setActiveYearID(BigDecimal activeYearID) {
        this.activeYearID = activeYearID;
    }

    public BigDecimal getPerComID() {
        return perComID;
    }

    public void setPerComID(BigDecimal perComID) {
        this.perComID = perComID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getIsMale() {
        return isMale;
    }

    public void setIsMale(Boolean isMale) {
        this.isMale = isMale;
    }

    public BigDecimal getDefaultServerID() {
        return defaultServerID;
    }

    public void setDefaultServerID(BigDecimal defaultServerID) {
        this.defaultServerID = defaultServerID;
    }
}


