package com.tarazgroup.tws.model.acc;
import com.tarazgroup.tws.util.global.TParams;

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
        name = "AccShowManifestHeader",
        procedureName = "AccShowManifestHeader",
        resultClasses = {AccManifestHeader.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)

        }
)

@NamedStoredProcedureQuery(
        name = "AccInsManifestHeader",
        procedureName = "AccInsManifestHeader",
        parameters = {
                @StoredProcedureParameter(name = "VoucherNumber", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ManifestType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "AccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ManifestDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center1ID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "AccDelManifestHeader",
        procedureName = "AccDelManifestHeader",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class AccManifestHeader extends TParams implements Serializable {
    @Id
    @Column(name = "VoucherHeaderID", columnDefinition ="decimal")
    private BigDecimal voucherHeaderID;

    @Column(name = "VoucherNumber", columnDefinition ="decimal")
    private BigDecimal voucherNumber;

    @Column(name = "VoucherDate", columnDefinition ="char")
    private String voucherDate;

    @Column(name = "ManifestType", columnDefinition ="tinyint")
    private Integer manifestType;

    @Column(name = "ManifestDesc", columnDefinition ="nvarchar")
    private String manifestDesc;

    @Column(name = "CreateDate", columnDefinition ="datetime")
    private Date createDate;

    @Column(name = "ModifyDate", columnDefinition ="datetime")
    private Date modifyDate;

    @Column(name = "CreatorID", columnDefinition ="decimal")
    private BigDecimal creatorID;

    @Column(name = "ModifierID", columnDefinition ="decimal")
    private BigDecimal modifierID;

    @Column(name = "ServerID", columnDefinition ="decimal")
    private BigDecimal serverID;

    @Column(name = "YearID", columnDefinition ="decimal")
    private BigDecimal yearID;

    @Column(name = "ManifestTypeDesc")
    private String manifestTypeDesc;

    @Column(name = "AccountID", columnDefinition ="decimal")
    private BigDecimal accountID;

    @Column(name = "TafsiliID", columnDefinition ="decimal")
    private BigDecimal tafsiliID;

    @Column(name = "AccountCode")
    private String accountCode;

    @Column(name = "AccountDesc")
    private String accountDesc;

    @Column(name = "Center1ID", columnDefinition ="decimal")
    private BigDecimal center1ID;

    @Column(name = "Center1Code")
    private String center1Code;

    @Column(name = "TafsiliDesc")
    private String tafsiliDesc;

    @Column(name = "Center1Desc")
    private String center1Desc;

    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
        this.voucherHeaderID = voucherHeaderID;
    }

    public BigDecimal getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(BigDecimal voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    public Integer getManifestType() {
        return manifestType;
    }

    public void setManifestType(Integer manifestType) {
        this.manifestType = manifestType;
    }

    public String getManifestDesc() {
        return manifestDesc;
    }

    public void setManifestDesc(String manifestDesc) {
        this.manifestDesc = manifestDesc;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public BigDecimal getYearID() {
        return yearID;
    }

    public void setYearID(BigDecimal yearID) {
        this.yearID = yearID;
    }

    public String getManifestTypeDesc() {
        return manifestTypeDesc;
    }

    public void setManifestTypeDesc(String manifestTypeDesc) {
        this.manifestTypeDesc = manifestTypeDesc;
    }

    public BigDecimal getAccountID() {
        return accountID;
    }

    public void setAccountID(BigDecimal accountID) {
        this.accountID = accountID;
    }

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
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

    public BigDecimal getCenter1ID() {
        return center1ID;
    }

    public void setCenter1ID(BigDecimal center1ID) {
        this.center1ID = center1ID;
    }

    public String getCenter1Code() {
        return center1Code;
    }

    public void setCenter1Code(String center1Code) {
        this.center1Code = center1Code;
    }

    public String getTafsiliDesc() {
        return tafsiliDesc;
    }

    public void setTafsiliDesc(String tafsiliDesc) {
        this.tafsiliDesc = tafsiliDesc;
    }

    public String getCenter1Desc() {
        return center1Desc;
    }

    public void setCenter1Desc(String center1Desc) {
        this.center1Desc = center1Desc;
    }
}
