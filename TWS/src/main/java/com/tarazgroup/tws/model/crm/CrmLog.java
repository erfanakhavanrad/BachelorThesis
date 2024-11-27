package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 10/20/22
 *
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "CrmShowLog",
        procedureName = "CrmShowLog",
        resultClasses = {CrmLog.class},
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
public class CrmLog extends TParams implements Serializable {

    @Id
    @Column(name = "LogID")
    private BigDecimal logID;

    @Column(name = "FormID")
    private BigDecimal formID;

    @Column(name = "ValueID")
    private BigDecimal valueID;

    @Column(name = "RecordID")
    private BigDecimal recordID;

    //sqlvariant
    @Column(name = "FieldValue", columnDefinition = "sql_variant")
    private String fieldValue;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "LogType")
    private Integer logType;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "LogTypeDesc")
    private String logTypeDesc;

    @Column(name = "CreatorName")
    private String creatorName;

    @Column(name = "CreateTime")
    private String createTime;

    public BigDecimal getLogID() {
        return logID;
    }

    public void setLogID(BigDecimal logID) {
        this.logID = logID;
    }

    public BigDecimal getFormID() {
        return formID;
    }

    public void setFormID(BigDecimal formID) {
        this.formID = formID;
    }

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

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public String getLogTypeDesc() {
        return logTypeDesc;
    }

    public void setLogTypeDesc(String logTypeDesc) {
        this.logTypeDesc = logTypeDesc;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
