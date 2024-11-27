package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author salman majidi
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "SaleShowCustomer",
        procedureName = "SaleShowCustomer",
        resultClasses = {SaleCustomer.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class SaleCustomer extends TParams implements Serializable {

    @Id
    @Column(name = "mID", columnDefinition = "decimal")
    @Parameter
    private BigDecimal mID;

    @Column(name = "CustomerID", columnDefinition = "decimal")
    @Parameter
    private BigDecimal customerID;

    @Column(name = "CustomerCode", columnDefinition = "nvarchar")
    @Parameter
    private String customerCode;

    @Column(name = "CustomerDesc", columnDefinition = "nvarchar")
    @Parameter
    private String customerDesc;

    @Column(name = "CustomerName", columnDefinition = "nvarchar")
    @Parameter
    private String customerName;

    @Column(name = "CreateDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "CreatorID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifyDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "ServerID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "GradeSum", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal gradeSum;

    @Column(name = "TafsiliCode")
    @Parameter(hidden = true)
    private String tafsiliCode;

    @Column(name = "PerComTitle")
    @Parameter(hidden = true)
    private String perComTitle;

    @Column(name = "PerComFName")
    @Parameter(hidden = true)
    private String perComFName;

    @Column(name = "PerComLName")
    @Parameter(hidden = true)
    private String perComLName;

    @Column(name = "PerComAddress")
    @Parameter(hidden = true)
    private String perComAddress;

    @Column(name = "ClassID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal classID;

    @Column(name = "GeoID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal geoID;

    @Column(name = "IsActive", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isActive;

    @Column(name = "PersonTypeID", columnDefinition = "tinyint")
    @Parameter
    private Integer personTypeID;

    @Column(name = "GeoClass")
    @Parameter(hidden = true)
    private String GgeoClass;

    @Column(name = "CustomerClass")
    @Parameter(hidden = true)
    private String customerClass;

    @Column(name = "PercomNameLatin")
    @Parameter(hidden = true)
    private String percomNameLatin;

    @Column(name = "CreateDateStr")
    @Parameter(hidden = true)
    private String createDateStr;

    @Column(name = "CustomerMobile")
    @Parameter(hidden = true)
    private String customerMobile;

    @Column(name = "CustomerTel")
    @Parameter(hidden = true)
    private String customerTel;

    @Column(name = "Longitude", columnDefinition = "decimal")
    @Parameter
    private BigDecimal longitude;

    @Column(name = "Latitude", columnDefinition = "decimal")
    @Parameter
    private BigDecimal latitude;

    @Column(name = "RemainCash", columnDefinition = "decimal")
    @Parameter
    private BigDecimal remainCash;

    @Column(name = "RemainChq", columnDefinition = "decimal")
    @Parameter
    private BigDecimal remainChq;


    public BigDecimal getMID() {
        return mID;
    }

    public void setMID(BigDecimal mID) {
        this.mID = mID;
    }

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

    public String getCustomerDesc() {
        return customerDesc;
    }

    public void setCustomerDesc(String customerDesc) {
        this.customerDesc = customerDesc;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public BigDecimal getGradeSum() {
        return gradeSum;
    }

    public void setGradeSum(BigDecimal gradeSum) {
        this.gradeSum = gradeSum;
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

    public String getPerComAddress() {
        return perComAddress;
    }

    public void setPerComAddress(String perComAddress) {
        this.perComAddress = perComAddress;
    }

    public BigDecimal getClassID() {
        return classID;
    }

    public void setClassID(BigDecimal classID) {
        this.classID = classID;
    }

    public BigDecimal getGeoID() {
        return geoID;
    }

    public void setGeoID(BigDecimal geoID) {
        this.geoID = geoID;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getPersonTypeID() {
        return personTypeID;
    }

    public void setPersonTypeID(Integer personTypeID) {
        this.personTypeID = personTypeID;
    }

    public String getGgeoClass() {
        return GgeoClass;
    }

    public void setGgeoClass(String ggeoClass) {
        GgeoClass = ggeoClass;
    }

    public String getCustomerClass() {
        return customerClass;
    }

    public void setCustomerClass(String customerClass) {
        this.customerClass = customerClass;
    }

    public String getPercomNameLatin() {
        return percomNameLatin;
    }

    public void setPercomNameLatin(String percomNameLatin) {
        this.percomNameLatin = percomNameLatin;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
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
