package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccManifestDetailRepository;
import com.tarazgroup.tws.dao.acc.AccManifestHeaderRepository;
import com.tarazgroup.tws.model.acc.AccManifestDetail;
import com.tarazgroup.tws.model.acc.AccManifestHeader;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("acc/manifestheader")

@Tag(name = "ManifestHeader")
public class AccManifestController {
    private final AccManifestHeaderRepository accManifestHeaderRepository;

    private final AccManifestDetailRepository accManifestDetailRepository;

    public AccManifestController(AccManifestHeaderRepository accManifestHeaderRepository, AccManifestDetailRepository accManifestDetailRepository) {
        this.accManifestHeaderRepository = accManifestHeaderRepository;
        this.accManifestDetailRepository = accManifestDetailRepository;
    }

    @Operation(
            summary = "Retrieve manifestHeaders",
            description = "<code>Retrieve</code> <i><b>manifestHeaders</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<AccManifestHeader>> manifestHeaders(@ParameterObject AccManifestHeader accManifestHeader) {
        return ResponseEntity.ok(accManifestHeaderRepository.accShowManifestHeader(accManifestHeader));
    }


    @Operation(
            summary = "Retrieve manifestDetails",
            description = "<code>Retrieve</code> <i><b>manifestDetails</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/details", produces = "application/json")
    public ResponseEntity<List<AccManifestDetail>> manifestDetails(@ParameterObject AccManifestDetail accManifestDetail) {
        return ResponseEntity.ok(accManifestDetailRepository.accShowManifestDetail(accManifestDetail));
    }
}
