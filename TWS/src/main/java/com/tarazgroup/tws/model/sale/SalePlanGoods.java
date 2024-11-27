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
        name = "SaleShowPlanGoods",
        procedureName = "SaleShowPlanGoods",
        resultClasses = {SalePlanGoods.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
        }
)

@Entity
public class SalePlanGoods extends TParams implements Serializable {

        @Id
        @Column(name = "VoucherDetailID")
        private BigDecimal voucherDetailID;

        @Column(name = "VoucherHeaderID")
        private BigDecimal voucherHeaderID;

        @Column(name = "GoodsID")
        private BigDecimal goodsID;

        @Column(name = "Quantity")
        private BigDecimal quantity;

        @Column(name = "Fee")
        private BigDecimal fee;

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

        @Column(name = "DReferID")
        private BigDecimal dReferID;

        @Column(name = "BaseDReferID")
        private BigDecimal baseDReferID;

        @Column(name = "GoodsCode")
        private String goodsCode;

        @Column(name = "GoodsDesc")
        private String goodsDesc;

        @Column(name = "UnitName")
        private String unitName;

        @Column(name = "DReferNumber")
        private BigDecimal dReferNumber;

        @Column(name = "DReferDate")
        private String dReferDate;

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

        public BigDecimal getGoodsID() {
                return goodsID;
        }

        public void setGoodsID(BigDecimal goodsID) {
                this.goodsID = goodsID;
        }

        public BigDecimal getQuantity() {
                return quantity;
        }

        public void setQuantity(BigDecimal quantity) {
                this.quantity = quantity;
        }

        public BigDecimal getFee() {
                return fee;
        }

        public void setFee(BigDecimal fee) {
                this.fee = fee;
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

        public BigDecimal getDReferID() {
                return dReferID;
        }

        public void setDReferID(BigDecimal dReferID) {
                this.dReferID = dReferID;
        }

        public BigDecimal getBaseDReferID() {
                return baseDReferID;
        }

        public void setBaseDReferID(BigDecimal baseDReferID) {
                this.baseDReferID = baseDReferID;
        }

        public String getGoodsCode() {
                return goodsCode;
        }

        public void setGoodsCode(String goodsCode) {
                this.goodsCode = goodsCode;
        }

        public String getGoodsDesc() {
                return goodsDesc;
        }

        public void setGoodsDesc(String goodsDesc) {
                this.goodsDesc = goodsDesc;
        }

        public String getUnitName() {
                return unitName;
        }

        public void setUnitName(String unitName) {
                this.unitName = unitName;
        }

        public BigDecimal getDReferNumber() {
                return dReferNumber;
        }

        public void setDReferNumber(BigDecimal dReferNumber) {
                this.dReferNumber = dReferNumber;
        }

        public String getDReferDate() {
                return dReferDate;
        }

        public void setDReferDate(String dReferDate) {
                this.dReferDate = dReferDate;
        }
}
