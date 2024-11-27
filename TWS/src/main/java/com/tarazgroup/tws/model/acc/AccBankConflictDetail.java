package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Jan-11, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "AccShowBankConflictDetail",
        procedureName = "AccShowBankConflictDetail",
        resultClasses = {AccBankConflictDetail.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "AccInsBankConflictDetail",
        procedureName = "AccInsBankConflictDetail",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsOpen", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "AccUpdBankConflictDetail",
        procedureName = "AccUpdBankConflictDetail",
        parameters = {
                @StoredProcedureParameter(name = "mID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOpen", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsManual", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class AccBankConflictDetail extends TParams implements Serializable {
        @Id
        @Column(name = "mID")
        private BigDecimal mID;

        @Column(name = "GroupNumber")
        private BigDecimal groupNumber;

        @Column(name = "DocCode")
        private String docCode;

        @Column(name = "DocNum")
        private String docNum;

        @Column(name = "DocDate")
        private String docDate;

        @Column(name = "SBed")
        private BigDecimal sBed;

        @Column(name = "SBes")
        private BigDecimal sBes;

        @Column(name = "DocDesc")
        private String docDesc;

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

        @Column(name = "IsOpen")
        private Boolean isOpen;

        @Column(name = "IsManual")
        private Boolean isManual;

        @Transient
        private BigDecimal voucherHeaderID;

        public BigDecimal getmID() {
                return mID;
        }

        public void setmID(BigDecimal mID) {
                this.mID = mID;
        }

        public BigDecimal getGroupNumber() {
                return groupNumber;
        }

        public void setGroupNumber(BigDecimal groupNumber) {
                this.groupNumber = groupNumber;
        }

        public String getDocCode() {
                return docCode;
        }

        public void setDocCode(String docCode) {
                this.docCode = docCode;
        }

        public String getDocNum() {
                return docNum;
        }

        public void setDocNum(String docNum) {
                this.docNum = docNum;
        }

        public String getDocDate() {
                return docDate;
        }

        public void setDocDate(String docDate) {
                this.docDate = docDate;
        }

        public BigDecimal getsBed() {
                return sBed;
        }

        public void setsBed(BigDecimal sBed) {
                this.sBed = sBed;
        }

        public BigDecimal getsBes() {
                return sBes;
        }

        public void setsBes(BigDecimal sBes) {
                this.sBes = sBes;
        }

        public String getDocDesc() {
                return docDesc;
        }

        public void setDocDesc(String docDesc) {
                this.docDesc = docDesc;
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

        public Boolean getIsOpen() {
                return isOpen;
        }

        public void setIsOpen(Boolean open) {
                isOpen = open;
        }

        public Boolean getIsManual() {
                return isManual;
        }

        public void setIsManual(Boolean manual) {
                isManual = manual;
        }

        public BigDecimal getVoucherHeaderID() {
                return voucherHeaderID;
        }

        public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
                this.voucherHeaderID = voucherHeaderID;
        }
}
