package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvActuaryStoreRepository;
import com.tarazgroup.tws.model.inv.InvActuaryStore;
import com.tarazgroup.tws.util.global.responseheader.Meta;
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

/**
 * @author Erfan Akhavan
 */
@RestController
@RequestMapping("inv/actuarystore")
@Validated
@Tag(name = "ActuaryStore")
public class InvActuaryStoreController {
    private final InvActuaryStoreRepository invActuaryStoreRepository;

    public InvActuaryStoreController(InvActuaryStoreRepository invActuaryStoreRepository) {
        this.invActuaryStoreRepository = invActuaryStoreRepository;
    }

    //    GET All
    @Operation(
            summary = "Retrieve all InvActuaryStore",
            description = "<code>Retrieve</code> all <i><b>InvActuaryStore</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvActuaryStore>> actuaryStores(@ParameterObject InvActuaryStore invActuaryStore) {
//        return ResponseEntity.ok(invActuaryStoreRepository.invShowActuaryStore(invActuaryStore));
        return ResponseEntity.ok(invActuaryStoreRepository.invShowActuaryStore(invActuaryStore));
    }

    //    GET by ID
    @Operation(
            summary = "Retrieve specific actuaryStore",
            description = "<code>Retrieve</code> specific <i><b>actuaryStore</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{selectStoreID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvActuaryStore> actuaryStore(@PathVariable BigDecimal selectStoreID) {
        return ResponseEntity.ok().body(invActuaryStoreRepository.invShowActuaryStoreByID(selectStoreID));
    }


    @Operation(
            summary = "Create actuaryStore",
            description = "<code>Create</code> <i><b>actuaryStore</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvActuaryStore> actuaryStoreInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody InvActuaryStore invActuaryStore
    ) {
        return ResponseEntity.ok(invActuaryStoreRepository.invInsActuaryStore(invActuaryStore));
    }



    //    POST
//    @Operation(
//            summary = "Create actuaryStore",
//            description = "<code>Create</code> <i><b>actuaryStore</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PostMapping(produces = "application/json", consumes = "application/json")
//    public ResponseEntity<InvActuaryStore> actuaryStoreInsSP(
//            @Valid
//            @io.swagger.v3.oas.annotations.parameters.RequestBody(
//                    content = @Content(
//                            schema = @Schema(
//                                    example = "{\n" +
//                                            "  \"selectStoreID\": 0,\n" +
//                                            "  \"actuaryID\": 0,\n" +
//                                            "  \"actuaryCode\": \"string\",\n" +
//                                            "  \"actuaryDesc\": \"string\",\n" +
//                                            "  \"actuaryCount\": 0,\n" +
//                                            "  \"storeID\": 0,\n" +
//                                            "  \"storeCode\": \"string\",\n" +
//                                            "  \"storeName\": \"string\",\n" +
//                                            "  \"tafsiliID\": 0,\n" +
//                                            "  \"tafsiliDesc\": \"string\",\n" +
//                                            "  \"tafsiliCode\": \"string\",\n" +
//                                            "  \"yearID\": 0,\n" +
//                                            "  \"rowCnt\": 0\n" +
//                                            "}"
//                            )
//                    )
//            )
//            @RequestBody InvActuaryStore invActuaryStore
//    ) {
//        return ResponseEntity.ok(invActuaryStoreRepository.invInsActuaryStore(invActuaryStore));
//    }

    //    PUT
    @Operation(
            summary = "Update actuaryStore",
            description = "<code>Update</code> <i><b>actuaryStore<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{selectStoreID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvActuaryStore> actuaryStoreUpdSP(@PathVariable BigDecimal selectStoreID,
                                                             @Valid
                                                             @io.swagger.v3.oas.annotations.parameters.RequestBody
                                                             @RequestBody InvActuaryStore invActuaryStore) {
        return ResponseEntity.ok(invActuaryStoreRepository.invUpdActuaryStore(selectStoreID, invActuaryStore));
    }

    //    DELETE
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete actuaryStore",
            description = "<code>Delete</code> <i><b>actuaryStore<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{selectStoreID}", produces = "application/json")
    public ResponseEntity<?> actuaryStoreDelSP(@PathVariable BigDecimal selectStoreID) {
        invActuaryStoreRepository.invDelActuaryStore(selectStoreID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve actuaryStore meta",
            description = "<code>Retrieve</code> <i><b>actuaryStore</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invActuaryStoreRepository.meta());
    }

}
