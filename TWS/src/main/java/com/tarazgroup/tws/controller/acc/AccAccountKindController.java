package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccAccountKindRepository;
import com.tarazgroup.tws.model.acc.AccAccountKind;
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

@RestController
@RequestMapping("acc/accountkinds")
@Validated

@Tag(name = "AccountKind")
public class AccAccountKindController {

    private final AccAccountKindRepository accAccountKindRepository;

    public AccAccountKindController(AccAccountKindRepository accAccountKindRepository) {
        this.accAccountKindRepository = accAccountKindRepository;
    }

    @Operation(
            summary = "Retrieve all accountKinds",
            description = "<code>Retrieve</code> all <i><b>accountKind</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccAccountKind>> showAccountKind(@ParameterObject AccAccountKind accAccountKind) {
        return ResponseEntity.ok(accAccountKindRepository.showSPDefault(accAccountKind));
    }

    @Operation(
            summary = "Retrieve specific accountKind",
            description = "<code>Retrieve</code> specific <i><b>accountKind</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8", value = "/{accountKindID}")
    public ResponseEntity<AccAccountKind> showAccountKindByID(
            @PathVariable BigDecimal accountKindID) {
        return ResponseEntity.ok(accAccountKindRepository.showSPByID(accountKindID));
    }

    @Operation(
            summary = "Create accountKind",
            description = "<code>Create</code> <i><b>accountKind</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")

    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccAccountKind> accountKindInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccAccountKind accAccountKind) {
        return ResponseEntity.ok(accAccountKindRepository.accInsAccountKind(accAccountKind));
    }


    @Operation(
            summary = "Update accountKind",
            description = "<code>Update</code> <i><b>accountKind</b></i>" ,
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{accountKindID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccAccountKind> accUpdAccountKind(
            @PathVariable BigDecimal accountKindID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccAccountKind accAccountKind) {
        return ResponseEntity.ok(accAccountKindRepository.accUpdAccountKind(accAccountKind, accountKindID));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete accountKind",
            description = "<code>Delete</code> <i><b>accountKind</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{accountKindID}", produces = "application/json")
    public ResponseEntity<?> accAccountKindDelSP(@PathVariable BigDecimal accountKindID) {
        accAccountKindRepository.accDelAccountKind(accountKindID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve accountKind meta",
            description = "<code>Retrieve</code> <i><b>accountKind</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity.ok().body(accAccountKindRepository.meta());
    }
}
