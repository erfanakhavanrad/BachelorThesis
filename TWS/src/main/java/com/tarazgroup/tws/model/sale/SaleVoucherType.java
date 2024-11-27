package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author A.Farahani
 */
@NamedStoredProcedureQuery(
        name = "SaleShowVoucherType",
        procedureName = "SaleShowVoucherType",
        resultClasses = {SaleVoucherType.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleUpdVoucherType",
        procedureName = "SaleUpdVoucherType",
        parameters = {
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsContinueNum", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAutoNumber", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromNum", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
public class SaleVoucherType extends TParams implements Serializable {
    @Id
    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "VoucherTypeDesc")
    private String voucherTypeDesc;

    @Column(name = "isAutoNumber")
    private Integer isAutoNumber;

    @Column(name = "isAutoNumberDesc")
    private String isAutoNumberDesc;

    @Column(name = "IsNotActive")
    private Boolean isNotActive;

    @Column(name = "IsNotActiveDesc")
    private String isNotActiveDesc;

    @Column(name = "PriceInVoucher")
    private Boolean priceInVoucher;

    @Column(name = "PriceInVoucherDesc")
    private String priceInVoucherDesc;

    @Column(name = "IsContinueNum")
    private Boolean isContinueNum;

    @Column(name = "FromNum")
    private Integer fromNum;

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public String getVoucherTypeDesc() {
        return voucherTypeDesc;
    }

    public void setVoucherTypeDesc(String voucherTypeDesc) {
        this.voucherTypeDesc = voucherTypeDesc;
    }

    public Integer getIsAutoNumber() {
        return isAutoNumber;
    }

    public void setIsAutoNumber(Integer isAutoNumber) {
        this.isAutoNumber = isAutoNumber;
    }

    public String getIsAutoNumberDesc() {
        return isAutoNumberDesc;
    }

    public void setIsAutoNumberDesc(String isAutoNumberDesc) {
        this.isAutoNumberDesc = isAutoNumberDesc;
    }

    public Boolean getIsNotActive() {
        return isNotActive;
    }

    public void setIsNotActive(Boolean isNotActive) {
        this.isNotActive = isNotActive;
    }

    public String getIsNotActiveDesc() {
        return isNotActiveDesc;
    }

    public void setIsNotActiveDesc(String isNotActiveDesc) {
        this.isNotActiveDesc = isNotActiveDesc;
    }

    public Boolean getPriceInVoucher() {
        return priceInVoucher;
    }

    public void setPriceInVoucher(Boolean priceInVoucher) {
        this.priceInVoucher = priceInVoucher;
    }

    public String getPriceInVoucherDesc() {
        return priceInVoucherDesc;
    }

    public void setPriceInVoucherDesc(String priceInVoucherDesc) {
        this.priceInVoucherDesc = priceInVoucherDesc;
    }

    public Boolean getIsContinueNum() {
        return isContinueNum;
    }

    public void setIsContinueNum(Boolean isContinueNum) {
        this.isContinueNum = isContinueNum;
    }

    public Integer getFromNum() {
        return fromNum;
    }

    public void setFromNum(Integer fromNum) {
        this.fromNum = fromNum;
    }
}
