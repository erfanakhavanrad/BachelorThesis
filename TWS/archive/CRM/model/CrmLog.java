package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
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
    @Column(name = "LogID", columnDefinition = "decimal")
    private BigDecimal logID;

    @Column(name = "ValueID", columnDefinition = "decimal")
    private BigDecimal valueID;

    @Column(name = "RecordID", columnDefinition = "decimal")
    private BigDecimal recordID;

    @Column(name = "FieldValue", columnDefinition = "sql_variant")
    private String fieldValue;

    @Column(name = "CreateDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "CreatorID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "LogType", columnDefinition = "tinyint")
    private Integer logType;

    @Column(name = "ServerID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "LogTypeDesc")
    private String logTypeDesc;

    public BigDecimal getLogID() {
        return logID;
    }

    public void setLogID(BigDecimal logID) {
        this.logID = logID;
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

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
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
}

