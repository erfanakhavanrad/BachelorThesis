package com.tarazgroup.tws.model.sale;

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
public class SaleVoucherOther implements Serializable {
    private Boolean isAndroidUser;

    private Boolean analysisSetup;

    private Boolean isAmendment;

    private String contractNumber;

    private String contractDate;

    private String bruntNumber;

    private String carNumber;

    private String otherDesc;

    private String xDesc;

    private BigDecimal driverID;

    private BigDecimal distNameID;

    private Integer webUserType;

    public Boolean getIsAndroidUser() {
        return isAndroidUser;
    }

    public void setIsAndroidUser(Boolean isAndroidUser) {
        this.isAndroidUser = isAndroidUser;
    }

    public Boolean getAnalysisSetup() {
        return analysisSetup;
    }

    public void setAnalysisSetup(Boolean analysisSetup) {
        this.analysisSetup = analysisSetup;
    }

    public Boolean getIsAmendment() {
        return isAmendment;
    }

    public void setIsAmendment(Boolean isAmendment) {
        this.isAmendment = isAmendment;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getBruntNumber() {
        return bruntNumber;
    }

    public void setBruntNumber(String bruntNumber) {
        this.bruntNumber = bruntNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getOtherDesc() {
        return otherDesc;
    }

    public void setOtherDesc(String otherDesc) {
        this.otherDesc = otherDesc;
    }

    public String getxDesc() {
        return xDesc;
    }

    public void setxDesc(String xDesc) {
        this.xDesc = xDesc;
    }

    public BigDecimal getDriverID() {
        return driverID;
    }

    public void setDriverID(BigDecimal driverID) {
        this.driverID = driverID;
    }

    public BigDecimal getDistNameID() {
        return distNameID;
    }

    public void setDistNameID(BigDecimal distNameID) {
        this.distNameID = distNameID;
    }

    public Integer getWebUserType() {
        return webUserType;
    }

    public void setWebUserType(Integer webUserType) {
        this.webUserType = webUserType;
    }
}

