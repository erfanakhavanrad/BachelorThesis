package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "SaleGetCustomers",
        procedureName = "SaleGetCustomers",
        resultClasses = {SaleGetCustomer.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCredit", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN)
        }

)
@Entity
public class SaleGetCustomer extends TParams implements Serializable {

    @Id
    @Column(name = "CustomerID")
    private BigDecimal customerID;

    @Column(name = "CustomerCode")
    private String customerCode;

    @Column(name = "ClassID")
    private BigDecimal classID;

    @Column(name = "TafsiliCode")
    private String tafsiliCode;

    @Column(name = "PerComTitle")
    private String perComTitle;

    @Column(name = "SexID")
    private Boolean sexID;

    @Column(name = "PercomTypeID")
    private BigDecimal percomTypeID;

    @Column(name = "PerComAddress")
    private String perComAddress;

    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "TafsiliID")
    private BigDecimal tafsiliID;

    @Column(name = "PercomMobile")
    private String percomMobile;

    @Column(name = "PerComTel")
    private String perComTel;

    @Column(name = "PostalCode")
    private String postalCode;

    @Column(name = "RegistrationCode")
    private String registrationCode;

    @Column(name = "PerComFName")
    private String perComFName;

    @Column(name = "PerComLName")
    private String perComLName;

    @Column(name = "NationalCode")
    private String nationalCode;

    @Column(name = "FatherName")
    private String fatherName;

    @Column(name = "Latitude")
    private BigDecimal latitude;

    @Column(name = "Longitude")
    private BigDecimal longitude;

    @Column(name = "RemainCash", columnDefinition = "decimal")
    private BigDecimal remainCash;

    @Column(name = "RemainChq", columnDefinition = "decimal")
    private BigDecimal remainChq;

    public BigDecimal getCustomerID() {
        return customerID;
    }

    public void setCustomerID(BigDecimal customerID) {
        this.customerID = customerID;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public BigDecimal getClassID() {
        return classID;
    }

    public void setClassID(BigDecimal classID) {
        this.classID = classID;
    }

    public String getTafsiliCode() {
        return tafsiliCode;
    }

    public void setTafsiliCode(String tafsiliCode) {
        this.tafsiliCode = tafsiliCode;
    }

    public String getPerComTitle() {
        return perComTitle;
    }

    public void setPerComTitle(String perComTitle) {
        this.perComTitle = perComTitle;
    }

    public Boolean getSexID() {
        return sexID;
    }

    public void setSexID(Boolean sexID) {
        this.sexID = sexID;
    }

    public BigDecimal getPercomTypeID() {
        return percomTypeID;
    }

    public void setPercomTypeID(BigDecimal percomTypeID) {
        this.percomTypeID = percomTypeID;
    }

    public String getPerComAddress() {
        return perComAddress;
    }

    public void setPerComAddress(String perComAddress) {
        this.perComAddress = perComAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
    }

    public String getPercomMobile() {
        return percomMobile;
    }

    public void setPercomMobile(String percomMobile) {
        this.percomMobile = percomMobile;
    }

    public String getPerComTel() {
        return perComTel;
    }

    public void setPerComTel(String perComTel) {
        this.perComTel = perComTel;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public String getPerComFName() {
        return perComFName;
    }

    public void setPerComFName(String perComFName) {
        this.perComFName = perComFName;
    }

    public String getPerComLName() {
        return perComLName;
    }

    public void setPerComLName(String perComLName) {
        this.perComLName = perComLName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getRemainCash() {
        return remainCash;
    }

    public void setRemainCash(BigDecimal remainCash) {
        this.remainCash = remainCash;
    }

    public BigDecimal getRemainChq() {
        return remainChq;
    }

    public void setRemainChq(BigDecimal remainChq) {
        this.remainChq = remainChq;
    }
}
