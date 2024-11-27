package com.tarazgroup.tws.model.exc;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "ExcShowProductType",
        procedureName = "ExcShowProductType",
        resultClasses = {ExcProductType.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "ExcInsProductType",
        procedureName = "ExcInsProductType",
        parameters = {
                @StoredProcedureParameter(name = "ProductTypeCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProductTypeDescLatin", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProductTypeDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "ExcDelProductType",
        procedureName = "ExcDelProductType",
        parameters = {
                @StoredProcedureParameter(name = "ProductTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "ExcUpdProductType",
        procedureName = "ExcUpdProductType",
        parameters = {
                @StoredProcedureParameter(name = "ProductTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProductTypeCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProductTypeDescLatin", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProductTypeDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
        }
)

@Entity
@Table(name = "ExcProductType")
public class ExcProductType implements Serializable {

    @Id
    @Column(name = "ProductTypeID")
    private BigDecimal productTypeID;

    @Column(name = "ProductTypeCode")
    private String productTypeCode;

    @Column(name = "ProductTypeDescLatin")
    private String productTypeDescLatin;

    @Column(name = "ProductTypeDesc")
    private String productTypeDesc;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "TafsiliID")
    private BigDecimal tafsiliID;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getProductTypeID() {
        return productTypeID;
    }

    public void setProductTypeID(BigDecimal productTypeID) {
        this.productTypeID = productTypeID;
    }

    @NotNull(message = "productTypeCode is mandatory")
    @Schema(
            required = true,
            example = "01"
    )
    public String getProductTypeCode() {
        return productTypeCode;
    }

    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }

    @NotNull(message = "productTypeDescLatin is mandatory")
    @Schema(
            required = true,
            example = "currency"
    )
    public String getProductTypeDescLatin() {
        return productTypeDescLatin;
    }

    public void setProductTypeDescLatin(String productTypeDescLatin) {
        this.productTypeDescLatin = productTypeDescLatin;
    }

    @NotNull(message = "productTypeDesc is mandatory")
    @Schema(
            required = true,
            example = "انواع ارز"
    )
    public String getProductTypeDesc() {
        return productTypeDesc;
    }

    public void setProductTypeDesc(String productTypeDesc) {
        this.productTypeDesc = productTypeDesc;
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

    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
    }
}
