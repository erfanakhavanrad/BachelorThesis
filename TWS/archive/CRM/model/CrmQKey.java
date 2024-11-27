package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Salman Majidi
 * @since 2.0.0
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


}
