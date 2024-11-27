package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "InvShowStoreCountExcelSetup",
        procedureName = "InvShowStoreCountExcelSetup",
        resultClasses = {InvStoreCountExcelSetup.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)


@NamedStoredProcedureQuery(
        name = "InvInsStoreCountExcelSetup",
        procedureName = "InvInsStoreCountExcelSetup",
        resultClasses = {InvStoreCountExcelSetup.class},
        parameters = {
                @StoredProcedureParameter(name = "FirstRowIsColumns", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Add13ToDateCol", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Col1", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Col2", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Col3", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Col4", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Col5", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Col6", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
public class InvStoreCountExcelSetup extends TParams implements Serializable {

    @Id
    @Column(name = "FirstRowIsColumns")
    private boolean firstRowIsColumns;

    @Column(name = "Add13ToDateCol")
    private boolean add13ToDateCol;

    @Column(name = "Col1")
    private Integer col1;

    @Column(name = "Col2")
    private Integer col2;

    @Column(name = "Col3")
    private Integer col3;

    @Column(name = "Col4")
    private Integer col4;

    @Column(name = "Col5")
    private Integer col5;

    @Column(name = "Col6")
    private Integer col6;

    @Parameter(hidden = true)
    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Parameter(hidden = true)
    @Column(name = "CreateDate")
    private Date createDate;

    @Parameter(hidden = true)
    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Parameter(hidden = true)
    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Parameter(hidden = true)
    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    public boolean getIsFirstRowIsColumns() {
        return firstRowIsColumns;
    }

    public void setFirstRowIsColumns(boolean firstRowIsColumns) {
        this.firstRowIsColumns = firstRowIsColumns;
    }

    public void setAdd13ToDateCol(boolean add13ToDateCol) {
        this.add13ToDateCol = add13ToDateCol;
    }

    public void setCol1(Integer col1) {
        this.col1 = col1;
    }

    public void setCol2(Integer col2) {
        this.col2 = col2;
    }

    public void setCol3(Integer col3) {
        this.col3 = col3;
    }

    public void setCol4(Integer col4) {
        this.col4 = col4;
    }

    public void setCol5(Integer col5) {
        this.col5 = col5;
    }

    public void setCol6(Integer col6) {
        this.col6 = col6;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public boolean getIsAdd13ToDateCol() {
        return add13ToDateCol;
    }

    public Integer getCol1() {
        return col1;
    }

    public Integer getCol2() {
        return col2;
    }

    public Integer getCol3() {
        return col3;
    }

    public Integer getCol4() {
        return col4;
    }

    public Integer getCol5() {
        return col5;
    }

    public Integer getCol6() {
        return col6;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }
}
