package com.tarazgroup.tws.model.buy;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 *
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "BuyShowPersonBuy",
        procedureName = "BuyShowPersonBuy",
        resultClasses = {BuyPersonBuy.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "BuyInsPersonBuy",
        procedureName = "BuyInsPersonBuy",
        parameters = {
                @StoredProcedureParameter(name = "PercomID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PersonCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "BuyDelPersonBuy",
        procedureName = "BuyDelPersonBuy",
        parameters = {
                @StoredProcedureParameter(name = "PersonBuyID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)


@NamedStoredProcedureQuery(
        name = "BuyUpdPersonBuy",
        procedureName = "BuyUpdPersonBuy",
        parameters = {
                @StoredProcedureParameter(name = "PersonBuyID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PercomID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PersonCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
@Table(name = "BuyPersonBuy")
public class BuyPersonBuy implements Serializable {

    @Id
    @Column(name = "PersonBuyID")
    private BigDecimal personBuyID;

    @Column(name = "PercomID")
    private BigDecimal percomID;

    @Column(name = "PersonCode")
    private BigDecimal personCode;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getPersonBuyID() {
        return personBuyID;
    }

    public void setPersonBuyID(BigDecimal personBuyID) {
        this.personBuyID = personBuyID;
    }

    public BigDecimal getPercomID() {
        return percomID;
    }

    public void setPercomID(BigDecimal percomID) {
        this.percomID = percomID;
    }

    @NotNull(message = "personCode is mandatory")
    @Schema(
            required = true,
            example = "100006"
    )
    public BigDecimal getPersonCode() {
        return personCode;
    }

    public void setPersonCode(BigDecimal personCode) {
        this.personCode = personCode;
    }

    @Schema(hidden = true)
    public Date getCreateDate() {
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
}
