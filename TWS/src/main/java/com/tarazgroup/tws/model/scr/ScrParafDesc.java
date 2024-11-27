package com.tarazgroup.tws.model.scr;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author A.Farahani
 * @date Dec-22, 2021
 */

@NamedStoredProcedureQuery(
        name = "ScrShowParafDesc",
        procedureName = "ScrShowParafDesc",
        resultClasses = {ScrParafDesc.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsWebUser", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "ScrInsParafDesc",
        procedureName = "ScrInsParafDesc",
        parameters = {
                @StoredProcedureParameter(name = "ParafDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "ScrUpdParafDesc",
        procedureName = "ScrUpdParafDesc",
        parameters = {
                @StoredProcedureParameter(name = "ParafID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ParafDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "ScrDelParafDesc",
        procedureName = "ScrDelParafDesc",
        parameters = {
                @StoredProcedureParameter(name = "ParafID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class ScrParafDesc extends TParams implements Serializable {
    @Id
    @Column(name = "ParafID")
    private BigDecimal parafID;

    @Column(name = "ParafDesc")
    private String parafDesc;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    public BigDecimal getParafID() {
        return parafID;
    }

    public void setParafID(BigDecimal parafID) {
        this.parafID = parafID;
    }

    public String getParafDesc() {
        return parafDesc;
    }

    public void setParafDesc(String parafDesc) {
        this.parafDesc = parafDesc;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
