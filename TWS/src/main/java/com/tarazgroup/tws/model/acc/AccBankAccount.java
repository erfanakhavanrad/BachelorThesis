package com.tarazgroup.tws.model.acc;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@NamedStoredProcedureQuery(
        name = "AccShowBankAccount",
        procedureName = "AccShowBankAccount",
        resultClasses = {AccBankAccount.class},
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
        name = "AccDelBankAccount",
        procedureName = "AccDelBankAccount",
        resultClasses = {AccBankAccount.class},
        parameters = {
                @StoredProcedureParameter(name = "BankAccountID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result",type = BigDecimal.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg",type = String.class,mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "AccInsBankAccount",
        procedureName = "AccInsBankAccount",
        resultClasses = {AccBankAccount.class},
        parameters = {
                @StoredProcedureParameter(name = "BankAccountNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankBranchID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountKindID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCurrency", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "BankAccountOwner", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SystemID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ShebaNo", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsControlAccount", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CardCode", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "AccUpdBankAccount",
        procedureName = "AccUpdBankAccount",
        resultClasses = {AccBankAccount.class},
        parameters = {
                @StoredProcedureParameter(name = "BankAccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankAccountNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankBranchID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountKindID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCurrency", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "BankID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankAccountOwner", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ShebaNo", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsControlAccount", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CardCode", type = String.class, mode = ParameterMode.IN)
        }
)


@Entity
public class AccBankAccount extends TParams implements Serializable {
    @Id
    @Column(name = "BankAccountID", columnDefinition = "decimal")
    private BigDecimal bankAccountID;

    @Column(name = "BankAccountNumber", columnDefinition = "nvarchar")
    private String bankAccountNumber;

    @Column(name = "BankBranchID", columnDefinition = "decimal")
    private BigDecimal bankBranchID;

    @Column(name = "AccountKindID", columnDefinition = "decimal")
    private BigDecimal accountKindID;

    @Column(name = "TafsiliID", columnDefinition = "decimal")
    private BigDecimal tafsiliID;

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

    @Column(name = "BankBranchcode")

    private String bankBranchCode;

    @Column(name = "BankBranchDesc")

    private String bankBranchDesc;

    @Column(name = "BankID", columnDefinition = "decimal")
    private BigDecimal bankID;

    @Column(name = "BankName")
    private String bankName;

    @Column(name = "AccountKindCode")
    private String accountKindCode;

    @Column(name = "AccountKindDesc")
    private String accountKindDesc;

    @Column(name = "TafsiliTypeID")
    private BigDecimal tafsiliTypeID;

    @Column(name = "TafsiliTypeDesc")
    private String tafsiliTypeDesc;

    @Column(name = "TafsiliCode")
    private String tafsiliCode;

    @Column(name = "ISCurrency", columnDefinition = "bit")
    private Boolean iSCurrency;

    @Column(name = "BankAccountOwner", columnDefinition = "nvarchar")
    private String bankAccountOwner;

    @Column(name = "ShebaNo", columnDefinition = "nvarchar")
    private String shebaNo;

    @Column(name = "IsControlAccount", columnDefinition = "bit")
    private Boolean isControlAccount;

    @Column(name = "CardCode", columnDefinition = "nvarchar")
    private String cardCode;

    @Column(name = "BADesc")
    private String bADesc;


    public BigDecimal getBankAccountID() {
        return bankAccountID;
    }

    public void setBankAccountID(BigDecimal bankAccountID) {
        this.bankAccountID = bankAccountID;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public BigDecimal getBankBranchID() {
        return bankBranchID;
    }

    public void setBankBranchID(BigDecimal bankBranchID) {
        this.bankBranchID = bankBranchID;
    }

    public BigDecimal getAccountKindID() {
        return accountKindID;
    }

    public void setAccountKindID(BigDecimal accountKindID) {
        this.accountKindID = accountKindID;
    }

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
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

    public String getBankBranchCode() {
        return bankBranchCode;
    }

    public void setBankBranchCode(String bankBranchcode) {
        this.bankBranchCode = bankBranchcode;
    }

    public String getBankBranchDesc() {
        return bankBranchDesc;
    }

    public void setBankBranchDesc(String bankBranchDesc) {
        this.bankBranchDesc = bankBranchDesc;
    }

    public BigDecimal getBankID() {
        return bankID;
    }

    public void setBankID(BigDecimal bankID) {
        this.bankID = bankID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountKindCode() {
        return accountKindCode;
    }

    public void setAccountKindCode(String accountKindCode) {
        this.accountKindCode = accountKindCode;
    }

    public String getAccountKindDesc() {
        return accountKindDesc;
    }

    public void setAccountKindDesc(String accountKindDesc) {
        this.accountKindDesc = accountKindDesc;
    }

    public BigDecimal getTafsiliTypeID() {
        return tafsiliTypeID;
    }

    public void setTafsiliTypeID(BigDecimal tafsiliTypeID) {
        this.tafsiliTypeID = tafsiliTypeID;
    }

    public String getTafsiliTypeDesc() {
        return tafsiliTypeDesc;
    }

    public void setTafsiliTypeDesc(String tafsiliTypeDesc) {
        this.tafsiliTypeDesc = tafsiliTypeDesc;
    }

    public String getTafsiliCode() {
        return tafsiliCode;
    }

    public void setTafsiliCode(String tafsiliCode) {
        this.tafsiliCode = tafsiliCode;
    }

    public Boolean getIsCurrency() {
        return iSCurrency;
    }

    public void setIsCurrency(Boolean iSCurrency) {
        this.iSCurrency = iSCurrency;
    }

    public String getBankAccountOwner() {
        return bankAccountOwner;
    }

    public void setBankAccountOwner(String bankAccountOwner) {
        this.bankAccountOwner = bankAccountOwner;
    }

    public String getShebaNo() {
        return shebaNo;
    }

    public void setShebaNo(String shebaNo) {
        this.shebaNo = shebaNo;
    }

    public Boolean getIsControlAccount() {
        return isControlAccount;
    }

    public void setIsControlAccount(Boolean controlAccount) {
        isControlAccount = controlAccount;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getBADesc() {
        return bADesc;
    }

    public void setBADesc(String bADesc) {
        this.bADesc = bADesc;
    }
}

