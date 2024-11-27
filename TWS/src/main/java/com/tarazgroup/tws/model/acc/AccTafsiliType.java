package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "AccShowTafsiliType",
        procedureName = "AccShowTafsiliType",
        resultClasses = {AccTafsiliType.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
        }
)

@NamedStoredProcedureQuery(
        name = "AccInsTafsiliType",
        procedureName = "AccInsTafsiliType",
        parameters = {
                @StoredProcedureParameter(name = "TafsiliTypeDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StartNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FinishNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefTableName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefFieldName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "isAutoCode", type = boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "isAutoDelete", type = boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliIdentity", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliKindID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ShowInLevels", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
        }
)

@NamedStoredProcedureQuery(
        name = "AccDelTafsiliType",
        procedureName = "AccDelTafsiliType",
        parameters = {
                @StoredProcedureParameter(name = "TafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
        }
)

@NamedStoredProcedureQuery(
        name = "AccUpdTafsiliType",
        procedureName = "AccUpdTafsiliType",
        parameters = {
                @StoredProcedureParameter(name = "TafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliTypeDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StartNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FinishNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefTableName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefFieldName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "isAutoCode", type = boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "isAutoDelete", type = boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliIdentity", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliKindID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ShowInLevels", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
        }
)

@Entity
@Table(name = "AccTafsiliType")
public class AccTafsiliType extends TParams implements Serializable {

    @Id
    @Column(name = "TafsiliTypeID")
    @Parameter
    private BigDecimal tafsiliTypeID;

    @Column(name = "TafsiliTypeDesc")
    @Parameter
    private String tafsiliTypeDesc;

    @Column(name = "StartNumber")
    @Parameter
    private String startNumber;

    @Column(name = "FinishNumber")
    @Parameter
    private String finishNumber;

    @Column(name = "RefTableName")
    private String refTableName;

    @Column(name = "RefFieldName")
    private String refFieldName;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

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

    @Column(name = "IsAutoCode")
    @Parameter
    private Boolean isAutoCode;

    @Column(name = "IsAutoDelete")
    @Parameter
    private Boolean isAutoDelete;

    @Column(name = "TafsiliIdentity")
    private Integer tafsiliIdentity;

    @Column(name = "TafsiliIdentityDesc")
    private String tafsiliIdentityDesc;

    @Column(name = "TafsiliKindDesc")
    private String tafsiliKindDesc;

    @Column(name = "TafsiliKindID")
    private BigDecimal tafsiliKindID;

    @Column(name = "ShowInLevels")
    private String showInLevels;

    @Column(name = "CodeFieldName")
    private String codeFieldName;

    @Column(name = "DescFieldName")
    private String descFieldName;

    @Column(name = "WhereCond")
    private String whereCond;

    @Column(name = "JoinStr")

    @Schema(/*accessMode = READ_ONLY*/)
    public BigDecimal getTafsiliTypeID() {
        return tafsiliTypeID;
    }

    public void setTafsiliTypeID(BigDecimal tafsiliTypeID) {
        this.tafsiliTypeID = tafsiliTypeID;
    }

    @NotNull(message = "tafsiliTypeDesc is mandatory")
    @Schema(
            required = true,
            example = "گروه کالا"
    )
    public String getTafsiliTypeDesc() {
        return tafsiliTypeDesc;
    }

    public void setTafsiliTypeDesc(String tafsiliTypeDesc) {
        this.tafsiliTypeDesc = tafsiliTypeDesc;
    }

    @NotNull(message = "startNumber is mandatory")
    @Schema(
            required = true,
            example = "270501"
    )
    public String getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(String startNumber) {
        this.startNumber = startNumber;
    }

    @NotNull(message = "finishNumber is mandatory")
    @Schema(
            required = true,
            example = "281000"
    )
    public String getFinishNumber() {
        return finishNumber;
    }

    public void setFinishNumber(String finishNumber) {
        this.finishNumber = finishNumber;
    }

    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
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

    @NotNull(message = "isAutoCode is mandatory")
    @Schema(
            example = "true"
    )
    public Boolean isAutoCode() {
        return isAutoCode;
    }

    public void setIsAutoCode(Boolean autoCode) {
        this.isAutoCode = autoCode;
    }

    @NotNull(message = "isAutoDelete is mandatory")
    @Schema(
            example = "true"
    )
    public Boolean isAutoDelete() {
        return isAutoDelete;
    }

    public void setIsAutoDelete(Boolean autoDelete) {
        this.isAutoDelete = autoDelete;
    }

    @Schema(
            example = "4,5"
    )
    public String getShowInLevels() {
        return showInLevels;
    }

    public void setShowInLevels(String showInLevels) {
        this.showInLevels = showInLevels;
    }

    public String getRefTableName() {
        return refTableName;
    }

    public void setRefTableName(String refTableName) {
        this.refTableName = refTableName;
    }

    public String getRefFieldName() {
        return refFieldName;
    }

    public void setRefFieldName(String refFieldName) {
        this.refFieldName = refFieldName;
    }

    public Boolean getAutoCode() {
        return isAutoCode;
    }

    public void setAutoCode(Boolean autoCode) {
        isAutoCode = autoCode;
    }

    public Boolean getAutoDelete() {
        return isAutoDelete;
    }

    public void setAutoDelete(Boolean autoDelete) {
        isAutoDelete = autoDelete;
    }

    public Integer getTafsiliIdentity() {
        return tafsiliIdentity;
    }

    public void setTafsiliIdentity(Integer tafsiliIdentity) {
        this.tafsiliIdentity = tafsiliIdentity;
    }

    public String getTafsiliIdentityDesc() {
        return tafsiliIdentityDesc;
    }

    public void setTafsiliIdentityDesc(String tafsiliIdentityDesc) {
        this.tafsiliIdentityDesc = tafsiliIdentityDesc;
    }

    public String getTafsiliKindDesc() {
        return tafsiliKindDesc;
    }

    public void setTafsiliKindDesc(String tafsiliKindDesc) {
        this.tafsiliKindDesc = tafsiliKindDesc;
    }

    public BigDecimal getTafsiliKindID() {
        return tafsiliKindID;
    }

    public void setTafsiliKindID(BigDecimal tafsiliKindID) {
        this.tafsiliKindID = tafsiliKindID;
    }

    public String getCodeFieldName() {
        return codeFieldName;
    }

    public void setCodeFieldName(String codeFieldName) {
        this.codeFieldName = codeFieldName;
    }

    public String getDescFieldName() {
        return descFieldName;
    }

    public void setDescFieldName(String descFieldName) {
        this.descFieldName = descFieldName;
    }

    public String getWhereCond() {
        return whereCond;
    }

    public void setWhereCond(String whereCond) {
        this.whereCond = whereCond;
    }
}
