package com.tarazgroup.tws.controller.pub;


import com.tarazgroup.tws.dao.pub.PubServerRepository;
import com.tarazgroup.tws.model.pub.PubServer;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@Validated
@RequestMapping("pub/servers")
@RestController
@Tag(name = "Server")
public class PubServerController {

    private final PubServerRepository pubServerRepository;

    public PubServerController(PubServerRepository pubServerRepository) {
        this.pubServerRepository = pubServerRepository;
    }


    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all servers",
            description = "<code>Retrieve</code> all <i><b>servers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubServer>> servers() {
        return ResponseEntity.ok(pubServerRepository.pubShowServers());
    }

    @Operation(
            summary = "Retrieve specific server",
            description = "<code>Retrieve</code> specific <i><b>server</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{serverID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubServer> server(
            @PathVariable BigDecimal serverID
    ) {
        return ResponseEntity.ok(pubServerRepository.pubShowServersByID(serverID));
    }

    @Operation(
            summary = "Retrieve server meta",
            description = "<code>Retrieve</code> <i><b>server</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json")
    public ResponseEntity<Meta> meta(){
        return ResponseEntity.ok().body(pubServerRepository.meta());
    }
    //</editor-fold>

}
