package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmUserRepository;
import com.tarazgroup.tws.dao.tkt.TktStaffRoleRepository;
import com.tarazgroup.tws.model.crm.CrmLead;
import com.tarazgroup.tws.model.crm.CrmUser;
import com.tarazgroup.tws.model.tkt.TktUser;
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

/***
 * @author A.Farahani
 * @date Jan-12, 2023
 ***/
@RestController
@RequestMapping("crm/users")
@Validated
@Tag(name = "Users")
public class CrmUserController {
    private final CrmUserRepository crmUserRepository;
    private final TktStaffRoleRepository tktStaffRoleRepository;


    public CrmUserController(CrmUserRepository crmUserRepository, TktStaffRoleRepository tktStaffRoleRepository) {
        this.crmUserRepository = crmUserRepository;
        this.tktStaffRoleRepository = tktStaffRoleRepository;
    }

    @Operation(

            summary = "Retrieve all users",
            description = "<code>Retrieve</code> all <i><b>users</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmUser>> users(@ParameterObject CrmUser crmUser) {
        return ResponseEntity.ok().body(crmUserRepository.crmShowUser(crmUser));
    }

    @Operation(

            summary = "Retrieve all staff",
            description = "<code>Retrieve</code> all <i><b>staff</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(path = "/staff", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmUser>> staff(@ParameterObject CrmUser crmUser) {
        return ResponseEntity.ok().body(crmUserRepository.crmShowStaff(crmUser));
    }

    //    GET by ID

    @Operation(
            summary = "Retrieve specific user",
            description = "<code>Retrieve</code> specific <i><b>user</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{userID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmUser> user(@PathVariable BigDecimal userID) {
        return ResponseEntity.ok().body(crmUserRepository.crmShowUserByID(userID));
    }

    @Operation(
            summary = "Update user",
            description = "<code>Update</code> <i><b>user<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{userID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmUser> userUpdSP(
            @PathVariable BigDecimal userID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmUser crmUser) {
        return ResponseEntity.ok(crmUserRepository.crmUpdProfile(userID, crmUser));
    }

//    staff POST
    @Operation(
            summary = "Create staff",
            description = "<code>Create</code> <i><b>staff</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(path = "/staff", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmUser> staffInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = ""
                            )
                    )
            )
            @RequestBody CrmUser crmUser

    ) {
        return ResponseEntity.ok(crmUserRepository.crmInsStaff(crmUser, tktStaffRoleRepository));
    }


    // customer POST

    @Operation(
            summary = "Create customer",
            description = "<code>Create</code> <i><b>customer</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(path = "/customer", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmUser> customerInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = ""
                            )
                    )
            )
            @RequestBody CrmUser crmUser

    ) {
        return ResponseEntity.ok(crmUserRepository.crmInsCustomer(crmUser));
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "update winner",
            description = "<code>Update</code> <i><b>winner</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/lottery/{userID}", produces = "application/json")
    public ResponseEntity<?> updLotterySP(
            @PathVariable BigDecimal userID) {
        CrmUser crmUser = crmUserRepository.crmUpdLotteryWinner(userID);
        return ResponseEntity.ok().body(crmUser);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete Winners",
            description = "<code>Delete</code> <i><b>Winners<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(produces = "application/json")
    public ResponseEntity<?> crmDelWinners() {
        crmUserRepository.crmDelWinners();
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve status meta",
            description = "<code>Retrieve</code> <i><b>status</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmUserRepository.meta());
    }

}
