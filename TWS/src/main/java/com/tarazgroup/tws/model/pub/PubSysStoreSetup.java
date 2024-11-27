package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "PubShowSysStoreSetup",
        procedureName = "PubShowSysStoreSetup",
        resultClasses = {PubSysStoreSetup.class},
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
        name = "PubInsSysStoreSetup",
        procedureName = "PubInsSysStoreSetup",
        resultClasses = {PubSysStoreSetup.class},
        parameters = {
                @StoredProcedureParameter(name = "ControlInventory", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNegativeStock", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAllowableQuantity", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsComputeValue", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsStoreAllocated", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsTaxInfoControl", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@Entity
@Table(name = "PubSysStoreSetup")
public class PubSysStoreSetup extends TParams {

    @Id
    @Column(name = "StoreID")
    private BigDecimal storeID;

    @Column(name = "ControlInventory")
    private Boolean controlInventory;

    @Column(name = "IsNegativeStock")
    private Boolean isNegativeStock;

    @Column(name = "IsAllowableQuantity")
    private Boolean isAllowableQuantity;

    @Column(name = "IsComputeValue")
    private Boolean isComputeValue;

    @Column(name = "IsStoreAllocated")
    private Boolean isStoreAllocated;

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

    @Column(name = "IsTaxInfoControl")
    private Boolean isTaxInfoControl;

    @Column(name = "StoreCode")
    private String storeCode;

    @Column(name = "StoreName")
    private String storeName;



    public Boolean getIsNegativeStock() {
        return isNegativeStock;
    }

    public void setIsNegativeStock(Boolean negativeStock) {
        isNegativeStock = negativeStock;
    }

    public Boolean getIsAllowableQuantity() {
        return isAllowableQuantity;
    }

    public void setIsAllowableQuantity(Boolean allowableQuantity) {
        isAllowableQuantity = allowableQuantity;
    }

    public Boolean getIsComputeValue() {
        return isComputeValue;
    }

    public void setIsComputeValue(Boolean computeValue) {
        isComputeValue = computeValue;
    }

    public Boolean getIsStoreAllocated() {
        return isStoreAllocated;
    }

    public void setIsStoreAllocated(Boolean storeAllocated) {
        isStoreAllocated = storeAllocated;
    }

    public Boolean getIsTaxInfoControl() {
        return isTaxInfoControl;
    }

    public void setIsTaxInfoControl(Boolean taxInfoControl) {
        isTaxInfoControl = taxInfoControl;
    }

    public BigDecimal getStoreID() {
        return storeID;
    }

    public void setStoreID(BigDecimal storeID) {
        this.storeID = storeID;
    }

    public Boolean getControlInventory() {
        return controlInventory;
    }

    public void setControlInventory(Boolean controlInventory) {
        this.controlInventory = controlInventory;
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
    /*
    public BigDecimal getStoreID() {
        return storeID;
    }

    public void setStoreID(BigDecimal storeID) {
        this.storeID = storeID;
    }

    public Boolean getControlInventory() {
        return controlInventory;
    }

    public void setControlInventory(Boolean controlInventory) {
        this.controlInventory = controlInventory;
    }

    public Boolean getNegativeStock() {
        return isNegativeStock;
    }

    public void setNegativeStock(Boolean isNegativeStock) {
        this.isNegativeStock = isNegativeStock;
    }

    public Boolean getAllowableQuantity() {
        return isAllowableQuantity;
    }

    public void setAllowableQuantity(Boolean isAllowableQuantity) {
        this.isAllowableQuantity = isAllowableQuantity;
    }

    public Boolean getComputeValue() {
        return isComputeValue;
    }

    public void setComputeValue(Boolean isComputeValue) {
        this.isComputeValue = isComputeValue;
    }

    public Boolean getStoreAllocated() {
        return isStoreAllocated;
    }

    public void setStoreAllocated(Boolean isStoreAllocated) {
        this.isStoreAllocated = isStoreAllocated;
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

    public Boolean getTaxInfoControl() {
        return isTaxInfoControl;
    }

    public void setTaxInfoControl(Boolean isTaxInfoControl) {
        this.isTaxInfoControl = isTaxInfoControl;
    }

 */
}
