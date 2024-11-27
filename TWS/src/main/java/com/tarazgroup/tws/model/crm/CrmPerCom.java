package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author Aref Azizi
 * 8/30/22
 */
@NamedStoredProcedureQuery(
        name = "CrmShowPerCom",
        procedureName = "CrmShowPerCom",
        resultClasses = {CrmPerCom.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }

)

@NamedStoredProcedureQuery(
        name = "CRMInsPerCom",
        procedureName = "CRMInsPerCom",
        resultClasses = {CrmPerCom.class},
        parameters = {
                @StoredProcedureParameter(name = "PerComTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComFName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComLName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComAddress", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComMobile", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComPhone", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComTypeID", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComWebsite", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComEmail", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmUpdPerCom",
        procedureName = "CrmUpdPerCom",
        resultClasses = {CrmPerCom.class},
        parameters = {
                @StoredProcedureParameter(name = "PerComID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComFName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComLName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComAddress", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComMobile", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComPhone", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComTypeID", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComWebsite", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComEmail", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmUpdOrganizationConversionToCustomer",
        procedureName = "CrmUpdOrganizationConversionToCustomer",
        resultClasses = {CrmPerCom.class},
        parameters = {
                @StoredProcedureParameter(name = "PerComID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmDelPerCom",
        procedureName = "CrmDelPerCom",
        resultClasses = {CrmPerCom.class},
        parameters = {
                @StoredProcedureParameter(name = "PerComID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)
@Entity
public class CrmPerCom extends TParams implements Serializable {
    @Id
    @Column(name = "PerComID")
    private BigDecimal perComID;

    @Column(name = "SaleCustomerID")
    private BigDecimal SaleCustomerID;

    @Column(name = "IsConverted")
    private String isConverted;
    @Column(name = "PerComTitle")
    private String perComTitle;
    @Column(name = "PerComFName")
    private String perComFName;
    @Column(name = "PerComLName")
    private String perComLName;
    @Column(name = "PerComName")
    private String perComName;
    @Column(name = "PerComAddress")
    private String perComAddress;
    @Column(name = "PerComMobile")
    private String perComMobile;
    @Column(name = "PerComPhone")
    private String perComPhone;
    @Column(name = "PerComTypeID")
    private Integer perComTypeID;
    @Column(name = "PerComTypeDesc")
    private String perComTypeDesc;

    @Column(name = "PerComWebsite")
    private String perComWebsite;

    @Column(name = "PerComEmail")
    private String perComEmail;

    @Column(name = "PerComDesc")
    private String perComDesc;
    @Column(name = "CreatorID")
    private BigDecimal creatorID;
    @Column(name = "CreateDate")
    private Date createDate;
    @Column(name = "ModifierID")
    private BigDecimal modifierID;
    @Column(name = "ModifyDate")
    private Date modifyDate;
    @Column(name = "ServerID")
    private BigDecimal serverID;


    public BigDecimal getPerComID() {
        return perComID;
    }

    public void setPerComID(BigDecimal perComID) {
        this.perComID = perComID;
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

    public String getPerComName() {
        return perComName;
    }

    public void setPerComName(String perComName) {
        this.perComName = perComName;
    }

    public String getPerComAddress() {
        return perComAddress;
    }

    public void setPerComAddress(String perComAddress) {
        this.perComAddress = perComAddress;
    }

    public String getPerComMobile() {
        return perComMobile;
    }

    public void setPerComMobile(String perComMobile) {
        this.perComMobile = perComMobile;
    }

    public String getPerComPhone() {
        return perComPhone;
    }

    public void setPerComPhone(String perComPhone) {
        this.perComPhone = perComPhone;
    }

    public String getPerComWebsite() {
        return perComWebsite;
    }

    public void setPerComWebsite(String perComWebsite) {
        this.perComWebsite = perComWebsite;
    }

    public String getPerComEmail() {
        return perComEmail;
    }

    public void setPerComEmail(String perComEmail) {
        this.perComEmail = perComEmail;
    }

    public String getPerComDesc() {
        return perComDesc;
    }

    public void setPerComDesc(String perComDesc) {
        this.perComDesc = perComDesc;
    }

    public Integer getPerComTypeID() {
        return perComTypeID;
    }

    public void setPerComTypeID(Integer perComTypeID) {
        this.perComTypeID = perComTypeID;
    }

    public String getPerComTypeDesc() {
        return perComTypeDesc;
    }

    public void setPerComTypeDesc(String perComTypeDesc) {
        this.perComTypeDesc = perComTypeDesc;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public BigDecimal getSaleCustomerID() {
        return SaleCustomerID;
    }

    public void setSaleCustomerID(BigDecimal saleCustomerID) {
        SaleCustomerID = saleCustomerID;
    }

    public String getIsConverted() {
        return isConverted;
    }

    public void setIsConverted(String isConverted) {
        this.isConverted = isConverted;
    }
}
