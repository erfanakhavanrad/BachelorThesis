package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
        name = "AccShowBankBranch",
        procedureName = "AccShowBankBranch",
        resultClasses = {AccBankBranch.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
        }
)
@NamedStoredProcedureQuery(
        name = "AccDelBankBranch",
        procedureName = "AccDelBankBranch",
        resultClasses = {AccBankBranch.class},
        parameters = {
                @StoredProcedureParameter(name = "BankBranchID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
        }
)
@NamedStoredProcedureQuery(
        name = "AccInsBankBranch",
        procedureName = "AccInsBankBranch",
        resultClasses = {AccBankBranch.class},
        parameters = {
                @StoredProcedureParameter(name = "BankBranchCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankBranchDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankBAddress", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankBTelphone", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
        }
)
@NamedStoredProcedureQuery(
        name = "AccUpdBankBranch",
        procedureName = "AccUpdBankBranch",
        resultClasses = {AccBankBranch.class},
        parameters = {
                @StoredProcedureParameter(name = "BankBranchID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankBranchCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankBranchDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankBAddress", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankBTelphone", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
        }
)


@Entity
public class AccBankBranch extends TParams implements Serializable {

    @Id
    @Column(name = "BankBranchID", columnDefinition = "decimal")
    private BigDecimal bankBranchID;


    @Column(name = "ServerID", columnDefinition = "decimal")
    private BigDecimal serverID;


    @Column(name = "BankBranchCode", columnDefinition = "nvarchar")
    private String bankBranchCode;


    @Column(name = "BankBranchDesc", columnDefinition = "nvarchar")
    private String bankBranchDesc;


    @Column(name = "BankBAddress", columnDefinition = "nvarchar")
    private String bankBAddress;


    @Column(name = "BankBTelphone", columnDefinition = "nchar")
    private String bankBTelphone;


    @Column(name = "CreateDate", columnDefinition = "datetime")
    private Date createDate;


    @Column(name = "CreatorID", columnDefinition = "decimal")
    private BigDecimal creatorID;


    @Column(name = "ModifyDate", columnDefinition = "datetime")
    private Date modifyDate;


    @Column(name = "ModifierID", columnDefinition = "decimal")
    private BigDecimal modifierID;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getBankBranchID() {
        return bankBranchID;
    }

    public void setBankBranchID(BigDecimal bankBranchID) {
        this.bankBranchID = bankBranchID;
    }

    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    @NotBlank(message = "bankBranchCode is mandatory")
    @Schema(
            name = "کد بانک",
            required = true,
            example = "C123"
    )
    public String getBankBranchCode() {
        return bankBranchCode;
    }

    public void setBankBranchCode(String bankBranchCode) {
        this.bankBranchCode = bankBranchCode;
    }

    @NotBlank(message = "bankBranchDesc is mandatory")
    @Schema(
            name = "توضیحات شعبه",
            required = true,
            example = "بانک صادرات"
    )
    public String getBankBranchDesc() {
        return bankBranchDesc;
    }

    public void setBankBranchDesc(String bankBranchDesc) {
        this.bankBranchDesc = bankBranchDesc;
    }

    @NotBlank(message = "bnakBAddrss is mandatory")
    @Schema(
            name = "آدرس بانک",
            required = true,
            example = "تهران - خ ولیعصر - ک فوزی"
    )
    public String getBankBAddress() {
        return bankBAddress;
    }

    public void setBankBAddress(String bankBAddress) {
        this.bankBAddress = bankBAddress;
    }

    @NotBlank(message = "bnakBTelphone is mandatory")
    @Schema(
            name = "شماره تماس بانک",
            required = true,
            example = "02112458548"
    )
    public String getBankBTelphone() {
        return bankBTelphone;
    }

    public void setBankBTelphone(String bankBTelphone) {
        this.bankBTelphone = bankBTelphone;
    }

    @Schema(hidden = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Schema(hidden = true)
    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    @Schema(hidden = true)
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Schema(hidden = true)
    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }
}
