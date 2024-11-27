package com.tarazgroup.tws.model.acc;
/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @Since 2.0.0
 */

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@NamedStoredProcedureQuery(
        name = "AccShowCostCenter",
        procedureName = "AccShowCostCenter",
        resultClasses = {AccCostCenter.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)
@NamedStoredProcedureQuery(
        name = "AccInsCostCenter",
        procedureName = "AccInsCostCenter",
        resultClasses = {AccCostCenter.class},
        parameters = {
                @StoredProcedureParameter(name = "CostCenterCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CostCenterDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CostCenterTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CostCenterFatherID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)
@NamedStoredProcedureQuery(
        name = "AccUpdCostCenter",
        procedureName = "AccUpdCostCenter",
        resultClasses = {AccCostCenter.class},
        parameters = {
                @StoredProcedureParameter(name = "CostCenterID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CostCenterCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CostCenterDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CostCenterTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "AccDelCostCenter",
        procedureName = "AccDelCostCenter",
        resultClasses = {AccCostCenter.class},
        parameters = {
                @StoredProcedureParameter(name = "CostCenterID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)
@Entity
public class AccCostCenter extends TParams implements Serializable {
    @Id
    @Column(name = "CostCenterID", columnDefinition = "decimal")
    private BigDecimal costCenterID;

    @Column(name = "ServerID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "CostCenterCode", columnDefinition = "nvarchar")
    @Parameter
    private String costCenterCode;

    @Column(name = "CostCenterDesc", columnDefinition = "nvarchar")
    @Parameter
    private String costCenterDesc;

    @Column(name = "CostCenterTypeID", columnDefinition = "decimal")
    @Parameter
    private BigDecimal costCenterTypeID;

    @Column(name = "TafsiliID")
    private BigDecimal tafsiliID;

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

    @Column(name = "TafsiliCode")
    private String tafsiliCode;

    @Column(name = "TafsiliTypeID")
    @Transient
    private BigDecimal tafsiliTypeID;

    @Column(name = "TafsiliTypeDesc")
    private String tafsiliTypeDesc;

    @Column(name = "CostCenterTypeCode")
    private String costCenterTypeCode;

    @Column(name = "CostCenterTypeDesc")
    private String costCenterTypeDesc;

    @Schema(hidden = true)
    public BigDecimal getCostCenterID() {
        return costCenterID;
    }

    public void setCostCenterID(BigDecimal costCenterID) {
        this.costCenterID = costCenterID;
    }

    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }


    @Schema(
            name = "Morteza",
            required = true,
            example = "7"
    )
    public String getCostCenterCode() {
        return costCenterCode;
    }


    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    @Schema(
            required = true,
            example = "پشتيباني و خدمات"
    )
    public String getCostCenterDesc() {
        return costCenterDesc;
    }

    public void setCostCenterDesc(String costCenterDesc) {
        this.costCenterDesc = costCenterDesc;
    }

    @Schema(
            required = true,
            example = "79"
    )
    public BigDecimal getCostCenterTypeID() {
        return costCenterTypeID;
    }

    public void setCostCenterTypeID(BigDecimal costCenterTypeID) {
        this.costCenterTypeID = costCenterTypeID;
    }

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
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

    public BigDecimal getTafsiliTypeID() {
        return tafsiliTypeID;
    }

    public void setTafsiliTypeID(BigDecimal tafsiliTypeID) {

        this.tafsiliTypeID = tafsiliTypeID;
    }

    public String getTafsiliTypeDesc() {
        return tafsiliTypeDesc;
    }

    public void setTafsiliTypeDesc(String tafsiliTypeDesc) {
        this.tafsiliTypeDesc = tafsiliTypeDesc;
    }

    public String getCostCenterTypeCode() {
        return costCenterTypeCode;
    }

    public void setCostCenterTypeCode(String costCenterTypeCode) {
        this.costCenterTypeCode = costCenterTypeCode;
    }

    public String getCostCenterTypeDesc() {
        return costCenterTypeDesc;
    }

    public void setCostCenterTypeDesc(String costCenterTypeDesc) {
        this.costCenterTypeDesc = costCenterTypeDesc;
    }

    public String getTafsiliCode() {
        return tafsiliCode;
    }

    public void setTafsiliCode(String tafsiliCode) {
        this.tafsiliCode = tafsiliCode;
    }
}
