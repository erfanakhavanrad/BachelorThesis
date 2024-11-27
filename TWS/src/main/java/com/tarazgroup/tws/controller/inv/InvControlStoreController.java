package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvControlStoreRepository;
import com.tarazgroup.tws.model.inv.InvControlStore;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Erfan Akhavan
 */
@RestController
@RequestMapping("/inv/controlstore")

@Tag(name = "controlStore")
public class InvControlStoreController {
    private final InvControlStoreRepository invControlStoreRepository;

    public InvControlStoreController(InvControlStoreRepository invControlStoreRepository) {
        this.invControlStoreRepository = invControlStoreRepository;
    }

    @Operation(
            summary = "Retrieve all controlStore",
            description = "<code>Retrieve</code> all <i><b>controlStore</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<InvControlStore>> controlStores(@ParameterObject InvControlStore invControlStore) {
        return ResponseEntity.ok(invControlStoreRepository.invShowControlStore(invControlStore));
    }


    @Operation(
            summary = "Retrieve specific controlStore",
            description = "<code>Retrieve</code> specific <i><b>controlStore</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{controlStoreID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvControlStore> controlStore(@PathVariable BigDecimal controlStoreID) {
        return ResponseEntity.ok().body(invControlStoreRepository.invShowControlStoreByID(controlStoreID));
    }


    @Operation(
            summary = "Create controlStore",
            description = "<code>Create</code> <i><b>controlStore</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvControlStore> controlStoreInsSP(@RequestBody InvControlStore invControlStore){
        return ResponseEntity.ok(invControlStoreRepository.invInsControlStore(invControlStore));
    }


    @Operation(
            summary = "Update controlStore",
            description = "<code>Update</code> <i><b>controlStore<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{controlStoreID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvControlStore> controlStoreUpdSP(@PathVariable BigDecimal controlStoreID,
                                                             @Valid
                                                             @io.swagger.v3.oas.annotations.parameters.RequestBody
                                                             @RequestBody InvControlStore invControlStore){
      return   ResponseEntity.ok(invControlStoreRepository.invUpdControlStore(controlStoreID, invControlStore));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete controlStore",
            description = "<code>Delete</code> <i><b>controlStore<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{controlStoreID}", produces = "application/json")
    public ResponseEntity<?> controlDelSP(@PathVariable BigDecimal controlStoreID){
        invControlStoreRepository.invDelControlStore(controlStoreID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Retrieve controlStore meta",
            description = "<code>Retrieve</code> <i><b>controlStore</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invControlStoreRepository.meta());
    }


}
