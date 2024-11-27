package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "PubShowAutoVoucher",
        procedureName = "PubShowAutoVoucher",
        resultClasses = {PubAutoVoucher.class},
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
        name = "PubInsAutoVoucher",
        procedureName = "PubInsAutoVoucher",
        resultClasses = {PubAutoVoucher.class},
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAutoVoucher", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAutoDelVoucher", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAutoControlVoucher", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsViewVoucher", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)


@NamedStoredProcedureQuery(
        name = "PubUpdAutoVoucher",
        procedureName = "PubUpdAutoVoucher",
        resultClasses = {PubAutoVoucher.class},
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAutoVoucher", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAutoDelVoucher", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAutoControlVoucher", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsViewVoucher", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = BigDecimal.class, mode = ParameterMode.OUT)
        }

)


@NamedStoredProcedureQuery(
        name = "PubDelAutoVoucher",
        procedureName = "PubDelAutoVoucher",
        resultClasses = {PubAutoVoucher.class},
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class    PubAutoVoucher extends TParams {
    @Id
    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "CustomVTypeDesc")
    private String customVTypeDesc;

    @Column(name = "IsAutoVoucher")
    private Boolean isAutoVoucher;

    @Column(name = "IsAutoDelVoucher")
    private Boolean isAutoDelVoucher;

    @Column(name = "IsAutoControlVoucher")
    private Boolean isAutoControlVoucher;

    @Column(name = "SystemFName")
    private String systemFName;

    @Column(name = "IsViewVoucher")
    private Boolean isViewVoucher;

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public String getCustomVTypeDesc() {
        return customVTypeDesc;
    }

    public void setCustomVTypeDesc(String customVTypeDesc) {
        this.customVTypeDesc = customVTypeDesc;
    }

    public Boolean getIsAutoVoucher() {
        return isAutoVoucher;
    }

    public void setIsAutoVoucher(Boolean autoVoucher) {
        isAutoVoucher = autoVoucher;
    }

    public Boolean getIsAutoDelVoucher() {
        return isAutoDelVoucher;
    }

    public void setIsAutoDelVoucher(Boolean autoDelVoucher) {
        isAutoDelVoucher = autoDelVoucher;
    }

    public Boolean getIsAutoControlVoucher() {
        return isAutoControlVoucher;
    }

    public void setIsAutoControlVoucher(Boolean autoControlVoucher) {
        isAutoControlVoucher = autoControlVoucher;
    }

    public String getSystemFName() {
        return systemFName;
    }

    public void setSystemFName(String systemFName) {
        this.systemFName = systemFName;
    }

    public Boolean getIsViewVoucher() {
        return isViewVoucher;
    }

    public void setIsViewVoucher(Boolean viewVoucher) {
        isViewVoucher = viewVoucher;
    }
}
