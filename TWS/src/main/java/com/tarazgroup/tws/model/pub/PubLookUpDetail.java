package com.tarazgroup.tws.model.pub;


import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "PubShowLookUpDetail",
        procedureName = "PubShowLookUpDetail",
        resultClasses = {PubLookUpDetail.class},
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
    public class PubLookUpDetail extends TParams implements Serializable {

    @Id
    @Column(name = "LookUpID", columnDefinition = "decimal")
    private BigDecimal lookUpID;

    @Column(name = "RefrenceID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal refrenceID;

    @Column(name = "LookUpCode", columnDefinition = "nvarchar")
    private String lookUpCode;

    @Column(name = "SubjectDesc", columnDefinition = "nvarchar")
    private String subjectDesc;

    @Column(name = "LookUpName", columnDefinition = "nvarchar")
    private String lookUpName;

    @Column(name = "SystemID")
    private BigDecimal systemID;

    @Column(name = "LookUpType", columnDefinition = "tinyint")
    private Integer lookUpType;

    @Parameter(hidden = true )
    @Column(name = "CreateDate", columnDefinition = "datetime")
    private Date createDate;

    @Column(name = "ModifyDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "CreatorID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifierID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "ServerID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "PriorityLevel", columnDefinition = "smallint")
    private Integer priorityLevel;

    @Column(name = "ButtonID", columnDefinition = "nvarchar")
    private String buttonID;

    @Column(name = "LookUpTypeDesc")
    private String lookUpTypeDesc;

    @Column(name = "IsNotActive", columnDefinition = "bit")
    private Boolean isNotActive;

    @Column(name = "LookUpIdentity")
    private BigDecimal lookUpIdentity;

    @Column(name = "LookUpIdentityDesc")
    private String lookUpIdentityDesc;

    @Column(name = "XFieldNo", columnDefinition = "tinyint")
    private Integer xFieldNo;

    @Column(name = "ColorName", columnDefinition = "int")
    private Integer colorName;

    @Column(name = "IsActiveReport")
    private Boolean isActiveReport;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getLookUpID() {
        return lookUpID;
    }

    public void setLookUpID(BigDecimal lookUpID) {
        this.lookUpID = lookUpID;
    }

    @NotNull(message = "refrenceID is mandatory")
    @Schema(
            required = true,
            example = "refrenceID"
    )
    public BigDecimal getRefrenceID() {
        return refrenceID;
    }

    public void setRefrenceID(BigDecimal refrenceID) {
        this.refrenceID = refrenceID;
    }

    @NotBlank(message = "lookUpCode is mandatory")
    @Schema(
            required = true,
            example = "lookUpCode"
    )
    public String getLookUpCode() {
        return lookUpCode;
    }

    public void setLookUpCode(String lookUpCode) {
        this.lookUpCode = lookUpCode;
    }

    @NotBlank(message = "subjectDesc is mandatory")
    @Schema(
            required = true,
            example = "subjectDesc"
    )
    public String getSubjectDesc() {
        return subjectDesc;
    }

    public void setSubjectDesc(String subjectDesc) {
        this.subjectDesc = subjectDesc;
    }

    @NotBlank(message = "lookUpName is mandatory")
    @Schema(
            required = true,
            example = "lookUpName"
    )
    public String getLookUpName() {
        return lookUpName;
    }

    public void setLookUpName(String lookUpName) {
        this.lookUpName = lookUpName;
    }

    public BigDecimal getSystemID() {
        return systemID;
    }

    public void setSystemID(BigDecimal systemID) {
        this.systemID = systemID;
    }

    @Schema(
            required = true,
            example = "1"
    )
    public Integer getLookUpType() {
        return lookUpType;
    }

    public void setLookUpType(Integer lookUpType) {
        this.lookUpType = lookUpType;
    }

    @Schema(hidden = true)
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

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    @NotNull(message = "priorityLevel is mandatory")
    @Schema(
            required = true,
            example = "priorityLevel1"
    )
    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    @NotBlank(message = "buttonID is mandatory")
    @Schema(
            required = true,
            example = "buttonID1"
    )
    public String getButtonID() {
        return buttonID;
    }

    public void setButtonID(String buttonID) {
        this.buttonID = buttonID;
    }

    @NotNull(message = "isNotActive is mandatory")
    @Schema(
            required = true,
            example = "true"
    )
    public Boolean getIsNotActive() {
        return isNotActive;
    }


    public void setIsNotActive(Boolean isNotActive) {
        this.isNotActive = isNotActive;
    }

    @NotNull(message = "lookUpIdentity is mandatory")
    public BigDecimal getLookUpIdentity() {
        return lookUpIdentity;
    }

    public void setLookUpIdentity(BigDecimal lookUpIdentity) {
        this.lookUpIdentity = lookUpIdentity;
    }

    @Schema(
            example = "xFieldNo"
    )
    public Integer getxFieldNo() {
        return xFieldNo;
    }

    public void setxFieldNo(Integer xFieldNo) {
        this.xFieldNo = xFieldNo;
    }

    @Schema(
            example = "colorName"
    )
    public Integer getColorName() {
        return colorName;
    }

    public void setColorName(Integer colorName) {
        this.colorName = colorName;
    }

    public String getLookUpTypeDesc() {
        return lookUpTypeDesc;
    }

    public void setLookUpTypeDesc(String lookUpTypeDesc) {
        this.lookUpTypeDesc = lookUpTypeDesc;
    }


    public String getLookUpIdentityDesc() {
        return lookUpIdentityDesc;
    }

    public void setLookUpIdentityDesc(String lookUpIdentityDesc) {
        this.lookUpIdentityDesc = lookUpIdentityDesc;
    }

    public Boolean getIsActiveReport() {
        return isActiveReport;
    }

    public void setIsActiveReport(Boolean activeReport) {
        isActiveReport = activeReport;
    }
}
