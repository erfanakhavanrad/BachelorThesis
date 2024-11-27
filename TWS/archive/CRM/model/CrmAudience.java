package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "CrmShowAudience",
        procedureName = "CrmShowAudience",
        resultClasses = {CrmAudience.class},
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
        name = "CrmInsAudience",
        procedureName = "CrmInsAudience",
        resultClasses = {CrmAudience.class},
        parameters = {
                @StoredProcedureParameter(name = "CustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TitleID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Tel", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Mobile", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "XDesc", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmUpdAudience",
        procedureName = "CrmUpdAudience",
        resultClasses = {CrmAudience.class},
        parameters = {
                @StoredProcedureParameter(name = "AudienceID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TitleID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Tel", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Mobile", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "XDesc", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmDelAudience",
        procedureName = "CrmDelAudience",
        resultClasses = {CrmAudience.class},
        parameters = {
                @StoredProcedureParameter(name = "AudienceID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)


@Entity
public class CrmAudience extends TParams implements Serializable {
    @Id
    @Column(name = "AudienceID")
    private BigDecimal audienceID;

    @Column(name = "CustomerID")
    @Parameter
    private BigDecimal customerID;

    @Column(name = "FName")
    @Parameter
    private String fName;

    @Column(name = "LName")
    @Parameter
    private String lName;

    @Column(name = "TitleID")
    @Parameter
    private BigDecimal titleID;

    @Column(name = "Tel")
    @Parameter
    private String tel;

    @Column(name = "Mobile")
    @Parameter
    private String mobile;

    @Column(name = "XDesc")
    @Parameter
    private String xDesc;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    public BigDecimal getAudienceID() {
        return audienceID;
    }

    public void setAudienceID(BigDecimal audienceID) {
        this.audienceID = audienceID;
    }

    public BigDecimal getCustomerID() {
        return customerID;
    }

    public void setCustomerID(BigDecimal customerID) {
        this.customerID = customerID;
    }

    public String getFName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public BigDecimal getTitleID() {
        return titleID;
    }

    public void setTitleID(BigDecimal titleID) {
        this.titleID = titleID;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getXDesc() {
        return xDesc;
    }

    public void setXDesc(String xDesc) {
        this.xDesc = xDesc;
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

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }
}
