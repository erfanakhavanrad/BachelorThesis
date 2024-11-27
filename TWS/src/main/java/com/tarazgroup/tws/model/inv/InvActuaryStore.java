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
        name = "InvShowActuaryStore",
        procedureName = "InvShowActuaryStore",
        resultClasses = {InvActuaryStore.class},
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
        name = "InvDelActuaryStore",
        procedureName = "InvDelActuaryStore",
        resultClasses = {InvActuaryStore.class},
        parameters = {
                @StoredProcedureParameter(name = "SelectStoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)
// TODO: 10/9/21 Fix POST

@NamedStoredProcedureQuery(

        name = "InvInsActuaryStore",
        procedureName = "InvInsActuaryStore",
        resultClasses = {InvActuaryStore.class},
        parameters = {
                @StoredProcedureParameter(name = "actuaryID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN)
        })

@NamedStoredProcedureQuery(
        name = "InvUpdActuaryStore",
        procedureName = "InvUpdActuaryStore",
        resultClasses = {InvActuaryStore.class},
        parameters = {
                @StoredProcedureParameter(name = "SelectStoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "actuaryID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
        }
)

@Entity
public class InvActuaryStore extends TParams implements Serializable {

    @Id
    @Column(name = "SelectStoreID")
    private BigDecimal selectStoreID;

    @Column(name = "actuaryID")
    private BigDecimal actuaryID;

    @Column(name = "ActuaryCode")
    private String actuaryCode;

    @Column(name = "ActuaryDesc")
    private String actuaryDesc;

    @Column(name = "ActuaryCount")
    private Integer actuaryCount;

    @Column(name = "StoreID")
    private BigDecimal storeID;

    @Column(name = "StoreCode")
    private String storeCode;

    @Column(name = "StoreName")
    private String storeName;

    @Column(name = "TafsiliID")
    private BigDecimal tafsiliID;

    @Column(name = "TafsiliDesc")
    private String tafsiliDesc;

    @Column(name = "TafsiliCode")
    private String tafsiliCode;

    @Parameter(hidden = true)
    @Column(name = "CreateDate")
    private Date createDate;

    @Parameter(hidden = true)
    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Parameter(hidden = true)
    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Parameter(hidden = true)
    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Parameter(hidden = true)
    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "YearID")
    private BigDecimal yearID;

    @Column(name = "RowCnt")
    private Integer rowCnt;

    public BigDecimal getSelectStoreID() {
        return selectStoreID;
    }

    public void setSelectStoreID(BigDecimal selectStoreID) {
        this.selectStoreID = selectStoreID;
    }

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

    public BigDecimal getStoreID() {
        return storeID;
    }

    public void setStoreID(BigDecimal storeID) {
        this.storeID = storeID;
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

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
    }

    public String getTafsiliDesc() {
        return tafsiliDesc;
    }

    public void setTafsiliDesc(String tafsiliDesc) {
        this.tafsiliDesc = tafsiliDesc;
    }

    public String getTafsiliCode() {
        return tafsiliCode;
    }

    public void setTafsiliCode(String tafsiliCode) {
        this.tafsiliCode = tafsiliCode;
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

    public BigDecimal getYearID() {
        return yearID;
    }

    public void setYearID(BigDecimal yearID) {
        this.yearID = yearID;
    }

    public Integer getRowCnt() {
        return rowCnt;
    }

    public void setRowCnt(Integer rowCnt) {
        this.rowCnt = rowCnt;
    }
}
