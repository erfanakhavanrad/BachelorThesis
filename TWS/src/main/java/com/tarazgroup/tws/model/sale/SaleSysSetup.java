package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
@NamedNativeQueries({
        @NamedNativeQuery(name = "SaleSysSetup", query = "SELECT row_number() OVER (ORDER BY IsByStore) _id,* FROM SaleSysSetup", resultClass = SaleSysSetup.class),
})
@Entity
@Table(name = "SaleSysSetup")
public class SaleSysSetup extends TParams {

    @Id
    @Column(name = "_id")
    private int _id;

    @Column(name = "FixCustomerID")
    private BigDecimal fixCustomerID;

    @Column(name = "IsByStore")
    private Boolean isByStore;

    @Column(name = "IsFeeAgrToFeeInRefer")
    private Boolean isFeeAgrToFeeInRefer;

    @Column(name = "IsShowCustomerByMarketingMan")
    private Boolean isShowCustomerByMarketingMan;

    @Column(name = "IsStoreInDet")
    private Boolean isStoreInDet;

    //اگر این فیلد
    //true
    //باشد بازاریاب حق دارد از طریق اندروید مشتری تعریف کند و همچنین وقتی لبست مشتریان در اندروید لود میشود هیچ فیلتر ندارد
    @Column(name = "CanCreateCustomerInAndroid")
    private Boolean canCreateCustomerInAndroid;

    @Column(name = "IsShowSaleTypeInVoucherHeaderInAndroid")
    private Boolean isShowSaleTypeInVoucherHeaderInAndroid;


    @Schema(hidden = true)
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public BigDecimal getFixCustomerID() {
        return fixCustomerID;
    }

    public void setFixCustomerID(BigDecimal fixCustomerID) {
        this.fixCustomerID = fixCustomerID;
    }

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

    public Boolean getIsShowCustomerByMarketingMan() {
        return isShowCustomerByMarketingMan;
    }

    public void setIsShowCustomerByMarketingMan(Boolean isShowCustomerByMarketingMan) {
        this.isShowCustomerByMarketingMan = isShowCustomerByMarketingMan;
    }

    public Boolean getIsStoreInDet() {
        return isStoreInDet;
    }

    public void setIsStoreInDet(Boolean storeInDet) {
        isStoreInDet = storeInDet;
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
