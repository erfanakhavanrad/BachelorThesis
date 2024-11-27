package com.tarazgroup.tws.dto;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
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
public class AccBankDto extends TParams {

    private BigDecimal bankId;

//    @Parameter(hidden = true)
//    private UUID _id = UUID.randomUUID();
//
//    @Schema(hidden = true)
//    public UUID get_id() {
//        return _id;
//    }
//
//    public void set_id(UUID _id) {
//        this._id = _id;
//    }

    @Parameter
    private String bankCode;

    @Parameter
    private String taxCode;

    @Parameter
    private String bankName;

    @Parameter
    private String bankLatinName;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Parameter(hidden = true)
    private Date createDate;

    @Parameter(hidden = true)
    private BigDecimal modifierID;

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

    @NotBlank(message = "bankLatinName is mandatory")
    @Schema(
            required = true,
            example = "bankLatinName1"
    )
    public String getBankLatinName() {
        return bankLatinName;
    }

    public void setBankLatinName(String bankLatinName) {
        this.bankLatinName = bankLatinName;
    }
}
