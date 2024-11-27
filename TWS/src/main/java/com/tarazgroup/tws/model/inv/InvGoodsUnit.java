package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "InvShowGoodsUnit",
        procedureName = "InvShowGoodsUnit",
        resultClasses = {InvGoodsUnit.class},
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
        name = "InvDelGoodsUnit",
        procedureName = "InvDelGoodsUnit",
        resultClasses = {InvGoodsUnit.class},
        parameters = {
                @StoredProcedureParameter(name = "UnitID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "InvInsGoodsUnit",
        procedureName = "InvInsGoodsUnit",
        resultClasses = {InvGoodsUnit.class},
        parameters = {
                @StoredProcedureParameter(name = "UnitCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UnitDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "InvUpdGoodsUnit",
        procedureName = "InvUpdGoodsUnit",
        resultClasses = {InvGoodsUnit.class},
        parameters = {
                @StoredProcedureParameter(name = "UnitID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UnitCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UnitDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class InvGoodsUnit extends TParams implements Serializable {

    @Id
    @Column(name = "UnitID")
    @Parameter(hidden = true)
    private BigDecimal unitID;

    @Column(name = "UnitCode")
    @Parameter
    private String unitCode;

    @Column(name = "UnitDesc")
    @Parameter
    private String unitDesc;

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

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "IsQuantitative")
    @Parameter
    private Boolean isQuantitative;

    @Column(name = "IsQuantitativeDesc")
    private String isQuantitativeDesc;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getUnitID() {
        return unitID;
    }

    public void setUnitID(BigDecimal unitID) {
        this.unitID = unitID;
    }

    @NotBlank(message = "unitCode is mandatory")
    @Schema(
            required = true,
            example = "6"
    )
    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    @NotBlank(message = "unitDesc is mandatory")
    @Schema(
            required = true,
            example = "میلی متر"
    )
    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
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
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    @Schema(
            example = "true"
    )
    public Boolean getIsQuantitative() {
        return isQuantitative;
    }

    public void setIsQuantitative(Boolean isQuantitative) {
        this.isQuantitative = isQuantitative;
    }

    public String getIsQuantitativeDesc() {
        return isQuantitativeDesc;
    }

    public void setIsQuantitativeDesc(String isQuantitativeDesc) {
        this.isQuantitativeDesc = isQuantitativeDesc;
    }
}
