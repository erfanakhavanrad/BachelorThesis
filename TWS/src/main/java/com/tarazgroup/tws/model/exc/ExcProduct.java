package com.tarazgroup.tws.model.exc;

import com.tarazgroup.tws.util.global.TParams;
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
        name = "ExcShowProduct",
        procedureName = "ExcShowProduct",
        resultClasses = {ExcProduct.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "ExcInsProduct",
        procedureName = "ExcInsProduct",
        parameters = {
                @StoredProcedureParameter(name = "ProductCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProductDescLatin", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProductDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProductTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "Symbol", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = Boolean.class, mode = ParameterMode.IN)
        }
)


@NamedStoredProcedureQuery(
        name = "ExcUpdProduct",
        procedureName = "ExcUpdProduct",
        parameters = {
                @StoredProcedureParameter(name = "ProductID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProductCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProductDescLatin", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProductDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProductTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "Symbol", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "ExcDelProduct",
        procedureName = "ExcDelProduct",
        parameters = {
                @StoredProcedureParameter(name = "ProductID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)


@Entity
//@Table(name = "ExcProduct")
public class ExcProduct extends TParams implements Serializable {

    @Id
    @Column(name = "ProductID")
    private BigDecimal productID;

    @Column(name = "ProductCode")
    private String productCode;

    @Column(name = "ProductDescLatin")
    private String productDescLatin;

    @Column(name = "ProductDesc")
    private String productDesc;

    @Column(name = "ProductTypeID")
    private BigDecimal productTypeID;

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

    @Column(name = "ProductTypeCode")
    private String productTypeCode;

    @Column(name = "ProductTypeDesc")
    private String productTypeDesc;

    @Column(name = "Symbol")
    private String symbol;

    @Column(name = "SalePrice")
    private BigDecimal salePrice;

    @Column(name = "BuyPrice")
    private BigDecimal buyPrice;

    @Column(name = "IsNotActive")
    private Boolean isNotActive;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getProductID() {
        return productID;
    }

    public void setProductID(BigDecimal productID) {
        this.productID = productID;
    }

    @NotNull(message = "productCode is mandatory")
    @Schema(
            required = true,
            example = "01"
    )
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Schema(
            required = true,
            example = "USD"
    )
    public String getProductDescLatin() {
        return productDescLatin;
    }

    public void setProductDescLatin(String productDescLatin) {
        this.productDescLatin = productDescLatin;
    }

    @NotNull(message = "productDesc is mandatory")
    @Schema(
            required = true,
            example = "دلار آمریکا"
    )
    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public BigDecimal getProductTypeID() {
        return productTypeID;
    }

    public void setProductTypeID(BigDecimal productTypeID) {
        this.productTypeID = productTypeID;
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

    @Schema(
            example = "$"
    )
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Schema(
            example = "true"
    )
    public Boolean GetIsNotActive() {
        return isNotActive;
    }

    public void setIsNotActive(Boolean isNotActive) {
        this.isNotActive = isNotActive;
    }

    public String getProductTypeCode() {
        return productTypeCode;
    }

    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }

    public String getProductTypeDesc() {
        return productTypeDesc;
    }

    public void setProductTypeDesc(String productTypeDesc) {
        this.productTypeDesc = productTypeDesc;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }
}
