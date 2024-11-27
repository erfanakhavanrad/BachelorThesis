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
        name = "SaleShowPlanDetail",
        procedureName = "SaleShowPlanDetail",
        resultClasses = {SalePlanDetail.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter",type = String.class,mode = ParameterMode.IN),
        }
)

@Entity
public class SalePlanDetail extends TParams implements Serializable {

    @Id
    @Column(name = "VoucherDetailID")
    private BigDecimal voucherDetailID;

    @Column(name = "VoucherHeaderID")
    private BigDecimal voucherHeaderID;

    @Column(name = "PaymentWayID")
    private BigDecimal paymentWayID;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "ValueOfTotal")
    private BigDecimal valueOfTotal;

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

    @Column(name = "PaymentWayDesc")
    private String paymentWayDesc;

    @Column(name = "FromDayCnt")
    private Integer fromDayCnt;

    @Column(name = "ToDayCnt")
    private Integer toDayCnt;

    public BigDecimal getVoucherDetailID() {
        return voucherDetailID;
    }

    public void setVoucherDetailID(BigDecimal voucherDetailID) {
        this.voucherDetailID = voucherDetailID;
    }

    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
        this.voucherHeaderID = voucherHeaderID;
    }

    public BigDecimal getPaymentWayID() {
        return paymentWayID;
    }

    public void setPaymentWayID(BigDecimal paymentWayID) {
        this.paymentWayID = paymentWayID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getValueOfTotal() {
        return valueOfTotal;
    }

    public void setValueOfTotal(BigDecimal valueOfTotal) {
        this.valueOfTotal = valueOfTotal;
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

    public String getPaymentWayDesc() {
        return paymentWayDesc;
    }

    public void setPaymentWayDesc(String paymentWayDesc) {
        this.paymentWayDesc = paymentWayDesc;
    }

    public Integer getFromDayCnt() {
        return fromDayCnt;
    }

    public void setFromDayCnt(Integer fromDayCnt) {
        this.fromDayCnt = fromDayCnt;
    }

    public Integer getToDayCnt() {
        return toDayCnt;
    }

    public void setToDayCnt(Integer toDayCnt) {
        this.toDayCnt = toDayCnt;
    }
}
