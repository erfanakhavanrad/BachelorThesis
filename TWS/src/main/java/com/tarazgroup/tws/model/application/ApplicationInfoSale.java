package com.tarazgroup.tws.model.application;

import com.tarazgroup.tws.dao.pub.PubSysStoreSetupRepository;
import com.tarazgroup.tws.dao.sale.SaleSysSetupRepository;
import com.tarazgroup.tws.model.pub.PubSysStoreSetup;
import com.tarazgroup.tws.model.sale.SaleSysSetup;
import com.tarazgroup.tws.model.sale.SaleVoucherDefault;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class ApplicationInfoSale implements Serializable {
    private List<VoucherDefault> voucherDefaults;

    private SysSetup sysSetup;

    public void voucherDefaultFromArrayList(List<SaleVoucherDefault> saleVoucherDefaults, PubSysStoreSetupRepository pubSysStoreSetupRepository) {
        List<VoucherDefault> voucherDefaults = new ArrayList();
        for (int i = 0; i < saleVoucherDefaults.size(); i++) {
            VoucherDefault voucherDefault = new VoucherDefault();
            voucherDefault.setDeliverCenterID(saleVoucherDefaults.get(i).getDeliverCenterID());
            voucherDefault.setSaleCenterID(saleVoucherDefaults.get(i).getSaleCenterID());
            voucherDefault.setStoreID(saleVoucherDefaults.get(i).getStoreID());
            voucherDefault.setVoucherTypeID(saleVoucherDefaults.get(i).getVoucherTypeID());
            PubSysStoreSetup pubSysStoreSetup = pubSysStoreSetupRepository.pubSysStoreSetupByStoreID(saleVoucherDefaults.get(i).getStoreID());
            voucherDefault.setControlInventory(pubSysStoreSetup.getControlInventory());
            voucherDefault.setIsFixedFee(saleVoucherDefaults.get(i).getIsFixFee());
            voucherDefault.setSaleTypeID(saleVoucherDefaults.get(i).getSaleTypeID());
            voucherDefault.setPaymentWayIDs(saleVoucherDefaults.get(i).getPaymentWayIDs());
            voucherDefault.setCenter1ID(saleVoucherDefaults.get(i).getCenter1ID());
            voucherDefault.setCenter2ID(saleVoucherDefaults.get(i).getCenter2ID());
            voucherDefault.setCenter3ID(saleVoucherDefaults.get(i).getCenter3ID());
            voucherDefaults.add(voucherDefault);
        }
        this.voucherDefaults = voucherDefaults;
    }

    public void sysSetupFromSaleSysSetup(SaleSysSetupRepository saleSysSetupRepository) {
        SysSetup sysSetup =new SysSetup();
        //it just has one record.
        SaleSysSetup saleSysSetup =  saleSysSetupRepository.selectSaleSysSetup();
        sysSetup.setIsByStore(saleSysSetup.getIsByStore()==null?false:saleSysSetup.getIsByStore());
        sysSetup.setIsFeeAgrToFeeInRefer(saleSysSetup.getIsFeeAgrToFeeInRefer()==null?false:saleSysSetup.getIsFeeAgrToFeeInRefer());
        sysSetup.setIsStoreInDet(saleSysSetup.getIsStoreInDet()==null?false:saleSysSetup.getIsStoreInDet());
        sysSetup.setCanCreateCustomerInAndroid(saleSysSetup.getCanCreateCustomerInAndroid()==null?false:saleSysSetup.getCanCreateCustomerInAndroid());
        sysSetup.setIsShowSaleTypeInVoucherHeaderInAndroid(saleSysSetup.getIsShowSaleTypeInVoucherHeaderInAndroid()==null?false:saleSysSetup.getIsShowSaleTypeInVoucherHeaderInAndroid());
        this.sysSetup = sysSetup;
    }

    public List<VoucherDefault> getVoucherDefaults() {
        return voucherDefaults;
    }

    public void setVoucherDefaults(List<VoucherDefault> voucherDefaults) {
        this.voucherDefaults = voucherDefaults;
    }

    public SysSetup getSysSetup() {
        return sysSetup;
    }

    public void setSysSetup(SysSetup sysSetup) {
        this.sysSetup = sysSetup;
    }
}

