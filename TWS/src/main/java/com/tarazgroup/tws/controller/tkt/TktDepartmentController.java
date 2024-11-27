package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktDepartmentRepository;
import com.tarazgroup.tws.dao.tkt.TktUserRepository;
import com.tarazgroup.tws.dto.tkt.TktDepartmentDto;
import com.tarazgroup.tws.model.tkt.TktDepartment;
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
 * @date Jan-24, 2022
 ***/
@RestController
@RequestMapping("tkt/departments")
@Validated
@Tag(name = "Department")

public class TktDepartmentController {
    final private TktDepartmentRepository tktDepartmentRepository;
    final private TktUserRepository tktUserRepository;

    public TktDepartmentController(TktDepartmentRepository tktDepartmentRepository, TktUserRepository tktUserRepository) {
        this.tktDepartmentRepository = tktDepartmentRepository;
        this.tktUserRepository = tktUserRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all departments",
            description = "<code>Retrieve</code> all <i><b>departments</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<com.tarazgroup.tws.dto.tkt.department.TktDepartment>> departments(@ParameterObject TktDepartment tktDepartment) {
        return ResponseEntity
                .ok()
                .body(tktDepartmentRepository.tktShowDepartment1(tktDepartment));
    }

    @Operation(
            summary = "Retrieve specific department",
            description = "<code>Retrieve</code> specific <i><b>department</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{departmentID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktDepartment> department(@PathVariable BigDecimal departmentID) {
        return ResponseEntity
                .ok()
                .body(tktDepartmentRepository.tktShowDepartmentByID(departmentID));
    }

    @Operation(
            summary = "Retrieve users from a specific department",
            description = "<code>Retrieve</code> users from a specific <i><b>department</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{departmentID}/users", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktUser>> departmentUsers(@PathVariable BigDecimal departmentID) {
        return ResponseEntity
                .ok()
                .body(tktUserRepository.tktShowUsersByDepartment(departmentID));
    }

    @Operation(
            summary = "Create department",
            description = "<code>Create</code> <i><b>department</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktDepartment> departmentInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +

                                                            "  \"departmentName\": \"department\",\n" +
                                                            "  \"departmentEmailAddress\": \"department@domain.com\",\n" +
                                                            "  \"isVisibleForCustomers\": true,\n" +
                                                            "  \"ticketTimeout\": null\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktDepartmentDto tktDepartmentDto
    ) {
        return ResponseEntity.ok(tktDepartmentRepository.tktInsDepartment(tktDepartmentDto));
    }


    @Operation(
            summary = "Update department",
            description = "<code>Update</code> <i><b>department<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{departmentID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktDepartment> departmentUpdSP(
            @PathVariable BigDecimal departmentID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"departmentID\": 10000001,\n" +
                                                            "  \"departmentName\": \"department\",\n" +
                                                            "  \"departmentEmailAddress\": \"department@domain.com\",\n" +
                                                            "  \"isVisibleForCustomers\": true,\n" +
                                                            "  \"ticketTimeout\": null\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktDepartmentDto tktDepartmentDto) {
        return ResponseEntity.ok(tktDepartmentRepository.tktUpdDepartment(departmentID, tktDepartmentDto));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete department",
            description = "<code>Delete</code> <i><b>department<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{departmentID}", produces = "application/json")
    public ResponseEntity<?> departmentDelSP(
            @PathVariable BigDecimal departmentID) {
        tktDepartmentRepository.tktDelDepartment(departmentID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Retrieve department meta",
            description = "<code>Retrieve</code> <i><b>department</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktDepartmentRepository.meta());
    }

    @Operation(
            summary = "Retrieve department meta1",
            description = "<code>Retrieve</code> <i><b>department</b></i> meta1",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta1", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta1() {
        return ResponseEntity
                .ok()
                .body(tktDepartmentRepository.meta1());
    }


    //</editor-fold>
}
