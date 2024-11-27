package com.tarazgroup.tws.model.trs;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author A.Farahani
 */
@NamedStoredProcedureQuery(
        name = "TrsShowRecieptType",
        procedureName = "TrsShowRecieptType",
        resultClasses = {TrsRecieptType.class},
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
        name = "TrsInsRecieptType",
        procedureName = "TrsInsRecieptType",
        parameters = {
                @StoredProcedureParameter(name = "RecieptTypeCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RecieptTypeDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RecieptType", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsSaleRefer", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsMandate", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsWarranty", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSettle", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotInTankhah", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OperationType", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "TrsUpdRecieptType",
        procedureName = "TrsUpdRecieptType",
        parameters = {
                @StoredProcedureParameter(name = "RecieptTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RecieptTypeCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RecieptTypeDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RecieptType", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsSaleRefer", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsMandate", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsWarranty", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSettle", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotInTankhah", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OperationType", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "TrsDelRecieptType",
        procedureName = "TrsDelRecieptType",
        parameters = {
                @StoredProcedureParameter(name = "RecieptTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class TrsRecieptType extends TParams implements Serializable {
        @Id
        @Column(name = "RecieptTypeID")
        private BigDecimal recieptTypeID;

        @Column(name = "RecieptTypeCode")
        private String recieptTypeCode;

        @Column(name = "RecieptTypeDesc")
        private String recieptTypeDesc;

        @Column(name = "AccountID")
        private BigDecimal accountID;

        @Column(name = "ServerID")
        private BigDecimal serverID;

        @Column(name = "CreateDate")
        private Date createDate;

        @Column(name = "CreatorID")
        private BigDecimal creatorID;

        @Column(name = "ModifyDate")
        private Date modifyDate;

        @Column(name = "ModifierID")
        private BigDecimal modifierID;

        @Column(name = "RecieptType")
        private Boolean recieptType;

        @Column(name = "RecieptDesc")
        private String recieptDesc;

        @Column(name = "AccountCode")
        private String accountCode;

        @Column(name = "AccountDesc")
        private String accountDesc;

        @Column(name = "IsSaleRefer")
        private Boolean isSaleRefer;

        @Column(name = "IsMandate")
        private Boolean isMandate;

        @Column(name = "IsWarranty")
        private Boolean isWarranty;

        @Column(name = "IsSettle")
        private Boolean isSettle;

        @Column(name = "IsNotInTankhah")
        private Boolean isNotInTankhah;

        @Column(name = "OperationType")
        private BigDecimal operationType;

        @Column(name = "OperationtypeDesc")
        private String operationtypeDesc;

        @Column(name = "IsNotActive")
        private Boolean isNotActive;

        @Column(name = "RowCnt")
        private Integer rowCnt;

        public BigDecimal getRecieptTypeID() {
                return recieptTypeID;
        }

        public void setRecieptTypeID(BigDecimal recieptTypeID) {
                this.recieptTypeID = recieptTypeID;
        }

        public String getRecieptTypeCode() {
                return recieptTypeCode;
        }

        public void setRecieptTypeCode(String recieptTypeCode) {
                this.recieptTypeCode = recieptTypeCode;
        }

        public String getRecieptTypeDesc() {
                return recieptTypeDesc;
        }

        public void setRecieptTypeDesc(String recieptTypeDesc) {
                this.recieptTypeDesc = recieptTypeDesc;
        }

        public BigDecimal getAccountID() {
                return accountID;
        }

        public void setAccountID(BigDecimal accountID) {
                this.accountID = accountID;
        }

        public BigDecimal getServerID() {
                return serverID;
        }

        public void setServerID(BigDecimal serverID) {
                this.serverID = serverID;
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

        public Boolean getRecieptType() {
                return recieptType;
        }

        public void setRecieptType(Boolean recieptType) {
                this.recieptType = recieptType;
        }

        public String getRecieptDesc() {
                return recieptDesc;
        }

        public void setRecieptDesc(String recieptDesc) {
                this.recieptDesc = recieptDesc;
        }

        public String getAccountCode() {
                return accountCode;
        }

        public void setAccountCode(String accountCode) {
                this.accountCode = accountCode;
        }


        public Boolean getIsMandate() {
                return isMandate;
        }

        public void setIsMandate(Boolean isMandate) {
                isMandate = isMandate;
        }

        public Boolean getIsWarranty() {
                return isWarranty;
        }

        public void setIsWarranty(Boolean isWarranty) {
                isWarranty = isWarranty;
        }

        public Boolean getIsSettle() {
                return isSettle;
        }

        public void setIsSettle(Boolean isSettle) {
                isSettle = isSettle;
        }

        public Boolean getIsNotInTankhah() {
                return isNotInTankhah;
        }

        public void setIsNotInTankhah(Boolean isNotInTankhah) {
                isNotInTankhah = isNotInTankhah;
        }

        public BigDecimal getOperationType() {
                return operationType;
        }

        public void setOperationType(BigDecimal operationType) {
                this.operationType = operationType;
        }

        public String getOperationtypeDesc() {
                return operationtypeDesc;
        }

        public void setOperationtypeDesc(String operationtypeDesc) {
                this.operationtypeDesc = operationtypeDesc;
        }

        public Boolean getIsNotActive() {
                return isNotActive;
        }

        public void setIsNotActive(Boolean isNotActive) {
                isNotActive = isNotActive;
        }

        public Integer getRowCnt() {
                return rowCnt;
        }

        public void setRowCnt(Integer rowCnt) {
                this.rowCnt = rowCnt;
        }

        public String getAccountDesc() {
                return accountDesc;
        }

        public void setAccountDesc(String accountDesc) {
                this.accountDesc = accountDesc;
        }

        public Boolean getIsSaleRefer() {
                return isSaleRefer;
        }

        public void setIsSaleRefer(Boolean isSaleRefer) {
                isSaleRefer = isSaleRefer;
        }
}
