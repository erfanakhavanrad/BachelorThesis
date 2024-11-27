package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
        name = "AccShowAccount",
        procedureName = "AccShowAccount",
        resultClasses = {AccAccount.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "AccInsAccount",
        procedureName = "AccInsAccount",
        resultClasses = {AccAccount.class},
        parameters = {
                @StoredProcedureParameter(name = "AccountCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountFatherID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountLevel", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCurrency", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Trace", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsDocCount", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsWarning", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsError", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountNature", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "AccountXDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountLatinDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "AccDelAccount",
        procedureName = "AccDelAccount",
        resultClasses = {AccAccount.class},
        parameters = {
                @StoredProcedureParameter(name = "AccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "AccUpdAccount",
        procedureName = "AccUpdAccount",
        resultClasses = {AccAccount.class},
        parameters = {
                @StoredProcedureParameter(name = "AccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCurrency", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Trace", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsDocCount", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsWarning", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsError", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountNature", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "AccountXDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountLatinDesc", type = String.class, mode = ParameterMode.IN)
        }
)


@Entity
public class AccAccount extends TParams implements Serializable {

    @Id
    @Column(name = "AccountID")
    @Parameter
    private BigDecimal accountID;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "AccountLevel")
    @Parameter(hidden = true)
    private BigDecimal accountLevel;

    @Column(name = "groupsAccountID")
    @Parameter(hidden = true)
    private BigDecimal groupsAccountID;

    @Column(name = "groupsAccountDesc")
    @Parameter(hidden = true)
    private String groupsAccountDesc;

    @Column(name = "groupsAccountCode")
    @Parameter(hidden = true)
    private String groupsAccountCode;

    @Column(name = "ColAccountID")
    @Parameter(hidden = true)
    private BigDecimal colAccountID;

    @Column(name = "ColAccountDesc")
    @Parameter(hidden = true)
    private String colAccountDesc;

    @Column(name = "ColAccountCode")
    @Parameter(hidden = true)
    private String colAccountCode;

    @Column(name = "AccountCode")
    private String accountCode;

    @Column(name = "AccountDesc")
    @Parameter
    private String accountDesc;

    @Column(name = "AccountFatherID")
    @Parameter
    private BigDecimal accountFatherID;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "CreatorID")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "IsCurrency")
    @Parameter(hidden = true)
    private Boolean isCurrency;

    @Column(name = "Trace")
    @Parameter(hidden = true)
    private Boolean trace;

    @Column(name = "IsDocCount")
    @Parameter(hidden = true)
    private Boolean isDocCount;

    @Column(name = "Iswarning")
    @Parameter(hidden = true)
    private Boolean isWarning;

    @Column(name = "IsError")
    @Parameter(hidden = true)
    private Boolean isError;

    @Column(name = "IsNotActive")
    @Parameter(hidden = true)
    private Boolean isNotActive;

    @Column(name = "AccountNature")
    @Parameter(hidden = true)
    private BigDecimal accountNature;

    @Column(name = "AccountLatinDesc")
    @Parameter(hidden = true)
    private String accountLatinDesc;

    @Column(name = "AccountXDesc")
    @Parameter(hidden = true)
    private String accountXDesc;

    @Column(name = "TafsiliTypeStr")
    @Parameter(hidden = true)
    private String tafsiliTypeStr;

    @Column(name = "YearDesc")
    @Parameter(hidden = true)
    private String yearDesc;

    @Column(name = "AccountNatureDesc")
    @Parameter(hidden = true)
    private String accountNatureDesc;

    @Schema()
    public BigDecimal getAccountID() {
        return accountID;
    }

    public void setAccountID(BigDecimal accountID) {
        this.accountID = accountID;
    }

    @NotNull(message = "accountCode is mandatory")
    @Schema(
            required = true,
            example = "7171"
    )

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }


    public String getGroupsAccountCode() {
        return groupsAccountCode;
    }

    public void setGroupsAccountCode(String groupsAccountCode) {
        this.groupsAccountCode = groupsAccountCode;
    }

    @NotNull(message = "accountDesc is mandatory")
    @Schema(
            required = true,
            example = "داراييهاي جاري"
    )
    public String getAccountDesc() {
        return accountDesc;
    }

    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
    }

    @Schema(
            example = "10000001"
    )
    public BigDecimal getAccountFatherID() {
        return accountFatherID;
    }

    public void setAccountFatherID(BigDecimal accountFatherID) {
        this.accountFatherID = accountFatherID;
    }

    @Schema(
            example = "0"
    )
    public BigDecimal getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(BigDecimal accountLevel) {
        this.accountLevel = accountLevel;
    }

    public Boolean getIsCurrency() {
        return isCurrency;
    }

    public void setIsCurrency(Boolean isCurrency) {
        this.isCurrency = isCurrency;
    }

    @Schema(
            example = "false"
    )
    public Boolean getTrace() {
        return trace;
    }

    public void setTrace(Boolean trace) {
        this.trace = trace;
    }

    @Schema(
            example = "false"
    )
    public Boolean getIsDocCount() {
        return isDocCount;
    }

    public void setIsDocCount(Boolean isDocCount) {
        this.isDocCount = isDocCount;
    }

    @Schema(
            example = "false"
    )
    public Boolean getIsWarning() {
        return isWarning;
    }

    public void setIsWarning(Boolean isWarning) {
        this.isWarning = isWarning;
    }

    @Schema(
            example = "false"
    )
    public Boolean getIsError() {
        return isError;
    }

    public void setIsError(Boolean isError) {
        this.isError = isError;
    }

    @Schema(
            example = "false"
    )
    public Boolean getIsNotActive() {
        return isNotActive;
    }

    public void setIsNotActive(Boolean isNotActive) {
        this.isNotActive = isNotActive;
    }

    @Schema(
            example = "1"
    )
    public BigDecimal getAccountNature() {
        return accountNature;
    }

    public void setAccountNature(BigDecimal accountNature) {
        this.accountNature = accountNature;
    }

    @Schema(hidden = true)
    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Schema(hidden = true)
    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    @Schema(hidden = true)
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Schema(hidden = true)
    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    @Schema(
            example = "accountXDesc1"
    )
    public String getAccountXDesc() {
        return accountXDesc;
    }

    public void setAccountXDesc(String accountXDesc) {
        this.accountXDesc = accountXDesc;
    }

    @Schema(
            example = " "
    )
    public String getAccountLatinDesc() {
        return accountLatinDesc;
    }

    public void setAccountLatinDesc(String accountLatinDesc) {
        this.accountLatinDesc = accountLatinDesc;
    }

    public BigDecimal getGroupsAccountID() {
        return groupsAccountID;
    }

    public void setGroupsAccountID(BigDecimal groupsAccountID) {
        this.groupsAccountID = groupsAccountID;
    }

    public String getGroupsAccountDesc() {
        return groupsAccountDesc;
    }

    public void setGroupsAccountDesc(String groupsAccountDesc) {
        this.groupsAccountDesc = groupsAccountDesc;
    }

    public BigDecimal getColAccountID() {
        return colAccountID;
    }

    public void setColAccountID(BigDecimal colAccountID) {
        this.colAccountID = colAccountID;
    }

    public String getColAccountDesc() {
        return colAccountDesc;
    }

    public void setColAccountDesc(String colAccountDesc) {
        this.colAccountDesc = colAccountDesc;
    }

    public String getColAccountCode() {
        return colAccountCode;
    }

    public void setColAccountCode(String colAccountCode) {
        this.colAccountCode = colAccountCode;
    }

    public String getTafsiliTypeStr() {
        return tafsiliTypeStr;
    }

    public void setTafsiliTypeStr(String tafsiliTypeStr) {
        this.tafsiliTypeStr = tafsiliTypeStr;
    }

    public String getYearDesc() {
        return yearDesc;
    }

    public void setYearDesc(String yearDesc) {
        this.yearDesc = yearDesc;
    }

    public String getAccountNatureDesc() {
        return accountNatureDesc;
    }

    public void setAccountNatureDesc(String accountNatureDesc) {
        this.accountNatureDesc = accountNatureDesc;
    }
}
