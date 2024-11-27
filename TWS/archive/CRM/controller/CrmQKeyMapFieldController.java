package com.tarazgroup.tws.controller.crm;


import com.tarazgroup.tws.dao.crm.CrmQKeyMapFieldRepository;
import com.tarazgroup.tws.model.crm.CrmQKeyMapField;
import com.tarazgroup.tws.model.crm.CrmSelector;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

@Validated
@RequestMapping("crm/qkeymapfields")
@RestController
@Tag(name = "QKeyMapField")
public class CrmQKeyMapFieldController {

    final private CrmQKeyMapFieldRepository crmQKeyMapFieldRepository;

    public CrmQKeyMapFieldController(CrmQKeyMapFieldRepository crmQKeyMapFieldRepository) {
        this.crmQKeyMapFieldRepository = crmQKeyMapFieldRepository;
    }

    @Operation(
            summary = "Retrieve all qkeymapfields",
            description = "<code>Retrieve</code> all <i><b>qkeymapfields</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmQKeyMapField>> qKeyMapFieldsShow(@ParameterObject CrmQKeyMapField crmQKeyMapField) {
        return ResponseEntity.ok(crmQKeyMapFieldRepository.crmShowQKeyMapField(crmQKeyMapField));
    }

    @Operation(
            summary = "Retrieve qkeymapfields meta",
            description = "<code>Retrieve</code> <i><b>qkeymapfields</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmQKeyMapFieldRepository.meta());
    }

    @Operation(
            summary = "Retrieve specific qkeymapfield",
            description = "<code>Retrieve</code> specific <i><b>qkeymapfield</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{fieldID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmQKeyMapField> qKeyMapFieldShow(@PathVariable BigDecimal fieldID) {
        return ResponseEntity
                .ok()
                .body(crmQKeyMapFieldRepository.crmShowQKeyMapFieldByFieldID(fieldID));
    }

    @Operation(
            summary = "Create qkeymapfield",
            description = "<code>Create</code> <i><b>qkeymapfield</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmQKeyMapField> qKeyMapFieldInsert(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmQKeyMapField crmQKeyMapField
    ) {
        return ResponseEntity.ok(crmQKeyMapFieldRepository.crmInsQKeyMapField(crmQKeyMapField));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete qkeymapfield",
            description = "<code>Delete</code> <i><b>qkeymapfield<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{fieldID}", produces = "application/json")
    public ResponseEntity<?> qKeyMapFieldDelete(
            @PathVariable BigDecimal fieldID) {
        crmQKeyMapFieldRepository.crmDelQKeyMapField(fieldID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update qkeymapfield",
            description = "<code>Update</code> <i><b>qkeymapfield<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{fieldID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmQKeyMapField> qKeyMapFieldUpdate(
            @PathVariable BigDecimal fieldID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmQKeyMapField crmQKeyMapField) {
        return ResponseEntity.ok(crmQKeyMapFieldRepository.crmUpdQKeyMapField(fieldID, crmQKeyMapField));
    }

    @Operation(
            summary = "Export all forms to Excel",
            description = "<code>Export</code> all <i><b>forms</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@ParameterObject CrmQKeyMapField crmQKeyMapField) {
        return ResponseEntity
                .ok()
                .body(crmQKeyMapFieldRepository.excel(crmQKeyMapField));
    }

}
