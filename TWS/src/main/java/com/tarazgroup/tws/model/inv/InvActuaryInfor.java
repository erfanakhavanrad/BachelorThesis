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
        name = "InvShowActuaryInfor",
        procedureName = "InvShowActuaryInfor",
        resultClasses = {InvActuaryInfor.class},
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
        name = "InvInsActuaryInfor",
        procedureName = "InvInsActuaryInfor",
        resultClasses = {InvActuaryInfor.class},
        parameters = {
                @StoredProcedureParameter(name = "ActuaryStoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActuaryDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "InvUpdActuaryInfor",
        procedureName = "InvUpdActuaryInfor",
        resultClasses = {InvActuaryInfor.class},
        parameters = {
                @StoredProcedureParameter(name = "ActuaryInforID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActuaryStoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActuaryDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "InvDelActuaryInfor",
        procedureName = "InvDelActuaryInfor",
        resultClasses = {InvActuaryInfor.class},
        parameters = {
                @StoredProcedureParameter(name = "ActuaryInforID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)


@Entity
public class InvActuaryInfor extends TParams implements Serializable {

    @Id
    @Column(name = "ActuaryInforID")
    private BigDecimal actuaryInforID;

    @Column(name = "ActuaryStoreID")
    private BigDecimal actuaryStoreID;

    @Column(name = "ActuaryCode")
    private String actuaryCode;

    @Column(name = "ActuaryDesc")
    private String actuaryDesc;

    @Column(name = "ActuaryCount")
    private Integer actuaryCount;

    @Column(name = "ToDate")
    private String toDate;

    @Column(name = "StoreId")
    private BigDecimal storeId;

    @Column(name = "StoreCode")
    private String storeCode;

    @Column(name = "StoreName")
    private String storeName;

    @Column(name = "TafsiliDesc")
    private String tafsiliDesc;

    @Column(name = "ActuaryDate")
    private String actuaryDate;

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

    public BigDecimal getActuaryInforID() {
        return actuaryInforID;
    }

    public void setActuaryInforID(BigDecimal actuaryInforID) {
        this.actuaryInforID = actuaryInforID;
    }

    public BigDecimal getActuaryStoreID() {
        return actuaryStoreID;
    }

    public void setActuaryStoreID(BigDecimal actuaryStoreID) {
        this.actuaryStoreID = actuaryStoreID;
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

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public BigDecimal getStoreId() {
        return storeId;
    }

    public void setStoreId(BigDecimal storeId) {
        this.storeId = storeId;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getTafsiliDesc() {
        return tafsiliDesc;
    }

    public void setTafsiliDesc(String tafsiliDesc) {
        this.tafsiliDesc = tafsiliDesc;
    }

    public String getActuaryDate() {
        return actuaryDate;
    }

    public void setActuaryDate(String actuaryDate) {
        this.actuaryDate = actuaryDate;
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
