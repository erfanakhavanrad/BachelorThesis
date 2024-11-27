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
        name = "BuyShowProvider",
        procedureName = "BuyShowProvider",
        resultClasses = {BuyProvider.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "BuyInsProvider",
        procedureName = "BuyInsProvider",
        parameters = {
                @StoredProcedureParameter(name = "providerCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Isnotactive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsForeign", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsAutoSavePercom", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GeoID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)


@NamedStoredProcedureQuery(
        name = "BuyDelProvider",
        procedureName = "BuyDelProvider",
        parameters = {
                @StoredProcedureParameter(name = "providerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "BuyUpdProvider",
        procedureName = "BuyUpdProvider",
        parameters = {
                @StoredProcedureParameter(name = "ProviderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "providerCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Isnotactive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsForeign", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "GeoID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
@Table(name = "BuyProvider")
public class BuyProvider implements Serializable {

    @Id
    @Column(name = "ProviderID")
    private BigDecimal providerID;

    @Column(name = "providerCode")
    private String providerCode;

    @Column(name = "PerComID")
    private BigDecimal perComID;

    @Column(name = "IsNotactive")
    private Boolean notactive;

    @Column(name = "IsForeign")
    private Boolean foreign;

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

    @Column(name = "GeoID")
    private BigDecimal geoID;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getProviderID() {
        return providerID;
    }

    public void setProviderID(BigDecimal providerID) {
        this.providerID = providerID;
    }

    @NotNull(message = "providerCode is mandatory")
    @Schema(
            required = true,
            example = "1"
    )
    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public BigDecimal getPerComID() {
        return perComID;
    }

    public void setPerComID(BigDecimal perComID) {
        this.perComID = perComID;
    }

    @NotNull(message = "isNotactive is mandatory")
    @Schema(
            example = "true"
    )
    public Boolean isNotactive() {
        return notactive;
    }

    public void setNotactive(Boolean notactive) {
        this.notactive = notactive;
    }

    @NotNull(message = "isForeign is mandatory")
    @Schema(
            example = "true"
    )
    public Boolean isForeign() {
        return foreign;
    }

    public void setForeign(Boolean foreign) {
        this.foreign = foreign;
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

    @Schema(
            example = "geoID"
    )
    public BigDecimal getGeoID() {
        return geoID;
    }

    public void setGeoID(BigDecimal geoID) {
        this.geoID = geoID;
    }
}
