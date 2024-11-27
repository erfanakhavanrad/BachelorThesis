package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "AccReport_AccountCompare",
        procedureName = "AccReport_AccountCompare",
        resultClasses = {AccReportAccountCompare.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GeneralFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReportLevel", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Remain", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ColNum", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ZFromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ZToDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class AccReportAccountCompare extends TParams implements Serializable {

    @Id
    @Column(name = "AccountId")
    private BigDecimal accountId;

    @Column(name = "Accountcode")
    private String accountcode;

    @Column(name = "AccountDesc")
    private String accountDesc;

    @Column(name = "AccountFatherID")
    private BigDecimal accountFatherID;

    @Column(name = "SBed")
    private BigDecimal sBed;

    @Column(name = "SBes")
    private BigDecimal sBes;

    @Column(name = "PreSBed")
    private BigDecimal preSBed;

    @Column(name = "PreSBes")
    private BigDecimal preSBes;

    @Column(name = "FPSbed")
    private BigDecimal fPSbed;

    @Column(name = "FPSbes")
    private BigDecimal fPSbes;

    @Column(name = "RemainBed")
    private BigDecimal remainBed;

    @Column(name = "ZRemainBed")
    private BigDecimal zRemainBed;

    @Column(name = "RemainBes")
    private BigDecimal remainBes;

    @Column(name = "ZRemainBes")
    private BigDecimal zRemainBes;

    @Column(name = "MinAccount")
    private BigDecimal minAccount;

    @Column(name = "MaxAccount")
    private BigDecimal maxAccount;

    @Column(name = "ZAccountID")
    private BigDecimal zAccountID;

    @Column(name = "ZSBed")
    private BigDecimal zSBed;

    @Column(name = "ZSBes")
    private BigDecimal zSBes;

    @Column(name = "ZPreSBed")
    private BigDecimal zPreSBed;

    @Column(name = "ZPreSBes")
    private BigDecimal zPreSBes;

    @Column(name = "ZFPSbed")
    private BigDecimal zFPSbed;

    @Column(name = "ZFPSbes")
    private BigDecimal zFPSbes;

    @Column(name = "ZMinAccount")
    private BigDecimal zMinAccount;

    @Column(name = "ZMaxAccount")
    private BigDecimal zMaxAccount;

    @Column(name = "FRemainBed")
    private BigDecimal fRemainBed;

    @Column(name = "FRemainBes")
    private BigDecimal fRemainBes;

    public BigDecimal getAccountId() {
        return accountId;
    }

    public void setAccountId(BigDecimal accountId) {
        this.accountId = accountId;
    }

    public String getAccountcode() {
        return accountcode;
    }

    public void setAccountcode(String accountcode) {
        this.accountcode = accountcode;
    }

    public String getAccountDesc() {
        return accountDesc;
    }

    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
    }

    public BigDecimal getAccountFatherID() {
        return accountFatherID;
    }

    public void setAccountFatherID(BigDecimal accountFatherID) {
        this.accountFatherID = accountFatherID;
    }

    public BigDecimal getsBed() {
        return sBed;
    }

    public void setsBed(BigDecimal sBed) {
        this.sBed = sBed;
    }

    public BigDecimal getsBes() {
        return sBes;
    }

    public void setsBes(BigDecimal sBes) {
        this.sBes = sBes;
    }

    public BigDecimal getPreSBed() {
        return preSBed;
    }

    public void setPreSBed(BigDecimal preSBed) {
        this.preSBed = preSBed;
    }

    public BigDecimal getPreSBes() {
        return preSBes;
    }

    public void setPreSBes(BigDecimal preSBes) {
        this.preSBes = preSBes;
    }

    public BigDecimal getfPSbed() {
        return fPSbed;
    }

    public void setfPSbed(BigDecimal fPSbed) {
        this.fPSbed = fPSbed;
    }

    public BigDecimal getfPSbes() {
        return fPSbes;
    }

    public void setfPSbes(BigDecimal fPSbes) {
        this.fPSbes = fPSbes;
    }

    public BigDecimal getRemainBed() {
        return remainBed;
    }

    public void setRemainBed(BigDecimal remainBed) {
        this.remainBed = remainBed;
    }

    public BigDecimal getzRemainBed() {
        return zRemainBed;
    }

    public void setzRemainBed(BigDecimal zRemainBed) {
        this.zRemainBed = zRemainBed;
    }

    public BigDecimal getRemainBes() {
        return remainBes;
    }

    public void setRemainBes(BigDecimal remainBes) {
        this.remainBes = remainBes;
    }

    public BigDecimal getzRemainBes() {
        return zRemainBes;
    }

    public void setzRemainBes(BigDecimal zRemainBes) {
        this.zRemainBes = zRemainBes;
    }

    public BigDecimal getMinAccount() {
        return minAccount;
    }

    public void setMinAccount(BigDecimal minAccount) {
        this.minAccount = minAccount;
    }

    public BigDecimal getMaxAccount() {
        return maxAccount;
    }

    public void setMaxAccount(BigDecimal maxAccount) {
        this.maxAccount = maxAccount;
    }

    public BigDecimal getzAccountID() {
        return zAccountID;
    }

    public void setzAccountID(BigDecimal zAccountID) {
        this.zAccountID = zAccountID;
    }

    public BigDecimal getzSBed() {
        return zSBed;
    }

    public void setzSBed(BigDecimal zSBed) {
        this.zSBed = zSBed;
    }

    public BigDecimal getzSBes() {
        return zSBes;
    }

    public void setzSBes(BigDecimal zSBes) {
        this.zSBes = zSBes;
    }

    public BigDecimal getzPreSBed() {
        return zPreSBed;
    }

    public void setzPreSBed(BigDecimal zPreSBed) {
        this.zPreSBed = zPreSBed;
    }

    public BigDecimal getzPreSBes() {
        return zPreSBes;
    }

    public void setzPreSBes(BigDecimal zPreSBes) {
        this.zPreSBes = zPreSBes;
    }

    public BigDecimal getzFPSbed() {
        return zFPSbed;
    }

    public void setzFPSbed(BigDecimal zFPSbed) {
        this.zFPSbed = zFPSbed;
    }

    public BigDecimal getzFPSbes() {
        return zFPSbes;
    }

    public void setzFPSbes(BigDecimal zFPSbes) {
        this.zFPSbes = zFPSbes;
    }

    public BigDecimal getzMinAccount() {
        return zMinAccount;
    }

    public void setzMinAccount(BigDecimal zMinAccount) {
        this.zMinAccount = zMinAccount;
    }

    public BigDecimal getzMaxAccount() {
        return zMaxAccount;
    }

    public void setzMaxAccount(BigDecimal zMaxAccount) {
        this.zMaxAccount = zMaxAccount;
    }

    public BigDecimal getfRemainBed() {
        return fRemainBed;
    }

    public void setfRemainBed(BigDecimal fRemainBed) {
        this.fRemainBed = fRemainBed;
    }

    public BigDecimal getfRemainBes() {
        return fRemainBes;
    }

    public void setfRemainBes(BigDecimal fRemainBes) {
        this.fRemainBes = fRemainBes;
    }
}
