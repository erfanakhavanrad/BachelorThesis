package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvStoreRepository;
import com.tarazgroup.tws.model.inv.InvStore;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */


@Validated
@RestController
@RequestMapping(value = "/inv/stores")
@Tag(name = "Stores")
public class InvStoreController {

    final private InvStoreRepository invStoreRepository;

    @Autowired
    public InvStoreController(InvStoreRepository invStoreRepository) {
        this.invStoreRepository = invStoreRepository;
    }

    @Operation(
            summary = "Retrieve all stores",
            description = "<code>Retrieve</code> all <i><b>stores</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvStore>> showStore(@ParameterObject InvStore invStore,@RequestParam(required = false) BigDecimal userID) {

        return ResponseEntity.ok(invStoreRepository.invShowStore(invStore,userID));
    }
    @Operation(
            summary = "Retrieve stores meta",
            description = "<code>Retrieve</code> <i><b>stores</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invStoreRepository.meta());
    }

    @Operation(
            summary = "Retrieve a specific store",
            description = "<code>Retrieve</code> a specific <i><b>store</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "{storeID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvStore> showStoreByID(
            @PathVariable BigDecimal storeID) {
        return ResponseEntity.ok(invStoreRepository.invShowStoreByID(storeID));
    }

    @Operation(
            summary = "Create specific store",
            description = "<code>Create</code> specific <i><b>store</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvStore> insStore(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"storeCode\": \"13\",\n" +
                                            "  \"storeName\": \"nm\",\n" +
                                            "  \"tafsiliTypeID\": \"10000037\",\n" +
                                            "  \"briefName\": \"briefName\",\n" +
                                            "  \"invPriority\": 0,\n" +
                                            "  \"isLCStore\": false\n" +
                                            "}"
                            )
                    )
            })
            @RequestBody InvStore invStore) {
        return ResponseEntity.ok(invStoreRepository.invInsStore(invStore));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete store",
            description = "<code>Delete</code> <i><b>store</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "{storeID}", produces = "application/json")
    public ResponseEntity<?> delStore(
            @PathVariable BigDecimal storeID) {
        invStoreRepository.invDelStore(storeID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update store",
            description = "<code>Update</code> <i><b>store</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "{storeID}", consumes = "application/json", produces = "application/json")


    public ResponseEntity<InvStore> updStore(
            @PathVariable BigDecimal storeID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"storeCode\": \"13\",\n" +
                                            "  \"storeName\": \"nm\",\n" +
                                            "  \"tafsiliTypeID\": \"10000037\",\n" +
                                            "  \"briefName\": \"briefName\",\n" +
                                            "  \"invPriority\":0,\n" +
                                            "  \"isLCStore\":false\n" +
                                            "}"
                            )
                    )
            })
            @RequestBody InvStore invStore
    ) {
        return ResponseEntity.ok(invStoreRepository.invUpdStore(storeID, invStore));
    }
}

