package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccGetVoucherFromExcelSetupRepository;
import com.tarazgroup.tws.model.acc.AccGetVoucherFromExcelSetup;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-10, 2022
 ***/
// TODO: 1/10/22 doesn't have PK and has an issue in insSP in SQL 


@RestController
@RequestMapping("acc/getvoucherfromexcelsetup")
@Validated
@Tag(name = "GetVoucherFromExcelSetup")
public class AccGetVoucherFromExcelSetupController {
        final private AccGetVoucherFromExcelSetupRepository accGetVoucherFromExcelSetupRepository;

        public AccGetVoucherFromExcelSetupController(AccGetVoucherFromExcelSetupRepository accGetVoucherFromExcelSetupRepository) {
            this.accGetVoucherFromExcelSetupRepository = accGetVoucherFromExcelSetupRepository;
        }

        //<editor-fold defaultstate="collapsed" desc="CRUD SP">
        @Operation(
                summary = "Retrieve all getVoucherFromExcelSetups",
                description = "<code>Retrieve</code> all <i><b>getVoucherFromExcelSetups</b></i>",
                security = @SecurityRequirement(name = "bearerAuth")
        )
        @GetMapping(produces = "application/json;charset=utf-8")
        public ResponseEntity<List<AccGetVoucherFromExcelSetup>> getVoucherFromExcelSetups(@ParameterObject AccGetVoucherFromExcelSetup accGetVoucherFromExcelSetup) {
            return ResponseEntity
                    .ok()
                    .body(accGetVoucherFromExcelSetupRepository.accShowGetVoucherFromExcelSetup(accGetVoucherFromExcelSetup));
        }

        @Operation(
                summary = "Retrieve specific getVoucherFromExcelSetup",
                description = "<code>Retrieve</code> specific <i><b>getVoucherFromExcelSetup</b></i>",
                security = @SecurityRequirement(name = "bearerAuth")
        )
        @GetMapping(value = "/{mID}", produces = "application/json;charset=utf-8")
        public ResponseEntity<AccGetVoucherFromExcelSetup> getVoucherFromExcelSetup(@PathVariable BigDecimal mID) {
            return ResponseEntity
                    .ok()
                    .body(accGetVoucherFromExcelSetupRepository.accShowGetVoucherFromExcelSetupByID(mID));
        }

        @Operation(
                summary = "Create getVoucherFromExcelSetup",
                description = "<code>Create</code> <i><b>getVoucherFromExcelSetup</b></i>",
                security = @SecurityRequirement(name = "bearerAuth")
        )
        @PostMapping(produces = "application/json", consumes = "application/json")
        public ResponseEntity<AccGetVoucherFromExcelSetup> getVoucherFromExcelSetupInsSP(
                @Valid
                @io.swagger.v3.oas.annotations.parameters.RequestBody
                @RequestBody AccGetVoucherFromExcelSetup accGetVoucherFromExcelSetup
        ) {
            return ResponseEntity.ok(accGetVoucherFromExcelSetupRepository.accInsGetVoucherFromExcelSetup(accGetVoucherFromExcelSetup));
        }
        //</editor-fold>

    }


