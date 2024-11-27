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
        name = "AccShowBankConflictSetup",
        procedureName = "AccShowBankConflictSetup",
        resultClasses = {AccBankConflictSetup.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

//@NamedStoredProcedureQuery(
//        name = "AccInsBankConflictSetup",
//        procedureName = "AccInsBankConflictSetup",
//        parameters = {
//                @StoredProcedureParameter(name = "FirstRowIsColumns", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Add13ToDateCol", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Col1", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Col2", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Col3", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Col4", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Col5", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Col6", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "BankID", type = BigDecimal.class, mode = ParameterMode.OUT)
//        }
//)

@Entity
public class AccBankConflictSetup extends TParams implements Serializable {
    @Id
    @Column(name = "BankID")
    private BigDecimal bankID;

    @Column(name = "FirstRowIsColumns")
    private Boolean firstRowIsColumns;

    @Column(name = "Add13ToDateCol")
    private Boolean add13ToDateCol;

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

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "BankName")
    private String bankName;

    public BigDecimal getBankID() {
        return bankID;
    }

    public void setBankID(BigDecimal bankID) {
        this.bankID = bankID;
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

    public Integer getCol1() {
        return col1;
    }

    public void setCol1(Integer col1) {
        this.col1 = col1;
    }

    public Integer getCol2() {
        return col2;
    }

    public void setCol2(Integer col2) {
        this.col2 = col2;
    }

    public Integer getCol3() {
        return col3;
    }

    public void setCol3(Integer col3) {
        this.col3 = col3;
    }

    public Integer getCol4() {
        return col4;
    }

    public void setCol4(Integer col4) {
        this.col4 = col4;
    }

    public Integer getCol5() {
        return col5;
    }

    public void setCol5(Integer col5) {
        this.col5 = col5;
    }

    public Integer getCol6() {
        return col6;
    }

    public void setCol6(Integer col6) {
        this.col6 = col6;
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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
