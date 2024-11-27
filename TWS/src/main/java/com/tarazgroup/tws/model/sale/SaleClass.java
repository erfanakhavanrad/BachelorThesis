package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "SaleShowClass",
        procedureName = "SaleShowClass",
        resultClasses = {SaleClass.class},
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
        name = "SaleInsClass",
        procedureName = "SaleInsClass",
        resultClasses = {SaleClass.class},
        parameters = {
                @StoredProcedureParameter(name = "ClassCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ClassDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FatherID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ClassLevel", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ClassType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "PriorityAddress", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "QuatoPercentage", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
public class SaleClass extends TParams implements Serializable {

    @Id
    @Column(name = "ClassID", columnDefinition = "decimal")
    private BigDecimal classID;

    @Column(name = "ClassCode", columnDefinition = "nvarchar")
    private String classCode;

    @Column(name = "ClassDesc", columnDefinition = "nvarchar")
    private String classDesc;

    @Column(name = "OtherDesc", columnDefinition = "nvarchar")
    private String otherDesc;

    @Column(name = "FatherID", columnDefinition = "decimal")
    private BigDecimal fatherID;

    @Column(name = "ServerID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "CreateDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private java.sql.Date createDate;

    @Column(name = "CreatorID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifyDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private java.sql.Date modifyDate;

    @Column(name = "ModifierID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "ClassLevel", columnDefinition = "tinyint")
    private Integer classLevel;

    @Column(name = "ClassType", columnDefinition = "tinyint")
    private Integer classType;

    @Column(name = "PriorityAddress", columnDefinition = "decimal")
    private BigDecimal priorityAddress;

    @Column(name = "QuatoPercentage", columnDefinition = "decimal")
    private BigDecimal quatoPercentage;


    @Schema(accessMode = READ_ONLY)
    public BigDecimal getClassID() {
        return classID;
    }

    public void setClassID(BigDecimal classID) {
        this.classID = classID;
    }

    @Schema(
            required = true,
            example = "01"
    )
    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    @Schema(
            required = true,
            example = "میدان ونک"
    )
    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

    @Schema(
            example = ""
    )
    public String getOtherDesc() {
        return otherDesc;
    }

    public void setOtherDesc(String otherDesc) {
        this.otherDesc = otherDesc;
    }

    @Schema(
            required = true,
            example = "10000001"
    )
    public BigDecimal getFatherID() {
        return fatherID;
    }

    public void setFatherID(BigDecimal fatherID) {
        this.fatherID = fatherID;
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

    @Schema(
            required = true,
            example = "2"
    )
    public Integer getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(Integer classLevel) {
        this.classLevel = classLevel;
    }

    @Schema(
            required = true,
            example = "4"
    )
    public Integer getClassType() {
        return classType;
    }

    public void setClassType(Integer classType) {
        this.classType = classType;
    }

    @Schema(
            required = true,
            example = "0"
    )
    public BigDecimal getPriorityAddress() {
        return priorityAddress;
    }

    public void setPriorityAddress(BigDecimal priorityAddress) {
        this.priorityAddress = priorityAddress;
    }

    @Schema(
            required = true,
            example = "0.000"
    )
    public BigDecimal getQuatoPercentage() {
        return quatoPercentage;
    }

    public void setQuatoPercentage(BigDecimal quatoPercentage) {
        this.quatoPercentage = quatoPercentage;
    }
}
