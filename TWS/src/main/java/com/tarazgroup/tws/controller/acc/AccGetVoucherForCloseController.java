package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccGetVoucherForCloseRepository;
import com.tarazgroup.tws.model.acc.AccGetVoucherForClose;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * @author A.Farahani
 * @date Dec-29, 2021
 ***/
@RestController
@RequestMapping("acc/getvoucherforcloses")
@Validated
@Tag(name = "GetVoucherForClose")
public class AccGetVoucherForCloseController {
    final private AccGetVoucherForCloseRepository accGetVoucherForCloseRepository;

    public AccGetVoucherForCloseController(AccGetVoucherForCloseRepository accGetVoucherForCloseRepository) {
        this.accGetVoucherForCloseRepository = accGetVoucherForCloseRepository;
    }

    @Operation(
            summary = "Retrieve all getVoucherForCloses",
            description = "<code>Retrieve</code> all <i><b>getVoucherForCloses</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccGetVoucherForClose>> getVoucherForCloses(@ParameterObject AccGetVoucherForClose accGetVoucherForClose, @RequestParam Integer accountNature) {
        return ResponseEntity
                .ok()
                .body(accGetVoucherForCloseRepository.accGetVoucherForClose(accGetVoucherForClose, accountNature));
    }

}
