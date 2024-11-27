package com.tarazgroup.tws.controller.crm;


import com.tarazgroup.tws.dao.crm.*;
import com.tarazgroup.tws.dto.crm.CrmFormFieldValueTO;
import com.tarazgroup.tws.util.global.responseheader.MetaDynamic;
import com.tarazgroup.tws.util.global.responseheader.THttpHeaders;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

@Validated
@RequestMapping("crm/formfieldvalues")
@RestController
@Tag(name = "FormFieldValue")
public class CrmFormFieldValueController {


    final private CrmFormFieldValueRepository crmFormFieldValueRepository;

    final private CrmFormBuilderRepository crmFormBuilderRepository;

    final private CrmSelectorRepository crmSelectorRepository;

    final private CrmQKeyMapFieldRepository crmQKeyMapFieldRepository;

    final private CrmFormRepository crmFormRepository;

    public CrmFormFieldValueController(
            CrmFormFieldValueRepository crmFormFieldValueRepository,
            CrmFormBuilderRepository crmFormBuilderRepository,
            CrmSelectorRepository crmSelectorRepository,
            CrmQKeyMapFieldRepository crmQKeyMapFieldRepository,
            CrmFormRepository crmFormRepository) {
        this.crmFormFieldValueRepository = crmFormFieldValueRepository;
        this.crmFormBuilderRepository = crmFormBuilderRepository;
        this.crmSelectorRepository = crmSelectorRepository;
        this.crmQKeyMapFieldRepository = crmQKeyMapFieldRepository;
        this.crmFormRepository = crmFormRepository;
    }

    @Operation(
            summary = "Retrieve Records Count",
            description = "<code>Retrieve</code> Records <i><b>Count</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/count")
    public ResponseEntity<Integer> recordsCount(@RequestParam Map<String, String> params) {
        return ResponseEntity
                .ok()
                .body(crmFormFieldValueRepository.recordsCount(params, crmFormBuilderRepository, crmQKeyMapFieldRepository));
    }


