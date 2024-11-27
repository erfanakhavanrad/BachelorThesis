package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author A.Farahani
 */
@NamedStoredProcedureQuery(
        name = "PubShowAnalysisRepConfig",
        procedureName = "PubShowAnalysisRepConfig",
        resultClasses = {PubAnalysisRepConfig.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class PubAnalysisRepConfig extends TParams implements Serializable {
    @Id
    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "VoucherIdentityDesc")
    private String voucherIdentityDesc;

    @Column(name = "VoucherTypeDesc")
    private String voucherTypeDesc;

    @Column(name = "CustomVTypeDesc")
    private String customVTypeDesc;

    @Column(name = "SystemFName")
    private String systemFName;

    @Column(name = "Priority")
    private Integer priority;

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public String getVoucherIdentityDesc() {
        return voucherIdentityDesc;
    }

    public void setVoucherIdentityDesc(String voucherIdentityDesc) {
        this.voucherIdentityDesc = voucherIdentityDesc;
    }

    public String getVoucherTypeDesc() {
        return voucherTypeDesc;
    }

    public void setVoucherTypeDesc(String voucherTypeDesc) {
        this.voucherTypeDesc = voucherTypeDesc;
    }

    public String getCustomVTypeDesc() {
        return customVTypeDesc;
    }

    public void setCustomVTypeDesc(String customVTypeDesc) {
        this.customVTypeDesc = customVTypeDesc;
    }

    public String getSystemFName() {
        return systemFName;
    }

    public void setSystemFName(String systemFName) {
        this.systemFName = systemFName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
