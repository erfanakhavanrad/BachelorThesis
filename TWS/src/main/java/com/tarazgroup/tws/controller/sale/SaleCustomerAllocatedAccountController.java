package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleCustomerAllocatedAccountRepository;
import com.tarazgroup.tws.model.sale.SaleCustomerAllocatedAccount;
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
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author A.Salehi
 */


@RestController
@RequestMapping("sale/customerallocatedaccounts")

@Tag(name = "CustomerAllocatedAccount")
public class SaleCustomerAllocatedAccountController {

    private final SaleCustomerAllocatedAccountRepository saleCustomerAllocatedAccountRepository;

    public SaleCustomerAllocatedAccountController(SaleCustomerAllocatedAccountRepository saleCustomerAllocatedAccountRepository) {
        this.saleCustomerAllocatedAccountRepository = saleCustomerAllocatedAccountRepository;
    }


    @Operation(
            summary = "Retrieve all customerAllocatedAccount",
            description = "<code>Retrieve</code> all <i><b>customerAllocatedAccount</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SaleCustomerAllocatedAccount>> customerAllocatedAccounts(@ParameterObject SaleCustomerAllocatedAccount saleCustomerAllocatedAccount) {
        return ResponseEntity.ok(saleCustomerAllocatedAccountRepository.saleShowCustomerAllocatedAccount(saleCustomerAllocatedAccount));
    }

    @Operation(
            summary = "Retrieve specific customerAllocatedAccount",
            description = "<code>Retrieve</code> specific <i><b>customerAllocatedAccount</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping("/{mID}")
    public ResponseEntity<SaleCustomerAllocatedAccount> customerAllocatedAccount(@PathVariable BigDecimal mID) {
        return ResponseEntity.ok(saleCustomerAllocatedAccountRepository.saleShowCustomerAllocatedAccountByID(mID));
    }

    @Operation(
            summary = "Create customerAllocatedAccount",
            description = "<code>Create</code> <i><b>customerAllocatedAccount</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleCustomerAllocatedAccount> customerAllocatedAccountInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"bankID\": 10000003,\n" +
                                            "  \"bankBranchDesc\": \"توضیحات\",\n" +
                                            "  \"bankAccountNumber\": \"1234\",\n" +
                                            "  \"customerID\": 7\n" +
                                            "}"
                            )
                    )
            )
            @RequestBody SaleCustomerAllocatedAccount saleCustomerAllocatedAccount) {
        return ResponseEntity.ok(saleCustomerAllocatedAccountRepository.saleInsCustomerAllocatedAccount(saleCustomerAllocatedAccount));
    }

    @Operation(
            summary = "Update customerAllocatedAccount",
            description = "<code>Update</code> <i><b>customerAllocatedAccount<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping("/{mID}")
    public ResponseEntity<SaleCustomerAllocatedAccount> customerAllocatedAccountUpdSP(@PathVariable BigDecimal mID,
                                                                                      @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                                              content = @Content(
                                                                                                      schema = @Schema(
                                                                                                              example = "{\n" +
                                                                                                                      "  \"bankID\": 10000001,\n" +
                                                                                                                      "  \"bankBranchDesc\": \"توضیحات\",\n" +
                                                                                                                      "  \"bankAccountNumber\": \"1234\",\n" +
                                                                                                                      "  \"customerID\": 6\n" +
                                                                                                                      "}"
                                                                                                      )
                                                                                              )
                                                                                      )
                                                                                      @RequestBody SaleCustomerAllocatedAccount saleCustomerAllocatedAccount) {
        return ResponseEntity.ok().body(saleCustomerAllocatedAccountRepository.saleUpdCustomerAllocatedAccount(mID, saleCustomerAllocatedAccount));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete customerAllocatedAccount",
            description = "<code>Delete</code> <i><b>customerAllocatedAccount<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping("/{mID}")
    public ResponseEntity<?> customerAllocatedAccountDelSP(@PathVariable BigDecimal mID) {
        saleCustomerAllocatedAccountRepository.SaleDelCustomerAllocatedAccount(mID);
        return ResponseEntity.noContent().build();
    }
}
