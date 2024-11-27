package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "CrmShowFieldType",
        procedureName = "CrmShowFieldType",
        resultClasses = {CrmFieldType.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class CrmFieldType extends TParams implements Serializable {
    @Id
    @Column(name = "FieldType")
    private BigDecimal fieldType;

    @Column(name = "FieldTypeDesc")
    @Parameter
    private String fieldTypeDesc;

    @Column(name = "FieldTypeDescLatin")
    @Parameter
    private String fieldTypeDescLatin;

    public BigDecimal getFieldType() {
        return fieldType;
    }

    public void setFieldType(BigDecimal fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldTypeDesc() {
        return fieldTypeDesc;
    }

    public void setFieldTypeDesc(String fieldTypeDesc) {
        this.fieldTypeDesc = fieldTypeDesc;
    }

    public String getFieldTypeDescLatin() {
        return fieldTypeDescLatin;
    }

    public void setFieldTypeDescLatin(String fieldTypeDescLatin) {
        this.fieldTypeDescLatin = fieldTypeDescLatin;
    }
}
