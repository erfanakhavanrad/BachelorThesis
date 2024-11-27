package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author A.Salehi
 */

@NamedStoredProcedureQuery(
        name = "SaleShowNoPurchase",
        procedureName = "SaleShowNoPurchase",
        resultClasses = {SaleNoPurchase.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleInsNoPurchase",
        procedureName = "SaleInsNoPurchase",
        parameters = {
                @StoredProcedureParameter(name = "NoPurchaseCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NoPurchaseDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
        }
)

@NamedStoredProcedureQuery(
        name = "SaleUpdNoPurchase",
        procedureName = "SaleUpdNoPurchase",
        parameters = {
                @StoredProcedureParameter(name = "NoPurchaseID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NoPurchaseCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NoPurchaseDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
        }
)

@NamedStoredProcedureQuery(
        name = "SaleDelNoPurchase",
        procedureName = "SaleDelNoPurchase",
        parameters = {
                @StoredProcedureParameter(name = "NoPurchaseID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = BigDecimal.class, mode = ParameterMode.OUT),
        }
)

@Entity
public class SaleNoPurchase extends TParams implements Serializable {

    @Id
    @Column(name = "noPurchaseID")
    private BigDecimal noPurchaseID;

    @Column(name = "NoPurchaseCode")
    private String noPurchaseCode;

    @Column(name = "NoPurchaseDesc")
    private String noPurchaseDesc;

    @Parameter(hidden = true)
    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Parameter(hidden = true)
    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Parameter(hidden = true)
    @Column(name = "CreateDate")
    private Date createDate;

    @Parameter(hidden = true)
    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Parameter(hidden = true)
    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    public BigDecimal getNoPurchaseID() {
        return noPurchaseID;
    }

    public void setNoPurchaseID(BigDecimal noPurchaseID) {
        this.noPurchaseID = noPurchaseID;
    }

    public String getNoPurchaseCode() {
        return noPurchaseCode;
    }

    public void setNoPurchaseCode(String noPurchaseCode) {
        this.noPurchaseCode = noPurchaseCode;
    }

    public String getNoPurchaseDesc() {
        return noPurchaseDesc;
    }

    public void setNoPurchaseDesc(String noPurchaseDesc) {
        this.noPurchaseDesc = noPurchaseDesc;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
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

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }
}
