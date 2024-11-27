package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmFormBuilderRepository;
import com.tarazgroup.tws.model.crm.CrmFormBuilder;
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
 * 9/6/22
 *
 * @author Aref Azizi
 */
@RestController
@RequestMapping("crm/formbuilders")
@Validated
@Tag(name = "FormBuilder")
public class CrmFormBuilderController {
    private final CrmFormBuilderRepository crmFormBuilderRepository;

    public CrmFormBuilderController(CrmFormBuilderRepository crmFormBuilderRepository) {
        this.crmFormBuilderRepository = crmFormBuilderRepository;
    }

    @Operation(
            summary = "Retrieve all FormBuilders",
            description = "<code>Retrieve</code> all <i><b>FormBuilders</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmFormBuilder>> formBuilders(@ParameterObject CrmFormBuilder crmFormBuilder) {
//       return ResponseEntity.ok(invActuaryStoreRepository.invShowActuaryStore(invActuaryStore));
        return ResponseEntity.ok().body(crmFormBuilderRepository.crmShowFormBuilder(crmFormBuilder));
    }

    //    GET by ID
    @Operation(
            summary = "Retrieve specific FormBuilder",
            description = "<code>Retrieve</code> specific <i><b>FormBuilder</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{formBuilderID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmFormBuilder> formBuilder(@PathVariable BigDecimal formBuilderID) {
        return ResponseEntity.ok().body(crmFormBuilderRepository.crmShowFormBuilderByID(formBuilderID));
    }

    @Operation(
            summary = "Retrieve specific FormBuilder",
            description = "<code>Retrieve</code> specific <i><b>FormBuilder</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{formID}/fields", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmFormBuilder>> formBuilderSelectorFields(@PathVariable BigDecimal formID) {
        return ResponseEntity.ok().body(crmFormBuilderRepository.crmShowFormBuilderSelectorFields(formID));
    }


    @Operation(
            summary = "Create FormBuilder",
            description = "<code>Create</code> <i><b>FormBuilder</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmFormBuilder> formBuilderInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"formID\": 10000001,\n" +
                                            "  \"categoryID\": 1000000,\n" +
                                            "  \"fieldType\": 2,\n" +
                                            "  \"fieldTitle\": \"firs test\",\n" +
                                            "  \"fieldTitleLatin\": \"test string\",\n" +
                                            "  \"fieldGridPosition\": 5,\n" +
                                            "  \"fieldGridWidth\": 1,\n" +
                                            "  \"fieldDataEntryRowPosition\": 1,\n" +
                                            "  \"fieldDataEntryColPosition\": 1,\n" +
                                            "  \"fieldDataEntryRowSpan\": 1,\n" +
                                            "  \"fieldDataEntryColSpan\": 1,\n" +
                                            "  \"cssStyle\": \"string\",\n" +
                                            "   \"isRequired\": true,\n" +
                                            "   \"isQuick\": true,\n" +
                                            "   \"visibility\": true\n" +
                                            "}"
                            )
                    )
            )
            @RequestBody CrmFormBuilder crmFormBuilder

    ) {
        return ResponseEntity.ok(crmFormBuilderRepository.crmInsFormBuilder(crmFormBuilder));
    }


    //    PUT
    @Operation(
            summary = "Update FormBuilder",
            description = "<code>Update</code> <i><b>FormBuilder<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{formBuilderID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmFormBuilder> formBuilderUpdSP(@PathVariable BigDecimal formBuilderID,
                                                           @Valid
                                                           @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                   content = @Content(
                                                                           schema = @Schema(
                                                                                   example = "{\n" +
                                                                                           "  \"fieldID\": 10000001,\n" +
                                                                                           "  \"formID\": 10000001,\n" +
                                                                                           "  \"categoryID\": 1000000,\n" +
                                                                                           "  \"fieldType\": 1,\n" +
                                                                                           "  \"fieldTitle\": \"string\",\n" +
                                                                                           "  \"fieldTitleLatin\": \"string\",\n" +
                                                                                           "  \"fieldGridPosition\": 1,\n" +
                                                                                           "  \"fieldGridWidth\": 0,\n" +
                                                                                           "  \"fieldDataEntryRowPosition\": 0,\n" +
                                                                                           "  \"fieldDataEntryColPosition\": 0,\n" +
                                                                                           "  \"fieldDataEntryRowSpan\": 0,\n" +
                                                                                           "  \"fieldDataEntryColSpan\": 0,\n" +
                                                                                           "  \"cssStyle\": \"style\",\n" +
                                                                                           "  \"visibility\": true,\n" +
                                                                                           "  \"isRequired\": true,\n" +
                                                                                           "  \"isQuick\": true\n" +
                                                                                           "}\n"
                                                                           )
                                                                   )
                                                           )
                                                           @RequestBody CrmFormBuilder crmFormBuilder) {
        return ResponseEntity.ok(crmFormBuilderRepository.crmUpdFormBuilder(formBuilderID, crmFormBuilder));
    }

    //    DELETE
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete FormBuilder",
            description = "<code>Delete</code> <i><b>FormBuilder<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{FormBuilderID}", produces = "application/json")
    public ResponseEntity<?> formBuilderDelSP(@PathVariable BigDecimal FormBuilderID) {
        crmFormBuilderRepository.crmDelFormBuilder(FormBuilderID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve FormBuilder meta",
            description = "<code>Retrieve</code> <i><b>Form</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmFormBuilderRepository.meta());
    }

}
