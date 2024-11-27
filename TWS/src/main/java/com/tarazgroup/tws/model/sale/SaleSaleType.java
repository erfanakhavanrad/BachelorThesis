package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "SaleShowSaleType",
        procedureName = "SaleShowSaleType",
        resultClasses = {SaleSaleType.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)
@Entity
@Table(name = "SaleSaleType")
public class SaleSaleType extends TParams implements Serializable {

    @Id
    @Column(name = "SaleTypeID", columnDefinition = "decimal")
    @Parameter
    private BigDecimal saleTypeID;

    @Column(name = "SaleTypeCode", columnDefinition = "nvarchar")
    @Parameter
    private String saleTypeCode;

    @Column(name = "SaleTypeDesc", columnDefinition = "nvarchar")
    @Parameter
    private String saleTypeDesc;

    @Column(name = "IsCurrency", columnDefinition = "bit")
    @Parameter
    private Boolean isCurrency;

    @Column(name = "CreateDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "CreatorID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifyDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "ServerID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "IsLC", columnDefinition = "bit")
    private Boolean isLC;

    @Column(name = "IsQuantity2", columnDefinition = "bit")
    @Transient
    private Boolean isQuantity2;

    @Column(name = "IsQuantity3", columnDefinition = "bit")
    @Transient
    private Boolean isQuantity3;

    @Column(name = "IsPayment", columnDefinition = "bit")
    private Boolean isPayment;

    @Column(name = "MaxPrintCount", columnDefinition = "tinyint")
    private Integer maxPrintCount;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getSaleTypeID() {
        return saleTypeID;
    }

    public void setSaleTypeID(BigDecimal saleTypeID) {
        this.saleTypeID = saleTypeID;
    }

    public String getSaleTypeCode() {
        return saleTypeCode;
    }

    public void setSaleTypeCode(String saleTypeCode) {
        this.saleTypeCode = saleTypeCode;
    }

    public String getSaleTypeDesc() {
        return saleTypeDesc;
    }

    public void setSaleTypeDesc(String saleTypeDesc) {
        this.saleTypeDesc = saleTypeDesc;
    }

    public Boolean getCurrency() {
        return isCurrency;
    }

    public void setCurrency(Boolean currency) {
        isCurrency = currency;
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

    public Boolean getLC() {
        return isLC;
    }

    public void setLC(Boolean LC) {
        isLC = LC;
    }

    public Boolean getQuantity2() {
        return isQuantity2;
    }

    public void setQuantity2(Boolean quantity2) {
        isQuantity2 = quantity2;
    }

    public Boolean getQuantity3() {
        return isQuantity3;
    }

    public void setQuantity3(Boolean quantity3) {
        isQuantity3 = quantity3;
    }

    public Boolean getPayment() {
        return isPayment;
    }

    public void setPayment(Boolean payment) {
        isPayment = payment;
    }

    public Integer getMaxPrintCount() {
        return maxPrintCount;
    }

    public void setMaxPrintCount(Integer maxPrintCount) {
        this.maxPrintCount = maxPrintCount;
    }
}
