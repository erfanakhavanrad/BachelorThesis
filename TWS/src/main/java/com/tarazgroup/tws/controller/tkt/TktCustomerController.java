package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktCustomerRepository;
import com.tarazgroup.tws.model.tkt.TktCustomer;
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
import java.security.NoSuchAlgorithmException;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-30, 2022
 ***/
@RestController
@RequestMapping("tkt/customers")
@Validated
@Tag(name = "Customer")
public class TktCustomerController {
    final private TktCustomerRepository tktCustomerRepository;

    public TktCustomerController(TktCustomerRepository tktCustomerRepository) {
        this.tktCustomerRepository = tktCustomerRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all customers",
            description = "<code>Retrieve</code> all <i><b>customers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<com.tarazgroup.tws.dto.tkt.customer.TktCustomer>> customers(@ParameterObject TktCustomer tktCustomer) {
        return ResponseEntity
                .ok()
                .body(tktCustomerRepository.tktShowCustomer1(tktCustomer));
    }

    @Operation(
            summary = "Retrieve specific customer",
            description = "<code>Retrieve</code> specific <i><b>customer</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{customerID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktCustomer> customer(@PathVariable BigDecimal customerID) {
        return ResponseEntity
                .ok()
                .body(tktCustomerRepository.tktShowCustomerByID(customerID));
    }

    @Operation(
            summary = "Create customer",
            description = "<code>Create</code> <i><b>customer</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktCustomer> customerInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"perComFName\": \"string\",\n" +
                                                            "  \"perComLName\": \"string\",\n" +
                                                            "  \"userLoginName\": \"string\",\n" +
                                                            "  \"androidUserPass\": \"string\",\n" +
                                                            "  \"organizationID\": 10000001,\n" +
                                                            "  \"anyDeskID\": \"253254585\",\n" +
                                                            "  \"isOrganizationOwner\": true,\n" +
                                                            "  \"isNotActive\": false,\n" +
                                                            "  \"customerPhoneNumber\": \"string\",\n" +
                                                            "  \"userMobileNumber\": \"string\",\n" +
                                                            "  \"priorityID\": 10000001,\n" +
                                                            "  \"organizationalRank\": \"string\",\n" +
                                                            "  \"customerInternalNumber\": 11,\n" +
                                                            "  \"customerDesc\": \"string\",\n" +
//                                                            "  \"accountExpirationDate\": \"2022-02-23T07:19:09.592Z\",\n" +
                                                            "  \"accountExpirationDate\": \"1400/12/04\"\n" +

                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktCustomer tktCustomer
    ) throws NoSuchAlgorithmException {
        return ResponseEntity.ok(tktCustomerRepository.tktInsCustomer(tktCustomer));
    }


    @Operation(
            summary = "Update customer",
            description = "<code>Update</code> <i><b>customer<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{perComID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktCustomer> customerUpdSP(
            @PathVariable BigDecimal perComID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"perComFName\": \"string\",\n" +
                                                            "  \"perComLName\": \"string\",\n" +
                                                            "  \"userLoginName\": \"string\",\n" +
//                                                            "  \"androidUserPass\": \"string\",\n" +
                                                            "  \"organizationID\": 10000001,\n" +
                                                            "  \"anyDeskID\": \"253254585\",\n" +
                                                            "  \"isOrganizationOwner\": true,\n" +
                                                            "  \"isNotActive\": false,\n" +
                                                            "  \"customerPhoneNumber\": \"string\",\n" +
                                                            "  \"userMobileNumber\": \"string\",\n" +
                                                            "  \"priorityID\": 10000001,\n" +
                                                            "  \"organizationalRank\": \"string\",\n" +
                                                            "  \"customerInternalNumber\": 11,\n" +
                                                            "  \"customerDesc\": \"string\",\n" +
//                                                            "  \"accountExpirationDate\": \"2022-02-23T07:19:09.592Z\",\n" +
                                                            "  \"accountExpirationDate\": \"1400/12/04\"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktCustomer tktCustomer) {
        return ResponseEntity.ok(tktCustomerRepository.tktUpdCustomer(perComID, tktCustomer));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete customer",
            description = "<code>Delete</code> <i><b>customer<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{customerID}", produces = "application/json")
    public ResponseEntity<?> customerDelSP(
            @PathVariable BigDecimal customerID) {
        tktCustomerRepository.tktDelCustomer(customerID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Retrieve customer meta1",
            description = "<code>Retrieve</code> <i><b>customer</b></i> meta1",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta1", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta1() {
        return ResponseEntity
                .ok()
                .body(tktCustomerRepository.meta1());
    }

    @Operation(
            summary = "Retrieve customer meta",
            description = "<code>Retrieve</code> <i><b>customer</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktCustomerRepository.meta());
    }
    //</editor-fold>
}