class VoucherDefault implements Serializable {
    private BigDecimal voucherTypeID;

    private BigDecimal storeID;

    private Boolean controlInventory;

    private Boolean isFixedFee;

    private BigDecimal saleCenterID;

    private BigDecimal deliverCenterID;

    private BigDecimal saleTypeID;

    private String paymentWayIDs;

    private BigDecimal center1ID;

    private BigDecimal center2ID;

    private BigDecimal center3ID;

    public BigDecimal getCenter1ID() {
        return center1ID;
    }

    public void setCenter1ID(BigDecimal center1ID) {
        this.center1ID = center1ID;
    }

    public BigDecimal getCenter2ID() {
        return center2ID;
    }

    public void setCenter2ID(BigDecimal center2ID) {
        this.center2ID = center2ID;
    }

    public BigDecimal getCenter3ID() {
        return center3ID;
    }

    public void setCenter3ID(BigDecimal center3ID) {
        this.center3ID = center3ID;
    }

    public String getPaymentWayIDs() {
        return paymentWayIDs;
    }

    public void setPaymentWayIDs(String paymentWayIDs) {
        this.paymentWayIDs = paymentWayIDs;
    }

    public BigDecimal getSaleTypeID() {
        return saleTypeID;
    }

    public void setSaleTypeID(BigDecimal saleTypeID) {
        this.saleTypeID = saleTypeID;
    }

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
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

    public Boolean getIsFixedFee() {
        return isFixedFee;
    }

    public void setIsFixedFee(Boolean isFixedFee) {
        this.isFixedFee = isFixedFee;
    }

    public BigDecimal getSaleCenterID() {
        return saleCenterID;
    }

    public void setSaleCenterID(BigDecimal saleCenterID) {
        this.saleCenterID = saleCenterID;
    }

    public BigDecimal getDeliverCenterID() {
        return deliverCenterID;
    }

    public void setDeliverCenterID(BigDecimal deliverCenterID) {
        this.deliverCenterID = deliverCenterID;
    }
}

class SysSetup implements Serializable {
    private Boolean isByStore;
    private Boolean isFeeAgrToFeeInRefer;
    private Boolean isStoreInDet;
    private Boolean canCreateCustomerInAndroid;
    private Boolean isShowSaleTypeInVoucherHeaderInAndroid;


    public Boolean getIsByStore() {
        return isByStore;
    }

    public void setIsByStore(Boolean isByStore) {
        this.isByStore = isByStore;
    }

    public Boolean getIsFeeAgrToFeeInRefer() {
        return isFeeAgrToFeeInRefer;
    }

    public void setIsFeeAgrToFeeInRefer(Boolean isFeeAgrToFeeInRefer) {
        this.isFeeAgrToFeeInRefer = isFeeAgrToFeeInRefer;
    }

    public Boolean getIsStoreInDet() {
        return isStoreInDet;
    }

    public void setIsStoreInDet(Boolean isStoreInDet) {
        this.isStoreInDet = isStoreInDet;
    }

    public Boolean getCanCreateCustomerInAndroid() {
        return canCreateCustomerInAndroid;
    }

    public void setCanCreateCustomerInAndroid(Boolean canCreateCustomerInAndroid) {
        this.canCreateCustomerInAndroid = canCreateCustomerInAndroid;
    }

    public Boolean getIsShowSaleTypeInVoucherHeaderInAndroid() {
        return isShowSaleTypeInVoucherHeaderInAndroid;
    }

    public void setIsShowSaleTypeInVoucherHeaderInAndroid(Boolean isShowSaleTypeInVoucherHeaderInAndroid) {
        this.isShowSaleTypeInVoucherHeaderInAndroid = isShowSaleTypeInVoucherHeaderInAndroid;
    }
}
