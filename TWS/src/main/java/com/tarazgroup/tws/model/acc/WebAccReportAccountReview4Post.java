package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "Web_AccReport_AccountReview_4Post",
        procedureName = "Web_AccReport_AccountReview_4Post",
        resultClasses = {WebAccReportAccountReview4Post.class},
        parameters = {
                @StoredProcedureParameter(name = "FromBujCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToBujCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CompCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CostCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCost", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "InComeType", type = Integer.class, mode = ParameterMode.IN)
        }
)

@Entity
public class WebAccReportAccountReview4Post extends TParams  {
    @Id
    @Column(name = "AccountId")
    private BigDecimal accountId;

    @Column(name = "ReportLevel")
    private String reportLevel;

    @Column(name = "AccountCode")
    private String accountCode;

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

    @Column(name = "RemainBes")
    private BigDecimal remainBes;

    @Column(name = "SumBed")
    private BigDecimal sumBed;

    @Column(name = "SumBes")
    private BigDecimal sumBes;

    @Column(name = "MinAccount")
    private BigDecimal minAccount;

    @Column(name = "MaxAccount")
    private BigDecimal maxAccount;

    @Column(name = "RelatedLevels")
    private String relatedLevels;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "ServerName")
    private String serverName;

    @Column(name = "ServerDesc")
    private String serverDesc;

    public String getReportLevel() {
        return reportLevel;
    }

    public void setReportLevel(String reportLevel) {
        this.reportLevel = reportLevel;
    }

    public BigDecimal getAccountId() {
        return accountId;
    }

    public void setAccountId(BigDecimal accountId) {
        this.accountId = accountId;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
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

    public BigDecimal getSBed() {
        return sBed;
    }

    public void setSBed(BigDecimal sBed) {
        this.sBed = sBed;
    }

    public BigDecimal getSBes() {
        return sBes;
    }

    public void setSBes(BigDecimal sBes) {
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

    public BigDecimal getFPSbed() {
        return fPSbed;
    }

    public void setFPSbed(BigDecimal fPSbed) {
        this.fPSbed = fPSbed;
    }

    public BigDecimal getFPSbes() {
        return fPSbes;
    }

    public void setFPSbes(BigDecimal fPSbes) {
        this.fPSbes = fPSbes;
    }

    public BigDecimal getRemainBed() {
        return remainBed;
    }

    public void setRemainBed(BigDecimal remainBed) {
        this.remainBed = remainBed;
    }

    public BigDecimal getRemainBes() {
        return remainBes;
    }

    public void setRemainBes(BigDecimal remainBes) {
        this.remainBes = remainBes;
    }

    public BigDecimal getSumBed() {
        return sumBed;
    }

    public void setSumBed(BigDecimal sumBed) {
        this.sumBed = sumBed;
    }

    public BigDecimal getSumBes() {
        return sumBes;
    }

    public void setSumBes(BigDecimal sumBes) {
        this.sumBes = sumBes;
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

    public String getRelatedLevels() {
        return relatedLevels;
    }

    public void setRelatedLevels(String relatedLevels) {
        this.relatedLevels = relatedLevels;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerDesc() {
        return serverDesc;
    }

    public void setServerDesc(String serverDesc) {
        this.serverDesc = serverDesc;
    }
}
