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
        name = "SaleShowGradeCustomers",
        procedureName = "SaleShowGradeCustomers",
        resultClasses = {SaleGradeCustomers.class},
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
        name = "SaleInsGradeCustomers",
        procedureName = "SaleInsGradeCustomers",
        parameters = {
                @StoredProcedureParameter(name = "GradeCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GradeDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GradeProminence", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleDelGradeCustomers",
        procedureName = "SaleDelGradeCustomers",
        resultClasses = {SaleGradeCustomers.class},
        parameters = {
                @StoredProcedureParameter(name = "GradeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleUpdGradeCustomers",
        procedureName = "SaleUpdGradeCustomers",
        resultClasses = {SaleGradeCustomers.class},
        parameters = {
                @StoredProcedureParameter(name = "GradeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GradeCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GradeDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GradeProminence", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)


@Entity
public class SaleGradeCustomers extends TParams implements Serializable {
    @Id
    @Column(name = "GradeID")
    private BigDecimal gradeID;

    @Column(name = "GradeCode")
    private String gradeCode;

    @Column(name = "GradeDesc")
    private String gradeDesc;

    @Column(name = "GradeProminence")
    private BigDecimal gradeProminence;

    @Column(name = "CreatorID")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

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

    public BigDecimal getGradeID() {
        return gradeID;
    }

    public void setGradeID(BigDecimal gradeID) {
        this.gradeID = gradeID;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getGradeDesc() {
        return gradeDesc;
    }

    public void setGradeDesc(String gradeDesc) {
        this.gradeDesc = gradeDesc;
    }

    public BigDecimal getGradeProminence() {
        return gradeProminence;
    }

    public void setGradeProminence(BigDecimal gradeProminence) {
        this.gradeProminence = gradeProminence;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
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
}
