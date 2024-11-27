package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccManifestDetailRepository;
import com.tarazgroup.tws.model.acc.AccManifestDetail;
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
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-12, 2022
 ***/
@RestController
@RequestMapping("acc/manifestdetails")
@Validated
@Tag(name = "ManifestDetail")
public class AccManifestDetailController {
    final private AccManifestDetailRepository accManifestDetailRepository;

    public AccManifestDetailController(AccManifestDetailRepository accManifestDetailRepository) {
        this.accManifestDetailRepository = accManifestDetailRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">

    @Operation(
            summary = "Retrieve all manifestDetails",
            description = "<code>Retrieve</code> all <i><b>manifestDetails</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccManifestDetail>> manifestDetails(@ParameterObject AccManifestDetail accManifestDetail) {
        return ResponseEntity
                .ok()
                .body(accManifestDetailRepository.accShowManifestDetail(accManifestDetail));
    }

    @Operation(
            summary = "Retrieve specific manifestDetail",
            description = "<code>Retrieve</code> specific <i><b>manifestDetail</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherDetailID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccManifestDetail> manifestDetail(@PathVariable BigDecimal voucherDetailID) {
        return ResponseEntity
                .ok()
                .body(accManifestDetailRepository.accShowManifestDetailByID(voucherDetailID));
    }

    @Operation(
            summary = "Create manifestDetail",
            description = "<code>Create</code> <i><b>manifestDetail</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccManifestDetail> manifestDetailInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccManifestDetail accManifestDetail
    ) {
        return ResponseEntity.ok(accManifestDetailRepository.accInsManifestDetail(accManifestDetail));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete manifestDetail",
            description = "<code>Delete</code> <i><b>manifestDetail<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{voucherDetailID}", produces = "application/json")
    public ResponseEntity<?> manifestDetailDelSP(
            @PathVariable BigDecimal voucherDetailID) {
        accManifestDetailRepository.accDelManifestDetail(voucherDetailID);
        return ResponseEntity.noContent().build();
    }
    //</editor-fold>

}
