package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubGeoLocationRepository;
import com.tarazgroup.tws.dao.pub.PubGeoLocationTypeRepository;
import com.tarazgroup.tws.model.pub.PubGeoLocation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;


/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@Validated
@RequestMapping("pub/geolocations")
@RestController
@Tag(name = "GeoLocation")
public class PubGeoLocationController {

    private final PubGeoLocationRepository pubGeoLocationRepository;
    private final PubGeoLocationTypeRepository pubGeoLocationTypeRepository;

    public PubGeoLocationController(PubGeoLocationRepository pubGeoLocationRepository, PubGeoLocationTypeRepository pubGeoLocationTypeRepository) {
        this.pubGeoLocationRepository = pubGeoLocationRepository;
        this.pubGeoLocationTypeRepository = pubGeoLocationTypeRepository;
    }


    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all geoLocation",
            description = "<code>Retrieve</code> all <i><b>geoLocation</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubGeoLocation>> geoLocations(@ParameterObject PubGeoLocation pubGeoLocation) {
        return ResponseEntity.ok(pubGeoLocationRepository.pubShowGeoLocation(pubGeoLocation));
    }

    @Operation(
            summary = "Retrieve specific geoLocation",
            description = "<code>Retrieve</code> specific <i><b>geoLocation</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{geoLocationID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubGeoLocation> geoLocation(
            @PathVariable BigDecimal geoLocationID
    ) {
        return ResponseEntity.ok(pubGeoLocationRepository.pubShowGeoLocationByID(geoLocationID));
    }


    @Operation(
            summary = "Retrieve specific geoLocation type",
            description = "<code>Retrieve</code> specific <i><b>geoLocation</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "type/{geoLocationTypeID}", produces = "application/json;charset=utf-8")
    public ResponseEntity <List<PubGeoLocation>> geoLocationType(
            @PathVariable BigDecimal geoLocationTypeID
    ) {
        return ResponseEntity.ok(pubGeoLocationRepository.pubShowGeoLocationTypeByID(geoLocationTypeID));
    }
//for test commnet

    @Operation(
            summary = "Retrieve specific geoLocation father",
            description = "<code>Retrieve</code> specific <i><b>geoLocation</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "father/{geoFatherLocationID}", produces = "application/json;charset=utf-8")
    public ResponseEntity <List<PubGeoLocation>> geoFatherLocation(
            @PathVariable BigDecimal geoFatherLocationID
    ) {
        return ResponseEntity.ok(pubGeoLocationRepository.pubShowGeoFatherLocationByID(geoFatherLocationID));
    }



//    @Operation(
//            summary = "Retrieve geoLocationType of this geoLocation",
//            description = "<code>Retrieve</code> <i><b>geoLocationType</b></i> of this <i><b>geoLocation</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(value = "/{geoLocationID}/geolocationtype", produces = "application/json")
//    public ResponseEntity<PubGeoLocationType> geoLocationType(
//            @PathVariable BigDecimal geoLocationID) {
//        PubGeoLocationType temp = new PubGeoLocationType();
//        temp.setGeoLocationTypeID(pubGeoLocationRepository.pubShowGeoLocationByID(geoLocationID).getGeoLocationTypeID());
//        return ResponseEntity.ok(pubGeoLocationTypeRepository.findByGeoLocationTypeDesc());
//    }

    @Operation(
            summary = "Create geoLocation",
            description = "<code>Create</code> <i><b>geoLocation</b></i></br>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubGeoLocation> geoLocationInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "   \"geoFatherLocationID\":10000001,\n" +
                                                            "   \"geoLocationAbbr\":\"abbr1\",\n" +
                                                            "   \"geoLocationCode\":\"C1\",\n" +
                                                            "   \"geoLocationDesc\":\"شرح ۱\",\n" +
                                                            "   \"geoLocationExt\":\"Ext1\",\n" +
                                                            "   \"geoLocationTypeID\":1\n" +
                                                            "}"

                                    )
                            )
                    }
            )
            @Valid @RequestBody PubGeoLocation pubGeoLocation
    ) {
        return ResponseEntity.ok(pubGeoLocationRepository.pubInsGeoLocation(pubGeoLocation));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully."),
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete geoLocation",
            description = "<code>Delete</code> <i><b>geoLocation</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{geoLocationID}", produces = "application/json")
    public ResponseEntity<?> geoLocationDelSP(
            @PathVariable BigDecimal geoLocationID) {
        pubGeoLocationRepository.pubDelGeoLocation(geoLocationID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update geoLocation",
            description = "<code>Update</code> <i><b>geoLocation</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{geoLocationID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubGeoLocation> geoLocationUpdSP(
            @PathVariable BigDecimal geoLocationID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "   \"geoFatherLocationID\":10000001,\n" +
                                                            "   \"geoLocationAbbr\":\"abbr1\",\n" +
                                                            "   \"geoLocationCode\":\"C1\",\n" +
                                                            "   \"geoLocationDesc\":\"شرح ۱\",\n" +
                                                            "   \"geoLocationExt\":\"Ext1\",\n" +
                                                            "   \"geoLocationTypeID\":1\n" +
                                                            "}"

                                    )
                            )
                    }
            )
            @Valid @RequestBody PubGeoLocation pubGeoLocation) {
        return ResponseEntity.ok(pubGeoLocationRepository.pubUpdGeoLocation(geoLocationID, pubGeoLocation));
    }
    //</editor-fold>

    @Operation(
            summary = "Retrieve geoLocation meta",
            description = "<code>Retrieve</code> <i><b>geoLocation</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json")
    public ResponseEntity<?> meta() {
        return ResponseEntity.ok().body(pubGeoLocationRepository.meta());
    }
}
