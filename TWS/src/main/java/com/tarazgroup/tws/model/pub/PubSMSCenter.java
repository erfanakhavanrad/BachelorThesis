package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author A.Farahani
 * @date Dec-18, 2021
 */

@NamedStoredProcedureQuery(
        name = "PubShowSMSCenter",
        procedureName = "PubShowSMSCenter",
        resultClasses = {PubSMSCenter.class},
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
        name = "PubInsSMSCenter",
        procedureName = "PubInsSMSCenter",
        parameters = {
                @StoredProcedureParameter(name = "SMSCenterCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMSCenterDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebServiceNo", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebServiceUserName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebServicePassWord", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebServiceAddress", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsShowMsg", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebServiceHost", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebServiceErrorMsg", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "PubUpdSMSCenter",
        procedureName = "PubUpdSMSCenter",
        parameters = {
                @StoredProcedureParameter(name = "SMSCenterID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMSCenterCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMSCenterDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebServiceNo", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebServiceUserName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebServicePassWord", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebServiceAddress", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsShowMsg", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebServiceHost", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebServiceErrorMsg", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "PubDelSMSCenter",
        procedureName = "PubDelSMSCenter",
        parameters = {
                @StoredProcedureParameter(name = "SMSCenterID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
//@Table(name = "PubSMSCenter")
public class PubSMSCenter extends TParams implements Serializable {
    @Id
    @Column(name = "SMSCenterID")
    @Parameter(hidden = true)
    private BigDecimal smsCenterID;

    @Column(name = "SMSCenterCode")
    @Parameter(hidden = true)
    private String smsCenterCode;

    @Column(name = "SMSCenterDesc")
    @Parameter(hidden = true)
    private String smsCenterDesc;

    @Column(name = "WebServiceNo")
    @Parameter(hidden = true)
    private String webServiceNo;

    @Column(name = "WebServiceUserName")
    @Parameter(hidden = true)
    private String webServiceUserName;

    @Column(name = "WebServicePassWord")
    @Parameter(hidden = true)
    private String webServicePassWord;

    @Column(name = "WebServiceAddress")
    @Parameter(hidden = true)
    private String webServiceAddress;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "CreatorID")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "IsShowMsg")
    @Parameter(hidden = true)
    private Boolean isShowMsg;

    @Column(name = "WebServiceHost")
    @Parameter(hidden = true)
    private String webServiceHost;

    @Column(name = "WebServiceErrorMsg")
    @Parameter(hidden = true)
    private String webServiceErrorMsg;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getSmsCenterID() {
        return smsCenterID;
    }

    public void setSmsCenterID(BigDecimal smsCenterID) {
        this.smsCenterID = smsCenterID;
    }

    @NotNull(message = "SMSCenterCode is mandatory")
    public String getSmsCenterCode() {
        return smsCenterCode;
    }

    public void setSmsCenterCode(String smsCenterCode) {
        this.smsCenterCode = smsCenterCode;
    }

    @NotNull(message = "SMSCenterDesc is mandatory")
    public String getSmsCenterDesc() {
        return smsCenterDesc;
    }

    public void setSmsCenterDesc(String smsCenterDesc) {
        this.smsCenterDesc = smsCenterDesc;
    }

    @NotNull(message = "WebServiceNo is mandatory")
    public String getWebServiceNo() {
        return webServiceNo;
    }

    public void setWebServiceNo(String webServiceNo) {
        this.webServiceNo = webServiceNo;
    }

    @NotNull(message = "WebServiceUserName is mandatory")
    public String getWebServiceUserName() {
        return webServiceUserName;
    }

    public void setWebServiceUserName(String webServiceUserName) {
        this.webServiceUserName = webServiceUserName;
    }

    @NotNull(message = "WebServicePassWord is mandatory")
    public String getWebServicePassWord() {
        return webServicePassWord;
    }

    public void setWebServicePassWord(String webServicePassWord) {
        this.webServicePassWord = webServicePassWord;
    }

    @NotNull(message = "WebServiceAddress is mandatory")
    public String getWebServiceAddress() {
        return webServiceAddress;
    }

    public void setWebServiceAddress(String webServiceAddress) {
        this.webServiceAddress = webServiceAddress;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Schema(hidden = true)
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Schema(hidden = true)
    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    @Schema(hidden = true)
    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public Boolean getIsShowMsg() {
        return isShowMsg;
    }

    public void setIsShowMsg(Boolean isShowMsg) {
        this.isShowMsg = isShowMsg;
    }

    public String getWebServiceHost() {
        return webServiceHost;
    }

    public void setWebServiceHost(String webServiceHost) {
        this.webServiceHost = webServiceHost;
    }

    public String getWebServiceErrorMsg() {
        return webServiceErrorMsg;
    }

    public void setWebServiceErrorMsg(String webServiceErrorMsg) {
        this.webServiceErrorMsg = webServiceErrorMsg;
    }
}
