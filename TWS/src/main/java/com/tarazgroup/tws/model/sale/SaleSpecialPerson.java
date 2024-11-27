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
        name = "SaleShowSpecialPerson",
        procedureName = "SaleShowSpecialPerson",
        resultClasses = {SaleSpecialPerson.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter",type = String.class,mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleDelSpecialPerson",
        procedureName = "SaleDelSpecialPerson",
        parameters = {
                @StoredProcedureParameter(name = "SpecialManID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result" , type = BigDecimal.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg",type = String.class,mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleInsSpecialPerson",
        procedureName = "SaleInsSpecialPerson",
        parameters = {
                @StoredProcedureParameter(name = "ManID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LookUPID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDesc",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result",type = BigDecimal.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg",type = String.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID",type = BigDecimal.class , mode = ParameterMode.OUT)

        }
)

@NamedStoredProcedureQuery(
        name = "SaleUpdSpecialPerson",
        procedureName = "SaleUpdSpecialPerson",
        parameters = {
                @StoredProcedureParameter(name = "SpecialManID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ManID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LookUPID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDesc",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result",type = BigDecimal.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg",type = String.class,mode = ParameterMode.OUT),
        }
)


@Entity
public class SaleSpecialPerson extends TParams implements Serializable {
    @Id
    @Column(name = "SpecialManID")
    private BigDecimal specialManID;

    @Column(name = "ManID")
    private BigDecimal ManID;

    @Column(name = "ManName")
    private String manName;

    @Column(name = "LookUPID")
    private BigDecimal LookUPID;

    @Column(name = "SubjectDesc")
    private String subjectDesc;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "CreatorID")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "VoucherDesc")
    private String VoucherDesc;


    public BigDecimal getSpecialManID() {
        return specialManID;
    }

    public void setSpecialManID(BigDecimal specialManID) {
        this.specialManID = specialManID;
    }

    public BigDecimal getManID() {
        return ManID;
    }

    public void setManID(BigDecimal manID) {
        ManID = manID;
    }

    public BigDecimal getLookUPID() {
        return LookUPID;
    }

    public void setLookUPID(BigDecimal lookUPID) {
        LookUPID = lookUPID;
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

    public String getVoucherDesc() {
        return VoucherDesc;
    }

    public void setVoucherDesc(String voucherDesc) {
        VoucherDesc = voucherDesc;
    }

    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    public String getSubjectDesc() {
        return subjectDesc;
    }

    public void setSubjectDesc(String subjectDesc) {
        this.subjectDesc = subjectDesc;
    }
}
