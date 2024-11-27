package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmPerComRepository;
import com.tarazgroup.tws.model.acc.AccBank;
import com.tarazgroup.tws.model.crm.CrmCampaign;
import com.tarazgroup.tws.model.crm.CrmLead;
import com.tarazgroup.tws.model.crm.CrmPerCom;
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
 * @author Aref Azizi
 * 8/30/22
 */


@RestController
@RequestMapping("crm/percoms")
@Validated
@Tag(name = "PerCom")
public class CrmPerComController {
    private final CrmPerComRepository crmPerComRepository;

    public CrmPerComController(CrmPerComRepository crmPerComRepository) {
        this.crmPerComRepository = crmPerComRepository;
    }


    //GET
    @Operation(
            summary = "Retrieve all perComes",
            description = "<code>Retrieve</code> all <i><b>perComes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmPerCom>> perComes(@ParameterObject CrmPerCom crmPerCom) {
        return ResponseEntity
                .ok()
                .body(crmPerComRepository.crmShowPerCom(crmPerCom));
    }


    //GET BY ID
    @Operation(
            summary = "Retrieve specific perCom",
            description = "<code>Retrieve</code> specific <i><b>perCom</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{perComID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmPerCom> perCom(@PathVariable BigDecimal perComID) {
        return ResponseEntity
                .ok()
                .body(crmPerComRepository.crmShowPerComByID(perComID));
    }


    // POST
    @Operation(
            summary = "Create perCom",
            description = "<code>Create</code> <i><b>perCom</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmPerCom> perComInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "  \"perComTitle\": \"string\",\n" +
                                                    "  \"perComFName\": \"string\",\n" +
                                                    "  \"perComLName\": \"string\",\n" +
                                                    "  \"perComAddress\": \"string\",\n" +
                                                    "  \"perComMobile\": 123,\n" +
                                                    "  \"perComPhone\": 123,\n" +
                                                    "  \"perComTypeID\": 1,\n" +
                                                    "  \"perComWebsite\": \"string\",\n" +
                                                    "  \"perComEmail\": \"string\",\n" +
                                                    "  \"perComDesc\": \"string\"\n" +
                                                    "}"
                                    )
                            )
                    }
            )
            @RequestBody CrmPerCom crmPerCom
    ) {
        return ResponseEntity.ok(crmPerComRepository.crmInsPerCom(crmPerCom));
    }

    // PUT
    @Operation(
            summary = "Update perCom",
            description = "<code>Update</code> <i><b>perCom<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{perComID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmPerCom> perComUpdSP(
            @PathVariable BigDecimal perComID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "  \"perComTitle\": \" test perCom\",\n" +
                                                    "  \"perComFName\": \"null\" ,\n" +
                                                    "  \"perComLName\": \"null\" ,\n" +
                                                    "  \"perComAddress\": \"Tehran\",\n" +
                                                    "  \"perComMobile\": \"02020202\",\n" +
                                                    "  \"perComPhone\": \"02112122\",\n" +
                                                    "  \"perComTypeID\": 1,\n" +
                                                    "  \"perComWebsite\": \"website\",\n" +
                                                    "  \"perComEmail\": \"Email.com\",\n" +
                                                    "  \"perComDesc\": \"Description\"\n" +
                                                    "}"
                                    )
                            )
                    }
            )
            @RequestBody CrmPerCom crmPerCom) {
        return ResponseEntity.ok(crmPerComRepository.crmUpdPerCom(perComID, crmPerCom));
    }

//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Update Organization Conversion To Customer",
            description = "<code>Update</code> <i><b>Organization Conversion To Customer<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(path = "/organizationconversiontocustomer/{perComID}", produces = "application/json")
    public ResponseEntity<CrmPerCom> organizationConversionToCustomerUpdSP(
            @PathVariable BigDecimal perComID)
    {
        return ResponseEntity.ok(crmPerComRepository.CrmUpdOrganizationConversionToCustomer(perComID));
    }


//    @Operation(
//            summary = "Update bank",
//            description = "<code>Update</code> <i><b>bank<b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PutMapping(value = "/{bankID}", produces = "application/json", consumes = "application/json")
//    public ResponseEntity<AccBank> bankUpdSP(
//            @PathVariable BigDecimal bankID,
//            @Valid
//            @io.swagger.v3.oas.annotations.parameters.RequestBody
//            @RequestBody AccBank accBank) {
//        return ResponseEntity.ok(accBankRepository.accUpdBank(bankID, accBank));
//    }





//    @Operation(
//            summary = "Update actuaryStore",
//            description = "<code>Update</code> <i><b>actuaryStore<b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PutMapping(value = "/{selectStoreID}", produces = "application/json", consumes = "application/json")
//    public ResponseEntity<InvActuaryStore> actuaryStoreUpdSP(@PathVariable BigDecimal selectStoreID,
//                                                             @Valid
//                                                             @io.swagger.v3.oas.annotations.parameters.RequestBody
//                                                             @RequestBody InvActuaryStore invActuaryStore) {
//        return ResponseEntity.ok(invActuaryStoreRepository.invUpdActuaryStore(selectStoreID, invActuaryStore));
//    }


    //DELETE
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete perCom ",
            description = "<code>Delete</code> <i><b>perCome<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{perComID}", produces = "application/json")
    public ResponseEntity<?> perComDelSP(
            @PathVariable BigDecimal perComID) {
        crmPerComRepository.crmDelPerCom(perComID);
        return ResponseEntity.noContent().build();
    }

    //Get meta
    @Operation(
            summary = "Retrieve perCom meta",
            description = "<code>Retrieve</code> <i><b>perCom</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmPerComRepository.meta());
    }
}
