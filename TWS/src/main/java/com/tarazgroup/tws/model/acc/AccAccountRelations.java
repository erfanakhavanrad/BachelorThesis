package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "AccInsAccountRelations",
        procedureName = "AccInsAccountRelations",
        resultClasses = {AccAccountRelations.class},
        parameters = {
                @StoredProcedureParameter(name = "AccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RelatedAccountID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
public class AccAccountRelations extends TParams  {

    @Id
    @GeneratedValue
    private BigDecimal accountRelationID;

    @Column(name = "AccountID")
    private BigDecimal accountID;

    @Column(name = "RelatedAccountID")
    private BigDecimal relatedAccountID;

    @Column(name = "ModifyDate", columnDefinition = "datetime")
    private java.sql.Date modifyDate;

    @Column(name = "ServerID", columnDefinition = "decimal")
    private BigDecimal serverID;

    @Column(name = "CreateDate", columnDefinition = "datetime")
    private java.sql.Date createDate;

    @Column(name = "ModifierID", columnDefinition = "decimal")
    private BigDecimal modifierID;

    @Column(name = "CreatorID", columnDefinition = "decimal")
    private BigDecimal creatorID;

    public BigDecimal getAccountRelationID() {
        return accountRelationID;
    }

    public void setAccountRelationID(BigDecimal accountRelationID) {
        this.accountRelationID = accountRelationID;
    }

    public BigDecimal getAccountID() {
        return accountID;
    }

    public void setAccountID(BigDecimal accountID) {
        this.accountID = accountID;
    }

    public BigDecimal getRelatedAccountID() {
        return relatedAccountID;
    }

    public void setRelatedAccountID(BigDecimal relatedAccountID) {
        this.relatedAccountID = relatedAccountID;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }
}
