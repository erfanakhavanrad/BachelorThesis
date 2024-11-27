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
        name = "PubShowXFieldsValue",
        procedureName = "PubShowXFieldsValue",
        resultClasses = {PubXFieldsValue.class},
        parameters = {
                @StoredProcedureParameter(name = "FieldNumber", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TableName", type = String.class, mode = ParameterMode.IN),
        }
)

@Entity
public class PubXFieldsValue extends TParams implements Serializable {

    @Id
    @Column(name = "RowNumber")
    private BigDecimal rowNumber;

    @Column(name = "mID")
    private String mID;

    @Column(name = "mDesc")
    private String mDesc;

    public BigDecimal getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(BigDecimal rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getMID() {
        return mID;
    }

    public void setMID(String mID) {
        this.mID = mID;
    }

    public String getMDesc() {
        return mDesc;
    }

    public void setMDesc(String mDesc) {
        this.mDesc = mDesc;
    }
}
