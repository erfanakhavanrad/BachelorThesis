package com.tarazgroup.tws.model.buy;

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
        name = "BuyShowType",
        procedureName = "BuyShowType",
        resultClasses = {BuyType.class},
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
        name = "BuyInsType",
        procedureName = "BuyInsType",
        parameters = {
                @StoredProcedureParameter(name = "BuyTypeCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BuyTypeDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCurrency", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "BuyUpdType",
        procedureName = "BuyUpdType",
        parameters = {
                @StoredProcedureParameter(name = "BuyTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BuyTypeCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BuyTypeDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCurrency", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "BuyDelType",
        procedureName = "BuyDelType",
        parameters = {
                @StoredProcedureParameter(name = "BuyTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
//@Table(name = "BuyType")
public class BuyType extends TParams implements Serializable {

    @Id
    @Column(name = "BuyTypeID")
    private BigDecimal buyTypeID;

    @Column(name = "BuyTypeCode")
    private String buyTypeCode;

    @Column(name = "BuyTypeDesc")
    private String buyTypeDesc;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "IsCurrency")
    private Boolean isCurrency;

    @Column(name = "RowCnt")
    private Integer rowCnt;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getBuyTypeID() {
        return buyTypeID;
    }

    public void setBuyTypeID(BigDecimal buyTypeID) {
        this.buyTypeID = buyTypeID;
    }

    @NotNull(message = "buyTypeCode is mandatory")
    @Schema(
            required = true,
            example = "1"
    )
    public String getBuyTypeCode() {
        return buyTypeCode;
    }

    public void setBuyTypeCode(String buyTypeCode) {
        this.buyTypeCode = buyTypeCode;
    }

    @NotNull(message = "buyTypeDesc is mandatory")
    @Schema(
            required = true,
            example = "1"
    )
    public String getBuyTypeDesc() {
        return buyTypeDesc;
    }

    public void setBuyTypeDesc(String buyTypeDesc) {
        this.buyTypeDesc = buyTypeDesc;
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
            required = true,
            example = "isCurrency"
    )
    public Boolean getIsCurrency() {
        return isCurrency;
    }

    public void setIsCurrency(Boolean isCurrency) {
        this.isCurrency = isCurrency;
    }

    public Integer getRowCnt() {
        return rowCnt;
    }

    public void setRowCnt(Integer rowCnt) {
        this.rowCnt = rowCnt;
    }
}
