package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "AccShowAccountKind",
        procedureName = "AccShowAccountKind",
        resultClasses = {AccAccountKind.class},
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
        name = "AccInsAccountKind",
        procedureName = "AccInsAccountKind",
        parameters = {
                @StoredProcedureParameter(name = "AccountKindCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountKindDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)
@NamedStoredProcedureQuery(
        name = "AccDelAccountKind",
        procedureName = "AccDelAccountKind",
        parameters = {
                @StoredProcedureParameter(name = "AccountKindID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)
@NamedStoredProcedureQuery(
        name = "AccUpdAccountKind",
        procedureName = "AccUpdAccountKind",
        parameters = {
                @StoredProcedureParameter(name = "AccountKindID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountKindCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountKindDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
        }
)


@Entity
@Table(name = "AccAccountKind")
public class AccAccountKind extends TParams implements Serializable {
    @Id
    @Column(name = "AccountKindID")
    @Parameter(hidden = true)
    private BigDecimal accountKindID;

    @Column(name = "AccountKindCode")
    @Parameter
    private String accountKindCode;

    @Column(name = "AccountKindDesc")
    @Parameter
    private String accountKindDesc;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "CreatorID")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;


    @Schema(accessMode = READ_ONLY)
    public BigDecimal getAccountKindID() {
        return accountKindID;
    }

    public void setAccountKindID(BigDecimal accountKindID) {
        this.accountKindID = accountKindID;
    }

    @Schema(
            name = "کد نوع حساب",
            required = true,
            example = "1"
    )
    public String getAccountKindCode() {
        return accountKindCode;
    }

    public void setAccountKindCode(String accountKindCode) {
        this.accountKindCode = accountKindCode;
    }

    @Schema(
            name = "شرح نوع حساب",
            required = true,
            example = "جاری"
    )
    public String getAccountKindDesc() {
        return accountKindDesc;
    }

    public void setAccountKindDesc(String accountKindDesc) {
        this.accountKindDesc = accountKindDesc;
    }

    @Schema(hidden = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }
}
