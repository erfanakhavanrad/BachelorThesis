package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvActuaryInforRepository;
import com.tarazgroup.tws.model.inv.InvActuaryInfor;
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
 * @author Erfan Akhavan
 */

@RestController
@RequestMapping("inv/actuaryinfor")
@Validated
@Tag(name = "ActuaryInfor")
public class InvActuaryInforController {

    private final InvActuaryInforRepository invActuaryInforRepository;

    public InvActuaryInforController(InvActuaryInforRepository invActuaryInforRepository) {
        this.invActuaryInforRepository = invActuaryInforRepository;
    }

    //    GET All
    @Operation(
            summary = "Retrieve all InvActuaryInfor",
            description = "<code>Retrieve</code> all <i><b>InvActuaryInfor</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvActuaryInfor>> actuariesInfor(@ParameterObject InvActuaryInfor invActuaryInfor) {
        return ResponseEntity.ok(invActuaryInforRepository.invShowActuaryInfor(invActuaryInfor));
    }

    //    GET By ID
    @Operation(
            summary = "Retrieve specific actuaryInfor",
            description = "<code>Retrieve</code> specific <i><b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{actuaryInforID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvActuaryInfor> actuaryInfo(@PathVariable BigDecimal actuaryInforID) {
        return ResponseEntity.ok().body(invActuaryInforRepository.invShowActuaryInforByID(actuaryInforID));
    }

    // POST
    @Operation(
            summary = "Create actuaryInfor",
            description = "<code>Create</code> <i><b>actuaryInfor</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvActuaryInfor> actuaryInfoInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"actuaryStoreID\": 10000002,\n" +
                                            "  \"actuaryCode\": \"1\",\n" +
                                            "  \"actuaryDesc\": \"انبارگردانی میان دوره\",\n" +
                                            "  \"actuaryCount\": 3,\n" +
                                            "  \"toDate\": \"1400/05/09\",\n" +
                                            "  \"storeId\": 10000001,\n" +
                                            "  \"storeCode\": \"1\",\n" +
                                            "  \"storeName\": \"مرکزی\",\n" +
                                            "  \"tafsiliDesc\": \"مشتری حقیقی دریا زینتی\",\n" +
                                            "  \"actuaryDate\": \"1400/05/09\",\n" +
                                            "  \"difType1\": 1,\n" +
                                            "  \"difType2\": 1,\n" +
                                            "  \"difType3\": 1,\n" +
                                            "  \"rowCnt\": 1\n" +
                                            "}"
                            )
                    )
            )
            @RequestBody InvActuaryInfor invActuaryInfor) {
        return ResponseEntity.ok(invActuaryInforRepository.invInsActuaryInfo(invActuaryInfor));
    }

    //    PUT
    @Operation(
            summary = "Update actuaryInfor",
            description = "<code>Update</code> <i><b>actuaryInfor<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{actuaryInforID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvActuaryInfor> actuaryInfoUpdSP(
            @PathVariable BigDecimal actuaryInforID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(

                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "        \"actuaryStoreID\": 10000005,\n" +
                                            "            \"actuaryCode\": \"1\",\n" +
                                            "            \"toDate\": \"1412/05/09\",\n" +
                                            "            \"storeId\": 10000001,\n" +
                                            "            \"actuaryDate\": \"1400/05/09\",\n" +
                                            "            \"difType1\": 1,\n" +
                                            "            \"difType2\": 1,\n" +
                                            "            \"difType3\": 1,\n" +
                                            "            \"rowCnt\": 1\n" +
                                            "    }"
                            )
                    )
            )
            @RequestBody InvActuaryInfor invActuaryInfor
    ) {
        return ResponseEntity.ok(invActuaryInforRepository.invUpdActuaryInfo(actuaryInforID, invActuaryInfor));
    }

    //    DELETE
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete actuaryInfor",
            description = "<code>Delete</code> <i><b>actuaryInfor<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{actuaryInforID}", produces = "application/json")
    public ResponseEntity<?> actuaryInfoDelSP(@PathVariable BigDecimal actuaryInforID) {
        invActuaryInforRepository.invDelActuaryInfo(actuaryInforID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve actuaryInfor meta",
            description = "<code>Retrieve</code> <i><b>actuaryInfor</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invActuaryInforRepository.meta());
    }

}
