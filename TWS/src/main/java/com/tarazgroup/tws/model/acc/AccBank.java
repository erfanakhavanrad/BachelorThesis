package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "AccShowBank",
        procedureName = "AccShowBank",
        resultClasses = {AccBank.class},
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
        name = "AccInsBank",
        procedureName = "AccInsBank",
        parameters = {
                @StoredProcedureParameter(name = "BankName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankLatinName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TaxCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "AccDelBank",
        procedureName = "AccDelBank",
        parameters = {
                @StoredProcedureParameter(name = "BankID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "AccUpdBank",
        procedureName = "AccUpdBank",
        parameters = {
                @StoredProcedureParameter(name = "BankID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankLatinName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TaxCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)



@Entity
//@Table(name = "AccBank")
public class AccBank extends TParams implements Serializable {
    @Id
    @Column(name = "BankID")
    private BigDecimal bankId;

    @Transient
    @Parameter(hidden = true)
    private UUID _id = UUID.randomUUID();

    @Schema(hidden = true)
    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    @Column(name = "BankCode")
    @Parameter
    private String bankCode;

    @Column(name = "taxCode")
    @Parameter
    private String taxCode;

    @Column(name = "BankName")
    @Parameter
    private String bankName;

    @Column(name = "BankLatinName")
    @Parameter
    private String bankLatinName;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "CreatorID")
    @Parameter(hidden = true)
    @Transient
    private BigDecimal creatorID;



    @Schema(hidden = true)
    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal salmanID) {
        this.creatorID = salmanID;
    }

    @Schema(hidden = true)
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    @Schema(hidden = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Schema(hidden = true)
    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getBankId() {
        return bankId;
    }

    public void setBankId(BigDecimal bankId) {
        this.bankId = bankId;
    }


    @NotBlank(message = "bankCode is mandatory")
    @Schema(
            name = "bankCode",
            required = true,
            example = "bankCode1"
    )
    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    @NotBlank(message = "taxCode is mandatory")
    @Schema(
            required = true,
            example = "taxCode1"
    )
    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    @NotBlank(message = "bankName is mandatory")
    @Schema(
            required = true,
            example = "bankName1",
            hidden = false
    )
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Schema(
            example = "bankLatinName1"
    )
    public String getBankLatinName() {
        return bankLatinName;
    }

    public void setBankLatinName(String bankLatinName) {
        this.bankLatinName = bankLatinName;
    }

}
