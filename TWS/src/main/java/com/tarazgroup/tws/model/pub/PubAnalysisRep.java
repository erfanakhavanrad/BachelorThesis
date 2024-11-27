package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author A.Farahani
 */

@NamedStoredProcedureQuery(
        name = "PubShowAnalysisRep",
        procedureName = "PubShowAnalysisRep",
        resultClasses = {PubAnalysisRep.class},
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
        name = "PubInsAnalysisRep",
        procedureName = "PubInsAnalysisRep",
        resultClasses = {PubAnalysisRep.class},
        parameters = {
                @StoredProcedureParameter(name = "RepName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPrice", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "RepType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Is1stVchConfirmed", type = Boolean.class, mode = ParameterMode.IN)

        }
)

@NamedStoredProcedureQuery(
        name = "PubUpdAnalysisRep",
        procedureName = "PubUpdAnalysisRep",
        resultClasses = {PubAnalysisRep.class},
        parameters = {
                @StoredProcedureParameter(name = "RepID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RepName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPrice", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "RepType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Is1stVchConfirmed", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "PubDelAnalysisRep",
        procedureName = "PubDelAnalysisRep",
        resultClasses = {PubAnalysisRep.class},
        parameters = {
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RepID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class PubAnalysisRep extends TParams {
    @Id
    @Column(name = "RepID")
    private BigDecimal repID;

    @Column(name = "RepName")
    private String repName;

    @Column(name = "IsPrice")
    private Boolean isPrice;

    @Column(name = "RepType")
    private Integer repType;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "Is1stVchConfirmed")
    private Boolean is1stVchConfirmed;

    @Column(name = "RepTypeDesc")
    private String repTypeDesc;

    @Column(name = "RowCnt")
    private Integer rowCnt;

    public BigDecimal getRepID() {
        return repID;
    }

    public void setRepID(BigDecimal repID) {
        this.repID = repID;
    }

    public String getRepName() {
        return repName;
    }

    public void setRepName(String repName) {
        this.repName = repName;
    }

    public Boolean getIsPrice() {
        return isPrice;
    }

    public void setIsPrice(Boolean isPrice) {
        this.isPrice = isPrice;
    }

    public int getRepType() {
        return repType;
    }

    public void setRepType(int repType) {
        this.repType = repType;
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

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public Boolean getIs1stVchConfirmed() {
        return is1stVchConfirmed;
    }

    public void setIs1stVchConfirmed(Boolean is1stVchConfirmed) {
        this.is1stVchConfirmed = is1stVchConfirmed;
    }

    public String getRepTypeDesc() {
        return repTypeDesc;
    }

    public void setRepTypeDesc(String repTypeDesc) {
        this.repTypeDesc = repTypeDesc;
    }

    public Integer getRowCnt() {
        return rowCnt;
    }

    public void setRowCnt(Integer rowCnt) {
        this.rowCnt = rowCnt;
    }
}

