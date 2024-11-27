package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 3/2/23
 *
 * @author Erfan Akhavan
 */


@NamedStoredProcedureQuery(
        name = "CrmShowQKey",
        procedureName = "CrmShowQKey",
        resultClasses = {CrmQKey.class},
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
public class CrmQKey extends TParams implements Serializable {

    @Id
    @Column(name = "QKeyID")
    private BigDecimal qKeyID;

    @Column(name = "TableName")
    private String tableName;

    @Column(name = "PKName")
    private String pKName;

    @Column(name = "CodeName")
    private String codeName;

    @Column(name = "DescName")
    private String descName;

    @Column(name = "TableDesc")
    private String tableDesc;

    @Column(name = "ResourceData")
    private String resourceData;

    @Column(name = "ResourceMeta")
    private String resourceMeta;

    public BigDecimal getqKeyID() {
        return qKeyID;
    }

    public void setqKeyID(BigDecimal qKeyID) {
        this.qKeyID = qKeyID;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getpKName() {
        return pKName;
    }

    public void setpKName(String pKName) {
        this.pKName = pKName;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getDescName() {
        return descName;
    }

    public void setDescName(String descName) {
        this.descName = descName;
    }

    public String getTableDesc() {
        return tableDesc;
    }

    public void setTableDesc(String tableDesc) {
        this.tableDesc = tableDesc;
    }

    public String getResourceData() {
        return resourceData;
    }

    public void setResourceData(String resourceData) {
        this.resourceData = resourceData;
    }

    public String getResourceMeta() {
        return resourceMeta;
    }

    public void setResourceMeta(String resourceMeta) {
        this.resourceMeta = resourceMeta;
    }
}
