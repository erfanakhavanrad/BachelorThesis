package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccBankBranchRepository;
import com.tarazgroup.tws.model.acc.AccBankBranch;
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
@Validated
@RequestMapping("acc/bankbranches")
@Tag(name = "BankBranch")
public class

AccBankBranchController {

    private final AccBankBranchRepository accBankBranchRepository;

    public AccBankBranchController(AccBankBranchRepository accBankBranchRepository) {
        this.accBankBranchRepository = accBankBranchRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">

    @Operation(
            summary = "Retrieve all bankBranches",
            description = "<code>Retrieve</code> specific <i><b>bankBranches</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<AccBankBranch>> bankBranches(@ParameterObject AccBankBranch accBankBranch) {
        return ResponseEntity
                .ok()
                .body(accBankBranchRepository.accShowBankBranch(accBankBranch));
    }

    @Operation(
            summary = "Retrieve all bankBranches",
            description = "showSPNativeQueryNative",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/test",produces = "application/json")
    public ResponseEntity<List<AccBankBranch>> bankBranches1(@ParameterObject AccBankBranch accBankBranch) {
        return ResponseEntity
                .ok()
                .body(accBankBranchRepository.accShowBankBranch1(accBankBranch));
    }

    @Operation(
            summary = "Retrieve bankBranch meta",
            description = "<code>Retrieve</code> <i><b>bankBranch</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(accBankBranchRepository.meta());
    }

    @Operation(
            summary = "Retrieve specific bankBranch",
            description = "<code>Retrieve</code> specific <i><b>bankBranch</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{bankBranchID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccBankBranch> bankBranch(@PathVariable BigDecimal bankBranchID) {
        return ResponseEntity.ok(accBankBranchRepository.accShowBankBranchID(bankBranchID));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully."),
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete bankBranch",
            description = "<code>Delete</code> <i><b>bankBranch</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{bankBranchID}", produces = "appliction/json")
    public ResponseEntity<?> bankBranchDelSP(
            @PathVariable BigDecimal bankBranchID) {
        accBankBranchRepository.accDelBankBranch(bankBranchID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Create bankBranch",
            description = "<code>Create</code> <i><b>bankBranch</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
//                    "\n" +
//                    "### Body Example Value" +
//                    "\n" +
//                    "```" +
//                    "\n" +
//                    "{\n" +
//                    "   \"bankBAddress\":\"تهران - خ ولیعصر - ک فوزی\",\n" +
//                    "   \"bankBTelphone\":\"02112458548\",\n" +
//                    "   \"bankBranchCode\":\"C123\",\n" +
//                    "   \"bankBranchDesc\":\"بانک صادرات\"\n" +
//                    "}\n" +
//                    "\n" +
//                    "```"
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccBankBranch> bankBranchInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccBankBranch accBankBranch) {
        return ResponseEntity.ok(accBankBranchRepository.accInsBankBranch(accBankBranch));
    }


    @Operation(
            summary = "Update bankBranch",
            description = "<code>Update</code> <i><b>bankBranch</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
//                    "\n" +
//                    "### Body Example Value" +
//                    "\n" +
//                    "```" +
//                    "\n" +
//                    "{\n" +
//                    "   \"bankBAddress\":\"تهران - خ ولیعصر - ک فوزی\",\n" +
//                    "   \"bankBTelphone\":\"02112458548\",\n" +
//                    "   \"bankBranchCode\":\"C123\",\n" +
//                    "   \"bankBranchDesc\":\"بانک صادرات\"\n" +
//                    "}\n" +
//                    "\n" +
//                    "```"

    )
    @PutMapping(value = "/{bankBranchID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccBankBranch> bankBranchUpd(
            @PathVariable BigDecimal bankBranchID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccBankBranch accBankBranch) {
        return ResponseEntity.ok(accBankBranchRepository.accUpdBankBranch(bankBranchID, accBankBranch));
    }
    //</editor-fold>

}
