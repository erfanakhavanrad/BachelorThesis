package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "PubGetLastVoucherType",
        procedureName = "PubGetLastVoucherType",
        resultClasses = {PubGetLastVoucherType.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDetailID",type = BigDecimal.class,mode = ParameterMode.IN)
        }
)

@Entity
public class PubGetLastVoucherType extends TParams implements Serializable {
    @Id
    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "CustomVTypeDesc")
    private String customVTypeDesc;

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
}