    @Operation(
            summary = "Retrieve all form field values for specific form",
            description = "<code>Retrieve</code> all <i><b>form field values for specific form</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping()
    public ResponseEntity<List<Map<String, Object>>> formFieldValuesShow(@RequestParam Map<String, String> params) {
        return ResponseEntity.ok(crmFormFieldValueRepository.crmShowFormFieldValue(params, crmFormBuilderRepository, crmSelectorRepository, crmQKeyMapFieldRepository));
    }

    @Operation(
            summary = "Retrieve form field value meta for specific form",
            description = "<code>Retrieve</code> <i><b>form field value</b></i> meta for specific form",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta/{formID}")
    public ResponseEntity<MetaDynamic> meta(@PathVariable BigDecimal formID) {
        return ResponseEntity
                .ok()
                .body(crmFormFieldValueRepository.meta(formID, crmFormBuilderRepository, crmFormRepository, crmQKeyMapFieldRepository));
    }

    @Operation(
            summary = "Retrieve specific record",
            description = "<code>Retrieve</code> specific <i><b>record</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{recordID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<Map<String, Object>> record(@PathVariable BigDecimal recordID, BigDecimal formID) {
        return ResponseEntity
                .ok()
                .body(crmFormFieldValueRepository.crmShowFormFieldValueByRecordID(formID, recordID, crmFormBuilderRepository, crmSelectorRepository));
    }

    @Operation(
            summary = "Export all form field values to PDF",
            description = "<code>Export</code> all <i><b>form field values</b></i> to <code>PDF</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/pdf", produces = "application/pdf")
    public ResponseEntity<InputStreamResource> exportToPDF(@RequestParam Map<String, String> params) {
        return ResponseEntity
                .ok()
                .headers(THttpHeaders.httpHeadersPdf("formfieldvalue"))
                .body(crmFormFieldValueRepository.reportPDF(params, crmFormBuilderRepository, crmQKeyMapFieldRepository));
    }

    @Operation(
            summary = "Export all form field values to Excel",
            description = "<code>Export</code> all <i><b>form field values</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@RequestParam Map<String, String> params) {
        return ResponseEntity
                .ok()
                .headers(THttpHeaders.httpHeadersExcel("formfieldvalue"))
                .body(crmFormFieldValueRepository.excel(params, crmFormBuilderRepository, crmSelectorRepository, crmFormRepository, crmQKeyMapFieldRepository));
    }

    @Operation(
            summary = "Create form field values",
            description = "<code>Create</code> <i><b>form field values</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Map<String, Object>> formFieldValuesIns(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content =
            @Content(
                    examples = {
                            @ExampleObject(
                                    value = "{\n" +
                                            "\n" +
                                            "    \"formFieldValues\":[\n" +
                                            "        {\n" +
                                            "            \"fieldID\":10000001,\n" +
                                            "            \"fieldValue\":\"سیروس\"\n" +
                                            "        },\n" +
                                            "        {\n" +
                                            "            \"fieldID\":10000002,\n" +
                                            "            \"fieldValue\":\"قایقران\"\n" +
                                            "        },\n" +
                                            "        {\n" +
                                            "            \"fieldID\":10000003,\n" +
                                            "            \"fieldValue\":\"بندر انزلی\"\n" +
                                            "        },\n" +
                                            "        {\n" +
                                            "            \"fieldID\":10000005,\n" +
                                            "            \"fieldValue\":20\n" +
                                            "        },\n" +
                                            "        {\n" +
                                            "            \"fieldID\":10000006,\n" +
                                            "            \"fieldValue\":false\n" +
                                            "        }\n" +
                                            "    ]\n" +
                                            "\n" +
                                            "}"
                            )
                    }
            )
            )
            @Valid @RequestBody CrmFormFieldValueTO crmFormFieldValueTO
    ) {
        return ResponseEntity.ok(crmFormFieldValueRepository.crmInsFormFieldValue(crmFormFieldValueTO, crmFormBuilderRepository, crmSelectorRepository));
    }

    @Operation(
            summary = "Update form field values",
            description = "<code>Update</code> <i><b>form field values</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{recordID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Map<String, Object>> formFieldValuesUpd(
            @PathVariable BigDecimal recordID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content =
            @Content(
                    examples = {
                            @ExampleObject(
                                    value = "{\n" +
                                            "\n" +
                                            "    \"formFieldValues\":[\n" +
                                            "        {\n" +
                                            "            \"fieldID\":10000001,\n" +
                                            "            \"fieldValue\":\"سیروس\"\n" +
                                            "        },\n" +
                                            "        {\n" +
                                            "            \"fieldID\":10000002,\n" +
                                            "            \"fieldValue\":\"قایقران\"\n" +
                                            "        },\n" +
                                            "        {\n" +
                                            "            \"fieldID\":10000003,\n" +
                                            "            \"fieldValue\":\"بندر انزلی\"\n" +
                                            "        },\n" +
                                            "        {\n" +
                                            "            \"fieldID\":10000005,\n" +
                                            "            \"fieldValue\":20\n" +
                                            "        },\n" +
                                            "        {\n" +
                                            "            \"fieldID\":10000006,\n" +
                                            "            \"fieldValue\":false\n" +
                                            "        }\n" +
                                            "    ]\n" +
                                            "\n" +
                                            "}"
                            )
                    }
            )
            )
            @Valid @RequestBody CrmFormFieldValueTO crmFormFieldValueTO
    ) {
        return ResponseEntity.ok(crmFormFieldValueRepository.crmUpdFormFieldValue(recordID, crmFormFieldValueTO, crmFormBuilderRepository, crmSelectorRepository));
    }

    @Operation(
            summary = "Update form field values ReferToUserID",
            description = "<code>Update</code> <i><b>form field values ReferToUserID<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PatchMapping(value = "/{recordID}", produces = "application/json")
    public ResponseEntity<Map<String, Object>> formFieldValuesUpdReferToUserID(
            @PathVariable BigDecimal recordID,
            @RequestBody CrmFormFieldValueTO crmFormFieldValueTO) {
        return ResponseEntity.ok(crmFormFieldValueRepository.crmUpdFormFieldValue(recordID, crmFormFieldValueTO, crmFormBuilderRepository, crmSelectorRepository));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete form field values",
            description = "<code>Delete</code> <i><b>form field values<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{recordID}", produces = "application/json")
    public ResponseEntity<?> formFieldValuesDel(
            @PathVariable BigDecimal recordID, @RequestParam BigDecimal formID) {
        crmFormFieldValueRepository.crmDelFormFieldValue(recordID, formID);
        return ResponseEntity.noContent().build();
    }
}

