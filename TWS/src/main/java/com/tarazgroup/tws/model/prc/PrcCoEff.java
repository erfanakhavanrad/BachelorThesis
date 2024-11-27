package com.tarazgroup.tws.model.prc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author A.Farahani
 */
@NamedStoredProcedureQuery(
        name = "PrcShowCoEff",
        procedureName = "PrcShowCoEff",
        resultClasses = {PrcCoEff.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "PrcInsCoEff",
        procedureName = "PrcInsCoEff",
        parameters = {
                @StoredProcedureParameter(name = "CoEffTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CoEffValue", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "PrcUpdCoEff",
        procedureName = "PrcUpdCoEff",
        parameters = {
                @StoredProcedureParameter(name = "CoEffID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CoEffTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CoEffValue", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "PrcDelCoEff",
        procedureName = "PrcDelCoEff",
        parameters = {
                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class PrcCoEff extends TParams implements Serializable {
    @Id
    @Column(name = "CoEffID")
    private BigDecimal coEffID;

    @Column(name = "CoEffTypeID")
    private BigDecimal coEffTypeID;

    @Column(name = "CoEffValue")
    private BigDecimal coEffValue;

    @Column(name = "GoodsID")
    private BigDecimal goodsID;

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

    @Column(name = "CoEffTypeDesc")
    private String coEffTypeDesc;

    public BigDecimal getCoEffID() {
        return coEffID;
    }

    public void setCoEffID(BigDecimal coEffID) {
        this.coEffID = coEffID;
    }

    public BigDecimal getCoEffTypeID() {
        return coEffTypeID;
    }

    public void setCoEffTypeID(BigDecimal coEffTypeID) {
        this.coEffTypeID = coEffTypeID;
    }

    public BigDecimal getCoEffValue() {
        return coEffValue;
    }

    public void setCoEffValue(BigDecimal coEffValue) {
        this.coEffValue = coEffValue;
    }

    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
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

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public String getCoEffTypeDesc() {
        return coEffTypeDesc;
    }

    public void setCoEffTypeDesc(String coEffTypeDesc) {
        this.coEffTypeDesc = coEffTypeDesc;
    }
}
