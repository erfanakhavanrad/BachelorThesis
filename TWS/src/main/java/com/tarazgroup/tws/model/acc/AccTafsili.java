package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "AccShowTafsili",
        procedureName = "AccShowTafsili",
        resultClasses = {AccTafsili.class},
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
        name = "AccInsTafsili",
        procedureName = "AccInsTafsili",
        parameters = {
                @StoredProcedureParameter(name = "TafsiliCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliDesc1", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliDesc2", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErroronDuplicate", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "AccDelTafsili",
        procedureName = "AccDelTafsili",
        parameters = {
                @StoredProcedureParameter(name = "TafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefTableName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefFieldName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "AccUpdTafsili",
        procedureName = "AccUpdTafsili",
        parameters = {
                @StoredProcedureParameter(name = "TafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliDesc1", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliDesc2", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliCode", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "AccAutoTafsili",
        procedureName = "AccAutoTafsili",
        parameters = {
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)
@Entity
public class AccTafsili extends TParams implements Serializable {

    @Id
    @Column(name = "TafsiliID")
    @Parameter(hidden = true)
    private BigDecimal tafsiliID;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "TafsiliCode")
    @Parameter
    private String tafsiliCode;

    @Column(name = "TafsiliDesc")
    @Parameter
    private String tafsiliDesc;

    @Column(name = "TafsiliDesc1")
    @Parameter
    private String tafsiliDesc1;

    @Column(name = "TafsiliDesc2")
    @Parameter
    private String tafsiliDesc2;

    @Column(name = "TafsiliName")
    private String tafsiliName;

    @Column(name = "TafsiliTypeID")
    private BigDecimal tafsiliTypeID;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "CreatorID")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "CreateDateShamsi")
    private String createDateShamsi;

    @Column(name = "ModifyDateShamsi")
    private String modifyDateShamsi;

    @Column(name = "CreateUserName")
    private String createUserName;

    @Column(name = "ModifyUserName")
    private String modifyUserName;

    @Column(name = "ReferID")
    @Parameter(hidden = true)
    private BigDecimal referID;

    @Column(name = "TafsiliTypeDesc")
    private String tafsiliTypeDesc;

    @Column(name = "HasFlow")
    private Boolean hasFlow;

    @Column(name = "IsNotActive")
    @Parameter
    private Boolean isNotActive;

    @Column(name = "LastTafsiliCode")
    @Parameter(hidden = true)
    @Transient
    private String lastTafsiliCode;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
    }

    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    @Schema(
            required = true,
            example = "7851232"
    )
    public String getTafsiliCode() {
        return tafsiliCode;
    }

    public void setTafsiliCode(String tafsiliCode) {
        this.tafsiliCode = tafsiliCode;
    }

    @Schema(
            required = true,
            example = "یه چیزی"
    )
    public String getTafsiliDesc() {
        return tafsiliDesc;
    }

    public void setTafsiliDesc(String tafsiliDesc) {
        this.tafsiliDesc = tafsiliDesc;
    }

    @Schema(
            required = true,
            example = "میوه و سبزیجات"
    )
    public String getTafsiliDesc1() {
        return tafsiliDesc1;
    }

    public void setTafsiliDesc1(String tafsiliDesc1) {
        this.tafsiliDesc1 = tafsiliDesc1;
    }

    @Schema(
            required = true,
            example = "چیز میز"
    )
    public String getTafsiliDesc2() {
        return tafsiliDesc2;
    }

    public void setTafsiliDesc2(String tafsiliDesc2) {
        this.tafsiliDesc2 = tafsiliDesc2;
    }

    @Schema(hidden = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Schema(hidden = true)
    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    @Schema(hidden = true)
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Schema(hidden = true)
    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    @Schema(hidden = true)
    public BigDecimal getReferID() {
        return referID;
    }

    public void setReferID(BigDecimal referID) {
        this.referID = referID;
    }

    @Schema(
            example = "$0000270504"
    )
    public String getLastTafsiliCode() {
        return lastTafsiliCode;
    }

    public void setLastTafsiliCode(String lastTafsiliCode) {
        this.lastTafsiliCode = lastTafsiliCode;
    }

    @Schema(
            example = "true"
    )
    public Boolean isNotActive() {
        return isNotActive;
    }

    public void setIsNotActive(boolean notActive) {


        this.isNotActive = notActive;
    }

    public String getTafsiliName() {
        return tafsiliName;
    }

    public void setTafsiliName(String tafsiliName) {
        this.tafsiliName = tafsiliName;
    }

    public BigDecimal getTafsiliTypeID() {
        return tafsiliTypeID;
    }

    public void setTafsiliTypeID(BigDecimal tafsiliTypeID) {
        this.tafsiliTypeID = tafsiliTypeID;
    }

    public String getCreateDateShamsi() {
        return createDateShamsi;
    }

    public void setCreateDateShamsi(String createDateShamsi) {
        this.createDateShamsi = createDateShamsi;
    }

    public String getModifyDateShamsi() {
        return modifyDateShamsi;
    }

    public void setModifyDateShamsi(String modifyDateShamsi) {
        this.modifyDateShamsi = modifyDateShamsi;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    public String getTafsiliTypeDesc() {
        return tafsiliTypeDesc;
    }

    public void setTafsiliTypeDesc(String tafsiliTypeDesc) {
        this.tafsiliTypeDesc = tafsiliTypeDesc;
    }

    public Boolean getHasFlow() {
        return hasFlow;
    }

    public void setHasFlow(Boolean hasFlow) {
        this.hasFlow = hasFlow;
    }

    public Boolean getNotActive() {
        return isNotActive;
    }

    public void setNotActive(Boolean notActive) {
        isNotActive = notActive;
    }
}
