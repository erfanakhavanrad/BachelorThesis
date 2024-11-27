package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktTimeZoneRepository;
import com.tarazgroup.tws.model.tkt.TktTimeZone;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/***
 * @author A.Farahani
 * @date Mar-09, 2022
 ***/
@RestController
@RequestMapping("tkt/timezones")
@Validated
@Tag(name = "TimeZone")
public class TktTimeZoneController {

    final private TktTimeZoneRepository tktTimeZoneRepository;

    public TktTimeZoneController(TktTimeZoneRepository tktTimeZoneRepository) {
        this.tktTimeZoneRepository = tktTimeZoneRepository;
    }

    @Operation(
            summary = "Retrieve all timeZones",
            description = "<code>Retrieve</code> all <i><b>timeZones</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktTimeZone>> timeZones(@ParameterObject TktTimeZone tktTimeZone) {
        return ResponseEntity
                .ok()
                .body(tktTimeZoneRepository.tktShowTimeZone(tktTimeZone));
    }

    @Operation(
            summary = "Retrieve specific timeZone",
            description = "<code>Retrieve</code> specific <i><b>timeZone</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{timeZoneID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktTimeZone> timeZone(@PathVariable BigDecimal timeZoneID) {
        return ResponseEntity
                .ok()
                .body(tktTimeZoneRepository.tktShowTimeZoneByID(timeZoneID));
    }

    @Operation(
            summary = "Retrieve timeZone meta",
            description = "<code>Retrieve</code> <i><b>timeZone</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktTimeZoneRepository.meta());
    }

}
