package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "InvShowSecUnit",
        procedureName = "InvShowSecUnit",
        resultClasses = {InvSecUnit.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "InvInsSecUnit",
        procedureName = "InvInsSecUnit",
        parameters = {
                @StoredProcedureParameter(name = "UnitID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ComputeType", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ComputeValue", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode= ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsDefault", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSec2Active", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSec3Active", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Quantity23Type", type = Integer.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "InvUpdSecUnit",
        procedureName = "InvUpdSecUnit",
        parameters = {
                @StoredProcedureParameter(name = "SecUnitID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UnitID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ComputeType", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ComputeValue", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsDefault", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSec2Active", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSec3Active", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Quantity23Type", type = Integer.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "InvDelSecUnit",
        procedureName = "InvDelSecUnit",
        parameters = {
                @StoredProcedureParameter(name = "SecUnitID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
@Table(name = "InvSecUnit")
public class InvSecUnit extends TParams implements Serializable {

    @Id
    @Column(name = "SecUnitID")
    private BigDecimal secUnitID;

    @Column(name = "UnitID")
    private BigDecimal unitID;

    @Column(name = "GoodsID")
    private BigDecimal goodsID;

    @Column(name = "ComputeType")
    private Boolean computeType;

    @Column(name = "ComputeValue")
    private BigDecimal computeValue;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "SecUnitCode")
    private String secUnitCode;

    @Column(name = "SecUnitDesc")
    private String secUnitDesc;

    @Column(name = "IsSec2Active")
    private Boolean isSec2Active;

    @Column(name = "IsSec3Active")
    private Boolean isSec3Active;

    @Column(name = "Quantity23Type")
    private Integer quantity23Type;

    @Column(name = "ComputeTypeDesc")
    private String computeTypeDesc;

    @Column(name = "IsDefault")
    private Boolean isDefault;

    @Column(name = "Quantity23TypeDesc")
    private String quantity23TypeDesc;

    @Column(name = "Goodscode")
    private String goodscode;

    @Column(name = "GoodsDesc")
    private String goodsDesc;

    @Column(name = "UnitDesc")
    private String unitDesc;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getSecUnitID() {
        return secUnitID;
    }

    public void setSecUnitID(BigDecimal secUnitID) {
        this.secUnitID = secUnitID;
    }

    public BigDecimal getUnitID() {
        return unitID;
    }

    public void setUnitID(BigDecimal unitID) {
        this.unitID = unitID;
    }

    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
    }

    @NotNull(message = "computeType is mandatory")
    @Schema(
            required = true,
            example = "false"
    )
    public Boolean getIsComputeType() {
        return computeType;
    }

    public void setComputeType(Boolean computeType) {
        this.computeType = computeType;
    }

    @NotNull(message = "accountCode is mandatory")
    @Schema(
            required = true,
            example = "1"
    )
    public BigDecimal getComputeValue() {
        return computeValue;
    }

    public void setComputeValue(BigDecimal computeValue) {
        this.computeValue = computeValue;
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
            example = "1"
    )
    public Integer getQuantity23Type() {
        return quantity23Type;
    }

    public void setQuantity23Type(Integer quantity23Type) {
        this.quantity23Type = quantity23Type;
    }

    @Schema(
            example = "true"
    )
    public Boolean getIsSec2Active() {
        return isSec2Active;
    }

    public void setIsSec2Active(Boolean isSec2Active) {
        this.isSec2Active = isSec2Active;
    }

    @Schema(
            example = "false"
    )
    public Boolean getIsSec3Active() {
        return isSec3Active;
    }

    public void setIsSec3Active(Boolean isSec3Active) {
        this.isSec3Active = isSec3Active;
    }

    public Boolean getComputeType() {
        return computeType;
    }

    public String getSecUnitCode() {
        return secUnitCode;
    }

    public void setSecUnitCode(String secUnitCode) {
        this.secUnitCode = secUnitCode;
    }

    public String getSecUnitDesc() {
        return secUnitDesc;
    }

    public void setSecUnitDesc(String secUnitDesc) {
        this.secUnitDesc = secUnitDesc;
    }





    public String getComputeTypeDesc() {
        return computeTypeDesc;
    }

    public void setComputeTypeDesc(String computeTypeDesc) {
        this.computeTypeDesc = computeTypeDesc;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getQuantity23TypeDesc() {
        return quantity23TypeDesc;
    }

    public void setQuantity23TypeDesc(String quantity23TypeDesc) {
        this.quantity23TypeDesc = quantity23TypeDesc;
    }

    public String getGoodscode() {
        return goodscode;
    }

    public void setGoodscode(String goodscode) {
        this.goodscode = goodscode;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
    }
}
