package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Jan-10, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "AccShowGetVoucherFromExcelSetup",
        procedureName = "AccShowGetVoucherFromExcelSetup",
        resultClasses = {AccGetVoucherFromExcelSetup.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "AccInsGetVoucherFromExcelSetup",
        procedureName = "AccInsGetVoucherFromExcelSetup",
        parameters = {
                @StoredProcedureParameter(name = "FirstRowIsColumns", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Add13ToDateCol", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ColsStrSetup", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID",  type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class AccGetVoucherFromExcelSetup extends TParams implements Serializable {
    @Id
    @Column(name = "mID")
    private BigDecimal mID;

    @Column(name = "FirstRowIsColumns")
    private Boolean firstRowIsColumns;

    @Column(name = "Add13ToDateCol")
    private Boolean add13ToDateCol;

    @Column(name = "ColsStrSetup")
    private String colsStrSetup;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    public BigDecimal getmID() {
        return mID;
    }

    public void setmID(BigDecimal mID) {
        this.mID = mID;
    }

    public Boolean getFirstRowIsColumns() {
        return firstRowIsColumns;
    }

    public void setFirstRowIsColumns(Boolean firstRowIsColumns) {
        this.firstRowIsColumns = firstRowIsColumns;
    }

    public Boolean getAdd13ToDateCol() {
        return add13ToDateCol;
    }

    public void setAdd13ToDateCol(Boolean add13ToDateCol) {
        this.add13ToDateCol = add13ToDateCol;
    }

    public String getColsStrSetup() {
        return colsStrSetup;
    }

    public void setColsStrSetup(String colsStrSetup) {
        this.colsStrSetup = colsStrSetup;
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

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
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
}
