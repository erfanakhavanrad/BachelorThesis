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
 * @author salman majidi
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "PubShowXFieldsFormula",
        procedureName = "PubShowXFieldsFormula",
        resultClasses = {PubXFieldsFormula.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
        }
)

@Entity
public class PubXFieldsFormula extends TParams implements Serializable {

    @Id
    @Column(name = "mCode")
    private String mCode;

    @Column(name = "CustomCaption")
    private String customCaption;

    public String getMCode() {
        return mCode;
    }

    public void setMCode(String mCode) {
        this.mCode = mCode;
    }

    public String getCustomCaption() {
        return customCaption;
    }

    public void setCustomCaption(String customCaption) {
        this.customCaption = customCaption;
    }
}
