package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubSystemsRepository;
import com.tarazgroup.tws.model.pub.PubSystems;
import com.tarazgroup.tws.util.global.TParams;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

@RestController
@RequestMapping("pub/systems")
@Validated

@Tag(name = "System")
public class PubSystemsController extends TParams implements Serializable {

    private final PubSystemsRepository pubSystemsRepository;

    public PubSystemsController(PubSystemsRepository pubSystemsRepository) {
        this.pubSystemsRepository = pubSystemsRepository;
    }

    @Operation(
            summary = "Retrieve all systems",
            description = "<code>Retrieve</code> all <i><b>systems</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubSystems>> pubSystems(@ParameterObject  PubSystems pubSystems) {
        return ResponseEntity.ok(pubSystemsRepository.pubShowSystems(pubSystems));
    }

    @Operation(
            summary = "Retrieve system meta",
            description = "<code>Retrieve</code> <i><b>system</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(pubSystemsRepository.meta());
    }
}
