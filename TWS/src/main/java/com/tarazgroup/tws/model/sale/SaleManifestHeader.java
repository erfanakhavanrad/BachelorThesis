package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author A.Farahani
 * Dec-20, 2021
 */
@NamedStoredProcedureQuery(
        name = "SaleShowManifestHeader",
        procedureName = "SaleShowManifestHeader",
        resultClasses = {SaleManifestHeader.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserSaleessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleInsManifestHeader",
        procedureName = "SaleInsManifestHeader",
        parameters = {
                @StoredProcedureParameter(name = "VoucherNumber", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SaleManID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DriverID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode  = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "SecondNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name ="DistNameID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleUpdManifestHeader",
        procedureName = "SaleUpdManifestHeader",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SaleManID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DriverID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name ="DistNameID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode  = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleDelManifestHeader",
        procedureName = "SaleDelManifestHeader",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode  = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class SaleManifestHeader extends TParams implements Serializable {
        @Id
        @Column(name = "VoucherHeaderID")
        private BigDecimal voucherHeaderID;

        @Column(name = "VoucherNumber")
        private BigDecimal voucherNumber;

        @Column(name = "VoucherDate")
        private String voucherDate;

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

        @Column(name = "YearID")
        private BigDecimal yearID;

        @Column(name = "SaleManID")
        private BigDecimal saleManID;

        @Column(name = "DriverID")
        private BigDecimal driverID;

        @Column(name = "DistNameID")
        private BigDecimal distNameID;

        @Column(name = "SecondNumber")
        private String secondNumber;

        @Column(name = "SaleManCode")
        private String saleManCode;

        @Column(name = "SaleManName")
        private String saleManName;

        @Column(name = "DriverName")
        private String driverName;

        @Column(name = "DistName")
        private String distName;

        @Column(name = "VoucherStatID")
        private BigDecimal voucherStatID;

        public BigDecimal getVoucherHeaderID() {
                return voucherHeaderID;
        }

        public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
                this.voucherHeaderID = voucherHeaderID;
        }

        public BigDecimal getVoucherNumber() {
                return voucherNumber;
        }

        public void setVoucherNumber(BigDecimal voucherNumber) {
                this.voucherNumber = voucherNumber;
        }

        public String getVoucherDate() {
                return voucherDate;
        }

        public void setVoucherDate(String voucherDate) {
                this.voucherDate = voucherDate;
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

        public BigDecimal getYearID() {
                return yearID;
        }

        public void setYearID(BigDecimal yearID) {
                this.yearID = yearID;
        }

        public BigDecimal getSaleManID() {
                return saleManID;
        }

        public void setSaleManID(BigDecimal saleManID) {
                this.saleManID = saleManID;
        }

        public BigDecimal getDriverID() {
                return driverID;
        }

        public void setDriverID(BigDecimal driverID) {
                this.driverID = driverID;
        }

        public BigDecimal getDistNameID() {
                return distNameID;
        }

        public void setDistNameID(BigDecimal distNameID) {
                this.distNameID = distNameID;
        }

        public String getSecondNumber() {
                return secondNumber;
        }

        public void setSecondNumber(String secondNumber) {
                this.secondNumber = secondNumber;
        }

        public String getSaleManCode() {
                return saleManCode;
        }

        public void setSaleManCode(String saleManCode) {
                this.saleManCode = saleManCode;
        }

        public String getSaleManName() {
                return saleManName;
        }

        public void setSaleManName(String saleManName) {
                this.saleManName = saleManName;
        }

        public String getDriverName() {
                return driverName;
        }

        public void setDriverName(String driverName) {
                this.driverName = driverName;
        }

        public String getDistName() {
                return distName;
        }

        public void setDistName(String distName) {
                this.distName = distName;
        }

        public BigDecimal getVoucherStatID() {
                return voucherStatID;
        }

        public void setVoucherStatID(BigDecimal voucherStatID) {
                this.voucherStatID = voucherStatID;
        }
}
