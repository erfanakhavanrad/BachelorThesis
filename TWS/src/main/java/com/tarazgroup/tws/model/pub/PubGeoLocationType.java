package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@Entity
public class
PubGeoLocationType extends TParams {

    @Id
    @Column(name = "GeoLocationTypeID", columnDefinition = "decimal")
    private BigDecimal geoLocationTypeID;

    @Column(name = "GeoLocationTypeDesc", columnDefinition = "nvarchar")
    private String geoLocationTypeDesc;

    @Column(name = "GeoFatherTypeID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal geoFatherTypeID;


    @Schema(accessMode = READ_ONLY)
    public BigDecimal getGeoLocationTypeID() {
        return geoLocationTypeID;
    }

    public void setGeoLocationTypeID(BigDecimal geoLocationTypeID) {
        this.geoLocationTypeID = geoLocationTypeID;
    }

    @NotBlank(message = "geoLocationTypeDesc is mandatory")
    @Schema(
            required = true,
            example = "قریه"
    )
    public String getGeoLocationTypeDesc() {
        return geoLocationTypeDesc;
    }

    public void setGeoLocationTypeDesc(String geoLocationTypeDesc) {
        this.geoLocationTypeDesc = geoLocationTypeDesc;
    }

    @NotNull(message = "geoFatherTypeID is mandatory")
    @Schema(
            required = true,
            example = "1"
    )
    public BigDecimal getGeoFatherTypeID() {
        return geoFatherTypeID;
    }

    public void setGeoFatherTypeID(BigDecimal geoFatherTypeID) {
        this.geoFatherTypeID = geoFatherTypeID;
    }
}
