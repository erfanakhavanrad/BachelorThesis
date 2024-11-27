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
// GET SP
@NamedStoredProcedureQuery(
        name = "InvShowActuary",
        procedureName = "InvShowActuary",
        resultClasses = {InvActuary.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

// POST
@NamedStoredProcedureQuery(name = "InvInsActuary",
        procedureName = "InvInsActuary",
        resultClasses = {InvActuary.class},
        parameters = {
                @StoredProcedureParameter(name = "ActuaryCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActuaryDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActuaryCount", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CounterPart1", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CounterPart2", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CounterPart3", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "DifType1", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DifType2", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DifType3", type = Integer.class, mode = ParameterMode.IN)
        }
)


// PUT SP
@NamedStoredProcedureQuery(name = "InvUpdActuary",
        procedureName = "InvUpdActuary",
        resultClasses = {InvActuary.class},
        parameters = {
                @StoredProcedureParameter(name = "ActuaryID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActuaryCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActuaryDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActuaryCount", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CounterPart1", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CounterPart2", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CounterPart3", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "DifType1", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DifType2", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DifType3", type = Integer.class, mode = ParameterMode.IN)
        }
)

// DELETE
@NamedStoredProcedureQuery(name = "InvDelActuary",
        procedureName = "InvDelActuary",
        resultClasses = {InvActuary.class},
        parameters = {
                @StoredProcedureParameter(name = "ActuaryID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)


@Entity
public class InvActuary extends TParams implements Serializable {

    @Id
    @Column(name = "ActuaryID")
    private BigDecimal actuaryID;

    @Column(name = "ActuaryCode")
    @Parameter(hidden = false)
    private String actuaryCode;

    @Column(name = "ActuaryDesc")
    private String actuaryDesc;

    @Column(name = "ActuaryCount")
    private Integer actuaryCount;

    @Column(name = "CounterPart1")
    private Integer counterPart1;

    @Column(name = "CounterPart2")
    private Integer counterPart2;

    @Column(name = "CounterPart3")
    private Integer counterPart3;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "DifType1")
    private Integer difType1;

    @Column(name = "DifType2")
    private Integer difType2;

    @Column(name = "DifType3")
    private Integer difType3;

    @Column(name = "RowCnt")
    private Integer rowCnt;

    public BigDecimal getActuaryID() {
        return actuaryID;
    }

    public void setActuaryID(BigDecimal actuaryID) {
        this.actuaryID = actuaryID;
    }

    public String getActuaryCode() {
        return actuaryCode;
    }

    public void setActuaryCode(String actuaryCode) {
        this.actuaryCode = actuaryCode;
    }

    public String getActuaryDesc() {
        return actuaryDesc;
    }

    public void setActuaryDesc(String actuaryDesc) {
        this.actuaryDesc = actuaryDesc;
    }

    public Integer getActuaryCount() {
        return actuaryCount;
    }

    public void setActuaryCount(Integer actuaryCount) {
        this.actuaryCount = actuaryCount;
    }

    public Integer getCounterPart1() {
        return counterPart1;
    }

    public void setCounterPart1(Integer counterPart1) {
        this.counterPart1 = counterPart1;
    }

    public Integer getCounterPart2() {
        return counterPart2;
    }

    public void setCounterPart2(Integer counterPart2) {
        this.counterPart2 = counterPart2;
    }

    public Integer getCounterPart3() {
        return counterPart3;
    }

    public void setCounterPart3(Integer counterPart3) {
        this.counterPart3 = counterPart3;
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

    public Integer getDifType1() {
        return difType1;
    }

    public void setDifType1(Integer difType1) {
        this.difType1 = difType1;
    }

    public Integer getDifType2() {
        return difType2;
    }

    public void setDifType2(Integer difType2) {
        this.difType2 = difType2;
    }

    public Integer getDifType3() {
        return difType3;
    }

    public void setDifType3(Integer difType3) {
        this.difType3 = difType3;
    }

    public Integer getRowCnt() {
        return rowCnt;
    }

    public void setRowCnt(Integer rowCnt) {
        this.rowCnt = rowCnt;
    }
}
