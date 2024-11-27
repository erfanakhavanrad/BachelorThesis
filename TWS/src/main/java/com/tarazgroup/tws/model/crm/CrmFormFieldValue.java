package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 9/11/22
 *
 * @author Erfan Akhavan
 */


@NamedStoredProcedureQuery(
        name = "CrmShowFormFieldValue",
        procedureName = "CrmShowFormFieldValue",
        resultClasses = {CrmFormFieldValue.class},
        parameters = {
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN)
        }
)


@NamedStoredProcedureQuery(
        name = "CrmInsUpdFormFieldValue",
        procedureName = "CrmInsUpdFormFieldValue",
        resultClasses = {CrmFormFieldValue.class},
        parameters = {
                @StoredProcedureParameter(name = "RecordID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "TValue", type = CrmFormFieldValueType.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
//                @TValue	dbo.CrmFormFieldValueType readonly,
//        }SQLServerDataRecordCrmFormFieldValueType
//        CrmFormFieldValueType
)


@NamedStoredProcedureQuery(
        name = "CrmInsUpdFormFieldValueweb",
        procedureName = "CrmInsUpdFormFieldValueweb",
        resultClasses = {CrmFormFieldValue.class},
        parameters = {
                @StoredProcedureParameter(name = "RecordID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewRecordID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TValue", type = CrmFormFieldValueTypeAk.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
//                @TValue	dbo.CrmFormFieldValueType readonly,
//        }SQLServerDataRecordCrmFormFieldValueType
//        CrmFormFieldValueTypeAk
//        CrmFormFieldValueType
)

//@NamedStoredProcedureQuery(
//        name = "CrmInsUpdFormFieldValueweb2",
//        procedureName = "CrmInsUpdFormFieldValueweb",
//        resultClasses = {CrmFormFieldValue.class},
//        parameters = {
//                @StoredProcedureParameter(name = "RecordID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "NewRecordID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "TValue", type = CrmFormFieldValueTypeAk.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.OUT)
//        }
//)


@NamedStoredProcedureQuery(
        name = "CrmDelFormFieldValue",
        procedureName = "CrmDelFormFieldValue",
        resultClasses = {CrmFormFieldValue.class},
        parameters = {
                @StoredProcedureParameter(name = "RecordID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)


@Entity
public class CrmFormFieldValue extends TParams implements Serializable {

    @Id
    @Column(name = "RecordID")
    private BigDecimal recordID;

    public BigDecimal getRecordID() {
        return recordID;
    }

    public void setRecordID(BigDecimal recordID) {
        this.recordID = recordID;
    }

}

//
//@Entity
//class CrmFormFieldValued extends TParams implements Serializable {
//}