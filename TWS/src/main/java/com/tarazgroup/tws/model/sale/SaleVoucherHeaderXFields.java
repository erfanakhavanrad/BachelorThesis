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
        name = "SaleShowVoucherHeaderXFields",
        procedureName = "SaleShowVoucherHeaderXFields",
        resultClasses = {SaleVoucherHeaderXFields.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleInsVoucherHeaderXFields",
        procedureName = "SaleInsVoucherHeaderXFields",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField26", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField27", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField28", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField29", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField30", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField31", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField32", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField33", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField34", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField35", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField36", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField37", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField38", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField39", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField40", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField41", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField42", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField43", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField44", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField45", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField46", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField47", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField48", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField49", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField50", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleUpdVoucherHeaderXFields",
        procedureName = "SaleUpdVoucherHeaderXFields",
        parameters = {
                @StoredProcedureParameter(name = "XFieldID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField26", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField27", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField28", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField29", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField30", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField31", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField32", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField33", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField34", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField35", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField36", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField37", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField38", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField39", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField40", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField41", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField42", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField43", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField44", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField45", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField46", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField47", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField48", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField49", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomField50", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
        }
)

@NamedStoredProcedureQuery(
        name = "SaleDelVoucherHeaderXFields",
        procedureName = "SaleDelVoucherHeaderXFields",
        parameters = {
                @StoredProcedureParameter(name = "XFieldID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class SaleVoucherHeaderXFields extends TParams implements Serializable {

        @Id
        @Column(name = "XFieldID")
        private BigDecimal XFieldID;

        @Column(name = "VoucherHeaderID")
        private BigDecimal voucherHeaderID;

        @Column(name = "CustomField26")
        private String customField26;

        @Column(name = "CustomField27")
        private String customField27;

        @Column(name = "CustomField28")
        private String customField28;

        @Column(name = "CustomField29")
        private String customField29;

        @Column(name = "CustomField30")
        private String customField30;

        @Column(name = "CustomField31")
        private String customField31;

        @Column(name = "CustomField32")
        private String customField32;

        @Column(name = "CustomField33")
        private String customField33;

        @Column(name = "CustomField34")
        private String customField34;

        @Column(name = "CustomField35")
        private String customField35;

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

        @Column(name = "CustomField36")
        private String customField36;

        @Column(name = "CustomField37")
        private String customField37;

        @Column(name = "CustomField38")
        private String customField38;

        @Column(name = "CustomField39")
        private String customField39;

        @Column(name = "CustomField40")
        private String customField40;

        @Column(name = "CustomField41")
        private String customField41;

        @Column(name = "CustomField42")
        private String customField42;

        @Column(name = "CustomField43")
        private String customField43;

        @Column(name = "CustomField44")
        private String customField44;

        @Column(name = "CustomField45")
        private String customField45;

        @Column(name = "CustomField46")
        private String customField46;

        @Column(name = "CustomField47")
        private String customField47;

        @Column(name = "CustomField48")
        private String customField48;

        @Column(name = "CustomField49")
        private String customField49;

        @Column(name = "CustomField50")
        private String customField50;

        public BigDecimal getXFieldID() {
                return XFieldID;
        }

        public void setXFieldID(BigDecimal XFieldID) {
                this.XFieldID = XFieldID;
        }

        public BigDecimal getVoucherHeaderID() {
                return voucherHeaderID;
        }

        public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
                this.voucherHeaderID = voucherHeaderID;
        }

        public String getCustomField26() {
                return customField26;
        }

        public void setCustomField26(String customField26) {
                this.customField26 = customField26;
        }

        public String getCustomField27() {
                return customField27;
        }

        public void setCustomField27(String customField27) {
                this.customField27 = customField27;
        }

        public String getCustomField28() {
                return customField28;
        }

        public void setCustomField28(String customField28) {
                this.customField28 = customField28;
        }

        public String getCustomField29() {
                return customField29;
        }

        public void setCustomField29(String customField29) {
                this.customField29 = customField29;
        }

        public String getCustomField30() {
                return customField30;
        }

        public void setCustomField30(String customField30) {
                this.customField30 = customField30;
        }

        public String getCustomField31() {
                return customField31;
        }

        public void setCustomField31(String customField31) {
                this.customField31 = customField31;
        }

        public String getCustomField32() {
                return customField32;
        }

        public void setCustomField32(String customField32) {
                this.customField32 = customField32;
        }

        public String getCustomField33() {
                return customField33;
        }

        public void setCustomField33(String customField33) {
                this.customField33 = customField33;
        }

        public String getCustomField34() {
                return customField34;
        }

        public void setCustomField34(String customField34) {
                this.customField34 = customField34;
        }

        public String getCustomField35() {
                return customField35;
        }

        public void setCustomField35(String customField35) {
                this.customField35 = customField35;
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

        public String getCustomField36() {
                return customField36;
        }

        public void setCustomField36(String customField36) {
                this.customField36 = customField36;
        }

        public String getCustomField37() {
                return customField37;
        }

        public void setCustomField37(String customField37) {
                this.customField37 = customField37;
        }

        public String getCustomField38() {
                return customField38;
        }

        public void setCustomField38(String customField38) {
                this.customField38 = customField38;
        }

        public String getCustomField39() {
                return customField39;
        }

        public void setCustomField39(String customField39) {
                this.customField39 = customField39;
        }

        public String getCustomField40() {
                return customField40;
        }

        public void setCustomField40(String customField40) {
                this.customField40 = customField40;
        }

        public String getCustomField41() {
                return customField41;
        }

        public void setCustomField41(String customField41) {
                this.customField41 = customField41;
        }

        public String getCustomField42() {
                return customField42;
        }

        public void setCustomField42(String customField42) {
                this.customField42 = customField42;
        }

        public String getCustomField43() {
                return customField43;
        }

        public void setCustomField43(String customField43) {
                this.customField43 = customField43;
        }

        public String getCustomField44() {
                return customField44;
        }

        public void setCustomField44(String customField44) {
                this.customField44 = customField44;
        }

        public String getCustomField45() {
                return customField45;
        }

        public void setCustomField45(String customField45) {
                this.customField45 = customField45;
        }

        public String getCustomField46() {
                return customField46;
        }

        public void setCustomField46(String customField46) {
                this.customField46 = customField46;
        }

        public String getCustomField47() {
                return customField47;
        }

        public void setCustomField47(String customField47) {
                this.customField47 = customField47;
        }

        public String getCustomField48() {
                return customField48;
        }

        public void setCustomField48(String customField48) {
                this.customField48 = customField48;
        }

        public String getCustomField49() {
                return customField49;
        }

        public void setCustomField49(String customField49) {
                this.customField49 = customField49;
        }

        public String getCustomField50() {
                return customField50;
        }

        public void setCustomField50(String customField50) {
                this.customField50 = customField50;
        }
}
