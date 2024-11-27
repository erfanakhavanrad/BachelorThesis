package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccPercomContactRepository;
import com.tarazgroup.tws.model.acc.AccPercomContact;
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
 * @author A.Farahani
 * @date 12/13/21
 */
@RestController
@RequestMapping("acc/percomcontacts")
@Validated
@Tag(name = "PercomContact")
public class AccPercomContactController {
    final private AccPercomContactRepository accPercomContactRepository;

    public AccPercomContactController(AccPercomContactRepository accPercomContactRepository) {
        this.accPercomContactRepository = accPercomContactRepository;
    }


    @Operation(
            summary = "Retrieve all percomContacts",
            description = "<code>Retrieve</code> all <i><b>percomContacts</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccPercomContact>> percomContacts(@ParameterObject AccPercomContact accPercomContact) {
        return ResponseEntity
                .ok()
                .body(accPercomContactRepository.accShowPercomContact(accPercomContact));
    }

    @Operation(
            summary = "Retrieve specific percomContact",
            description = "<code>Retrieve</code> specific <i><b>percomContact</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{contactID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccPercomContact> percomContact(@PathVariable BigDecimal contactID) {
        return ResponseEntity
                .ok()
                .body(accPercomContactRepository.accShowPercomContactByID(contactID));
    }
    // TODO: 12/14/21 ins sp exists but windows form doesn't have any insert

//    @Operation(
//            summary = "Create percomContact",
//            description = "<code>Create</code> <i><b>percomContact</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PostMapping(produces = "application/json", consumes = "application/json")
//    public ResponseEntity<AccPercomContact> percomContactInsSP(
//            @Valid
//            @io.swagger.v3.oas.annotations.parameters.RequestBody
//            @RequestBody AccPercomContact accPercomContact
//    ) {
//        return ResponseEntity.ok(accPercomContactRepository.accInsPercomContact(accPercomContact));
//    }

    @Operation(
            summary = "Update percomContact",
            description = "<code>Update</code> <i><b>percomContact<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{contactID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccPercomContact> percomContactUpdSP(
            @PathVariable BigDecimal contactID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccPercomContact accPercomContact) {
        return ResponseEntity.ok(accPercomContactRepository.accUpdPercomContact(contactID, accPercomContact));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete percomContact",
            description = "<code>Delete</code> <i><b>percomContact<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{contactID}", produces = "application/json")
    public ResponseEntity<?> percomContactDelSP(
            @PathVariable BigDecimal contactID) {
        accPercomContactRepository.accDelPercomContact(contactID);
        return ResponseEntity.noContent().build();
    }
}
