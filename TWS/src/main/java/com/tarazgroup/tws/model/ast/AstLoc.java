package com.tarazgroup.tws.model.ast;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Erfan Akhavan
 */


@NamedStoredProcedureQuery(
        name = "AstShowLoc",
        procedureName = "AstShowLoc",
        resultClasses = {AstLoc.class},
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
        name = "AstInsLoc",
        procedureName = "AstInsLoc",
        resultClasses = {AstLoc.class},
        parameters = {
                @StoredProcedureParameter(name = "LocFatherID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LocCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LocName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LocDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "AstUpdLoc",
        procedureName = "AstUpdLoc",
        resultClasses = {AstLoc.class},
        parameters = {
                @StoredProcedureParameter(name = "LocID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LocFatherID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LocCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LocName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LocDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "AstDelLoc",
        procedureName = "AstDelLoc",
        resultClasses = {AstLoc.class},
        parameters = {
                @StoredProcedureParameter(name = "LocID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class AstLoc extends TParams implements Serializable {

    @Id
    @Column(name = "LocID")
    private BigDecimal locID;

    @Column(name = "LocFatherID")
    private BigDecimal locFatherID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "LocCode")
    private String locCode;

    @Column(name = "LocName")
    private String locName;

    @Column(name = "LocDesc")
    private String locDesc;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "RowCnt")
    private Integer rowCnt;

    public BigDecimal getLocID() {
        return locID;
    }

    public void setLocID(BigDecimal locID) {
        this.locID = locID;
    }

    public BigDecimal getLocFatherID() {
        return locFatherID;
    }

    public void setLocFatherID(BigDecimal locFatherID) {
        this.locFatherID = locFatherID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public String getLocCode() {
        return locCode;
    }

    public void setLocCode(String locCode) {
        this.locCode = locCode;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public String getLocDesc() {
        return locDesc;
    }

    public void setLocDesc(String locDesc) {
        this.locDesc = locDesc;
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

    public Integer getRowCnt() {
        return rowCnt;
    }

    public void setRowCnt(Integer rowCnt) {
        this.rowCnt = rowCnt;
    }
}
