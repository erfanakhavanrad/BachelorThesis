package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktTicketCategoryRepository;
import com.tarazgroup.tws.model.tkt.TktTicketCategory;
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
@RequestMapping("tkt/ticketcategories")
@Validated
@Tag(name = "TicketCategory")
public class TktTicketCategoryController {
    final private TktTicketCategoryRepository tktTicketCategoryRepository;

    public TktTicketCategoryController(TktTicketCategoryRepository tktTicketCategoryRepository) {
        this.tktTicketCategoryRepository = tktTicketCategoryRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all ticketCategories",
            description = "<code>Retrieve</code> all <i><b>ticketCategories</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktTicketCategory>> ticketCategories(@ParameterObject TktTicketCategory tktTicketCategory) {
        return ResponseEntity
                .ok()
                .body(tktTicketCategoryRepository.tktShowTicketCategory(tktTicketCategory));
    }

    @Operation(
            summary = "Retrieve all ticketCategories for grid",
            description = "<code>Retrieve</code> all <i><b>ticketCategories for grid</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(path = "/forgrid",produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktTicketCategory>> ticketCategoriesForGrid(@ParameterObject TktTicketCategory tktTicketCategory) {
        return ResponseEntity
                .ok()
                .body(tktTicketCategoryRepository.tktShowTicketCategoryForGrid(tktTicketCategory));
    }

    @Operation(
            summary = "Retrieve specific ticketCategory",
            description = "<code>Retrieve</code> specific <i><b>ticketCategory</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{ticketCategoryID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktTicketCategory> ticketCategory(@PathVariable BigDecimal ticketCategoryID) {
        return ResponseEntity
                .ok()
                .body(tktTicketCategoryRepository.tktShowTicketCategoryByID(ticketCategoryID));
    }

    @Operation(
            summary = "Retrieve specific ticketCategory for grid",
            description = "<code>Retrieve</code> specific <i><b>ticketCategory for grid</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{ticketCategoryID}/forgrid", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktTicketCategory> ticketCategoryForGrid(@PathVariable BigDecimal ticketCategoryID) {
        return ResponseEntity
                .ok()
                .body(tktTicketCategoryRepository.tktShowTicketCategoryByIDForGrid(ticketCategoryID));
    }

    @Operation(
            summary = "Create ticketCategory",
            description = "<code>Create</code> <i><b>ticketCategory</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktTicketCategory> ticketCategoryInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"departmentID\": 10000001,\n" +
                                                            "  \"ticketCategoryName\": \"name\",\n" +
                                                            "  \"ticketLabelColor\": \"color hex\"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktTicketCategory tktTicketCategory
    ) {
        return ResponseEntity.ok(tktTicketCategoryRepository.tktInsTicketCategory(tktTicketCategory));
    }


    @Operation(
            summary = "Update ticketCategory",
            description = "<code>Update</code> <i><b>ticketCategory<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{ticketCategoryID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktTicketCategory> ticketCategoryUpdSP(
            @PathVariable BigDecimal ticketCategoryID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"ticketCategoryID\": 10000001,\n" +
                                                            "  \"departmentID\": 10000001,\n" +
                                                            "  \"ticketCategoryName\": \"name\",\n" +
                                                            "  \"ticketLabelColor\": \"color hex\"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktTicketCategory tktTicketCategory) {
        return ResponseEntity.ok(tktTicketCategoryRepository.tktUpdTicketCategory(ticketCategoryID, tktTicketCategory));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete ticketCategory",
            description = "<code>Delete</code> <i><b>ticketCategory<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/forgrid/{ticketCategoryID}", produces = "application/json")
    public ResponseEntity<?> ticketCategoryDelSP(
            @PathVariable BigDecimal ticketCategoryID) {
        tktTicketCategoryRepository.tktDelTicketCategory(ticketCategoryID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve ticketCategory meta",
            description = "<code>Retrieve</code> <i><b>ticketCategory</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktTicketCategoryRepository.meta());
    }
    //</editor-fold>
}
