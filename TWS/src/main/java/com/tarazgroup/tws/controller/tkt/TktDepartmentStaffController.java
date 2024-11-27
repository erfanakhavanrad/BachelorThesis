package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktDepartmentStaffRepository;
import com.tarazgroup.tws.model.tkt.TktDepartmentStaff;
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
 * @date Jan-29, 2022
 ***/
@RestController
@RequestMapping("tkt/departmentstaff")
@Validated
@Tag(name = "DepartmentStaff")
public class TktDepartmentStaffController {
    final private TktDepartmentStaffRepository tktDepartmentStaffRepository;

    public TktDepartmentStaffController(TktDepartmentStaffRepository tktDepartmentStaffRepository) {
        this.tktDepartmentStaffRepository = tktDepartmentStaffRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all departmentStaffs",
            description = "<code>Retrieve</code> all <i><b>departmentStaffs</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktDepartmentStaff>> departmentStaffs(@ParameterObject TktDepartmentStaff tktDepartmentStaff) {
        return ResponseEntity
                .ok()
                .body(tktDepartmentStaffRepository.tktShowDepartmentStaff(tktDepartmentStaff));
    }

    @Operation(
            summary = "Retrieve specific departmentStaff",
            description = "<code>Retrieve</code> specific <i><b>departmentStaff</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{departmentStaffID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktDepartmentStaff> departmentStaff(@PathVariable BigDecimal departmentStaffID) {
        return ResponseEntity
                .ok()
                .body(tktDepartmentStaffRepository.tktShowDepartmentStaffByID(departmentStaffID));
    }

    @Operation(
            summary = "Create departmentStaff",
            description = "<code>Create</code> <i><b>departmentStaff</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktDepartmentStaff> departmentStaffInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"departmentID\": 10000001,\n" +
                                                            "  \"userID\": 10000001,\n" +
                                                            "  \"isOwner\": false\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktDepartmentStaff tktDepartmentStaff
    ) {
        return ResponseEntity.ok(tktDepartmentStaffRepository.tktInsDepartmentStaff(tktDepartmentStaff));
    }


    @Operation(
            summary = "Update departmentStaff",
            description = "<code>Update</code> <i><b>departmentStaff<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{departmentStaffID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktDepartmentStaff> departmentStaffUpdSP(
            @PathVariable BigDecimal departmentStaffID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"departmentStaffID\": 10000001,\n" +
                                                            "  \"departmentID\": 10000001,\n" +
                                                            "  \"userID\": 10000001,\n" +
                                                            "  \"isOwner\": false\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktDepartmentStaff tktDepartmentStaff) {
        return ResponseEntity.ok(tktDepartmentStaffRepository.tktUpdDepartmentStaff(departmentStaffID, tktDepartmentStaff));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete departmentStaff",
            description = "<code>Delete</code> <i><b>departmentStaff<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{departmentStaffID}", produces = "application/json")
    public ResponseEntity<?> departmentStaffDelSP(
            @PathVariable BigDecimal departmentStaffID) {
        tktDepartmentStaffRepository.tktDelDepartmentStaff(departmentStaffID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Retrieve departmentStaff meta",
            description = "<code>Retrieve</code> <i><b>departmentStaff</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktDepartmentStaffRepository.meta());
    }
    //</editor-fold>
}
