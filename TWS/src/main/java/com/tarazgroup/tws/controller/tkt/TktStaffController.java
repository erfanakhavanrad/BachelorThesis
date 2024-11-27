package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktStaffRepository;
import com.tarazgroup.tws.dao.tkt.TktStaffRoleRepository;
import com.tarazgroup.tws.dto.tkt.TktStaffDto;
import com.tarazgroup.tws.model.tkt.TktStaff;
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
import java.security.NoSuchAlgorithmException;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-27, 2022
 ***/
@RestController
@RequestMapping("tkt/staff")
@Validated
@Tag(name = "Staff")
public class TktStaffController {
    final private TktStaffRepository tktStaffRepository;

    final private TktStaffRoleRepository tktStaffRoleRepository;

    public TktStaffController(TktStaffRepository tktStaffRepository, TktStaffRoleRepository tktStaffRoleRepository) {
        this.tktStaffRepository = tktStaffRepository;
        this.tktStaffRoleRepository = tktStaffRoleRepository;
    }


    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all staffs",
            description = "<code>Retrieve</code> all <i><b>staffs</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<com.tarazgroup.tws.dto.tkt.staff.TktStaff>> staffs(@ParameterObject TktStaff tktStaff, @RequestParam(required = false) BigDecimal departmentID) {
        return ResponseEntity
                .ok()
                .body(tktStaffRepository.tktShowStaff(tktStaff, departmentID));
    }

//    @Operation(
//            summary = "Retrieve all staffs",
//            description = "<code>Retrieve</code> all <i><b>staffs</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(value = "{/departmentID}",produces = "application/json;charset=utf-8")
//    public ResponseEntity<List<TktStaff>> staffsDep(@PathVariable BigDecimal departmentID) {
//        return ResponseEntity
//                .ok()
//                .body(tktStaffRepository.tktShowStaffByIDDep(departmentID));
//    }

    @Operation(
            summary = "Retrieve specific staff",
            description = "<code>Retrieve</code> specific <i><b>staff</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{staffID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktStaffDto> staff(@PathVariable BigDecimal staffID) {
        return ResponseEntity
                .ok()
                .body(tktStaffRepository.tktShowStaffByID(staffID, tktStaffRoleRepository));
    }



//    @Operation(
//            summary = "Create staff",
//            description = "<code>Create</code> <i><b>staff</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PostMapping(produces = "application/json", consumes = "application/json")
//    public ResponseEntity<TktStaff> staffInsSP(



//            @Valid
//            @io.swagger.v3.oas.annotations.parameters.RequestBody(
//                    content = {
//                            @Content(
//                                    schema = @Schema(
//                                            example =
//                                                    "{\n" +
//                                                            "  \"perComFName\": \"Sname\",\n" +
//                                                            "  \"perComLName\": \"Sfamily\",\n" +
//                                                            "  \"userMobileNumber\": \"09123456789\",\n" +
//                                                            "  \"androidUserPass\": \"namedfd123456\",\n" +
//                                                            "  \"userLoginName\": \"name@domain.com\"\n" +
//                                                            "}"
//                                    )
//                            )

//                    }
//            )
//            @RequestBody TktStaff tktStaff
//    ) {
//        return ResponseEntity.ok(tktStaffRepository.tktInsStaff(tktStaff));
//    }

    @Operation(
            summary = "Create staff1",
            description = "<code>Create</code> <i><b>staff1</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktStaffDto> staff1InsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "    {\n" +
                                                            "            \"email\": \"name@domain.com\",\n" +
                                                            "            \"userMobileNumber\": \"01234567899\",\n" +
                                                            "            \"password\": \"stringskfhkd\",\n" +
                                                            "            \"staffImg\": null,\n" +
                                                            "            \"hasAccessSendTicketToCustomer\": true,\n" +
                                                            "            \"hasAccessToCustomerInfo\": true,\n" +
                                                            "            \"isNotActive\": true,\n" +
                                                            "            \"roles\": [\n" +
                                                            "        10000002\n" +
                                                            "  ],\n" +
                                                            "        \"perComFName\": \"name\",\n" +
                                                            "            \"perComLName\": \"family\"\n" +
                                                            "    }"
                                    )
                            )

                    }
            )
            @RequestBody TktStaffDto tktStaffDto
    ) throws NoSuchAlgorithmException {
        return ResponseEntity.ok(tktStaffRepository.tktInsStaff(tktStaffDto, tktStaffRoleRepository));
    }


    @Operation(
            summary = "Update staff",
            description = "<code>Update</code> <i><b>staff<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{staffID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktStaffDto> staffUpdSP(
            @PathVariable BigDecimal staffID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "    {\n" +
                                                            "        \"staffID\": 10000001,\n" +
                                                            "            \"email\": \"name@domain.com\",\n" +
                                                            "            \"userMobileNumber\": \"01234567899\",\n" +
                                                            "            \"password\": \"stringskfhkd\",\n" +
                                                            "            \"staffImg\": null,\n" +
                                                            "            \"hasAccessSendTicketToCustomer\": true,\n" +
                                                            "            \"hasAccessToCustomerInfo\": true,\n" +
                                                            "            \"isNotActive\": true,\n" +
                                                            "            \"roles\": [\n" +
                                                            "        10000002\n" +
                                                            "  ],\n" +
                                                            "        \"perComFName\": \"name\",\n" +
                                                            "            \"perComLName\": \"family\"\n" +
                                                            "    }"
                                    )
                            )

                    }
            )
            @RequestBody TktStaffDto tktStaffDto) throws NoSuchAlgorithmException {
        return ResponseEntity.ok(tktStaffRepository.tktUpdStaff(staffID, tktStaffDto, tktStaffRoleRepository));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete staff",
            description = "<code>Delete</code> <i><b>staff<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{staffID}", produces = "application/json")
    public ResponseEntity<?> staffDelSP(
            @PathVariable BigDecimal staffID) {
        tktStaffRepository.tktDelStaff(staffID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Retrieve staff meta",
            description = "<code>Retrieve</code> <i><b>staff</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktStaffRepository.meta());
    }

    @Operation(
            summary = "Retrieve staff meta1",
            description = "<code>Retrieve</code> <i><b>staff</b></i> meta1",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta1", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta1() {
        return ResponseEntity
                .ok()
                .body(tktStaffRepository.meta1());
    }
    //</editor-fold>
}
