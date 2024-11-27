package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Erfan Akhavan
 */
@NamedStoredProcedureQuery(
        name = "InvReport_Review_L1",
        procedureName = "InvReport_Review_L1",
        resultClasses = {InvReportReviewL1.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RepType", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsRiali", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOtherSystem", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "QuantityType", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class InvReportReviewL1 extends TParams implements Serializable {

    @Id
    @Column(name = "mID")
    private BigDecimal mID;

    @Column(name = "SystemID")
    private BigDecimal systemID;

    @Column(name = "SystemFName")
    private BigDecimal systemFName;

    @Column(name = "mCode")
    private String mCode;

    @Column(name = "mDesc")
    private String mDesc;

    @Column(name = "FirstPeriod")
    private BigDecimal firstPeriod;

    @Column(name = "Import")
    private BigDecimal cImport;

    @Column(name = "Export")
    private BigDecimal cExport;

    @Column(name = "Remain")
    private BigDecimal remain;

    public BigDecimal getmID() {
        return mID;
    }

    public void setmID(BigDecimal mID) {
        this.mID = mID;
    }

    public BigDecimal getSystemID() {
        return systemID;
    }

    public void setSystemID(BigDecimal systemID) {
        this.systemID = systemID;
    }

    public BigDecimal getSystemFName() {
        return systemFName;
    }

    public void setSystemFName(BigDecimal systemFName) {
        this.systemFName = systemFName;
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public BigDecimal getFirstPeriod() {
        return firstPeriod;
    }

    public void setFirstPeriod(BigDecimal firstPeriod) {
        this.firstPeriod = firstPeriod;
    }

    public BigDecimal getcImport() {
        return cImport;
    }

    public void setcImport(BigDecimal cImport) {
        this.cImport = cImport;
    }

    public BigDecimal getcExport() {
        return cExport;
    }

    public void setcExport(BigDecimal cExport) {
        this.cExport = cExport;
    }

    public BigDecimal getRemain() {
        return remain;
    }

    public void setRemain(BigDecimal remain) {
        this.remain = remain;
    }
}
