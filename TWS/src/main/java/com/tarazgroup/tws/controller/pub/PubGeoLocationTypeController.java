package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubGeoLocationTypeRepository;
import com.tarazgroup.tws.model.pub.PubGeoLocationType;
import com.tarazgroup.tws.util.exception.TNoContentException;
import io.swagger.v3.oas.annotations.Operation;
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
import java.util.ArrayList;
import java.util.List;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@Validated
@RequestMapping("pub/geolocationtypes")
@RestController
@Tag(name = "GeoLocationType")
public class PubGeoLocationTypeController {

    private final PubGeoLocationTypeRepository pubGeoLocationTypeRepository;

    public PubGeoLocationTypeController(PubGeoLocationTypeRepository pubGeoLocationTypeRepository) {
        this.pubGeoLocationTypeRepository = pubGeoLocationTypeRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SD and SPI">
    @Operation(
            summary = "Retrieve all geoLocationTypes",
            description = "<code>Retrieve</code> all <i><b>geoLocationTypes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubGeoLocationType>> geoLocationtypes(@ParameterObject PubGeoLocationType pubGeoLocationType) {
        if (pubGeoLocationType.getGeoLocationTypeDesc() == null) {
            List<PubGeoLocationType> result = new ArrayList<>();
            Iterable<PubGeoLocationType> pubGeoLocationTypes = pubGeoLocationTypeRepository.findAll();
            pubGeoLocationTypes.forEach(result::add);
            return ResponseEntity.ok(result);
        } else {
            List<PubGeoLocationType> pubGeoLocationTypes = pubGeoLocationTypeRepository.findByGeoLocationTypeDesc(pubGeoLocationType.getGeoLocationTypeDesc());
            if (pubGeoLocationTypes.isEmpty()) {
                throw new TNoContentException();
            } else {
                return ResponseEntity.ok(pubGeoLocationTypes);
            }
        }
    }

    @Operation(
            summary = "Retrieve specific geoLocationType",
            description = "<code>Retrieve</code> specific <i><b>geoLocationType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{geoLocationTypeID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubGeoLocationType> geoLocationtype(
            @PathVariable BigDecimal geoLocationTypeID
    ) {
        return ResponseEntity.ok(pubGeoLocationTypeRepository.findById(geoLocationTypeID).get());
    }

    @Operation(
            summary = "Create geoLocationType",
            description = "<code>Create</code> <i><b>geoLocationType<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubGeoLocationType> geoLocationtypeInsH(
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @Valid @RequestBody PubGeoLocationType pubGeoLocationType) {
        return ResponseEntity.ok(pubGeoLocationTypeRepository.insertSPI(pubGeoLocationType));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully."),
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete geoLocationType",
            description = "<code>Delete</code> <i><b>geoLocationType<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{geoLocationTypeID}")
    public ResponseEntity<?> geoLocationtypeDelH(
            @PathVariable BigDecimal geoLocationTypeID) {
        pubGeoLocationTypeRepository.deleteById(geoLocationTypeID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Update geoLocationType",
            description = "<code>Update</code> <i><b>geoLocationType<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{geoLocationTypeID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubGeoLocationType> geoLocationtypeUpdH(
            @PathVariable BigDecimal geoLocationTypeID,
            @Valid @RequestBody PubGeoLocationType pubGeoLocationType) {
        pubGeoLocationType.setGeoLocationTypeID(geoLocationTypeID);
        return ResponseEntity.ok(pubGeoLocationTypeRepository.updateSPI(pubGeoLocationType));
    }
    //</editor-fold>
}
