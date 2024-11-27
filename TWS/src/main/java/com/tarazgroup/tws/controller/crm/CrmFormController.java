package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmFormRepository;
import com.tarazgroup.tws.model.crm.CrmForm;
import com.tarazgroup.tws.model.inv.InvActuaryStore;
import com.tarazgroup.tws.util.global.responseheader.Meta;
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
 * 8/20/22
 *
 * @author Erfan Akhavan
 */
@RestController
@RequestMapping("crm/forms")
@Validated
@Tag(name = "Form")
public class CrmFormController {
    private final CrmFormRepository crmFormRepository;

    public CrmFormController(CrmFormRepository crmFormRepository) {
        this.crmFormRepository = crmFormRepository;
    }

    @Operation(
            summary = "Retrieve all Forms",
            description = "<code>Retrieve</code> all <i><b>Forms</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmForm>> forms(@ParameterObject CrmForm crmForm) {
//        return ResponseEntity.ok(invActuaryStoreRepository.invShowActuaryStore(invActuaryStore));
        return ResponseEntity.ok().body(crmFormRepository.crmShowForm(crmForm));
    }

    //    GET by ID
    @Operation(
            summary = "Retrieve specific Form",
            description = "<code>Retrieve</code> specific <i><b>Form</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{formID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmForm> form(@PathVariable BigDecimal formID) {
        return ResponseEntity.ok().body(crmFormRepository.crmShowFormByID(formID));
    }


    @Operation(
            summary = "Create Form",
            description = "<code>Create</code> <i><b>Form</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmForm> formInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "   {\n" +
                                            "        \"formName\": \"string\",\n" +
                                            "            \"formLatinName\": \"string\",\n" +
                                            "            \"dataEntryHeight\": 0\n" +
                                            "    }"
                            )
                    )
            )
            @RequestBody CrmForm crmForm

    ) {
        return ResponseEntity.ok(crmFormRepository.crmInsForm(crmForm));
    }


    //    PUT
    @Operation(
            summary = "Update Form",
            description = "<code>Update</code> <i><b>Form<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{formID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmForm> formUpdSP(@PathVariable BigDecimal formID,
                                             @Valid
                                             @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                     content = @Content(
                                                             schema = @Schema(
                                                                     example ="{\n" +
                                                                             "  \"formName\": \"formtest\",\n" +
                                                                             "  \"formLatinName\": \"english\",\n" +
                                                                             "  \"dataEntryHeight\": 1\n" +
                                                                             "}"
                                                             )
                                                     )
                                             )
                                             @RequestBody CrmForm crmForm) {
        return ResponseEntity.ok(crmFormRepository.crmUpdForm(formID, crmForm));
    }

    //    DELETE
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete Form",
            description = "<code>Delete</code> <i><b>Form<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{formID}", produces = "application/json")
    public ResponseEntity<?> formDelSP(@PathVariable BigDecimal formID) {
        crmFormRepository.crmDelForm(formID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve Form meta",
            description = "<code>Retrieve</code> <i><b>Form</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmFormRepository.meta());
    }


}
