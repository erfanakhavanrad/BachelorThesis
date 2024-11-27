package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "PubShowGeoLocation",
        procedureName = "PubShowGeoLocation",
        resultClasses = {PubGeoLocation.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "PubInsGeoLocation",
        procedureName = "PubInsGeoLocation",
        resultClasses = {PubGeoLocation.class},
        parameters = {
                @StoredProcedureParameter(name = "GeoFatherLocationID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GeoLocationTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GeoLocationAbbr", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GeoLocationCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GeoLocationExt", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GeoLocationDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "PubDelGeoLocation",
        procedureName = "PubDelGeoLocation",
        resultClasses = {PubGeoLocation.class},
        parameters = {
                @StoredProcedureParameter(name = "GeoLocationID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
        }
)

@NamedStoredProcedureQuery(
        name = "PubUpdGeoLocation",
        procedureName = "PubUpdGeoLocation",
        resultClasses = {PubGeoLocation.class},
        parameters = {
                @StoredProcedureParameter(name = "GeoLocationID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GeoLocationTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GeoLocationAbbr", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GeoLocationCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GeoLocationExt", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GeoLocationDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "iGeoLocationID", type = BigDecimal.class, mode = ParameterMode.IN),
        }
)

@Entity
@Table(name = "PubGeoLocation")
public class PubGeoLocation extends TParams implements Serializable {

    @Id
    @Column(name = "GeoLocationID", columnDefinition = "decimal")
    private BigDecimal geoLocationID;

    @Column(name = "GeoFatherLocationID", columnDefinition = "decimal")
    private BigDecimal geoFatherLocationID;

    @Column(name = "GeoLocationTypeID")
    private BigDecimal geoLocationTypeID;

    @Column(name = "GeoLocationCode", columnDefinition = "char")
    private String geoLocationCode;

    @Column(name = "GeoLocationAbbr", columnDefinition = "char")
    private String geoLocationAbbr;

    @Column(name = "GeoLocationExt", columnDefinition = "char")
    private String geoLocationExt;

    @Column(name = "GeoLocationDesc", columnDefinition = "nvarchar")
    private String geoLocationDesc;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getGeoLocationID() {
        return geoLocationID;
    }

    public void setGeoLocationID(BigDecimal geoLocationID) {
        this.geoLocationID = geoLocationID;
    }

    @NotNull(message = "geoFatherLocationID is mandatory")
    @Schema(
            required = true,
            example = "10000001"
    )
    public BigDecimal getGeoFatherLocationID() {
        return geoFatherLocationID;
    }

    public void setGeoFatherLocationID(BigDecimal geoFatherLocationID) {
        this.geoFatherLocationID = geoFatherLocationID;
    }

    @NotNull(message = "geoLocationType is mandatory")
    public BigDecimal getGeoLocationTypeID() {
        return geoLocationTypeID;
    }

    public void setGeoLocationTypeID(BigDecimal geoLocationTypeID) {
        this.geoLocationTypeID = geoLocationTypeID;
    }

    @NotBlank(message = "geoLocationCode is mandatory")
    @Schema(
            required = true,
            example = "C1"
    )
    public String getGeoLocationCode() {
        return geoLocationCode;
    }

    public void setGeoLocationCode(String geoLocationCode) {
        this.geoLocationCode = geoLocationCode;
    }

    @Schema(
            example = "abbr1"
    )
    public String getGeoLocationAbbr() {
        return geoLocationAbbr;
    }

    public void setGeoLocationAbbr(String geoLocationAbbr) {
        this.geoLocationAbbr = geoLocationAbbr;
    }

    @Schema(
            example = "Ext1"
    )
    public String getGeoLocationExt() {
        return geoLocationExt;
    }

    public void setGeoLocationExt(String geoLocationExt) {
        this.geoLocationExt = geoLocationExt;
    }

    @NotBlank(message = "geoLocationDesc is mandatory")
    @Schema(
            required = true,
            example = "شرح ۱"
    )
    public String getGeoLocationDesc() {
        return geoLocationDesc;
    }

    public void setGeoLocationDesc(String geoLocationDesc) {
        this.geoLocationDesc = geoLocationDesc;
    }
}





