package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;
import com.tarazgroup.tws.util.tabletype.crm.CrmFormFieldValueType;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "CrmShowFormFieldValue",
        procedureName = "CrmShowFormFieldValue",
        resultClasses = {CrmFormFieldValue.class},
        parameters = {
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmInsUpdFormFieldValue",
        procedureName = "CrmInsUpdFormFieldValue",
        parameters = {
                @StoredProcedureParameter(name = "RecordID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TValue", type = CrmFormFieldValueType.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmDelFormFieldValue",
        procedureName = "CrmDelFormFieldValue",
        parameters = {
                @StoredProcedureParameter(name = "RecordID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)

        }
)

@NamedNativeQueries({
        @NamedNativeQuery(name = "CrmFormFieldValue.findByRecordID", query = "SELECT * FROM CrmFormFieldValue WHERE RecordID= ?1", resultClass = CrmFormFieldValue.class),
        @NamedNativeQuery(name = "CrmShowFormFieldValue", query = "EXEC CrmShowFormFieldValue 10000003,10000000,N'?1,14?'"),
})



@Entity
@Table
public class CrmFormFieldValue extends TParams implements Serializable {
    // توجه شود که این انتیتی به جدول
    // CrmFormFieldValue
    // مپ شده است و نه به اس پی آن . زیرا وقتی اس پی
    // CrmShowFormFieldValue
    // اجرا میشود یک
    // HashMap<String, Object>
    // بر میگردد
    @Id
    @Column(name = "ValueID")
    @Parameter(hidden = true)
    private BigDecimal valueID;

    @Column(name = "RecordID")
    @Parameter(hidden = true)
    private BigDecimal recordID;

    @Column(name = "FieldID")
    @Parameter(hidden = true)
    private BigDecimal fieldID;

//    @Column(name = "FieldValue", columnDefinition = "sql_variant")
//    private String fieldValue;

    @Column(name = "CreatorID")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    public BigDecimal getValueID() {
        return valueID;
    }

    public void setValueID(BigDecimal valueID) {
        this.valueID = valueID;
    }

    public BigDecimal getRecordID() {
        return recordID;
    }

    public void setRecordID(BigDecimal recordID) {
        this.recordID = recordID;
    }

//    public String getFieldValue() {
//        return fieldValue;
//    }
//
//    public void setFieldValue(String fieldValue) {
//        this.fieldValue = fieldValue;
//    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public BigDecimal getFieldID() {
        return fieldID;
    }

    public void setFieldID(BigDecimal fieldID) {
        this.fieldID = fieldID;
    }
}
