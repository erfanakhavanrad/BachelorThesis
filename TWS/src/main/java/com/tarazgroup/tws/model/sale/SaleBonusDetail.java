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
        name = "SaleShowBonusDetail",
        procedureName = "SaleShowBonusDetail",
        resultClasses = {SaleBonusDetail.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleInsBonusDetail",
        procedureName = "SaleInsBonusDetail",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Amount", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromNum", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToNum", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SecUnitID", type = BigDecimal.class, mode = ParameterMode.IN)
        }

)

@NamedStoredProcedureQuery(
        name = "SaleUpdBonusDetail",
        procedureName = "SaleUpdBonusDetail",
        parameters = {
                @StoredProcedureParameter(name = "VoucherDetailID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Amount", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromNum", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToNum", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SecUnitID", type = BigDecimal.class, mode = ParameterMode.IN)
        }

)

@NamedStoredProcedureQuery(
        name = "SaleDelBonusDetail",
        procedureName = "SaleDelBonusDetail",
        parameters = {
                @StoredProcedureParameter(name = "VoucherDetailID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class SaleBonusDetail extends TParams implements Serializable {
        @Id
        @Column(name = "VoucherDetailID")
        private BigDecimal voucherDetailID;

        @Column(name = "VoucherHeaderID")
        private BigDecimal voucherHeaderID;

        @Column(name = "Amount")
        private BigDecimal amount;

        @Column(name = "FromNum")
        private BigDecimal fromNum;

        @Column(name = "ToNum")
        private BigDecimal toNum;

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

        @Column(name = "GoodsID")
        private BigDecimal goodsID;

        @Column(name = "SecUnitID")
        private BigDecimal secUnitID;

        @Column(name = "GoodsCode")
        private String goodsCode;

        @Column(name = "GoodsDesc")
        private String goodsDesc;

        @Column(name = "UnitDesc")
        private String unitDesc;

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

        public BigDecimal getAmount() {
                return amount;
        }

        public void setAmount(BigDecimal amount) {
                this.amount = amount;
        }

        public BigDecimal getFromNum() {
                return fromNum;
        }

        public void setFromNum(BigDecimal fromNum) {
                this.fromNum = fromNum;
        }

        public BigDecimal getToNum() {
                return toNum;
        }

        public void setToNum(BigDecimal toNum) {
                this.toNum = toNum;
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

        public BigDecimal getGoodsID() {
                return goodsID;
        }

        public void setGoodsID(BigDecimal goodsID) {
                this.goodsID = goodsID;
        }

        public BigDecimal getSecUnitID() {
                return secUnitID;
        }

        public void setSecUnitID(BigDecimal secUnitID) {
                this.secUnitID = secUnitID;
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

        public String getUnitDesc() {
                return unitDesc;
        }

        public void setUnitDesc(String unitDesc) {
                this.unitDesc = unitDesc;
        }
}
