package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "InvShowControlStore",
        procedureName = "InvShowControlStore",
        resultClasses = {InvControlStore.class},
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
        name = "InvInsControlStore",
        procedureName = "InvInsControlStore",
        resultClasses = {InvControlStore.class},
        parameters = {
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StartDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FinishDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StartDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FinishDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ControllerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "InvUpdControlStore",
        procedureName = "InvUpdControlStore",
        resultClasses = {InvControlStore.class},
        parameters = {
                @StoredProcedureParameter(name = "ControlStoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StartDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FinishDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StartDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FinishDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ControllerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "InvDelControlStore",
        procedureName = "InvDelControlStore",
        resultClasses = {InvControlStore.class},
        parameters = {
                @StoredProcedureParameter(name = "ControlStoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class InvControlStore extends TParams {
    @Id
    @Column(name = "ControlStoreID")
    private BigDecimal controlStoreID;

    @Column(name = "StoreID")
    private BigDecimal storeID;

    @Column(name = "StartDate")
    private String startDate;

    @Column(name = "FinishDate")
    private String finishDate;

    @Column(name = "StartDateG")
    private Date startDateG;

    @Column(name = "FinishDateG")
    private Date finishDateG;

    @Column(name = "ControllerID")
    private BigDecimal controllerID;

    @Parameter(hidden = true)
    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Parameter(hidden = true)
    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Parameter(hidden = true)
    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Parameter(hidden = true)
    @Column(name = "CreateDate")
    private Date createDate;

    @Parameter(hidden = true)
    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "YearID")
    private BigDecimal yearID;

    @Column(name = "StoreCode")
    private String storeCode;

    @Column(name = "StoreName")
    private String storeName;

    public BigDecimal getControlStoreID() {
        return controlStoreID;
    }

    public void setControlStoreID(BigDecimal controlStoreID) {
        this.controlStoreID = controlStoreID;
    }

    public BigDecimal getStoreID() {
        return storeID;
    }

    public void setStoreID(BigDecimal storeID) {
        this.storeID = storeID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public Date getStartDateG() {
        return startDateG;
    }

    public void setStartDateG(Date startDateG) {
        this.startDateG = startDateG;
    }

    public Date getFinishDateG() {
        return finishDateG;
    }

    public void setFinishDateG(Date finishDateG) {
        this.finishDateG = finishDateG;
    }

    public BigDecimal getControllerID() {
        return controllerID;
    }

    public void setControllerID(BigDecimal controllerID) {
        this.controllerID = controllerID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
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

    public BigDecimal getYearID() {
        return yearID;
    }

    public void setYearID(BigDecimal yearID) {
        this.yearID = yearID;
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

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public Integer getRowCnt() {
        return rowCnt;
    }

    public void setRowCnt(Integer rowCnt) {
        this.rowCnt = rowCnt;
    }

    @Column(name = "ControllerName")
    private String controllerName;

    @Column(name = "RowCnt")
    private Integer rowCnt;

}
