package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
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
        name = "AccReport_AccountReview",
        procedureName = "AccReport_AccountReview",
        resultClasses = {AccReportAccountReview.class},
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
                @StoredProcedureParameter(name = "AccountFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCurrency", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsTemp", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FilterTypeVoucher", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsShowContactInfo", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsByServer", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsShowLastActivity", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@Entity
public class AccReportAccountReview extends TParams implements Serializable {

    @Column(name = "ReportLevel")
    private String reportLevel;

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
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "LastSaleWithdrawal")
    private String lstSaleWithdrawal;

    @Column(name = "LastBuyDeposit")
    private String lastBuyDeposit;

    @Column(name = "GeoDesc")
    private String geoDesc;

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

    public String getLstSaleWithdrawal() {
        return lstSaleWithdrawal;
    }

    public void setLstSaleWithdrawal(String lstSaleWithdrawal) {
        this.lstSaleWithdrawal = lstSaleWithdrawal;
    }

    public String getLastBuyDeposit() {
        return lastBuyDeposit;
    }

    public void setLastBuyDeposit(String lastBuyDeposit) {
        this.lastBuyDeposit = lastBuyDeposit;
    }

    public String getGeoDesc() {
        return geoDesc;
    }

    public void setGeoDesc(String geoDesc) {
        this.geoDesc = geoDesc;
    }
}
