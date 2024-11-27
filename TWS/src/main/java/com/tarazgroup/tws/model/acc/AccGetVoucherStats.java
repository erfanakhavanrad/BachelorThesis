package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/***
 * @author A.Farahani
 * @date Dec-29, 2021
 ***/
@NamedStoredProcedureQuery(
        name = "AccGetVoucherStats",
        procedureName = "AccGetVoucherStats",
        resultClasses = {AccGetVoucherStats.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class AccGetVoucherStats extends TParams implements Serializable {
    @Id



    @Column(name = "TotalHeaderCount")
    private BigDecimal totalHeaderCount;

    @Column(name = "TotalDetailCount")
    private BigDecimal totalDetailCount;

    @Column(name = "Stat3Count")
    private BigDecimal stat3Count;

    @Column(name = "Stat2Count")
    private BigDecimal stat2Count;

    @Column(name = "Stat1Count")
    private  BigDecimal stat1Count;

    @Column(name = "Stat0Count")
    private  BigDecimal stat0Count;

    @Column(name = "HDelCount")
    private BigDecimal hDelCount;

    @Column(name = "DDelCount")
    private BigDecimal dDelCount;

    @Column(name = "NotControlled")
    private  BigDecimal notControlled;

    @Column(name = "Controlled")
    private BigDecimal controlled;

    @Column(name = "InRepHCount")
    private BigDecimal inRepHCount;

    @Column(name = "InRepDCount")
    private BigDecimal inRepDCount;

    public BigDecimal getTotalHeaderCount() {
        return totalHeaderCount;
    }

    public void setTotalHeaderCount(BigDecimal totalHeaderCount) {
        this.totalHeaderCount = totalHeaderCount;
    }

    public BigDecimal getTotalDetailCount() {
        return totalDetailCount;
    }

    public void setTotalDetailCount(BigDecimal totalDetailCount) {
        this.totalDetailCount = totalDetailCount;
    }

    public BigDecimal getStat3Count() {
        return stat3Count;
    }

    public void setStat3Count(BigDecimal stat3Count) {
        this.stat3Count = stat3Count;
    }

    public BigDecimal getStat2Count() {
        return stat2Count;
    }

    public void setStat2Count(BigDecimal stat2Count) {
        this.stat2Count = stat2Count;
    }

    public BigDecimal getStat1Count() {
        return stat1Count;
    }

    public void setStat1Count(BigDecimal stat1Count) {
        this.stat1Count = stat1Count;
    }

    public BigDecimal getStat0Count() {
        return stat0Count;
    }

    public void setStat0Count(BigDecimal stat0Count) {
        this.stat0Count = stat0Count;
    }

    public BigDecimal gethDelCount() {
        return hDelCount;
    }

    public void sethDelCount(BigDecimal hDelCount) {
        this.hDelCount = hDelCount;
    }

    public BigDecimal getdDelCount() {
        return dDelCount;
    }

    public void setdDelCount(BigDecimal dDelCount) {
        this.dDelCount = dDelCount;
    }

    public BigDecimal getNotControlled() {
        return notControlled;
    }

    public void setNotControlled(BigDecimal notControlled) {
        this.notControlled = notControlled;
    }

    public BigDecimal getControlled() {
        return controlled;
    }

    public void setControlled(BigDecimal controlled) {
        this.controlled = controlled;
    }

    public BigDecimal getInRepHCount() {
        return inRepHCount;
    }

    public void setInRepHCount(BigDecimal inRepHCount) {
        this.inRepHCount = inRepHCount;
    }

    public BigDecimal getInRepDCount() {
        return inRepDCount;
    }

    public void setInRepDCount(BigDecimal inRepDCount) {
        this.inRepDCount = inRepDCount;
    }
}
